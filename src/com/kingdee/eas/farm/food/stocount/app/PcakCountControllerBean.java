package com.kingdee.eas.farm.food.stocount.app;

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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.eas.farm.food.CarExcuteCircsFactory;
import com.kingdee.eas.farm.food.CarExcuteCircsInfo;
import com.kingdee.eas.farm.food.comm.FarmCommUtils;
import com.kingdee.eas.farm.food.stocount.PcakCountCollection;
import com.kingdee.eas.farm.food.stocount.PcakCountFactory;

import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.food.stocount.PcakCountInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PcakCountControllerBean extends AbstractPcakCountControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.food.stocount.app.PcakCountControllerBean");
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PcakCountInfo info = (PcakCountInfo) model;
		info.setStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		PcakCountInfo info = (PcakCountInfo) model;
		info.setStatus(BillBaseStatusEnum.SUBMITED);
		return super._submit(ctx, info);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		PcakCountInfo info = (PcakCountInfo) model;
		// ��ֹ�ظ���� ���ύ�����
		if (!info.getStatus().equals(BillBaseStatusEnum.SUBMITED)) {
			return;
		}
		try {
			info.setStatus(BillBaseStatusEnum.AUDITED);
			//info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}

	

	/* (non-Javadoc)
	 * @see com.kingdee.eas.farm.food.stocount.app.AbstractPcakCountControllerBean#_unaudit(com.kingdee.bos.Context, com.kingdee.bos.dao.IObjectValue)
	 */
	@Override
	protected void _unaudit(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		PcakCountInfo info = (PcakCountInfo) model;
		// ����ֹ�ظ����
		if (!info.getStatus().equals(BillBaseStatusEnum.AUDITED)) {
			return;
		}
		try {
			FarmCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			info.setStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
			 //info.setAuditTime(null);
			info.setAuditor(null);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			logger.error(e);
			throw new BOSException(e);
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PcakCountInfo info = PcakCountFactory.getLocalInstance(ctx).getPcakCountInfo(pk);
		if (info.getStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":�����Ѿ���ˣ���ֹɾ��"));
		}
		super._delete(ctx, pk);
	}
}