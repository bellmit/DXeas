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
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionCollection;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionFactory;
import com.kingdee.eas.custom.applicationofsocialsecurity.billStatus;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DataBaseConnectionControllerBean extends AbstractDataBaseConnectionControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.applicationofsocialsecurity.app.DataBaseConnectionControllerBean");
	protected void _audit(Context ctx, IObjectValue model)throws BOSException
	{
	}
	protected void _unAudit(Context ctx, IObjectValue model)throws BOSException
	{
	}

	/**
	 * ����
	 */
	 @Override
	 protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
	 throws BOSException, EASBizException {
		 // TODO Auto-generated method stub
		 DataBaseConnectionInfo info = (DataBaseConnectionInfo)model;
		 if(!info.getBillStatus().equals(billStatus.cancelcancel))
			 throw new EASBizException(new NumericExceptionSubItem("001","����״̬���������"));
		 info.setBillStatus(billStatus.cancel);
		 super._cancel(ctx, pk, model);
	 }
	 /**
	  * ����
	  */
	 @Override
	 protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
	 throws BOSException, EASBizException {
		 // TODO Auto-generated method stub
		 DataBaseConnectionInfo info = (DataBaseConnectionInfo)model;
		 if(checkIsExist(ctx,info))
			 throw new EASBizException(new NumericExceptionSubItem("001","�Ѵ������õ���������"));
		 if(!info.getBillStatus().equals(billStatus.cancel)&&!info.getBillStatus().equals(billStatus.submit))
			 throw new EASBizException(new NumericExceptionSubItem("001","����״̬����������"));
		 info.setBillStatus(billStatus.cancelcancel);
		 super._cancelCancel(ctx, pk, model);
	 }
	 
	 /**
	  * ɾ��
	  */
	 @Override
	 protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	 EASBizException {
		 // TODO Auto-generated method stub
		 DataBaseConnectionInfo info = DataBaseConnectionFactory.getLocalInstance(ctx).getDataBaseConnectionInfo(pk);
		 if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit)&&!info.getBillStatus().equals(billStatus.cancel))
			 throw new EASBizException(new NumericExceptionSubItem("001","����״̬������ɾ��"));
		 super._delete(ctx, pk);
	 }

	 /**
	  * ����
	  */
	 @Override
	 protected IObjectPK _save(Context ctx, IObjectValue model)
	 throws BOSException, EASBizException {
		 // TODO Auto-generated method stub
		 DataBaseConnectionInfo info = (DataBaseConnectionInfo)model;
		 if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit)&&!info.getBillStatus().equals(billStatus.cancel))
			 throw new EASBizException(new NumericExceptionSubItem("001","����״̬��������"));
		 info.setBillStatus(billStatus.save);
		 return super._save(ctx, model);
	 }

	 /**
	  * �ύ
	  */
	 @Override
	 protected IObjectPK _submit(Context ctx, IObjectValue model)
	 throws BOSException, EASBizException {
		 // TODO Auto-generated method stub
		 DataBaseConnectionInfo info = (DataBaseConnectionInfo)model;
		 if(checkIsExist(ctx,info))
			 throw new EASBizException(new NumericExceptionSubItem("001","�Ѵ������õ���������"));
		 if(!info.getBillStatus().equals(billStatus.save)&&!info.getBillStatus().equals(billStatus.submit)&&!info.getBillStatus().equals(billStatus.cancel))
			 throw new EASBizException(new NumericExceptionSubItem("001","����״̬�������ύ"));
		 info.setBillStatus(billStatus.submit);
		 return super._submit(ctx, model);
	 }

	 /**
	  * У���Ƿ���������õ����ݿ���������
	  * @param ctx 
	  * @param info
	  * @return
	  * @throws BOSException 
	  */
	 private boolean checkIsExist(Context ctx, DataBaseConnectionInfo info) throws BOSException {
		 // TODO Auto-generated method stub
		 CoreBaseCollection coll = DataBaseConnectionFactory.getLocalInstance(ctx).getCollection("where billStatus=3 and ID<>'"+info.getId().toString()+"'");
		 if(coll.size()>0)
			 return true;
		 return false;
	 }

}