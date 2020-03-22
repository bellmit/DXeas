package com.kingdee.eas.weighbridge.app;

import java.math.BigDecimal;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.base.btp.BTPManagerFactory;
import com.kingdee.eas.base.btp.BTPTransformResult;
import com.kingdee.eas.base.btp.IBTPManager;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.dx.weight.CarSendBillCollection;
import com.kingdee.eas.custom.dx.weight.CarSendBillEntryInfo;
import com.kingdee.eas.custom.dx.weight.CarSendBillEntrysS;
import com.kingdee.eas.custom.dx.weight.CarSendBillEntrysSInfo;
import com.kingdee.eas.custom.dx.weight.CarSendBillFactory;
import com.kingdee.eas.custom.dx.weight.CarSendBillInfo;
import com.kingdee.eas.custom.dx.weight.ICarSendBill;
import com.kingdee.eas.custom.taihe.weight.CarcassType;
import com.kingdee.eas.farm.food.CCReceivingBillFactory;
import com.kingdee.eas.farm.food.ICCReceivingBill;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.weighbridge.InStorageBillEntryInfo;
import com.kingdee.eas.weighbridge.InStorageBillFactory;
import com.kingdee.eas.weighbridge.InStorageBillInfo;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.eas.wlhlcomm.BotpAppCommon;
import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.util.NumericExceptionSubItem;

public class InStorageBillControllerBean extends AbstractInStorageBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.weighbridge.app.InStorageBillControllerBean");

	private static final String purInwareBosType="783061E3";//new PurInWarehsBillInfo().getBOSType().toString();
	private static final String OrderWeighQty="";//订单已过磅数量字段
	private static final String OrderEntryBosType="";//订单BOSTYPE
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		InStorageBillInfo info=(InStorageBillInfo)model;
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
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}
	
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		IObjectPK pk =  super._save(ctx, model);
		InStorageBillInfo info=(InStorageBillInfo)model;
		// 订单不为空 同时 净重不为空  则更新对应订单的 过磅重量
		//updatePurorder(ctx,info);
		super._save(ctx, info);
		return pk;
	}
	
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		InStorageBillInfo info=(InStorageBillInfo)model;
		//非完成、质检完成修改状态为完成
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			info.setBillStatus(WeighBaseStatus.finish);
		}
		IObjectPK pk = super._submit(ctx, info);
		
		// 订单不为空 同时 净重不为空  则更新对应订单的 过磅重量
		updatePurorder(ctx,info);
		
		return pk;
	}
	
	/**
	 * 更新派车单 过磅数据
	 * @param ctx
	 * @param info
	 * @throws BillBaseException 
	 */
	private void updatePurorder(Context ctx,InStorageBillInfo info) throws BillBaseException{
		CarSendBillInfo carinfo = info.getSendCar();
		if(carinfo!=null){
			BigDecimal Gross = BigDecimal.ZERO;
			for(int i = 0;i<info.getEntrys().size();i++){
				//更新派车单明细数据
				CarSendBillEntrysSInfo ssinfo = new CarSendBillEntrysSInfo();
				ssinfo.setDtime(info.getInTime());
				ssinfo.setDweight(info.getEntrys().get(i).getGross());
				Gross = Gross.add(info.getEntrys().get(i).getGross());
				carinfo.getEntrysS().add(ssinfo);
			}
			// 更新派车单胴体数据
//			CarSendBillEntryInfo einfo = new CarSendBillEntryInfo();
//			einfo.setWgt(Gross);
//			einfo.setCarcassType(CarcassType.gross);
//			carinfo.getEntrys().add(einfo);
			carinfo.setIsGross(true);
			carinfo.setSumGross(Gross);
			try {
				ICarSendBill pk = CarSendBillFactory.getLocalInstance(ctx);
				IObjectPK pk1=new ObjectUuidPK(carinfo.getId());
				pk.update(pk1, carinfo);
			} catch (BOSException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (EASBizException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		InStorageBillInfo info=(InStorageBillInfo)model;
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
	private void createCCReceiveBill(Context ctx, InStorageBillInfo info) throws BOSException {
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
		InStorageBillInfo info=(InStorageBillInfo)model;
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
		InStorageBillInfo info=(InStorageBillInfo)model;
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
		InStorageBillInfo info = InStorageBillFactory.getLocalInstance(ctx).getInStorageBillInfo(pk);
		if (info.getBillStatus().equals(WeighBaseStatus.finish)||info.getBillStatus().equals(WeighBaseStatus.audit)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经完成或审核，禁止删除"));
		}
		super._delete(ctx, pk);
	}
    
}