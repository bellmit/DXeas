package com.kingdee.eas.farm.breed.layegg.app;

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
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import java.lang.String;
import java.util.Date;



public abstract class AbstractLayEggFacadeControllerBean extends AbstractBizControllerBean implements LayEggFacadeController
{
    protected AbstractLayEggFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("6D392CC8");
    }

    public Object getHouseLayEggSet(Context ctx, String henhouseID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d80b973d-a728-46fc-9a44-2ce389ddb746"), new Object[]{ctx, henhouseID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Object retValue = (Object)_getHouseLayEggSet(ctx, henhouseID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Object)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Object _getHouseLayEggSet(Context ctx, String henhouseID) throws BOSException
    {    	
        return null;
    }

    public List getConveyors(Context ctx, String stoOrgID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("fa2c01bf-65ba-46f6-b400-a9ff31775045"), new Object[]{ctx, stoOrgID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getConveyors(ctx, stoOrgID);
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
    protected List _getConveyors(Context ctx, String stoOrgID) throws BOSException
    {    	
        return null;
    }

    public Map getLayeggStandard(Context ctx, String henType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("de4d8dd1-45d0-42ae-81e5-d102900dd9b3"), new Object[]{ctx, henType});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getLayeggStandard(ctx, henType);
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
    protected Map _getLayeggStandard(Context ctx, String henType) throws BOSException
    {    	
        return null;
    }

    public Map getFeedStandard(Context ctx, String henType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("13ec7384-7eaa-47f1-93f4-51b377f5c1ca"), new Object[]{ctx, henType});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getFeedStandard(ctx, henType);
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
    protected abstract Map _getFeedStandard(Context ctx, String henType) throws BOSException;

    public boolean isBatchFixed(Context ctx, String batchID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("16d7f5ac-5864-4bc6-af08-b65d96ba2f6d"), new Object[]{ctx, batchID, bizDate});
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

    public ParentBreedBatchInfo getCurrentParentBatch(Context ctx, String internalFarmID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("19006249-75b0-4a89-ae18-696fdbe992fc"), new Object[]{ctx, internalFarmID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ParentBreedBatchInfo retValue = (ParentBreedBatchInfo)_getCurrentParentBatch(ctx, internalFarmID, bizDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ParentBreedBatchInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ParentBreedBatchInfo _getCurrentParentBatch(Context ctx, String internalFarmID, Date bizDate) throws BOSException
    {    	
        return null;
    }

    public boolean checkDateDailyState(Context ctx, String breedBatchID, Date bizDate, String batchID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f068dc5e-c7ab-4ac3-81dc-7ed14bb68567"), new Object[]{ctx, breedBatchID, bizDate, batchID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_checkDateDailyState(ctx, breedBatchID, bizDate, batchID);
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
    protected boolean _checkDateDailyState(Context ctx, String breedBatchID, Date bizDate, String batchID) throws BOSException
    {    	
        return false;
    }

    public void toStockDaily(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d81594e6-53c9-486f-a6a9-e01cff617e7e"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _toStockDaily(ctx);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _toStockDaily(Context ctx) throws BOSException
    {    	
        return;
    }

}