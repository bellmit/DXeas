package com.kingdee.eas.farm.food.app;

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

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import java.util.LinkedHashMap;
import java.util.Map;
import java.lang.String;
import com.kingdee.eas.common.EASBizException;



public abstract class AbstractSlaughterPlanFacadeControllerBean extends AbstractBizControllerBean implements SlaughterPlanFacadeController
{
    protected AbstractSlaughterPlanFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("CFD4080C");
    }

    public LinkedHashMap getSlaughterPlan(Context ctx, PeriodInfo fiscalPeriod, int ageOfDaysBeginFrom, int ageOfDaysBeginTo) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("12f0dffc-e348-4658-86b7-81a5ba2c7934"), new Object[]{ctx, fiscalPeriod, new Integer(ageOfDaysBeginFrom), new Integer(ageOfDaysBeginTo)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            LinkedHashMap retValue = (LinkedHashMap)_getSlaughterPlan(ctx, fiscalPeriod, ageOfDaysBeginFrom, ageOfDaysBeginTo);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (LinkedHashMap)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract LinkedHashMap _getSlaughterPlan(Context ctx, IObjectValue fiscalPeriod, int ageOfDaysBeginFrom, int ageOfDaysBeginTo) throws BOSException, EASBizException;

    public Map getCullAndDeathFromFeedModel(Context ctx) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("44a42ca5-916f-4882-ba1e-8268b53059ad"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getCullAndDeathFromFeedModel(ctx);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract Map _getCullAndDeathFromFeedModel(Context ctx) throws BOSException, EASBizException;

    public String[] getSlaughterQtyInOneDay(Context ctx, String sroOrgUnitID, String henHouseID, String breedBatchID) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c8a64404-41d2-4b84-8c55-b192beaafcbb"), new Object[]{ctx, sroOrgUnitID, henHouseID, breedBatchID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String[] retValue = (String[])_getSlaughterQtyInOneDay(ctx, sroOrgUnitID, henHouseID, breedBatchID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String[] _getSlaughterQtyInOneDay(Context ctx, String sroOrgUnitID, String henHouseID, String breedBatchID) throws BOSException, EASBizException;

}