package com.kingdee.eas.farm.hatch.app;

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
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.farm.hatch.ImmuneBillCollection;
import com.kingdee.eas.farm.hatch.ImmuneBillFactory;
import com.kingdee.eas.farm.hatch.ImmuneBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.commld.ServerUtils;
import com.kingdee.util.IPropertyContainer;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ImmuneBillControllerBean extends AbstractImmuneBillControllerBean
{
	private static Logger logger =
		Logger.getLogger("com.kingdee.eas.farm.hatch.app.ImmuneBillControllerBean");


	/**
	 * …Û∫À
	 */
	@Override
	protected void _audit(Context ctx, IObjectValue model) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub
		model=ServerUtils.audit(ctx, model, null);
		super._save(ctx, model);
	}

	/**
	 * ∑¥…Û∫À
	 */
	@Override
	protected void _unAudit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		model=ServerUtils.unAudit(ctx, model, null);
		super._save(ctx, model);
	}

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
	EASBizException {
		// TODO Auto-generated method stub
		IObjectValue model = (IObjectValue)ImmuneBillFactory.getLocalInstance(ctx).getImmuneBillInfo(pk);
		ServerUtils.delete(ctx, model, null);
		super._delete(ctx, pk);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		model=ServerUtils.save(ctx, model, null);
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
	throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		model=ServerUtils.submit(ctx, model, null);
		return super._submit(ctx, model);
	}

}