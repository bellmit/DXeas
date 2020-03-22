package com.kingdee.eas.custom.emt.app;

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



public abstract class AbstractWSEmtDataFacadeControllerBean extends AbstractBizControllerBean implements WSEmtDataFacadeController
{
    protected AbstractWSEmtDataFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("A34B4C6D");
    }

    public String getUserFeedInfo(Context ctx, String lastUpdateDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("955a68a6-85a1-40e7-90ee-4378033aeff7"), new Object[]{ctx, lastUpdateDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getUserFeedInfo(ctx, lastUpdateDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String _getUserFeedInfo(Context ctx, String lastUpdateDate) throws BOSException;

    public String getUserFeedBatchInfo(Context ctx, String lastUpdateTime) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d8ec3475-ea3d-4972-9a07-7ab0ac66acc4"), new Object[]{ctx, lastUpdateTime});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getUserFeedBatchInfo(ctx, lastUpdateTime);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String _getUserFeedBatchInfo(Context ctx, String lastUpdateTime) throws BOSException;

    public String getUserInComeInfo(Context ctx, String lastUpdateTime) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("fd34c348-c541-42c8-b26c-aeee643d5684"), new Object[]{ctx, lastUpdateTime});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getUserInComeInfo(ctx, lastUpdateTime);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String _getUserInComeInfo(Context ctx, String lastUpdateTime) throws BOSException;

    public String getUserPayInfo(Context ctx, String lastUpdateTime) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("537d2b76-27ac-4eec-9c58-dc449fe7bac6"), new Object[]{ctx, lastUpdateTime});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getUserPayInfo(ctx, lastUpdateTime);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String _getUserPayInfo(Context ctx, String lastUpdateTime) throws BOSException;

}