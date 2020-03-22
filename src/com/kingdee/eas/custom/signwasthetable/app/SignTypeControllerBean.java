package com.kingdee.eas.custom.signwasthetable.app;

import org.apache.log4j.Logger;
import com.kingdee.bos.*;
import com.kingdee.bos.dao.IObjectValue;

import com.kingdee.eas.custom.signwasthetable.SignTypeFactory;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableFactory;
import com.kingdee.eas.custom.signwasthetable.UsedStatus;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.signwasthetable.SignTypeInfo;
import com.kingdee.util.NumericExceptionSubItem;

public class SignTypeControllerBean extends AbstractSignTypeControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.signwasthetable.app.SignTypeControllerBean");

	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SignTypeInfo info = (SignTypeInfo)model;
		if(info.getBillStatus().equals(UsedStatus.trueValue)){}
		else
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许禁用"));
		info.setBillStatus(UsedStatus.falseValue);
		super._cancel(ctx, pk, model);
	}
	/**
	 * 启用
	 */
	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SignTypeInfo info = (SignTypeInfo)model;
		if(info.getBillStatus().equals(UsedStatus.auditValue)||info.getBillStatus().equals(UsedStatus.falseValue)){}
		else
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许启用"));
		info.setBillStatus(UsedStatus.trueValue);
		super._cancelCancel(ctx, pk, model);
	}

	/**
	 * 保存
	 */
	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SignTypeInfo info = (SignTypeInfo)model;
		if(info.getBillStatus().equals(UsedStatus.saveValue)||info.getBillStatus().equals(UsedStatus.submit)){}
		else
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许保存"));
		info.setBillStatus(UsedStatus.saveValue);
		return super._save(ctx, model);
	}

	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SignTypeInfo info = (SignTypeInfo)model;
		if(info.getBillStatus().equals(UsedStatus.saveValue)||info.getBillStatus().equals(UsedStatus.submit)){}
		else
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许提交"));
		info.setBillStatus(UsedStatus.submit);
		return super._submit(ctx, model);
	}

	/**
	 * 删除
	 */
	@Override
	public void delete(Context arg0, IObjectPK arg1) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub
		if(arg1!=null&&!arg1.equals("")){
			CoreBaseCollection coll = SignWasTheTableFactory.getLocalInstance(arg0).getCollection("where SignType='"+arg1.toString()+"'");
			if(coll.size()>0)
				throw new EASBizException(new NumericExceptionSubItem("001","该基础资料已被引用"));


			SignTypeInfo info = SignTypeFactory.getLocalInstance(arg0).getSignTypeInfo(arg1);
			if(info.getBillStatus().equals(UsedStatus.trueValue)||info.getBillStatus().equals(UsedStatus.auditValue))
				throw new EASBizException(new NumericExceptionSubItem("001","单据状态不符合删除的条件"));
		}
		super.delete(arg0, arg1);
	}
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SignTypeInfo info = (SignTypeInfo)model;
		if(info.getBillStatus().equals(UsedStatus.submit)){}
		else
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许审核"));
		info.setBillStatus(UsedStatus.auditValue);
		super._save(ctx, model);
	}
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SignTypeInfo info = (SignTypeInfo)model;
		if(info.getBillStatus().equals(UsedStatus.auditValue)){}
		else
			throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许反审核"));
		info.setBillStatus(UsedStatus.saveValue);
		super._save(ctx, model);
	}
}