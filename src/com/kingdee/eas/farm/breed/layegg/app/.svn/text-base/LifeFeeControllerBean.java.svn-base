package com.kingdee.eas.farm.breed.layegg.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;

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
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.breed.layegg.BillStatus;
import com.kingdee.eas.farm.breed.layegg.LifeFeeFactory;
import com.kingdee.eas.farm.breed.layegg.LifeFeeInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.breed.layegg.LifeFeeCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.eas.custom.commld.BotpUtils;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LifeFeeControllerBean extends AbstractLifeFeeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.breed.layegg.app.LifeFeeControllerBean");

    /**
     * 审核
     */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		LifeFeeInfo info=(LifeFeeInfo) model;
		if(!info.getBillStatus().equals(BillStatus.submit))
			throw new EASBizException(new NumericExceptionSubItem("","只能审核提交状态的单据"));
        UserInfo user = (UserInfo)ctx.get(SysContextConstant.USERINFO);
        Date date = new Date();
        info.setAuditor(user);
        info.setAuditTime(date);
        info.setBillStatus(BillStatus.audit);
        super._save(ctx, model);
	}

	/**
	 * 反审核
	 * @throws EASBizException 
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		LifeFeeInfo info = (LifeFeeInfo)model;
        if(!info.getBillStatus().equals(BillStatus.audit))
            throw new EASBizException(new NumericExceptionSubItem("001","只允许反审核审核状态的单据"));
        if(BotpUtils.checkIsExistDownBill(ctx, info, info.getBOSType().toString(), null, null, "DOWN"))
        	throw new EASBizException(new NumericExceptionSubItem("001","存在下游单据，禁止此操作"));
        info.setAuditor(null);
        info.setAuditTime(null);
        info.setBillStatus(BillStatus.save);
        super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		LifeFeeInfo info = LifeFeeFactory.getLocalInstance(ctx).getLifeFeeInfo(pk);
		if(info.getBillStatus().equals(BillStatus.audit))
            throw new EASBizException(new NumericExceptionSubItem("001","单子已经审过了，要不客官您先反审核一下"));
		super._delete(ctx, pk);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		LifeFeeInfo info = (LifeFeeInfo)model;
        if(!info.getBillStatus().equals(BillStatus.save))
            throw new EASBizException(new NumericExceptionSubItem("001","该操作只适用保存状态的单据"));
		return super._save(ctx, info);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		LifeFeeInfo info = (LifeFeeInfo)model;
        if(!info.getBillStatus().equals(BillStatus.save)&&!info.getBillStatus().equals(BillStatus.submit))
            throw new EASBizException(new NumericExceptionSubItem("001","该操作只适用保存或提交状态的单据"));
        info.setBillStatus(BillStatus.submit);
		return super._submit(ctx, model);
	}
}