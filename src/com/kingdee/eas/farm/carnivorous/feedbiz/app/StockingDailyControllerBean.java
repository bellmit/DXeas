package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.sql.SQLException;

import com.kingdee.bos.*;
import com.kingdee.bos.ui.face.UIRuleUtil;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyInfo;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StockingDailyControllerBean extends AbstractStockingDailyControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.carnivorous.feedbiz.app.StockingDailyControllerBean");
	@Override
	//保存方法
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		StockingDailyInfo info = (StockingDailyInfo) model;
		//		info.getBatch().getId().toString()
		if(info.getBaseStatus()==null||info.getBaseStatus().getValue()==-1||info.getBaseStatus().equals(BillBaseStatusEnum.ADD)) {
			info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, info);
	}
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		StockingDailyInfo info = (StockingDailyInfo) model;
		if(info.getBaseStatus()==null||info.getBaseStatus().getValue()==-1||info.getBaseStatus().equals(BillBaseStatusEnum.ADD)||info.getBaseStatus().equals(BillBaseStatusEnum.TEMPORARILYSAVED)) {
			info.setBaseStatus(BillBaseStatusEnum.SUBMITED);
		}
		//提交后自动审核
		this._save(ctx, model);
		this._audit(ctx, model);
		return super._submit(ctx, info);
	}

	protected void _audit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{
		//定义一个Info，里面有我们所填的信息
		StockingDailyInfo info=(StockingDailyInfo)model;
		//设置业务单元的状态
		info.setBaseStatus(BillBaseStatusEnum.AUDITED);
		//设置审核时间
		info.setAuditTime(new java.util.Date());
		//设置审核人
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		//  查询是否需要重新计算其他批次的信息
		ArrayList<String> list = checkIsNeedRecalQty(ctx,info);
		for(int i=0;i<list.size();i++){
			_recalStockingByBatchID(ctx, info.getBizDate() , list.get(i));
		}


	}
	/*
	 * 查询是否需要重新计算其他批次的信息
	 */
	private ArrayList<String> checkIsNeedRecalQty(Context ctx,
			StockingDailyInfo info) {
		// TODO Auto-generated method stub
		//得到Info中的批次信息,并把信息转换成字符串
		String batchID = info.getBatch().getId().toString();
		//获得获得批次日期，并转换成相应的格式
		Date bizDate = info.getBizDate();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		//定义一个列表
		ArrayList<String> list=new ArrayList<String>();
		try {//从养殖日报中 查找 该养殖日报 业务日期之后的养殖日报的所有信息
			IRowSet rs = DbUtil.executeQuery(ctx, "select * from T_FM_StockingDaily where FBizDate>={d '"+sdf.format(bizDate)+"'}+1 and FBatchID='"+batchID+"'");
			if(rs.size()>0){
				list.add(batchID);
			}

		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//返回一个列表，该列表包含该养殖日报业务日期之后的所有信息
		return list;
	}
	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException, EASBizException
	{//获得批次信息
		StockingDailyInfo info = (StockingDailyInfo) model;
		//设置这张养殖日报的状态为保存
		info.setBaseStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		//设置这张养殖日报的审核时间
		info.setAuditTime(null);
		//设置审核人
		info.setAuditor(null);
		super._update(ctx, new ObjectUuidPK(info.getId()), info);
		//获得需要重新计算存栏量的
		ArrayList<String> list = checkIsNeedRecalQty(ctx,info);
		
		for(int i=0;i<list.size();i++){
			_recalStockingByBatchIDUnAudit(ctx, info.getBizDate() , list.get(i));
		}
	}
	
	//重算列表中某一项养殖日报的存栏量
	private String  _recalStockingByBatchIDUnAudit(Context ctx, Date date, String batchID) throws BOSException {
		StringBuffer sb=new StringBuffer();
		//选择 养殖日报的 单据编号，批次ID，FID，业务日期。以及 养殖信息分录的 FID，分录序列号,存栏量
		String sql = "select t1.Fnumber,t1.FBatchID,t1.FID dailyID,t2.FID entryID,t2.FSeq,t1.FBizDate,t2.CFBreekingStock  from T_FM_StockingDaily t1 inner join T_FM_StockingDailyAssEntry t2 on t1.FID=t2.FParentID where t1.FBatchID='"+batchID+"' and t1.CFBaseStatus= 4 ";
		//date是指新增加的那张表的业务日期
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			//其他表的业务日期大于新增表的业务日期
			sql += " and t1.FBizDate>{d '"+sdf.format(date)+"'}";
		}
		sql += " order by t1.FBizDate";

		IRowSet rs = DbUtil.executeQuery(ctx,sql);
		IRowSet rsA =null;
		String BatchID;
		String dailyID;
		String entryID;
		Date FBizDate;
		Integer seq;
		String billNum;

		BigDecimal intMaleQty;//存栏量
		BigDecimal CFBreekingStock;
		SimpleDateFormat sdf1=new SimpleDateFormat("yyyy-MM-dd");
		try {
			while(rs.next()){
				intMaleQty=BigDecimal.ZERO;
				BatchID = rs.getString("FBatchID");//批次ID
				dailyID=rs.getString("dailyID");//日报ID
				entryID=rs.getString("entryID");//分录ID
				FBizDate=rs.getDate("FBizDate");//业务日期
				CFBreekingStock=rs.getBigDecimal("CFBreekingStock");//当前存栏量
				seq=rs.getInt("FSeq");//分录序列号
				billNum=rs.getString("Fnumber");//单据编号
				//判断批次是否为空
				if(StringUtils.isEmpty(BatchID)){
					continue;
				}
				rsA=DbUtil.executeQuery(ctx,"select FBatchQty  from T_FM_Batch where FID=?",new String[]{BatchID});
				if(rsA.next()){
					intMaleQty=rsA.getBigDecimal("FBatchQty");
				}
				//累计死淘、调整、出栏
				rsA=DbUtil.executeQuery(ctx, "/*dialect*/select nvl(sum(t2.CFDeathQty),0) CFDeathQty,nvl(sum(t2.CFCullQty),0)CFCullQty,nvl(sum(t2.FAdjustQty),0) FAdjustQty ,nvl(sum(t2.FMarkedQty),0)  FMarkedQty from T_FM_StockingDailyAssEntry    t2  inner join T_FM_StockingDaily t1 on t1.FID=t2.FParentID and t1.FBatchID=? and t1.FBizDate<{d '"+sdf1.format(FBizDate)+"'}+1 and t1.CFBaseStatus= 4",new String[]{BatchID});
				if(rsA.next()){
					intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FMarkedQty")));
				}
				if(intMaleQty.compareTo(CFBreekingStock)!=0){
					sb.append(billNum+"   第"+seq+"条存栏量不正确,正确存栏为"+intMaleQty+",当前值为"+CFBreekingStock).append("\n");
					DbUtil.execute(ctx, "update T_FM_StockingDailyAssEntry set CFBreekingStock="+intMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	protected List _genNextBill(Context ctx, IObjectValue model)throws BOSException
	{
		return null;
	}
	protected void _reShareCoalAndDiesel(Context ctx, IObjectValue model)throws BOSException
	{

	}
	//重算某批次的存栏量
	protected String _recalStockingByBatchID(Context ctx, Date date, String batchID)throws BOSException, EASBizException
	{//列表已经返回了，需要修改存栏量的养殖日报的所有信息
		StringBuffer sb=new StringBuffer();
		//选择 养殖日报的 单据编号，批次ID，FID，业务日期。以及 养殖信息分录的 FID，分录序列号,存栏量
		String sql = "select t1.Fnumber,t1.FBatchID,t1.FID dailyID,t2.FID entryID,t2.FSeq,t1.FBizDate,t2.CFBreekingStock  from T_FM_StockingDaily t1 inner join T_FM_StockingDailyAssEntry t2 on t1.FID=t2.FParentID where t1.FBatchID='"+batchID+"' and t1.CFBaseStatus=4 ";
		//如果这张表不为空不需要重算这张表，要重算以后业务日期的存栏量（相应改变）；
		//如果这张表的业务日期为空（这张表是重新加的）
		if(date != null){
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			sql += " and t1.FBizDate>{d '"+sdf.format(date)+"'}";
		}
		sql += " order by t1.FBizDate";

		IRowSet rs = DbUtil.executeQuery(ctx,sql);
		IRowSet rsA =null;
		String BatchID;
		String dailyID;
		String entryID;
		Date FBizDate;
		Integer seq;
		String billNum;

		BigDecimal intMaleQty;//存栏量
		BigDecimal CFBreekingStock;
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		try {
			while(rs.next()){
				intMaleQty=BigDecimal.ZERO;
				BatchID = rs.getString("FBatchID");//批次ID
				dailyID=rs.getString("dailyID");//日报ID
				entryID=rs.getString("entryID");//分录ID
				FBizDate=rs.getDate("FBizDate");//业务日期
				CFBreekingStock=rs.getBigDecimal("CFBreekingStock");//当前存栏量
				seq=rs.getInt("FSeq");//分录序列号
				billNum=rs.getString("Fnumber");//单据编号
				//判断批次是否为空
				if(StringUtils.isEmpty(BatchID)){
					continue;
				}
				rsA=DbUtil.executeQuery(ctx,"select FBatchQty  from T_FM_Batch where FID=?",new String[]{BatchID});
				if(rsA.next()){
					intMaleQty=rsA.getBigDecimal("FBatchQty");
				}
				//累计死淘、调整、出栏
				rsA=DbUtil.executeQuery(ctx, "/*dialect*/select nvl(sum(t2.CFDeathQty),0) CFDeathQty,nvl(sum(t2.CFCullQty),0)CFCullQty,nvl(sum(t2.FAdjustQty),0) FAdjustQty ,nvl(sum(t2.FMarkedQty),0)  FMarkedQty from T_FM_StockingDailyAssEntry    t2  inner join T_FM_StockingDaily t1 on t1.FID=t2.FParentID and t1.FBatchID=? and t1.FBizDate<{d '"+sdf.format(FBizDate)+"'}+1",new String[]{BatchID});
				if(rsA.next()){
					intMaleQty=intMaleQty.subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFDeathQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("CFCullQty"))).add(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FAdjustQty"))).subtract(UIRuleUtil.getBigDecimal(rsA.getBigDecimal("FMarkedQty")));
				}
				if(intMaleQty.compareTo(CFBreekingStock)!=0){
					sb.append(billNum+"   第"+seq+"条存栏量不正确,正确存栏为"+intMaleQty+",当前值为"+CFBreekingStock).append("\n");
					DbUtil.execute(ctx, "update T_FM_StockingDailyAssEntry set CFBreekingStock="+intMaleQty+" where FParentID='"+dailyID+"' and FID='"+entryID+"'");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	@Override
	protected String _recalStockingByBatchID(Context ctx, String String)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		return null;
	}
}