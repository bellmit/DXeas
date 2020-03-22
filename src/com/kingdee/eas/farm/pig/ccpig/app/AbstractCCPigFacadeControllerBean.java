package com.kingdee.eas.farm.pig.ccpig.app;

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
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo;
import java.util.Date;
import com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelEntryInfo;
import com.kingdee.eas.farm.pig.bean.CCPigBatchNormalInfo;



public abstract class AbstractCCPigFacadeControllerBean extends AbstractBizControllerBean implements CCPigFacadeController
{
    protected AbstractCCPigFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("3EBC9AA8");
    }

    public CCPigBatchNormalInfo getFarmBreedCCPigBatch(Context ctx, String farmID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("73e6b5a9-9c58-43b1-96bf-ff251673af6f"), new Object[]{ctx, farmID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CCPigBatchNormalInfo retValue = (CCPigBatchNormalInfo)_getFarmBreedCCPigBatch(ctx, farmID, bizDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CCPigBatchNormalInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CCPigBatchNormalInfo _getFarmBreedCCPigBatch(Context ctx, String farmID, Date bizDate) throws BOSException
    {    	
        return null;
    }

    public CCPigBatchNormalInfo getFarmBreedCCPigBatch(Context ctx, String farmID, String batchID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("1bfc5092-8a6a-4c15-9268-cda6377b219e"), new Object[]{ctx, farmID, batchID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CCPigBatchNormalInfo retValue = (CCPigBatchNormalInfo)_getFarmBreedCCPigBatch(ctx, farmID, batchID, bizDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CCPigBatchNormalInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract CCPigBatchNormalInfo _getFarmBreedCCPigBatch(Context ctx, String farmID, String batchID, Date bizDate) throws BOSException;

    public CCPigBreedModelInfo getAvailableBreedModel(Context ctx, Date bizDate, String farmID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("dca8d1ba-3f9d-48f0-b672-61ebd8ec7b47"), new Object[]{ctx, bizDate, farmID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CCPigBreedModelInfo retValue = (CCPigBreedModelInfo)_getAvailableBreedModel(ctx, bizDate, farmID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CCPigBreedModelInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract CCPigBreedModelInfo _getAvailableBreedModel(Context ctx, Date bizDate, String farmID) throws BOSException;

    public CCPigBreedModelEntryInfo getModelBreedEntryInfo(Context ctx, CCPigBreedModelInfo modelInfo, int days) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d754b0c0-1cf4-4a4e-925a-642448243587"), new Object[]{ctx, modelInfo, new Integer(days)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CCPigBreedModelEntryInfo retValue = (CCPigBreedModelEntryInfo)_getModelBreedEntryInfo(ctx, modelInfo, days);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CCPigBreedModelEntryInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract CCPigBreedModelEntryInfo _getModelBreedEntryInfo(Context ctx, CCPigBreedModelInfo modelInfo, int days) throws BOSException;

    public List getModelImmunePlans(Context ctx, CCPigBreedModelInfo modelInfo, Date bizDate, int days) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b17f6a63-7036-447c-8e30-21ddf43e4a0f"), new Object[]{ctx, modelInfo, bizDate, new Integer(days)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getModelImmunePlans(ctx, modelInfo, bizDate, days);
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
    protected abstract List _getModelImmunePlans(Context ctx, CCPigBreedModelInfo modelInfo, Date bizDate, int days) throws BOSException;

    public List getModelRecentImmunePlans(Context ctx, CCPigBreedModelInfo modelInfo, Date bizDate, int batchDays) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ad6fecce-2370-4f29-b443-741fc1f10dd8"), new Object[]{ctx, modelInfo, bizDate, new Integer(batchDays)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getModelRecentImmunePlans(ctx, modelInfo, bizDate, batchDays);
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
    protected abstract List _getModelRecentImmunePlans(Context ctx, CCPigBreedModelInfo modelInfo, Date bizDate, int batchDays) throws BOSException;

}