package com.kingdee.eas.farm.breed.business.app;

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

import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import java.util.List;
import com.kingdee.eas.farm.breed.comm.BatchTowerInhouseInfo;
import java.lang.String;
import com.kingdee.eas.farm.breed.comm.CCSendFodderStandard;
import java.util.Date;
import com.kingdee.eas.farm.breed.business.CCBreedPlanInfo;



public abstract class AbstractBusinessBreedFacadeControllerBean extends AbstractBizControllerBean implements BusinessBreedFacadeController
{
    protected AbstractBusinessBreedFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("3717FD40");
    }

    public BreedBatchInfo getFarmBreedDailyByDate(Context ctx, String farmID, Date searchDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3af6f1be-dbee-42f9-9d70-fdeebf1d4032"), new Object[]{ctx, farmID, searchDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BreedBatchInfo retValue = (BreedBatchInfo)_getFarmBreedDailyByDate(ctx, farmID, searchDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BreedBatchInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BreedBatchInfo _getFarmBreedDailyByDate(Context ctx, String farmID, Date searchDate) throws BOSException
    {    	
        return null;
    }

    public List getBatchHouseAllAdjustInfos(Context ctx, String batchID, List rptBeans) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("dbebad82-6e24-4b95-8310-77861d255590"), new Object[]{ctx, batchID, rptBeans});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getBatchHouseAllAdjustInfos(ctx, batchID, rptBeans);
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
    protected List _getBatchHouseAllAdjustInfos(Context ctx, String batchID, List rptBeans) throws BOSException
    {    	
        return null;
    }

    public void updateImmDaysOldData(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6c1784de-a82b-4dc1-8847-57d0632c8b7f"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _updateImmDaysOldData(ctx);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _updateImmDaysOldData(Context ctx) throws BOSException
    {    	
        return;
    }

    public void getCCBreedPlan(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("622ce074-ee89-4150-b5ec-6613c0664e0f"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _getCCBreedPlan(ctx);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract void _getCCBreedPlan(Context ctx) throws BOSException;

    public CCSendFodderStandard getCCSendFodderStandard(Context ctx, String companyNumber) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c7f8de8e-a0bf-4893-89a6-5c60d11760f8"), new Object[]{ctx, companyNumber});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CCSendFodderStandard retValue = (CCSendFodderStandard)_getCCSendFodderStandard(ctx, companyNumber);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CCSendFodderStandard)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CCSendFodderStandard _getCCSendFodderStandard(Context ctx, String companyNumber) throws BOSException
    {    	
        return null;
    }

    public WarehouseInfo getHenhouseTowerInfo(Context ctx, String henhouseID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("aa49872f-dbe0-4a67-9a7d-34be773ccd90"), new Object[]{ctx, henhouseID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            WarehouseInfo retValue = (WarehouseInfo)_getHenhouseTowerInfo(ctx, henhouseID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (WarehouseInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected WarehouseInfo _getHenhouseTowerInfo(Context ctx, String henhouseID) throws BOSException
    {    	
        return null;
    }

    public BatchTowerInhouseInfo getBreedPlanTowerInhouseInfo(Context ctx, CCBreedPlanInfo breedPlanInfo) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("1e4e6188-c632-41fc-a05a-7b7c514a9af1"), new Object[]{ctx, breedPlanInfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BatchTowerInhouseInfo retValue = (BatchTowerInhouseInfo)_getBreedPlanTowerInhouseInfo(ctx, breedPlanInfo);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BatchTowerInhouseInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BatchTowerInhouseInfo _getBreedPlanTowerInhouseInfo(Context ctx, CCBreedPlanInfo breedPlanInfo) throws BOSException
    {    	
        return null;
    }

}