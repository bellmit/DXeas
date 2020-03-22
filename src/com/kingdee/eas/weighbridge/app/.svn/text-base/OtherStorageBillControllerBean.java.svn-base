package com.kingdee.eas.weighbridge.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import org.apache.commons.lang.StringUtils;
import java.rmi.RemoteException;
import java.sql.SQLException;
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
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.weighbridge.OtherStorageBillCollection;
import com.kingdee.eas.weighbridge.OtherStorageBillEntryInfo;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.weighbridge.OtherStorageBillInfo;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class OtherStorageBillControllerBean extends AbstractOtherStorageBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.weighbridge.app.OtherStorageBillControllerBean");
    private static final String purInwareBosType="783061E3";//new PurInWarehsBillInfo().getBOSType().toString();
	private static final String OrderWeighQty="";//订单已过磅数量字段
	private static final String OrderEntryBosType="";//订单BOSTYPE
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		OtherStorageBillInfo info=(OtherStorageBillInfo)model;
		//禁止重复审核 
		if(info.getBillStatus().equals(WeighBaseStatus.audit)) {
			return;
		}
		//非完成状态不允许审核
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			return;
		}

		/*if(info.isIsAutoCreateToInvBill()) {
			WeighbridgeCommUtils.createToSCMBill(ctx, info, purInwareBosType);//采购入库单
		}*/

		info.setBillStatus(WeighBaseStatus.audit);
		info.setAuditTime(new java.util.Date());
		info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
			checkSaleOrderBillFlag(ctx,info.getPurOrderNumber());
			DbUtil.execute(ctx, "/*dialect*/update T_SM_PurOrder t1 set t1.CFISHASWGTBILL=1 where exists (select 1  from CT_WHB_InStorageBill t2 where t2.CFPurOrderNumber=t1.FNumber) and t1.CFISHASWGTBILL=0");
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		//info.
		OtherStorageBillInfo info=(OtherStorageBillInfo)model;
		IObjectPK pk =  super._save(ctx, model);
		// 订单不为空 同时 净重不为空  则更新对应订单的 过磅重量
		//updatePurorder(ctx,info);

		return pk;
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		OtherStorageBillInfo info=(OtherStorageBillInfo)model;
		//非完成、质检完成修改状态为完成
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			info.setBillStatus(WeighBaseStatus.finish);
		}
		IObjectPK pk = super._submit(ctx, info);

		// 订单不为空 同时 净重不为空  则更新对应订单的 过磅重量
		checkSaleOrderBillFlag(ctx,info.getPurOrderNumber());
		DbUtil.execute(ctx, "/*dialect*/update T_SM_PurOrder t1 set t1.CFISHASWGTBILL=1 where exists (select 1  from CT_WHB_InStorageBill t2 where t2.CFPurOrderNumber=t1.FNumber) and t1.CFISHASWGTBILL=0");
		updatePurorder(ctx,info);

		return pk;
	}
	/*
	 * 校验过磅完成是否应该反写采购订单的  过磅完成标志
	 */
	private void checkSaleOrderBillFlag(Context ctx, String purOrderNumber) {
		// TODO Auto-generated method stub
		if(StringUtils.isNotEmpty(purOrderNumber)){
			IRowSet rs;
			try {
				rs = DbUtil.executeQuery(ctx,"select t1.CFISHASWGTBILL,t2.FID from T_SM_PurOrder t1 left join CT_FM_QualityCheckBill t2 on t1.FID=t2.CFPurOrderID where t1.FNumber='"+purOrderNumber+"' order by t1.CFISHASWGTBILL desc ,t2.FID desc");
				if(rs.next()){
					//没有时清除标志
					if(rs.getBoolean("CFISHASWGTBILL")&&StringUtils.isEmpty(rs.getString("FID"))){
						DbUtil.execute(ctx,"update T_SM_PurOrder set CFisHasWgtBill=0 where FNumber='"+purOrderNumber+"'");
					}else if(!rs.getBoolean("CFISHASWGTBILL")&&StringUtils.isNotEmpty(rs.getString("FID"))){
						DbUtil.execute(ctx,"update T_SM_PurOrder set CFisHasWgtBill=1 where FNumber='"+purOrderNumber+"'");
					}
				}
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	/**
	 * 更新采购订单 过磅重量 和结算重量
	 * @param ctx
	 * @param info
	 * @throws BillBaseException 
	 */
	private void updatePurorder(Context ctx,OtherStorageBillInfo info) throws BillBaseException{
		try{
			String orderNumber = info.getPurOrderNumber();

			if(StringUtils.isNotBlank(orderNumber)){

				// 注意 只取第一行  订单分录进行比较 ，所有原料采购都只有一行分录，其他类型过磅  不依赖该算法
				//String searchSql = "select t.cfisSettleBySupplierQty,t.fid,te.fbaseqty from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid and te.fseq=1   where fnumber = ?";
				//yumingxu 0417
				String searchSql = "select t.cfisSettleBySupplierQty,t.fid,t.cfisfreight,t.cffreght,t.cfsendcardate,sum(te.fbaseqty) fbaseqty from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid where fnumber = ?  group by t.cfisSettleBySupplierQty,t.fid,t.cfisfreight,t.cffreght,t.cfsendcardate";
				String searchSqls = "select te.FPrice from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid where fnumber = ? and te.fseq = 1";

				Object[] args = {orderNumber};
				IRowSet rs = DbUtil.executeQuery(ctx, searchSql,args);
				IRowSet rsss = DbUtil.executeQuery(ctx, searchSqls,args);
				// 存在订单  继续操作 
				if(rs.next()){

					Boolean isSettleBySupplierQty = rs.getBoolean("cfisSettleBySupplierQty");
					Boolean isfreight = rs.getBoolean("cfisfreight");
					String orderID = rs.getString("fid");
					//运费单价
					BigDecimal freght = new BigDecimal("0");
					//公司承担亏重
					BigDecimal lostweghtstand = new BigDecimal("0");
					BigDecimal lostweghtstandAmount = new BigDecimal("0");
					BigDecimal lostweghtstandweight = new BigDecimal("0");
					//原料单价
					BigDecimal mprice =  new BigDecimal("0");
					
					// 添加关联关系
					BotpAppCommon.addRelations(ctx, "3171BFAD", orderID, this.getBOSType().toString(), info.getId().toString());

					// 订单 基本数量
					BigDecimal baseQty = rs.getBigDecimal("fbaseqty");
					if(baseQty == null) baseQty = new BigDecimal("0");


					// 按合同结算时  除了过磅净重，结算重量需要比较过磅重量和  订单 基本数量，按较小的一个更新 结算重量
					
					//String upSql = "update t_sm_purorderentry set cfnetWeight=?,cfconfirmInQty=? where fparentid=? and fmaterialid=?";
					//yumingxu 更新采购订单表头总数量，过磅净重和净重差异
					String upSql = "update t_sm_purorder set cfycts=?,cfycje=?,cfSumWeight=?,cfSumWeidiff=?,cflostweightAmount=?,cfsumkfreight=?,cfcyscdkz=? where fid=? ";
					BigDecimal netQty = new BigDecimal("0");
					BigDecimal yc = new BigDecimal("0");
					BigDecimal ycdate = new BigDecimal("0");
					for(int i = 0; i < info.getEntrys().size(); i++){
						OtherStorageBillEntryInfo entryInfo = info.getEntrys().get(i);
						if(entryInfo != null && entryInfo.getMaterial() != null){
							BigDecimal netQtys = entryInfo.getSuttle();
							String materialID = entryInfo.getMaterial().getId().toString();
							if(netQty != null ){
//								if(isSettleBySupplierQty){
//									//以供应商数量结算，计算亏重  
//									String sql = "select CFWeightstand from CT_WHB_LosWeightStand order by fcreatetime desc "; 
//									IRowSet rss = DbUtil.executeQuery(ctx, sql);
//									if(rss.next()){
//										lostweghtstand = rss.getBigDecimal("CFWeightstand");
//									}
//									if(rsss.next()){
//										mprice = rsss.getBigDecimal("FPrice");
//									}	
//								}
//								if(isfreight){
//									//承担运费
//									if(StringUtils.isBlank(rs.getString("cffreght"))){
//										freght = BigDecimal.ZERO;
//									}else{
//										freght = rs.getBigDecimal("cffreght");
//									}
//									
//									
//								}
								
								netQty  = netQty.add(netQtys);
							}
							//计算亏重金额
//							lostweghtstandweight = baseQty.subtract(netQty);
//							if(lostweghtstandweight.compareTo(BigDecimal.ZERO)==1){
//								lostweghtstandweight = baseQty.subtract(netQty).subtract(lostweghtstand);
//								if(lostweghtstandweight.compareTo(BigDecimal.ZERO)==1){
//									lostweghtstandAmount = lostweghtstandweight.multiply(mprice);
//								}else{
//									lostweghtstandAmount = BigDecimal.ZERO;
//								}
//								
//								
//							}
							//压车金额
							//过磅日期-派车日期-1=压车日期
							
//							if(StringUtils.isBlank(rs.getString("cfsendcardate"))){
//								System.out.println("订单压车日期为空");
//							}else{
//								String datediff = getDatePoor(entryInfo.getWeighTime(),rs.getDate("cfsendcardate"));
//								BigDecimal datediffs = new BigDecimal(datediff);
//								ycdate = datediffs.subtract(new BigDecimal("1"));
//								if(ycdate.compareTo(BigDecimal.ZERO)==1){
//									System.out.println("压车天数为"+ycdate);
//								}else{
//									ycdate = BigDecimal.ZERO;
//									System.out.println("压车时间合理，不存在压车金额");
//								}
//								
//							}	
							//yc = netQty.divide(new BigDecimal("1000"), 0, BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal("5")).multiply(ycdate);
							
							//已吨为单位 20180824
							//netQty = netQty.divide(new BigDecimal("1000"));
//							BigDecimal gbjz = netQty.divide(new BigDecimal("1000"),2,BigDecimal.ROUND_HALF_UP);
//							freght = freght.multiply(gbjz);
//							//加压车金额-亏重金额
//							freght = freght.add(yc).subtract(lostweghtstandAmount);
						}
					}
					//yumingxu 20180427
					
					
					Object[] upArgs = {ycdate,yc,netQty,netQty.subtract(baseQty),lostweghtstandAmount,freght,lostweghtstandweight,orderID};
					DbUtil.execute(ctx,upSql, upArgs);
				}
			}

			//			if(info.isIsAutoCreateToInvBill()) {
			//				WeighbridgeCommUtils.createToSCMBill(ctx, info, purInwareBosType);//采购入库单
			//			}
		}catch(Exception e) {
			throw new BillBaseException(new NumericExceptionSubItem("001",e.getMessage()));
		}
	}
	public static String getDatePoor(Date endDate, Date nowDate) {
		 
	    long nd = 1000 * 24 * 60 * 60;
	    long nh = 1000 * 60 * 60;
	    long nm = 1000 * 60;
	    // long ns = 1000;
	    // 获得两个时间的毫秒时间差异
	    long diff = endDate.getTime() - nowDate.getTime();
	    // 计算差多少天
	    long day = diff / nd;
	    // 计算差多少小时
	    long hour = diff % nd / nh;
	    // 计算差多少分钟
	    long min = diff % nd % nh / nm;
	    // 计算差多少秒//输出结果
	    // long sec = diff % nd % nh % nm / ns;
	    return day+"" ;
	}
	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		OtherStorageBillInfo info=(OtherStorageBillInfo)model;
		//反禁止重复审核
		if(!info.getBillStatus().equals(WeighBaseStatus.audit)) {
			return;
		}
		info.setBillStatus(WeighBaseStatus.save);
		info.setAuditTime(null);
		info.setAuditor(null);
		try {
			//检查是否存在下游单据
			WeighbridgeCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}

    
    
}