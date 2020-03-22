package com.kingdee.eas.weighbridge.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.weighbridge.OutStorageBillFactory;
import com.kingdee.eas.weighbridge.OutStorageBillInfo;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.util.NumericExceptionSubItem;

public class OutStorageBillControllerBean extends AbstractOutStorageBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.weighbridge.app.OutStorageBillControllerBean");
    private static final String SaleIssueBosType="CC3E933B";//new SaleIssueBillInfo().getBOSType().toString();
	private static final String OrderWeighQty="";//订单已过磅数量字段
	private static final String OrderEntryBosType="";//订单BOSTYPE
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		OutStorageBillInfo info=(OutStorageBillInfo)model;
		//禁止重复审核 
		if(info.getBillStatus().equals(WeighBaseStatus.audit)) {
			return;
		}
		//非完成状态不允许审核
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			return;
		}
		
		/*if(info.isIsAutoCreateToInvBill()) {
			WeighbridgeCommUtils.createToSCMBill(ctx, info, SaleIssueBosType);//销售出库单
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
		IObjectPK pk = super._save(ctx, model);
		return pk;
	}
	
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		OutStorageBillInfo info=(OutStorageBillInfo)model;
		//非完成、质检完成修改状态为完成
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			info.setBillStatus(WeighBaseStatus.finish);
		}
		reWriteSaleOrderStatus(ctx, info);
		 IObjectPK pk = super._submit(ctx, info);
		try{
			if(info.isIsAutoCreateToInvBill()) {
				WeighbridgeCommUtils.createToSCMBill(ctx, info, SaleIssueBosType);//采购入库单
			}
		}catch(Exception e) {
			throw new BillBaseException(new NumericExceptionSubItem("001",e.getMessage()));
		}
		return pk;
	}
	/**
	 * 反写销售订单过磅状态
	 * @param ctx
	 * @param info
	 */
	private void reWriteSaleOrderStatus(Context ctx,OutStorageBillInfo info) {
		try {
			String saleOrderEntryID;
			for(int i=0;i<info.getEntrys().size();i++) {
				for(int j=0;j<info.getEntrys().get(i).getDetail().size();j++) {
					saleOrderEntryID=info.getEntrys().get(i).getDetail().get(j).getSourceEntryID();
					//反写订单过磅状态
					DbUtil.execute(ctx, "update t_sd_saleOrderEntry set cfweighted='1' where fid='"+saleOrderEntryID+"'");
				}
			}
		}catch(Exception err) {
			err.printStackTrace();
		}
	}
	
	
	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		OutStorageBillInfo info=(OutStorageBillInfo)model;
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
	

	//作废
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		//反禁止重复审核
		OutStorageBillInfo info=(OutStorageBillInfo)model;
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
		OutStorageBillInfo info=(OutStorageBillInfo)model;
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
		OutStorageBillInfo info = OutStorageBillFactory.getLocalInstance(ctx).getOutStorageBillInfo(pk);
		if (info.getBillStatus().equals(WeighBaseStatus.finish)||info.getBillStatus().equals(WeighBaseStatus.audit)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经完成或审核，禁止删除"));
		}
		super._delete(ctx, pk);
	}
}