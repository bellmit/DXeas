package com.kingdee.eas.farm.feedfactory.app;

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

import java.util.Map;
import java.util.List;
import com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataInfo;
import java.util.Date;



public abstract class AbstractTruckPlanFacadeControllerBean extends AbstractBizControllerBean implements TruckPlanFacadeController
{
    protected AbstractTruckPlanFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("2795E4C0");
    }

    public List getFodderPlandetails(Context ctx, Date planDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b9b061ed-37f0-4cf6-acbf-9616594e96fa"), new Object[]{ctx, planDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getFodderPlandetails(ctx, planDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (List)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected List _getFodderPlandetails(Context ctx, Date planDate) throws BOSException
    {    	
        return null;
    }

    public FeedFactoryBaseDataInfo getFeedFactoryBaseData(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d6061a1e-b0e3-4421-a008-6321eb6780e4"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            FeedFactoryBaseDataInfo retValue = (FeedFactoryBaseDataInfo)_getFeedFactoryBaseData(ctx);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (FeedFactoryBaseDataInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected FeedFactoryBaseDataInfo _getFeedFactoryBaseData(Context ctx) throws BOSException
    {    	
        return null;
    }

    public Map getDistanseSetinfo(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7b63acb1-11a8-459d-b12c-af96a4eaf824"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getDistanseSetinfo(ctx);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Map _getDistanseSetinfo(Context ctx) throws BOSException
    {    	
        return null;
    }

}