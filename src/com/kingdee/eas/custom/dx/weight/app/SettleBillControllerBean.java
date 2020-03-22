package com.kingdee.eas.custom.dx.weight.app;

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

import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.custom.dx.weight.SettleBillFactory;
import com.kingdee.eas.custom.dx.weight.SettleBillInfo;
import com.kingdee.eas.custom.dx.weight.SettleReFactory;
import com.kingdee.eas.custom.dx.weight.SettleReInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.dx.weight.SettleBillCollection;
import com.kingdee.eas.custom.settlebill.billStatus;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.util.app.DbUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SettleBillControllerBean extends AbstractSettleBillControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.dx.weight.app.SettleBillControllerBean");
    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SettleBillInfo info = (SettleBillInfo) model;
		info.setBillStatus(billStatus.SAVE);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		SettleBillInfo info = (SettleBillInfo) model;
		info.setBillStatus(billStatus.SUBMIT);
		return super._submit(ctx, info);
	}
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		SettleBillInfo info = (SettleBillInfo) model;
		
		// ��ֹ�ظ���� ���ύ�����
		try {
			info.setBillStatus(billStatus.AUDIT);
			//info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
			upCarbill(info,ctx,true);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}
	//��д�ɳ���
	private void upCarbill(SettleBillInfo info, Context ctx, boolean b) {
		// TODO Auto-generated method stub
		String carid = info.getCarSend().getId().toString();
		String sql = "";
		if(b){
			sql = "update CT_DX_CarSendBill set  CFIsSettle = 1 where fid = '"+carid+"'";
		}else{
			sql = "update CT_DX_CarSendBill set  CFIsSettle = 0 where fid = '"+carid+"'";

		}
			
		try {
			DbUtil.execute(ctx,sql);
		} catch (BOSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		SettleBillInfo info = (SettleBillInfo) model;
		// ����ֹ�ظ����
		try {
			FarmCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			info.setBillStatus(billStatus.SAVE);
			 //info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
			upCarbill(info,ctx,false);
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SettleBillInfo info = SettleBillFactory.getLocalInstance(ctx).getSettleBillInfo(pk);
		if (info.getBillStatus().equals(billStatus.AUDIT)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":�����Ѿ���ˣ���ֹɾ��"));
		}
		IObjectPK pks = LogUtil.beginLog(ctx, "_delete", info.getBOSType(), pk, "ɾ��ë�����㵥��"+info.getNumber());
		super._delete(ctx, pk);
		LogUtil.afterLog(ctx, pks);
	}
}