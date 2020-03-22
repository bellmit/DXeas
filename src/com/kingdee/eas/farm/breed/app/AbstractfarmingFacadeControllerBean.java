package com.kingdee.eas.farm.breed.app;

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

import java.util.ArrayList;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import java.lang.String;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import java.util.Date;



public abstract class AbstractfarmingFacadeControllerBean extends AbstractBizControllerBean implements farmingFacadeController
{
    protected AbstractfarmingFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("E37AA0AC");
    }

    public ArrayList getBreedPlan(Context ctx, Date date, PeriodInfo period, StorageOrgUnitInfo stoOrgUnit, String planType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ec503302-bb4a-4058-87d2-f06275e6f865"), new Object[]{ctx, date, period, stoOrgUnit, planType});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getBreedPlan(ctx, date, period, stoOrgUnit, planType);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ArrayList)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract ArrayList _getBreedPlan(Context ctx, Date date, IObjectValue period, IObjectValue stoOrgUnit, String planType) throws BOSException;

    public ArrayList getSlaughterPlan(Context ctx, StorageOrgUnitInfo storageUnit, PeriodInfo period) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("58985d27-bfd1-45e2-b638-d4b12728eb89"), new Object[]{ctx, storageUnit, period});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getSlaughterPlan(ctx, storageUnit, period);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ArrayList)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract ArrayList _getSlaughterPlan(Context ctx, IObjectValue storageUnit, IObjectValue period) throws BOSException;

}