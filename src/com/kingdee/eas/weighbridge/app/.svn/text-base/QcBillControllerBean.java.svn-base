package com.kingdee.eas.weighbridge.app;

import org.apache.log4j.Logger;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.Context;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.weighbridge.QcBillFactory;
import com.kingdee.eas.weighbridge.QcBillInfo;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.util.NumericExceptionSubItem;

public class QcBillControllerBean extends AbstractQcBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.weighbridge.app.QcBillControllerBean");
    @Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		QcBillInfo info=(QcBillInfo)model;
		//禁止重复审核 
		//非完成状态不允许审核
		if(!info.getBillStatus().equals(BillBaseStatusEnum.SUBMITED)&&info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			return;
		}
		
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
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
		QcBillInfo info=(QcBillInfo)model;
		//非完成、质检完成修改状态为完成
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, model);
	}
	
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		QcBillInfo info=(QcBillInfo)model;
		//非完成、质检完成修改状态为完成
		info.setBillStatus(BillBaseStatusEnum.SUBMITED);
		 IObjectPK pk = super._submit(ctx, info);
		return pk;
	}
	
	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		QcBillInfo info=(QcBillInfo)model;
		//反禁止重复审核
		if(!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			return;
		}
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
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
		QcBillInfo info=(QcBillInfo)model;
		if(info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","单据已经审核！，禁止作废"));
		}
		info.setBillStatus(BillBaseStatusEnum.DELETED);
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
		QcBillInfo info=(QcBillInfo)model;
		if(!info.getBillStatus().equals(BillBaseStatusEnum.DELETED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","该单据没有被作废！，反作废失败"));
		}
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		QcBillInfo info = QcBillFactory.getLocalInstance(ctx).getQcBillInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":单据已经审核，禁止删除"));
		}
		super._delete(ctx, pk);
	}
}