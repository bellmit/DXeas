package com.kingdee.eas.custom.bsxbudget.app;

import org.apache.log4j.Logger;
import javax.ejb.*;

import java.math.BigDecimal;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.bi.model.DB.DBUtil;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.basedata.assistant.SystemStatusCtrolUtils;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;


public class BSXBudgetFacadeControllerBean extends AbstractBSXBudgetFacadeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.bsxbudget.app.BSXBudgetFacadeControllerBean");

	/**
	 * 获取当前会计期间
	 */
	protected  PeriodInfo _getCurrentPeriod(Context ctx)throws BOSException
	{
		PeriodInfo currentPeriod=null;
		CompanyOrgUnitInfo currentFIUnit = ContextUtil.getCurrentFIUnit(ctx);
		try {
			currentPeriod = SystemStatusCtrolUtils.getCurrentPeriod(ctx, SystemEnum.GENERALLEDGER, currentFIUnit);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return currentPeriod;
	}

	/**
	 * 根据会计期间获得月初第一天的库存量和库存价值[其实是上一个月最后一天接近零点的数据]
	 */
	@Override
	protected String[] _getInventoryValue(Context ctx, IObjectValue period)
	throws BOSException {
		// TODO Auto-generated method stub

		String[] amt=new String[2];


		//获取上月最后一天的日期
		PeriodInfo periodInfo=(PeriodInfo) period;
		if(periodInfo==null)
			return null;
		Date firstDay = periodInfo.getBeginDate();
		Date lastDay = new Date(firstDay.getTime()-1*24*3600*1000);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String lastDayStr = sdf.format(lastDay);


		//根据日期查询数据		
		StringBuffer sb=new StringBuffer();
		sb.append("/*dialect*/SELECT to_char(t2.fbizdate,'yyyy-MM-dd') bizDate,sum(tt.BaseQty) allQty,sum(tt.BaseQty*t1.fprice) allAmt FROM");
		sb.append(" T_STO_SalesPriceEntry           t1");
		sb.append(" inner join T_STO_SalesPrice     t2  on t2.fid=t1.fparentid");
		sb.append(" inner join T_BD_Material        t3  on t3.fid=t1.FMaterialID"); 
		sb.append(" inner join T_BD_MeasureUnit     t4  on t4.fid=t1.fUnitID");
		sb.append(" inner join T_BD_Currency        t5  on t5.fid=t1.FCurrencyID");
		sb.append(" inner join	(");
		sb.append(" 		select t6.FMaterialID fmaterialID,");
		sb.append(" 		sum(t6.FBaseQty) baseQty,");
		sb.append(" 		t6.fparentid     parentid,");
		sb.append(" 		t8.fname_l2      baseUnit,");
		sb.append(" 		t7.fbizDate      bizDate");
		sb.append(" 		from");
		sb.append(" 		T_STO_RealTimeInventoryEntry  t6");
		sb.append(" 		inner join"); 
		sb.append(" 		T_STO_RealTimeInventory       t7  on t7.fid=t6.fparentid"); 
		sb.append(" 		inner join T_BD_MeasureUnit   t8  on t8.fid=t6.fBaseUnitID"); 
		sb.append(" 		group by t6.FMaterialID,t6.fparentid,t7.fbizDate,t8.fname_l2");
		sb.append(" ) tt");
		sb.append(" on tt.FMaterialID=t1.FMaterialID");
		sb.append(" and to_char(tt.bizdate,'yyyy-MM-dd')=to_char(t2.fbizdate,'yyyy-MM-dd')");
		sb.append(" where to_char(t2.fbizdate,'yyyy-MM-dd')=to_char({ts '").append(lastDayStr).append("'},'yyyy-MM-dd')");
		sb.append(" group by to_char(t2.fbizdate,'yyyy-MM-dd')");

		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			if(rs.next()){
				amt[0]=rs.getString("allQty");
				amt[1]=rs.getString("allAmt");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return amt;
	}


	/**
	 * 食品厂预算  获取养殖预算的毛鸡总重量
	 */
	@Override
	protected BigDecimal _getTotalWeightFromBugetFeed(Context ctx,
			IObjectValue periodInfo) throws BOSException {
		// TODO Auto-generated method stub
		if(periodInfo==null)
			return null;
		//会计期间
		PeriodInfo fiscalPeriod = (PeriodInfo)periodInfo;
		StringBuffer sb=new StringBuffer();
		sb.append("select FTotalWeight from T_BSX_BSXBudgetOfFeed ");
		sb.append("where FPeriodID='").append(fiscalPeriod.getId().toString()).append("'");
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			if(rs.next())
				return new BigDecimal(rs.getString("FTotalWeight"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 养殖预算获得入栏量
	 */
	@Override
	protected BigDecimal _getLairageQty(Context ctx, String beginDate,
			String endDate) throws BOSException {
		// TODO Auto-generated method stub
		StringBuffer sb=new StringBuffer();
		sb.append("select sum(t2.CFInitQty) qty from CT_FM_BreedBatch t1 ");
		sb.append("inner join CT_FM_BreedBatchEntry t2 on t1.fid=t2.fparentid ");
		sb.append("where t1.CFHouseType=3 ");//商品鸡舍
		sb.append("and t1.CFBaseStatus=4 ");//审核状态
		sb.append("and to_char(t2.CFIncoopDate,'yyyy-MM-dd')>=to_char({ts '").append(beginDate).append("'},'yyyy-MM-dd') ");
		sb.append("and to_char(t2.CFIncoopDate,'yyyy-MM-dd')<=to_char({ts '").append(endDate).append("'},'yyyy-MM-dd') ");
		IRowSet rs = DbUtil.executeQuery(ctx, sb.toString());
		try {
			if(rs.next())
				return rs.getBigDecimal("qty");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}