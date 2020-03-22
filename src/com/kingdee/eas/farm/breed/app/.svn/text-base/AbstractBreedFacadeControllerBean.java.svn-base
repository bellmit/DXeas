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

import com.kingdee.eas.farm.breed.BreedBatchInfo;
import java.util.Map;
import com.kingdee.eas.base.permission.UserInfo;
import java.lang.String;
import java.util.Date;
import java.util.HashMap;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.farm.breed.ResidueSetInfo;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchDetailInfo;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;



public abstract class AbstractBreedFacadeControllerBean extends AbstractBizControllerBean implements BreedFacadeController
{
    protected AbstractBreedFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("70039994");
    }

    public HenhouseInfo getWarehsHenhouse(Context ctx, String warehouseId) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("257c1074-01b6-4075-ba9d-bcad207da89b"), new Object[]{ctx, warehouseId});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            HenhouseInfo retValue = (HenhouseInfo)_getWarehsHenhouse(ctx, warehouseId);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (HenhouseInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected HenhouseInfo _getWarehsHenhouse(Context ctx, String warehouseId) throws BOSException
    {    	
        return null;
    }

    public BreedBatchDetailInfo getBreedBatchDetailInfos(Context ctx, String batchID, String costObjectID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3209c084-f216-49ae-8d11-930abf9ae51e"), new Object[]{ctx, batchID, costObjectID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BreedBatchDetailInfo retValue = (BreedBatchDetailInfo)_getBreedBatchDetailInfos(ctx, batchID, costObjectID, bizDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BreedBatchDetailInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BreedBatchDetailInfo _getBreedBatchDetailInfos(Context ctx, String batchID, String costObjectID, Date bizDate) throws BOSException
    {    	
        return null;
    }

    public BreedModelInfo getBreedModelByHouseType(Context ctx, String henHouseType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ba3f10d4-5933-49dc-876e-f1c2758a1373"), new Object[]{ctx, henHouseType});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BreedModelInfo retValue = (BreedModelInfo)_getBreedModelByHouseType(ctx, henHouseType);
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
    protected BreedModelInfo _getBreedModelByHouseType(Context ctx, String henHouseType) throws BOSException
    {    	
        return null;
    }

    public BreedBatchInfo getBreedBatchInfoByCostObjID(Context ctx, String costObjectID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("1c471977-d8a9-4bbc-ac5d-ecd0759c997c"), new Object[]{ctx, costObjectID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BreedBatchInfo retValue = (BreedBatchInfo)_getBreedBatchInfoByCostObjID(ctx, costObjectID);
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
    protected BreedBatchInfo _getBreedBatchInfoByCostObjID(Context ctx, String costObjectID) throws BOSException
    {    	
        return null;
    }

    public HashMap getBatchWeekages(Context ctx, String batchID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("442ad6f1-8df0-4d4f-9886-1baeffe05342"), new Object[]{ctx, batchID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            HashMap retValue = (HashMap)_getBatchWeekages(ctx, batchID, bizDate);
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
    protected HashMap _getBatchWeekages(Context ctx, String batchID, Date bizDate) throws BOSException
    {    	
        return null;
    }

    public BreedModelEntryInfo getBreedModelEntryInfo(Context ctx, String modelID, int week, int days) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("18435654-03ee-423b-bac1-961de673d20d"), new Object[]{ctx, modelID, new Integer(week), new Integer(days)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BreedModelEntryInfo retValue = (BreedModelEntryInfo)_getBreedModelEntryInfo(ctx, modelID, week, days);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BreedModelEntryInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BreedModelEntryInfo _getBreedModelEntryInfo(Context ctx, String modelID, int week, int days) throws BOSException
    {    	
        return null;
    }

    public boolean isBatchGeneratedDailyInfos(Context ctx, String batchID, String henHouseType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("056f642d-5444-4217-958a-09e4427099d0"), new Object[]{ctx, batchID, henHouseType});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isBatchGeneratedDailyInfos(ctx, batchID, henHouseType);
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
    protected boolean _isBatchGeneratedDailyInfos(Context ctx, String batchID, String henHouseType) throws BOSException
    {    	
        return false;
    }

    public int getCommecialBatchDayage(Context ctx, String breedBatchID, String henhouseID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("0673aff2-affe-4ffe-8d3c-a8af2ac9f0a9"), new Object[]{ctx, breedBatchID, henhouseID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            int retValue = (int)_getCommecialBatchDayage(ctx, breedBatchID, henhouseID, bizDate);
            svcCtx.setMethodReturnValue(new Integer(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Integer)svcCtx.getMethodReturnValue()).intValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected int _getCommecialBatchDayage(Context ctx, String breedBatchID, String henhouseID, Date bizDate) throws BOSException
    {    	
        return 0;
    }

    public Map getBatchBreedingStock(Context ctx, String batchID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b037e6e5-3743-4788-8e5e-858158112c5e"), new Object[]{ctx, batchID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getBatchBreedingStock(ctx, batchID, bizDate);
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
    protected Map _getBatchBreedingStock(Context ctx, String batchID, Date bizDate) throws BOSException
    {    	
        return null;
    }

    public boolean checkDateDailyState(Context ctx, String breedBatchID, Date bizDate, String henhouseType, String dailyID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b4bd5476-67e9-438b-b23b-0d51d4dc234f"), new Object[]{ctx, breedBatchID, bizDate, henhouseType, dailyID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_checkDateDailyState(ctx, breedBatchID, bizDate, henhouseType, dailyID);
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
    protected boolean _checkDateDailyState(Context ctx, String breedBatchID, Date bizDate, String henhouseType, String dailyID) throws BOSException
    {    	
        return false;
    }

    public int getBatchEntryEditInfos(Context ctx, String batchID, String henhouseID, Date bizDate, String chikenType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("8d73b2b5-c103-4ade-bd20-0bab00e3d87d"), new Object[]{ctx, batchID, henhouseID, bizDate, chikenType});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            int retValue = (int)_getBatchEntryEditInfos(ctx, batchID, henhouseID, bizDate, chikenType);
            svcCtx.setMethodReturnValue(new Integer(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Integer)svcCtx.getMethodReturnValue()).intValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected int _getBatchEntryEditInfos(Context ctx, String batchID, String henhouseID, Date bizDate, String chikenType) throws BOSException
    {    	
        return 0;
    }

    public CostObjectInfo getFarmLatestCostObject(Context ctx, String farmID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("8008cbf1-8ae9-48c8-9e35-5aa57ca258cc"), new Object[]{ctx, farmID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CostObjectInfo retValue = (CostObjectInfo)_getFarmLatestCostObject(ctx, farmID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CostObjectInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CostObjectInfo _getFarmLatestCostObject(Context ctx, String farmID) throws BOSException
    {    	
        return null;
    }

    public boolean updateBatchEntryOutState(Context ctx, String batchID, String houseID, boolean isAllOut, int outQty, Date outDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("83761678-582b-4044-8695-2a5adb710ab8"), new Object[]{ctx, batchID, houseID, new Boolean(isAllOut), new Integer(outQty), outDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_updateBatchEntryOutState(ctx, batchID, houseID, isAllOut, outQty, outDate);
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
    protected boolean _updateBatchEntryOutState(Context ctx, String batchID, String houseID, boolean isAllOut, int outQty, Date outDate) throws BOSException
    {    	
        return false;
    }

    public void updateBatchOutState(Context ctx, String batchID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9e4efd0d-6100-4a2b-b32e-496278944261"), new Object[]{ctx, batchID});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _updateBatchOutState(ctx, batchID);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _updateBatchOutState(Context ctx, String batchID) throws BOSException
    {    	
        return;
    }

    public Map getCCBatchAgeAndQty(Context ctx, Date bizDate, int breedDays, int count) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("11547c17-9691-4c1e-9152-7678adb28d36"), new Object[]{ctx, bizDate, new Integer(breedDays), new Integer(count)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getCCBatchAgeAndQty(ctx, bizDate, breedDays, count);
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
    protected Map _getCCBatchAgeAndQty(Context ctx, Date bizDate, int breedDays, int count) throws BOSException
    {    	
        return null;
    }

    public BreedBatchInfo getBreedBatchByOrgAndOutDate(Context ctx, String stoOrgID, Date outDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6398677f-50e9-4479-af43-5d647046a386"), new Object[]{ctx, stoOrgID, outDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BreedBatchInfo retValue = (BreedBatchInfo)_getBreedBatchByOrgAndOutDate(ctx, stoOrgID, outDate);
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
    protected BreedBatchInfo _getBreedBatchByOrgAndOutDate(Context ctx, String stoOrgID, Date outDate) throws BOSException
    {    	
        return null;
    }

    public int getBatchEntryTransQty(Context ctx, String batchID, String henhouseID, Date bizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3bbb02c4-7a4f-48fa-9814-0a04b757f0ab"), new Object[]{ctx, batchID, henhouseID, bizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            int retValue = (int)_getBatchEntryTransQty(ctx, batchID, henhouseID, bizDate);
            svcCtx.setMethodReturnValue(new Integer(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Integer)svcCtx.getMethodReturnValue()).intValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected int _getBatchEntryTransQty(Context ctx, String batchID, String henhouseID, Date bizDate) throws BOSException
    {    	
        return 0;
    }

    public int getMaterialResidueDays(Context ctx, String materialID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b0c99b19-6945-45f6-a6a9-c20522e4c6fa"), new Object[]{ctx, materialID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            int retValue = (int)_getMaterialResidueDays(ctx, materialID);
            svcCtx.setMethodReturnValue(new Integer(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Integer)svcCtx.getMethodReturnValue()).intValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected int _getMaterialResidueDays(Context ctx, String materialID) throws BOSException
    {    	
        return 0;
    }

    public ResidueSetInfo getMaterialResidueSet(Context ctx, String materialID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7f08638a-c446-48d9-afad-3d4027879b74"), new Object[]{ctx, materialID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ResidueSetInfo retValue = (ResidueSetInfo)_getMaterialResidueSet(ctx, materialID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ResidueSetInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ResidueSetInfo _getMaterialResidueSet(Context ctx, String materialID) throws BOSException
    {    	
        return null;
    }

    public String getPermission(Context ctx, UserInfo user) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("0a32db91-dd79-4754-9692-ae59e7b3e969"), new Object[]{ctx, user});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getPermission(ctx, user);
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
    protected abstract String _getPermission(Context ctx, IObjectValue user) throws BOSException;

    public BreedStoorgSetInfo getStorageFarmInfo(Context ctx, String storageID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("bf9e4392-c41f-4992-962c-d6cbbc22de05"), new Object[]{ctx, storageID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BreedStoorgSetInfo retValue = (BreedStoorgSetInfo)_getStorageFarmInfo(ctx, storageID);
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
    protected BreedStoorgSetInfo _getStorageFarmInfo(Context ctx, String storageID) throws BOSException
    {    	
        return null;
    }

}