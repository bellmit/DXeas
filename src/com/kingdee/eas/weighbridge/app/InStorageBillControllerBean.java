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
	private static final String OrderWeighQty="";//�����ѹ��������ֶ�
	private static final String OrderEntryBosType="";//����BOSTYPE
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		InStorageBillInfo info=(InStorageBillInfo)model;
		//��ֹ�ظ���� 
		if(info.getBillStatus().equals(WeighBaseStatus.audit)) {
			return;
		}
		//�����״̬���������
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			return;
		}
		
		/*if(info.isIsAutoCreateToInvBill()) {
			WeighbridgeCommUtils.createToSCMBill(ctx, info, purInwareBosType);//�ɹ���ⵥ
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
		// ������Ϊ�� ͬʱ ���ز�Ϊ��  ����¶�Ӧ������ ��������
		//updatePurorder(ctx,info);
		super._save(ctx, info);
		return pk;
	}
	
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		InStorageBillInfo info=(InStorageBillInfo)model;
		//����ɡ��ʼ�����޸�״̬Ϊ���
		if(!info.getBillStatus().equals(WeighBaseStatus.finish)&&!info.getBillStatus().equals(WeighBaseStatus.qcFinish)) {
			info.setBillStatus(WeighBaseStatus.finish);
		}
		IObjectPK pk = super._submit(ctx, info);
		
		// ������Ϊ�� ͬʱ ���ز�Ϊ��  ����¶�Ӧ������ ��������
		updatePurorder(ctx,info);
		
		return pk;
	}
	
	/**
	 * �����ɳ��� ��������
	 * @param ctx
	 * @param info
	 * @throws BillBaseException 
	 */
	private void updatePurorder(Context ctx,InStorageBillInfo info) throws BillBaseException{
		CarSendBillInfo carinfo = info.getSendCar();
		if(carinfo!=null){
			BigDecimal Gross = BigDecimal.ZERO;
			for(int i = 0;i<info.getEntrys().size();i++){
				//�����ɳ�����ϸ����
				CarSendBillEntrysSInfo ssinfo = new CarSendBillEntrysSInfo();
				ssinfo.setDtime(info.getInTime());
				ssinfo.setDweight(info.getEntrys().get(i).getGross());
				Gross = Gross.add(info.getEntrys().get(i).getGross());
				carinfo.getEntrysS().add(ssinfo);
			}
			// �����ɳ�����������
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
	
	/**
	 * ������Ʒ�����յ�
	 * @throws BOSException 
	 */
	private void createCCReceiveBill(Context ctx, InStorageBillInfo info) throws BOSException {
		IObjectValue destBillInfo = null; // destBillBosType��Ŀ�굥��BOS����
		ICCReceivingBill iInstace = null;
		ObjectUuidPK destPK = null;
		IBTPManager btp = null;
		BTPTransformResult result = null;
		String bosType="4C3F10BD";//new CCReceivingBillInfo().getBOSType().toString();
		try {
			// ����BOTP�ӿ��Զ����ɵ���--��ⵥ
			btp = BTPManagerFactory.getLocalInstance(ctx);
			// [ע��]��ȡBTP�ı��ؽӿ�
			result = btp.transform(info, bosType);
			// [ע��] result��Ϊת���ɹ�����Ŀ�굥��
			// objectValue��Դ���ݵ�ֵ����
			destBillInfo = result.getBills().getObject(0);

			iInstace = CCReceivingBillFactory.getLocalInstance(ctx);

			destPK = new ObjectUuidPK(((CoreBaseInfo) destBillInfo).getId());// Ŀ�굥��Id

			// [ע��] ���浥�ݵĹ���ϵͳ
			btp.submitRelations(result.getBOTRelationCollection());
		} catch (Exception e1) {// botp ʧ�� ɾ������
			throw new BOSException(e1.getMessage());
		}
	}

	//����
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		//����ֹ�ظ����
		InStorageBillInfo info=(InStorageBillInfo)model;
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
		InStorageBillInfo info=(InStorageBillInfo)model;
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
		InStorageBillInfo info = InStorageBillFactory.getLocalInstance(ctx).getInStorageBillInfo(pk);
		if (info.getBillStatus().equals(WeighBaseStatus.finish)||info.getBillStatus().equals(WeighBaseStatus.audit)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":�����Ѿ���ɻ���ˣ���ֹɾ��"));
		}
		super._delete(ctx, pk);
	}
    
}