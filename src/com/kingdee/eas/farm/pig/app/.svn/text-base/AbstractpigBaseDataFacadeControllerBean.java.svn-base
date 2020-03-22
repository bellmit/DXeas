package com.kingdee.eas.farm.pig.app;

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

import java.util.List;
import java.lang.String;
import java.util.Date;
import com.kingdee.eas.farm.pig.PigFarmInfo;



public abstract class AbstractpigBaseDataFacadeControllerBean extends AbstractBizControllerBean implements pigBaseDataFacadeController
{
    protected AbstractpigBaseDataFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("D8B4F1A3");
    }

    public PigFarmInfo getPigfarm(Context ctx, String stoOrgID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("0d8823c0-2252-47bf-9b79-ff7fa14612f9"), new Object[]{ctx, stoOrgID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            PigFarmInfo retValue = (PigFarmInfo)_getPigfarm(ctx, stoOrgID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (PigFarmInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract PigFarmInfo _getPigfarm(Context ctx, String stoOrgID) throws BOSException;

    public List getDailyImmunePlans(Context ctx, String pigFarmType, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a8acb041-6397-4064-a04c-eb9b5645adb6"), new Object[]{ctx, pigFarmType, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getDailyImmunePlans(ctx, pigFarmType, bizDate);
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
    protected abstract List _getDailyImmunePlans(Context ctx, String pigFarmType, Date bizDate) throws BOSException;

}