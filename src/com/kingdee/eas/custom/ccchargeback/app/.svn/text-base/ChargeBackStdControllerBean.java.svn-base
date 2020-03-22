package com.kingdee.eas.custom.ccchargeback.app;

import org.apache.log4j.Logger;
import com.kingdee.bos.*;
import com.kingdee.bos.dao.IObjectValue;



import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.custom.ccchargeback.ChargeBackStdFactory;
import com.kingdee.eas.custom.ccchargeback.billStatus;
import com.kingdee.eas.custom.ccchargeback.ChargeBackStdInfo;
import java.lang.String;
import java.util.Date;

import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.common.SysContextConstant;
import com.kingdee.util.NumericExceptionSubItem;

public class ChargeBackStdControllerBean extends AbstractChargeBackStdControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.ccchargeback.app.ChargeBackStdControllerBean");

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub
		String strFilter = "where ID='"+pk.toString()+"'";
		CoreBaseCollection coll = ChargeBackStdFactory.getLocalInstance(ctx).getCollection(strFilter);
		ChargeBackStdInfo info=null;
		if(coll.size()>0)
			info=(ChargeBackStdInfo)coll.get(0);
		if(!billStatus.save.equals(info.getBillStatus())&&!billStatus.submit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许保删除"));
		super._delete(ctx, pk);
	}


	/**
	 *保存 
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ChargeBackStdInfo info = (ChargeBackStdInfo)model;
		if(info.getCropSTD()==null)
			throw new EASBizException(new NumericExceptionSubItem("001","嗉囊标准不能为空"));
		if(!billStatus.save.equals(info.getBillStatus())&&!billStatus.submit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许保存"));
		return super._save(ctx, model);
	}

	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ChargeBackStdInfo info = (ChargeBackStdInfo)model;
		if(info.getCropSTD()==null)
			throw new EASBizException(new NumericExceptionSubItem("001","嗉囊标准不能为空"));
		if(!billStatus.save.equals(info.getBillStatus())&&!billStatus.submit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许提交"));

		info.setBillStatus(billStatus.submit);
		return super._submit(ctx, model);
	}
	/**
	 * 禁用
	 */
	@Override
	public void cancel(Context arg0, IObjectPK arg1, CoreBaseInfo arg2)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ChargeBackStdInfo info = (ChargeBackStdInfo)arg2;
		if(!billStatus.cancelcancel.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许禁用"));
		info.setCancelUser((UserInfo) arg0.get(SysContextConstant.USERINFO));
		info.setCancelTime(new Date());
		info.setBillStatus(billStatus.cancel);
		super.cancel(arg0, arg1, arg2);
	}

	/**
	 * 启用
	 */
	@Override
	public void cancelCancel(Context arg0, IObjectPK arg1, CoreBaseInfo arg2)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ChargeBackStdInfo info = (ChargeBackStdInfo)arg2;
		if(!billStatus.audit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许启用"));
		checkIsExist(arg0,arg1);
		info.setCancelcanceler((UserInfo) arg0.get(SysContextConstant.USERINFO));
		info.setCancelcancelTime(new Date());
		info.setBillStatus(billStatus.cancelcancel);
		super.cancelCancel(arg0, arg1, arg2);
	}

	/**
	 * 审核
	 * @throws EASBizException 
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ChargeBackStdInfo info = (ChargeBackStdInfo)model;
		if(!billStatus.submit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许审核"));
		info.setAuditor((UserInfo) ctx.get(SysContextConstant.USERINFO));
		info.setAuditTime(new Date());
		info.setBillStatus(billStatus.audit);
		super._save(ctx, info);
	}
	
	/**
	 * 反审核
	 * @throws EASBizException 
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		ChargeBackStdInfo info = (ChargeBackStdInfo)model;
		if(!billStatus.audit.equals(info.getBillStatus()))
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许反审核"));
		info.setAuditor(null);
		info.setAuditTime(null);
		info.setBillStatus(billStatus.save);
		super._save(ctx, info);
	}

	/**
	 *校验是否已经存在已经启用的基础资料 
	 * @param arg0 
	 * @param arg1
	 * @throws BOSException 
	 * @throws EASBizException 
	 */
	private void checkIsExist(Context arg0, IObjectPK arg1) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		String filterStr="where ID<>'"+arg1+"' and billStatus=2";
		CoreBaseCollection coll = ChargeBackStdFactory.getLocalInstance(arg0).getCollection(filterStr);
		if(coll.size()>0)
			throw new EASBizException(new NumericExceptionSubItem("001","已存在启用的验收标准"));
	}

}