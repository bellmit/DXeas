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
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.base.log.LogUtil;
import com.kingdee.eas.custom.dx.weight.CarSendBillFactory;
import com.kingdee.eas.custom.dx.weight.CarSendBillInfo;
import com.kingdee.eas.custom.dx.weight.SettleReCollection;
import com.kingdee.eas.custom.dx.weight.SettleReFactory;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.BillBaseException;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.custom.dx.weight.SettleReInfo;
import com.kingdee.eas.custom.settlebill.billStatus;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SettleReControllerBean extends AbstractSettleReControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.dx.weight.app.SettleReControllerBean");
    
    @Override
	protected IObjectPK _save(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SettleReInfo info = (SettleReInfo) model;
		info.setBillStatus(billStatus.SAVE);
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		SettleReInfo info = (SettleReInfo) model;
		info.setBillStatus(billStatus.SUBMIT);
		return super._submit(ctx, info);
	}
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
	SettleReInfo info = (SettleReInfo) model;
		
		// Ω˚÷π÷ÿ∏¥…Û∫À ∑«Ã·Ωª≤ª…Û∫À
		try {
			info.setBillStatus(billStatus.AUDIT);
			//info.setAuditTime(new java.util.Date());
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (Exception ex) {
			throw new BOSException(ex);
		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		SettleReInfo info = (SettleReInfo) model;
		// ∑¥Ω˚÷π÷ÿ∏¥…Û∫À
		try {
			FarmCommUtils.isExitBTPBill(ctx, new ObjectUuidPK(info.getId()), info);
			info.setBillStatus(billStatus.SAVE);
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
		SettleReInfo info = SettleReFactory.getLocalInstance(ctx).getSettleReInfo(pk);
		if (info.getBillStatus().equals(billStatus.AUDIT)) {
			throw new BillBaseException(new NumericExceptionSubItem("001", info.getNumber() + ":µ•æ›“—æ≠…Û∫À£¨Ω˚÷π…æ≥˝"));
		}
		IObjectPK pks = LogUtil.beginLog(ctx, "_delete", info.getBOSType(), pk, "…æ≥˝Ω·À„ºÏ≤‚µ•£∫"+info.getNumber());
		super._delete(ctx, pk);
		LogUtil.afterLog(ctx, pks);
	}
    
}