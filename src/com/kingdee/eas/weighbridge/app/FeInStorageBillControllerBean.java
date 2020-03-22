package com.kingdee.eas.weighbridge.app;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.dao.query.SQLExecutorFactory;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commonld.CommFacadeFactory;
import com.kingdee.eas.farm.food.CCReceivingBillFactory;
import com.kingdee.eas.farm.food.ICCReceivingBill;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.weighbridge.FeInStorageBillEntryInfo;
import com.kingdee.eas.weighbridge.FeInStorageBillFactory;
import com.kingdee.eas.weighbridge.FeInStorageBillInfo;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.WeighBizType;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class FeInStorageBillControllerBean extends AbstractFeInStorageBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.weighbridge.app.FeInStorageBillControllerBean");
    
    private static final String purInwareBosType="783061E3";//new PurInWarehsBillInfo().getBOSType().toString();
	private static final String OrderWeighQty="";//订单已过磅数量字段
	private static final String OrderEntryBosType="";//订单BOSTYPE
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
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
			//checkSaleOrderBillFlag(ctx,info.getPurnumber());
			//DbUtil.execute(ctx, "/*dialect*/update T_SM_PurOrder t1 set t1.CFISHASWGTBILL=1 where exists (select 1  from CT_WHB_InStorageBill t2 where t2.CFPurOrderNumber=t1.FNumber) and t1.CFISHASWGTBILL=0");
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		//info.
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
		IObjectPK pk =  super._save(ctx, model);
		// 订单不为空 同时 净重不为空  则更新对应订单的 过磅重量
		//updatePurorder(ctx,info);

		return pk;
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
		//非完成、质检完成修改状态为完成
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			info.setBillStatus(WeighBaseStatus.finish);
		}
		IObjectPK pk = super._submit(ctx, info);

		// 订单不为空 同时 净重不为空  则更新对应订单的 过磅重量
		checkSaleOrderBillFlag(ctx,info.getPurnumber());
		DbUtil.execute(ctx, "/*dialect*/update T_SM_PurOrder t1 set t1.CFISHASWGTBILL=1 where exists (select 1  from CT_WHB_InStorageBill t2 where t2.CFPurOrderNumber=t1.FNumber) and t1.CFISHASWGTBILL=0");
		if(info.getBizType().getValue().equals(WeighBizType.Pur)){
			updatePurorder(ctx,info);
		}else{
			updateQC(ctx,info);
		}

		return pk;
	}
	//更新质检单
	private void updateQC(Context ctx, FeInStorageBillInfo info) {
		// TODO Auto-generated method stub
		if(info.getPurnumber()!=null){
			String upDate = " update CT_FM_QualityCheckBill set CFIsWeight=1  where fnumber=? ";
			Object[] upDateArgs = {info.getPurnumber()};
			try {
				DbUtil.execute(ctx,upDate, upDateArgs);
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
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
	private void updatePurorder(Context ctx,FeInStorageBillInfo info) throws BillBaseException{
		try{
			String orderNumber = info.getPurnumber();

			if(StringUtils.isNotBlank(orderNumber)){

				// 注意 只取第一行  订单分录进行比较 ，所有原料采购都只有一行分录，其他类型过磅  不依赖该算法
				//String searchSql = "select t.cfisSettleBySupplierQty,t.fid,te.fbaseqty from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid and te.fseq=1   where fnumber = ?";
				//yumingxu 0417
				String searchSql = "select t.cfisSettleBySupplierQty,t.FPurchaseOrgUnitID,t.fid,t.cfisfreight,t.cffreght,t.cfsendcardate,sum(te.fbaseqty) fbaseqty from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid where fnumber = ?  group by t.cfisSettleBySupplierQty,t.fid,t.cfisfreight,t.cffreght,t.cfsendcardate,t.FPurchaseOrgUnitID";
				String searchSqls = "select max(te.FPrice) FPrice from t_sm_purorder t inner join t_sm_purorderentry te on t.fid = te.fparentid where fnumber = ? ";

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
					
					//采购组织
					String FPurchaseOrgUnitID = rs.getString("FPurchaseOrgUnitID");
					// 添加关联关系
					BotpAppCommon.addRelations(ctx, "3171BFAD", orderID, this.getBOSType().toString(), info.getId().toString());

					// 订单 基本数量
					BigDecimal baseQty = rs.getBigDecimal("fbaseqty");
					if(baseQty == null) baseQty = new BigDecimal("0");


					// 按合同结算时  除了过磅净重，结算重量需要比较过磅重量和  订单 基本数量，按较小的一个更新 结算重量
					
					//String upSql = "update t_sm_purorderentry set cfnetWeight=?,cfconfirmInQty=? where fparentid=? and fmaterialid=?";
					//yumingxu 更新采购订单表头总数量，过磅净重和净重差异
					String upSql = "/*dialect*/ update t_sm_purorder set cfycts=?,cfycje=?,cfSumWeight=?,cfSumWeidiff=?,cflostweightAmount=?,cfsumkfreight=?,cfcyscdkz=? where fid=? ";
					//String upDate = " update t_sm_purorder set cfoutdate=to_date(?,'yyyy-MM-dd')  where fid=? ";
					String upDate = " update t_sm_purorder set cfoutdate=SYSDATE  where fid=? ";

					BigDecimal netQty = new BigDecimal("0");
					BigDecimal yc = new BigDecimal("0");
					BigDecimal ycdate = new BigDecimal("0");
					for(int i = 0; i < info.getEntrys().size(); i++){
						FeInStorageBillEntryInfo entryInfo = info.getEntrys().get(i);
						if(entryInfo != null && entryInfo.getMaterial() != null){
							BigDecimal netQtys = entryInfo.getSuttle();
							String materialID = entryInfo.getMaterial().getId().toString();

							netQty  = netQty.add(netQtys);
							
							//压车金额
							//过磅日期-派车日期-1=压车日期
							
							if(StringUtils.isBlank(rs.getString("cfsendcardate"))){
								System.out.println("订单压车日期为空");
							}else{
								String datediff = getDatePoor(entryInfo.getWeighTime(),rs.getDate("cfsendcardate"));
								BigDecimal datediffs = new BigDecimal(datediff);
								ycdate = datediffs.subtract(new BigDecimal("1"));
								if(ycdate.compareTo(BigDecimal.ZERO)==1){
									System.out.println("压车天数为"+ycdate);
								}else{
									ycdate = BigDecimal.ZERO;
									System.out.println("压车时间合理，不存在压车金额");
								}
								
							}
							
						}
					}
					if(netQty != null ){
						if(isSettleBySupplierQty){
							//以供应商数量结算，计算亏重  
							String sql = "select CFWeightstand from CT_WHB_LosWeightStand where CFCompanyID ='"+FPurchaseOrgUnitID+"' order by fcreatetime desc "; 
							IRowSet rss = DbUtil.executeQuery(ctx, sql);
							if(rss.next()){
								lostweghtstand = rss.getBigDecimal("CFWeightstand");
							}
							if(rsss.next()){
								mprice = rsss.getBigDecimal("FPrice");
							}
							//计算亏重金额
							lostweghtstandweight = baseQty.subtract(netQty);
							if(lostweghtstandweight.compareTo(BigDecimal.ZERO)==1){
								lostweghtstandweight = baseQty.subtract(netQty).subtract(lostweghtstand);
								if(lostweghtstandweight.compareTo(BigDecimal.ZERO)==1){
									lostweghtstandAmount = lostweghtstandweight.multiply(mprice);
								}else{
									lostweghtstandAmount = BigDecimal.ZERO;
									lostweghtstandweight = BigDecimal.ZERO;
								}
								
								
							}
						}
						if(isfreight){
							//承担运费
							if(StringUtils.isBlank(rs.getString("cffreght"))){
								freght = BigDecimal.ZERO;
							}else{
								freght = rs.getBigDecimal("cffreght");
							}
 
							
						}
						
					}
					
						
					yc = netQty.divide(new BigDecimal("1000"), 0, BigDecimal.ROUND_HALF_DOWN).multiply(new BigDecimal("5")).multiply(ycdate);
					
					//已吨为单位 20180824
					//netQty = netQty.divide(new BigDecimal("1000"));
					BigDecimal gbjz = netQty.divide(new BigDecimal("1000"),3,BigDecimal.ROUND_HALF_UP);
					//freght = freght.multiply(gbjz);
					BigDecimal jbsl = baseQty.divide(new BigDecimal("1000"),3,BigDecimal.ROUND_HALF_UP);

					freght = freght.multiply(jbsl).setScale(2, BigDecimal.ROUND_HALF_UP);
					//加压车金额-亏重金额
					//freght = freght.add(yc).subtract(lostweghtstandAmount).setScale(2,BigDecimal.ROUND_HALF_UP);
					
					
					//yumingxu 20180427
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					//String dateString = formatter.format();
					//dateString = " to_date('"+dateString+"','yyyy-MM-dd')";
					Object[] upDateArgs = {orderID};
					Object[] upArgs = {ycdate,yc,netQty.setScale(0,BigDecimal.ROUND_HALF_UP),netQty.subtract(baseQty).setScale(0,BigDecimal.ROUND_HALF_UP),lostweghtstandAmount.setScale(2,BigDecimal.ROUND_HALF_UP),freght,lostweghtstandweight.setScale(0,BigDecimal.ROUND_HALF_UP),orderID};
					DbUtil.execute(ctx,upSql, upArgs);
					DbUtil.execute(ctx,upDate, upDateArgs);
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
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
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

	/**
	 * 生成商品鸡接收单
	 * @throws BOSException 
	 */
	private void createCCReceiveBill(Context ctx, FeInStorageBillInfo info) throws BOSException {
		IObjectValue destBillInfo = null; // destBillBosType：目标单据BOS类型
		ICCReceivingBill iInstace = null;
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;
		String bosType="4C3F10BD";//new CCReceivingBillInfo().getBOSType().toString();
		try {
			// 调用BOTP接口自动生成单据--入库单
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [注释]获取BTP的本地接口
			result = btp.transform(info, bosType);
			// [注释] result：为转换成功生的目标单据
			// objectValue：源单据的值对象
			destBillInfo = result.getBills().getObject(0);

			iInstace = CCReceivingBillFactory.getLocalInstance(ctx);

			destPK = new ObjectUuidPK(((CoreBaseInfo) destBillInfo).getId());// 目标单据Id

			// [注释] 保存单据的关联系统
			btp.submitRelations(result.getBOTRelationCollection());
		} catch (Exception e1) {// botp 失败 删除单据
			throw new BOSException(e1.getMessage());
		}
	}

	//作废
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		//反禁止重复审核
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
		if(info.getBillStatus().equals(WeighBaseStatus.audit)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核！，禁止作废"));
		}
		info.setBillStatus(WeighBaseStatus.cancel);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}

	/**
	 * 反作废
	 */
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		FeInStorageBillInfo info=(FeInStorageBillInfo)model;
		if(!info.getBillStatus().equals(WeighBaseStatus.cancel)) {
			throw new EASBizException(new NumericExceptionSubItem("001","该单据没有被作废！，反作废失败"));
		}
		info.setBillStatus(WeighBaseStatus.save);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e); 
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		FeInStorageBillInfo info = FeInStorageBillFactory.getLocalInstance(ctx).getFeInStorageBillInfo(pk);
		if (info.getBillStatus().equals(WeighBaseStatus.finish)||info.getBillStatus().equals(WeighBaseStatus.audit)||info.getBillStatus().equals(WeighBaseStatus.gross)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经完成或审核，禁止删除"));
		}
		//String purOrderNum = info.getPurnumber();
		super._delete(ctx, pk);
		//checkSaleOrderBillFlag(ctx,purOrderNum);
	}
}