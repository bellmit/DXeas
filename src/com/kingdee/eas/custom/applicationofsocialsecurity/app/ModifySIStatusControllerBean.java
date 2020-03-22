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

import com.kingdee.eas.framework.app.CoreBillBaseControllerBean;
import com.kingdee.eas.framework.SystemEnum;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.ObjectBaseCollection;
import java.lang.String;
import com.kingdee.eas.framework.CoreBillBaseCollection;
import com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusCollection;
import com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ModifySIStatusControllerBean extends AbstractModifySIStatusControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.applicationofsocialsecurity.app.ModifySIStatusControllerBean");

	@Override
	protected void _undoAll(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void _undoSelected(Context ctx, IObjectValue model)
			throws BOSException {
		// TODO Auto-generated method stub
		
	}
}