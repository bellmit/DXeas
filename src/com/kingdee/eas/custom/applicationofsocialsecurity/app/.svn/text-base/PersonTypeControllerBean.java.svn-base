package com.kingdee.eas.custom.applicationofsocialsecurity.app;

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

import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.billStatus;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.custom.applicationofsocialsecurity.PersonTypeCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PersonTypeControllerBean extends AbstractPersonTypeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.applicationofsocialsecurity.app.PersonTypeControllerBean");

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 禁用
	 */
	 @Override
	 protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
	 throws BOSException, EASBizException {
		 // TODO Auto-generated method stub
		 PersonTypeInfo info = (PersonTypeInfo)model;
		 if(!info.getBillStatus().equals(billStatus.cancelcancel))
			 throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许禁用"));
		 info.setBillStatus(billStatus.cancel);
		 super._cancel(ctx, pk, model);
	 }
	 /**
	  * 启用
	  */
	 @Override
	 protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
	 throws BOSException, EASBizException {
		 // TODO Auto-generated method stub
		 PersonTypeInfo info = (PersonTypeInfo)model;
		 if(!info.getBillStatus().equals(billStatus.cancel)&&!info.getBillStatus().equals(billStatus.submit))
			 throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许启用"));
		 info.setBillStatus(billStatus.cancelcancel);
		 super._cancelCancel(ctx, pk, model);
	 }
	 
	 /**
	  * 删除
	  */
	 @Override
	 protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	 EASBizException {
		 // TODO Auto-generated method stub
		 PersonTypeInfo info = PersonTypeFactory.getLocalInstance(ctx).getPersonTypeInfo(pk);
		 if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit)&&!info.getBillStatus().equals(billStatus.cancel))
			 throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许删除"));
		 super._delete(ctx, pk);
	 }

	 /**
	  * 保存
	  */
	 @Override
	 protected IObjectPK _save(Context ctx, IObjectValue model)
	 throws BOSException, EASBizException {
		 // TODO Auto-generated method stub
		 PersonTypeInfo info = (PersonTypeInfo)model;
		 if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit)&&!info.getBillStatus().equals(billStatus.cancel))
			 throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许保存"));
		 info.setBillStatus(billStatus.save);
		 return super._save(ctx, model);
	 }

	 /**
	  * 提交
	  */
	 @Override
	 protected IObjectPK _submit(Context ctx, IObjectValue model)
	 throws BOSException, EASBizException {
		 // TODO Auto-generated method stub
		 PersonTypeInfo info = (PersonTypeInfo)model;
		 if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit)&&!info.getBillStatus().equals(billStatus.cancel))
			 throw new EASBizException(new NumericExceptionSubItem("001","单据状态不允许提交"));
		 info.setBillStatus(billStatus.submit);
		 return super._submit(ctx, model);
	 }

}