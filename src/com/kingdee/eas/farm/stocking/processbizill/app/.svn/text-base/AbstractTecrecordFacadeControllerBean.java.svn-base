package com.kingdee.eas.farm.stocking.processbizill.app;

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
import com.kingdee.eas.framework.Result;
import com.kingdee.eas.framework.LineResult;
import com.kingdee.eas.framework.exception.EASMultiException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;

import java.lang.String;



public abstract class AbstractTecrecordFacadeControllerBean extends AbstractBizControllerBean implements TecrecordFacadeController
{
    protected AbstractTecrecordFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("334DEB58");
    }

    public long getData(Context ctx, String jsonStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5284976b-085e-47ea-ad79-94ccbc49f406"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            long retValue = (long)_getData(ctx, jsonStr);
            svcCtx.setMethodReturnValue(new Long(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Long)svcCtx.getMethodReturnValue()).longValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract long _getData(Context ctx, String jsonStr) throws BOSException;

}