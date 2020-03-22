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

import com.kingdee.eas.farm.breed.comm.ParentBreedBatchDetailInfo;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import java.lang.String;
import java.util.Date;
import java.util.HashMap;



public abstract class AbstractparentFacadeControllerBean extends AbstractBizControllerBean implements parentFacadeController
{
    protected AbstractparentFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("D8E26C1E");
    }

    public BreedStoorgSetInfo getFarmByStoOrgID(Context ctx, String stoOrgID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("40ce2081-0755-4081-9af8-36778b56ef96"), new Object[]{ctx, stoOrgID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BreedStoorgSetInfo retValue = (BreedStoorgSetInfo)_getFarmByStoOrgID(ctx, stoOrgID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BreedStoorgSetInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BreedStoorgSetInfo _getFarmByStoOrgID(Context ctx, String stoOrgID) throws BOSException
    {    	
        return null;
    }

    public ParentBreedBatchDetailInfo getBreedBatchDetailInfos(Context ctx, String parentBatchID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("901fd75d-289b-4646-85c9-65d69c666e32"), new Object[]{ctx, parentBatchID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ParentBreedBatchDetailInfo retValue = (ParentBreedBatchDetailInfo)_getBreedBatchDetailInfos(ctx, parentBatchID, bizDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ParentBreedBatchDetailInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ParentBreedBatchDetailInfo _getBreedBatchDetailInfos(Context ctx, String parentBatchID, Date bizDate) throws BOSException
    {    	
        return null;
    }

    public BreedModelInfo getBreedModel(Context ctx, String henhouseType, String companyID, boolean isMoulting) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("4f940597-3083-4e0f-a3c6-309832532752"), new Object[]{ctx, henhouseType, companyID, new Boolean(isMoulting)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BreedModelInfo retValue = (BreedModelInfo)_getBreedModel(ctx, henhouseType, companyID, isMoulting);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BreedModelInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BreedModelInfo _getBreedModel(Context ctx, String henhouseType, String companyID, boolean isMoulting) throws BOSException
    {    	
        return null;
    }

    public HashMap getBatchWeekages(Context ctx, String parentBatchID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ebb3c227-c459-4b8b-8262-45163b0f375b"), new Object[]{ctx, parentBatchID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            HashMap retValue = (HashMap)_getBatchWeekages(ctx, parentBatchID, bizDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (HashMap)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected HashMap _getBatchWeekages(Context ctx, String parentBatchID, Date bizDate) throws BOSException
    {    	
        return null;
    }

    public boolean isBatchFixed(Context ctx, String batchID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("82b33b91-2f18-466b-a54b-6c00a5946577"), new Object[]{ctx, batchID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isBatchFixed(ctx, batchID, bizDate);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Boolean)svcCtx.getMethodReturnValue()).booleanValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected boolean _isBatchFixed(Context ctx, String batchID, Date bizDate) throws BOSException
    {    	
        return false;
    }

    public boolean isBatchBroodFixed(Context ctx, String batchID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5e97d433-7469-4bba-a9a4-5576f24840a1"), new Object[]{ctx, batchID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isBatchBroodFixed(ctx, batchID, bizDate);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Boolean)svcCtx.getMethodReturnValue()).booleanValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected boolean _isBatchBroodFixed(Context ctx, String batchID, Date bizDate) throws BOSException
    {    	
        return false;
    }

}