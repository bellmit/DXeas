package com.kingdee.eas.custom.wages.food.app;

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

import com.kingdee.eas.custom.wages.BasicStatus;
import com.kingdee.eas.custom.wages.food.BasicPostFoodInfo;
import com.kingdee.eas.framework.app.DataBaseControllerBean;
import com.kingdee.eas.framework.ObjectBaseCollection;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import java.lang.String;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.custom.wages.food.BasicPostFoodCollection;
import com.kingdee.eas.framework.DataBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BasicPostFoodControllerBean extends AbstractBasicPostFoodControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.wages.food.app.BasicPostFoodControllerBean");

	/* (non-Javadoc)
	 * @see com.kingdee.eas.framework.app.CoreBaseControllerBean#_cancel(com.kingdee.bos.Context, com.kingdee.bos.dao.IObjectPK, com.kingdee.bos.dao.IObjectValue)
	 */
	@Override
	protected void _cancel(Context ctx, IObjectPK pk, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BasicPostFoodInfo info = (BasicPostFoodInfo)model;
		info.setBaseStatus(BasicStatus.close);
		super._cancel(ctx, pk, model);
	}

	/* (non-Javadoc)
	 * @see com.kingdee.eas.framework.app.CoreBaseControllerBean#_cancelCancel(com.kingdee.bos.Context, com.kingdee.bos.dao.IObjectPK, com.kingdee.bos.dao.IObjectValue)
	 */
	@Override
	protected void _cancelCancel(Context ctx, IObjectPK pk, IObjectValue model)
			throws BOSException, EASBizException {
		// TODO Auto-generated method stub
		BasicPostFoodInfo info = (BasicPostFoodInfo)model;
		info.setBaseStatus(BasicStatus.open);
		super._cancelCancel(ctx, pk, model);
	}
    
}