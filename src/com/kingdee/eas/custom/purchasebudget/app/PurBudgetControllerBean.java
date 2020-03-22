package com.kingdee.eas.custom.purchasebudget.app;

import org.apache.log4j.Logger;
import javax.ejb.*;
import java.rmi.RemoteException;
import java.util.Date;

import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.query.util.CompareType;
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
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.custom.purchasebudget.PurBudgetFactory;
import com.kingdee.eas.custom.purchasebudget.PurBudgetInfo;
import com.kingdee.eas.custom.purchasebudget.billStatus;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.custom.purchasebudget.PurBudgetCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.metadata.entity.FilterInfo;
import com.kingdee.bos.metadata.entity.FilterItemInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PurBudgetControllerBean extends AbstractPurBudgetControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.purchasebudget.app.PurBudgetControllerBean");

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PurBudgetInfo info = (PurBudgetInfo)model;
		if(!info.getBillStatus().equals(billStatus.submit)&&!info.getBillStatus().equals(billStatus.save))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许保存"));
		checkIsExist(ctx,info);
		return super._save(ctx, model);
	}


	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PurBudgetInfo info = (PurBudgetInfo)model;
		if(!info.getBillStatus().equals(billStatus.submit)&&!info.getBillStatus().equals(billStatus.save))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许提交"));
		else
			info.setBillStatus(billStatus.submit);
		checkIsExist(ctx,info);
		return super._submit(ctx, model);
	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PurBudgetInfo info = (PurBudgetInfo)model;
		if(!info.getBillStatus().equals(billStatus.submit))
			throw new EASBizException(new NumericExceptionSubItem("001","只允许审核提交状态的单据"));
		UserInfo user = (UserInfo)ctx.get(SysContextConstant.USERINFO);
		Date date = new Date();
		info.setAuditor(user);
		info.setAuditTime(date);
		info.setBillStatus(billStatus.audit);
		super._save(ctx, model);
	}

	@Override
	protected void _noPass(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PurBudgetInfo info = (PurBudgetInfo)model;
		if(!info.getBillStatus().equals(billStatus.submit))
			throw new EASBizException(new NumericExceptionSubItem("001","只允许审核提交状态的单据"));
		info.setBillStatus(billStatus.noPass);
		super._save(ctx, model);
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PurBudgetInfo info = (PurBudgetInfo)model;
		if(!info.getBillStatus().equals(billStatus.audit))
			throw new EASBizException(new NumericExceptionSubItem("001","只允许反审核审核状态的单据"));
		info.setAuditor(null);
		info.setAuditTime(null);
		info.setBillStatus(billStatus.save);
		super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub
		PurBudgetInfo info = PurBudgetFactory.getLocalInstance(ctx).getPurBudgetInfo(pk);
		if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许删除"));
		super._delete(ctx, pk);
	}

	/**
	 * 校验是否存在同一公司同一期间的数据
	 * @param ctx
	 * @param info
	 * @throws BOSException
	 * @throws EASBizException
	 */
	private void checkIsExist(Context ctx, PurBudgetInfo info) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		EntityViewInfo evi=new EntityViewInfo();

		FilterInfo filterInfo=new FilterInfo();
		filterInfo.getFilterItems().add(new FilterItemInfo("company",info.getCompany().getId().toString(),CompareType.EQUALS));
		filterInfo.getFilterItems().add(new FilterItemInfo("period",info.getPeriod().getId().toString(),CompareType.EQUALS));
		if(info.getId()!=null)
			filterInfo.getFilterItems().add(new FilterItemInfo("ID",info.getId().toString(),CompareType.NOTEQUALS));
		evi.setFilter(filterInfo);

		CoreBaseCollection coll = PurBudgetFactory.getLocalInstance(ctx).getCollection(evi);
		if(coll.size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","存在同一期间的单据"));
	}


	@Override
	protected void _importFormExcel(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
}