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
	private static final String OrderWeighQty="";//�����ѹ��������ֶ�
	private static final String OrderEntryBosType="";//����BOSTYPE
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		OutStorageBillInfo info=(OutStorageBillInfo)model;
		//��ֹ�ظ���� 
		if(info.getBillStatus().equals(WeighBaseStatus.audit)) {
			return;
		}
		//�����״̬���������
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			return;
		}
		
		/*if(info.isIsAutoCreateToInvBill()) {
			WeighbridgeCommUtils.createToSCMBill(ctx, info, SaleIssueBosType);//���۳��ⵥ
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
		//����ɡ��ʼ�����޸�״̬Ϊ���
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			info.setBillStatus(WeighBaseStatus.finish);
		}
		reWriteSaleOrderStatus(ctx, info);
		 IObjectPK pk = super._submit(ctx, info);
		try{
			if(info.isIsAutoCreateToInvBill()) {
				WeighbridgeCommUtils.createToSCMBill(ctx, info, SaleIssueBosType);//�ɹ���ⵥ
			}
		}catch(Exception e) {
			throw new BillBaseException(new NumericExceptionSubItem("001",e.getMessage()));
		}
		return pk;
	}
	/**
	 * ��д���۶�������״̬
	 * @param ctx
	 * @param info
	 */
	private void reWriteSaleOrderStatus(Context ctx,OutStorageBillInfo info) {
		try {
			String saleOrderEntryID;
			for(int i=0;i<info.getEntrys().size();i++) {
				for(int j=0;j<info.getEntrys().get(i).getDetail().size();j++) {
					saleOrderEntryID=info.getEntrys().get(i).getDetail().get(j).getSourceEntryID();
					//��д��������״̬
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
		//����ֹ�ظ����
		if(!info.getBillStatus().equals(WeighBaseStatus.audit)) {
			return;
		}
		info.setBillStatus(WeighBaseStatus.save);
		info.setAuditTime(null);
		info.setAuditor(null);
		try {
			//����Ƿ�������ε���
			WeighbridgeCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}
	

	//����
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		//����ֹ�ظ����
		OutStorageBillInfo info=(OutStorageBillInfo)model;
		if(info.getBillStatus().equals(WeighBaseStatus.audit)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�����Ѿ���ˣ�����ֹ����"));
		}
		info.setBillStatus(WeighBaseStatus.cancel);
		try {
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			throw new BOSException(e);
		}
	}
	
	/**
	 * ������
	 */
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		OutStorageBillInfo info=(OutStorageBillInfo)model;
		if(!info.getBillStatus().equals(WeighBaseStatus.cancel)) {
			throw new EASBizException(new NumericExceptionSubItem("001","�õ���û�б����ϣ���������ʧ��"));
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
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":�����Ѿ���ɻ���ˣ���ֹɾ��"));
		}
		super._delete(ctx, pk);
	}
}