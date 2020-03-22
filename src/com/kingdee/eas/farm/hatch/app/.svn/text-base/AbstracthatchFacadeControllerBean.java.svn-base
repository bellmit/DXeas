package com.kingdee.eas.farm.hatch.app;

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
import java.util.Map;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import java.lang.String;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import java.util.Date;
import com.kingdee.eas.common.EASBizException;



public abstract class AbstracthatchFacadeControllerBean extends AbstractBizControllerBean implements hatchFacadeController
{
    protected AbstracthatchFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("B544A64C");
    }

    public Map getLayEggPlan(Context ctx, PeriodInfo period) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6d13ab66-7108-49ab-be17-f583c674af83"), new Object[]{ctx, period});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getLayEggPlan(ctx, period);
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
    protected abstract Map _getLayEggPlan(Context ctx, IObjectValue period) throws BOSException;

    public HatchBaseDataInfo getHatchBaseData(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9974e629-7e52-407e-9225-9d6b4645337a"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            HatchBaseDataInfo retValue = (HatchBaseDataInfo)_getHatchBaseData(ctx);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (HatchBaseDataInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract IObjectValue _getHatchBaseData(Context ctx) throws BOSException;

    public Map getCCBreedInfo(Context ctx, Date pkDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("37e12893-6527-4957-b500-4ad99cd0bcbb"), new Object[]{ctx, pkDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getCCBreedInfo(ctx, pkDate);
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
    protected abstract Map _getCCBreedInfo(Context ctx, Date pkDate) throws BOSException;

    public Map getLayEggPlanTotal(Context ctx, PeriodInfo period) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("72c51244-ed10-4e2e-80a4-e7163d29a140"), new Object[]{ctx, period});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getLayEggPlanTotal(ctx, period);
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
    protected abstract Map _getLayEggPlanTotal(Context ctx, IObjectValue period) throws BOSException;

    public HatchBaseDataInfo getHatchBaseData(Context ctx, StorageOrgUnitInfo stoOrg) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d4f678da-34fa-4d1a-a3a5-69735dd5c53d"), new Object[]{ctx, stoOrg});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            HatchBaseDataInfo retValue = (HatchBaseDataInfo)_getHatchBaseData(ctx, stoOrg);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (HatchBaseDataInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract HatchBaseDataInfo _getHatchBaseData(Context ctx, StorageOrgUnitInfo stoOrg) throws BOSException;

    public void excuteSql(Context ctx, String sql) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("667aeda2-2cf9-4ff3-82e0-44a95f8668f7"), new Object[]{ctx, sql});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _excuteSql(ctx, sql);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _excuteSql(Context ctx, String sql) throws BOSException, EASBizException;

}