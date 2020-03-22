package com.kingdee.eas.weighbridge.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
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

import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.weighbridge.InStorageBillFactory;
import com.kingdee.eas.weighbridge.InStorageBillInfo;
import com.kingdee.eas.weighbridge.TaraStorageBillCollection;
import com.kingdee.eas.weighbridge.TaraStorageBillFactory;
import com.kingdee.eas.weighbridge.WeighBaseStatus;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import java.math.BigDecimal;

import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.weighbridge.TaraStorageBillInfo;
import com.kingdee.eas.weighbridge.comm.WeighbridgeCommUtils;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.dx.weight.CarSendBillEntryInfo;
import com.kingdee.eas.custom.dx.weight.CarSendBillEntrysSInfo;
import com.kingdee.eas.custom.dx.weight.CarSendBillFactory;
import com.kingdee.eas.custom.dx.weight.CarSendBillInfo;
import com.kingdee.eas.custom.dx.weight.ICarSendBill;
import com.kingdee.eas.custom.taihe.weight.CarcassType;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class TaraStorageBillControllerBean extends AbstractTaraStorageBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.weighbridge.app.TaraStorageBillControllerBean");
    
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		TaraStorageBillInfo info=(TaraStorageBillInfo)model;
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
		TaraStorageBillInfo info=(TaraStorageBillInfo)model;
		super._save(ctx, info);
		return pk;
	}
	
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		TaraStorageBillInfo info=(TaraStorageBillInfo)model;
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
	private void updatePurorder(Context ctx,TaraStorageBillInfo info) throws BillBaseException{
		CarSendBillInfo carinfo;
		try {
			carinfo = CarSendBillFactory.getLocalInstance(ctx).getCarSendBillInfo(new ObjectUuidPK(info.getSendCar().getId().toString()));
		
		if(carinfo!=null){
			if(carinfo.isIsGross()){
				if(carinfo.getEntrysS().size()>=info.getEntrys().size()){
				BigDecimal Tara = BigDecimal.ZERO;
				for(int i = 0;i<info.getEntrys().size();i++){
					//�����ɳ�����ϸ����
					carinfo.getEntrysS().get(i).setPweight(info.getEntrys().get(i).getTare());
					Tara = Tara.add(info.getEntrys().get(i).getTare());
				}
				// �����ɳ�����������
				carinfo.setIsTara(true);
				carinfo.setIsweight(true);
				carinfo.setSumTara(Tara);	
				BigDecimal sut = BigDecimal.ZERO;
				sut = sut.add(carinfo.getSumGross()).subtract(Tara);			
//				CarSendBillEntryInfo einfo = new CarSendBillEntryInfo();
//				einfo.setWgt(sut);
//				einfo.setCarcassType(CarcassType.gross);
//				carinfo.getEntrys().add(einfo);
				
				carinfo.setSuttleWgt(sut);

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
				}else{
					throw new EASBizException(new NumericExceptionSubItem("001","Ƥ�ع�����������ë�ع�����������ֹƤ����ɣ�"));
				}
				
			}else{
				try {
					throw new EASBizException(new NumericExceptionSubItem("001","ë��δ������ɣ���ֹƤ����ɣ�"));
				} catch (EASBizException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		} catch (EASBizException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (BOSException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException {
		TaraStorageBillInfo info=(TaraStorageBillInfo)model;
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
		TaraStorageBillInfo info=(TaraStorageBillInfo)model;
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
		TaraStorageBillInfo info=(TaraStorageBillInfo)model;
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
		TaraStorageBillInfo info = TaraStorageBillFactory.getLocalInstance(ctx).getTaraStorageBillInfo(pk);
		if (info.getBillStatus().equals(WeighBaseStatus.finish)||info.getBillStatus().equals(WeighBaseStatus.audit)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":�����Ѿ���ɻ���ˣ���ֹɾ��"));
		}
		super._delete(ctx, pk);
	}
	
	
}