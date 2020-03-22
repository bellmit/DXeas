package com.kingdee.eas.farm.carnivorous.basedata.app;

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

import com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenFactory;
import com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo;
import com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyFactory;
import com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyInfo;
import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.DateUtilsComm;
import com.kingdee.eas.custom.commld.ServerUtils;
import com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenCollection;
import com.kingdee.eas.scm.common.BillBaseStatusEnum;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class InvestmentPolicyChickenControllerBean extends AbstractInvestmentPolicyChickenControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.farm.carnivorous.basedata.app.InvestmentPolicyChickenControllerBean");
    
    @Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
    	InvestmentPolicyChickenInfo info = (InvestmentPolicyChickenInfo) model;
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED) ) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准！"));
		}
		info.setBillStatus(BillBaseStatusEnum.AUDITED);
		try {
			info.setAuditor(ContextUtil.getCurrentUserInfo(ctx));
			info.setAuditTime(new java.util.Date());
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		InvestmentPolicyChickenInfo info = (InvestmentPolicyChickenInfo) model;
		if (!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED) ) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准！"));
		}
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		try {
			info.setAuditor(null);
			info.setAuditTime(null);
			this._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			e.printStackTrace();
		}
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		InvestmentPolicyChickenInfo info = InvestmentPolicyChickenFactory.getLocalInstance(ctx).getInvestmentPolicyChickenInfo(pk);
		if (info.getBillStatus().equals(BillBaseStatusEnum.AUDITED) 
				|| info.getBillStatus().equals(BillBaseStatusEnum.cancelcancel) ) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料已经核准或启用！"));
		}
		super._delete(ctx, pk);
	}
	
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		InvestmentPolicyChickenInfo info = (InvestmentPolicyChickenInfo) model;
		if(info.getBillStatus()!=null 
				&& !info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)
				&&!info.getBillStatus().equals(BillBaseStatusEnum.CLOSED)) {
			info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		}
		return super._save(ctx, model);
	}
	
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		if(model.getInt("billStatus")!=-1&&model.getInt("billStatus")!=0&&model.getInt("billStatus")!=1&&model.getInt("billStatus")!=2)
			throw new EASBizException(ServerUtils.CHECKSUBMIT);
		InvestmentPolicyChickenInfo info = (InvestmentPolicyChickenInfo) model;
		model.setDate("bizDate", DateUtilsComm.clearDateHMS(model.getDate("bizDate")));
		model.setInt("billStatus", 2);
		return super._submit(ctx, model);
	}

	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		InvestmentPolicyChickenInfo info = (InvestmentPolicyChickenInfo) model;
		if (!info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)
				&& !info.getBillStatus().equals(BillBaseStatusEnum.cancelcancel)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未核准,或者未启用！"));
		}
		info.setBillStatus(BillBaseStatusEnum.TEMPORARILYSAVED);
		this._update(ctx, pk, info);
	}

	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model) throws BOSException, EASBizException {
		InvestmentPolicyChickenInfo info = (InvestmentPolicyChickenInfo) model;
		if (!info.getBillStatus().equals(BillBaseStatusEnum.cancel)
				&& !info.getBillStatus().equals(BillBaseStatusEnum.AUDITED)) {
			throw new EASBizException(new NumericExceptionSubItem("001","资料尚未禁用！"));
		}
		info.setBillStatus(BillBaseStatusEnum.cancelcancel);
		this._update(ctx, pk, info);
	}
    
    
}