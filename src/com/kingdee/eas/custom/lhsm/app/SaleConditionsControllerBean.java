package com.kingdee.eas.custom.lhsm.app;

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
import com.kingdee.eas.custom.lhsm.SaleConditionsFactory;
import com.kingdee.eas.custom.lhsm.SaleConditionsInfo;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.util.app.ContextUtil;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.custom.lhsm.SaleConditionsCollection;
import com.kingdee.util.NumericExceptionSubItem;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SaleConditionsControllerBean extends AbstractSaleConditionsControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.lhsm.app.SaleConditionsControllerBean");

	@Override
	protected void _delete(Context ctx, IObjectPK pk) throws BOSException,
			EASBizException {
		// TODO Auto-generated method stub
		SelectorItemCollection slor = new SelectorItemCollection();
		slor.add("*");
		slor.add("user.*");
		SaleConditionsInfo info = SaleConditionsFactory.getLocalInstance(ctx).getSaleConditionsInfo(pk,slor);
		if(!info.getUser().getNumber().equals(ContextUtil.getCurrentUserInfo(ctx).getNumber())){
			throw new EASBizException(new NumericExceptionSubItem("001","请在本人的账号下操作"));
		}
		super._delete(ctx, pk);
	}

	@Override
	protected IObjectPK _save(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SaleConditionsInfo info = (SaleConditionsInfo)model;
		if(!info.getUser().getNumber().equals(ContextUtil.getCurrentUserInfo(ctx).getNumber())){
			throw new EASBizException(new NumericExceptionSubItem("001","请在本人的账号下操作"));
		}
		return super._save(ctx, model);
	}

	@Override
	protected IObjectPK _submit(Context ctx, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		SaleConditionsInfo info = (SaleConditionsInfo)model;
		if(!info.getUser().getNumber().equals(ContextUtil.getCurrentUserInfo(ctx).getNumber())){
			throw new EASBizException(new NumericExceptionSubItem("001","请在本人的账号下操作"));
		}
		return super._submit(ctx, model);
	}
	
}