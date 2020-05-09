package com.kingdee.eas.outinterface.base.app;

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

import java.lang.String;
import javax.activation.DataHandler;
import com.kingdee.eas.common.EASBizException;

public class OutAppInterfaceControllerBeanEx extends com.kingdee.eas.outinterface.base.app.OutAppInterfaceControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.outinterface.base.app.OutAppInterfaceControllerBeanEx");
    
}				
