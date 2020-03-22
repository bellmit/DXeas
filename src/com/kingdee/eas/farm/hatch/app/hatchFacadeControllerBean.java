package com.kingdee.eas.farm.hatch.app;

import org.apache.log4j.Logger;
import javax.ejb.*;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.access.Simple;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.bi.model.DB.DBUtil;
import com.kingdee.bos.dao.AbstractObjectValue;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.StorageOrgUnitFactory;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.business.CCBreedPlanEntryInfo;
import com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryFactory;
import com.kingdee.eas.farm.breed.layegg.LayEggPlanEntryInfo;
import com.kingdee.eas.farm.hatch.HatchBaseDataFactory;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.jdbc.rowset.IRowSet;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class hatchFacadeControllerBean extends AbstracthatchFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.hatch.app.hatchFacadeControllerBean");

	/**
	 * 获得特定会计期间的产蛋计划的分录 返回类型：日期+场+产蛋量
	 * @param：会计期间
	 * @return:产蛋计划
	 */
	@Override
	protected Map _getLayEggPlan(Context ctx, IObjectValue period) throws BOSException {
		// TODO Auto-generated method stub
		//LinkeHashMap具有按存入顺序
		Map<String,LayEggPlanEntryInfo> map=new LinkedHashMap<String, LayEggPlanEntryInfo>();

		SimpleDateFormat sdft=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb=new StringBuffer();
		sb.append("select t2.cfplandate,t2.fid from CT_FM_LayEggPlan t1");
		sb.append(" inner join CT_FM_LayEggPlanEntry t2 on t1.fid=t2.fparentid");
		sb.append(" where t1.cfBaseStatus=4 and t2.cfplanDate between ");
		//在期间的起始日期和结束日期之间
		sb.append(" {ts '").append(((PeriodInfo)period).getBeginDate()).append("'}");
		sb.append(" and {ts '").append(sdft.format(((PeriodInfo)period).getEndDate())).append("'}");
		sb.append(" order by t2.cfplandate");
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx,sb.toString()).executeSQL();
		try {
			while(rs.next())
			{
				//将日期转换成字符串并以(yyyyMMdd)的格式保存起来
				String dateStr = (rs.getString("cfplandate")).substring(0,10);
				dateStr=dateStr.replace("-","");
				LayEggPlanEntryInfo layEggPlanEntryInfo = LayEggPlanEntryFactory.getLocalInstance(ctx).getLayEggPlanEntryInfo(new ObjectUuidPK(rs.getString("fid")));
				//字符串key的保存格式：yyyyMMdd+entryInfo的id，目的是区别不同产蛋厂同一日的产蛋计划
				String str=dateStr.concat(rs.getString("fid"));
				map.put(str, layEggPlanEntryInfo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	






	protected void _excuteSql(Context ctx, String sql) throws BOSException,
			EASBizException {
		DbUtil.execute(ctx, sql);
	}







	/**
	 * 获得特定期间 产蛋计划   
	 * @param period  期间
	 * @return        返回类型:日期+当日所有产当场的产合格蛋总量
	 */
	protected Map _getLayEggPlanTotal(Context ctx, IObjectValue period) throws BOSException {
		// TODO Auto-generated method stub
		//LinkeHashMap具有按存入顺序
		Map<Date,BigDecimal> map=new LinkedHashMap<Date, BigDecimal>();

		SimpleDateFormat sdft=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb=new StringBuffer();
		sb.append("select t2.cfplandate,sum(t2.CFUpEggQty) from CT_FM_LayEggPlan t1");
		sb.append(" inner join CT_FM_LayEggPlanEntry t2 on t1.fid=t2.fparentid");
		sb.append(" where t1.cfBaseStatus=4 and t2.cfplanDate between ");
		//在期间的起始日期和结束日期之间
		sb.append(" {ts '").append(((PeriodInfo)period).getBeginDate()).append("'}");
		sb.append(" and {ts '").append(sdft.format(((PeriodInfo)period).getEndDate())).append("'}");
		sb.append(" group by t2.cfplandate");
		sb.append(" order by t2.cfplandate"); 
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx,sb.toString()).executeSQL();
		try {
			while(rs.next())
			{
				map.put(sdft.parse(rs.getString("cfplandate")), new BigDecimal(rs.getString("sum(t2.CFUpEggQty)")));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	
	/**
	 * 获取孵化基础资料(仅存在一个孵化场)
	 */
	@Override
	protected IObjectValue _getHatchBaseData(Context ctx) throws BOSException {
		// TODO Auto-generated method stub
		HatchBaseDataInfo info=null;
		String str="select * from CT_FM_HatchBaseData where fBillStatus=4";
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, str).executeSQL();
		int num=0;
		try {
			while(rs.next())
			{
				info=HatchBaseDataFactory.getLocalInstance(ctx).getHatchBaseDataInfo(new ObjectUuidPK(rs.getString("fid")));
				num++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//num==0，无启用的孵化基础资料  num>1  存在多个
		if(num!=1)
			return null;
		return info;
	}
	
	
	
	/**
	 * 根据孵化场获得孵化场基础资料(多个孵化场)
	 * @param stoOrg  孵化场
	 * @return        该孵化场基础资料
	 */
	@Override
	protected HatchBaseDataInfo _getHatchBaseData(Context ctx,StorageOrgUnitInfo stoOrg) throws BOSException {
		// TODO Auto-generated method stub
		if(stoOrg == null){
			return null;
		}
		HatchBaseDataInfo info=null;
		String id = stoOrg.getId().toString();
		String str="select top 1 * from CT_FM_HatchBaseData where fBillStatus in (3,4) and CFHatchFactoryID='"+id+"' order by fnumber asc";
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, str).executeSQL();
		int num = rs.size();
		if(num >1){
			throw new BOSException("传入的库存组织存在多个 已审核的孵化场基础设置");
		}else if(num == 0){
			return null;
//			throw new BOSException("传入的库存组织没有对应的孵化场基础设置");
		}
		try {
			while(rs.next())
			{
				info=HatchBaseDataFactory.getLocalInstance(ctx).getHatchBaseDataInfo(new ObjectUuidPK(rs.getString("fid")));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return info;
	}
	
	
	/**
	 * 查询各产蛋厂某天的入栏计划
	 */
	@Override
	protected Map _getCCBreedInfo(Context ctx, Date pkDate) throws BOSException {
		// TODO Auto-generated method stub
		Map<StorageOrgUnitInfo,String> map = new LinkedHashMap<StorageOrgUnitInfo, String>();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		StringBuffer sb=new StringBuffer();
		sb.append("select t3.fid,sum(CFInitQty) qty from CT_FM_CCBreedPlanEntry t1");
		sb.append(" inner join CT_FM_CCBreedPlan t2 on t2.fid=t1.fparentid ");
		sb.append(" inner join t_org_storage t3 on t2.CFStoOrgID=t3.fid");
		sb.append(" where t1.CFIncoopDate={ts '").append(sdf.format(pkDate)).append("'}");
		sb.append(" group by t3.fid");
		IRowSet rs = SQLExecutorFactory.getLocalInstance(ctx, sb.toString()).executeSQL();
		try {
			while(rs.next())
			{
				String id=rs.getString("fid");			
				StorageOrgUnitInfo info=StorageOrgUnitFactory.getLocalInstance(ctx).getStorageOrgUnitInfo(new ObjectUuidPK(id));
				map.put(info, rs.getString("qty"));
			}
			return map;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}