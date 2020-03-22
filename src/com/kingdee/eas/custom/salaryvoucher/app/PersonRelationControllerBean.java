package com.kingdee.eas.custom.salaryvoucher.app;

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
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.custom.salaryvoucher.PersonRelationCollection;
import com.kingdee.eas.custom.salaryvoucher.PersonRelationInfo;
import com.kingdee.eas.custom.salaryvoucher.voucherStatus;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PersonRelationControllerBean extends AbstractPersonRelationControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.custom.salaryvoucher.app.PersonRelationControllerBean");



	/**
	 * 提交
	 */
	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PersonRelationInfo info = (PersonRelationInfo)model;
		if(info!=null)
			if(info.getBillStatus().equals(voucherStatus.save)){
				info.setBillStatus(voucherStatus.submit);
				return super._submit(ctx, model);
			}
			else
				throw new EASBizException(new NumericExceptionSubItem("001","只能提交保存状态的单据"));
		return null;
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		PersonRelationInfo info = (PersonRelationInfo)model;
		if(info!=null)
			if(info.getBillStatus().equals(voucherStatus.save)){
				info.setBillStatus(voucherStatus.save);
				return super._save(ctx, model);
			}
			else
				throw new EASBizException(new NumericExceptionSubItem("001","只允许保存保存状态的单据"));
		return null;

	}

	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException  {
		// TODO Auto-generated method stub
		PersonRelationInfo info = (PersonRelationInfo)model;		
		try {
			if(info!=null)
				info.setBillStatus(voucherStatus.audit);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException {
		// TODO Auto-generated method stub
		PersonRelationInfo info = (PersonRelationInfo)model;		
		try {
			if(info!=null)
				info.setBillStatus(voucherStatus.save);
			super._update(ctx, new ObjectUuidPK(info.getId()), info);
		} catch (EASBizException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}