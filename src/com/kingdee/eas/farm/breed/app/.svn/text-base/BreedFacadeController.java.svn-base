package com.kingdee.eas.farm.breed.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import java.util.Map;
import com.kingdee.eas.base.permission.UserInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.ResidueSetInfo;
import com.kingdee.eas.farm.breed.HenhouseInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.farm.breed.BreedModelEntryInfo;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import com.kingdee.eas.farm.breed.BreedStoorgSetInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchDetailInfo;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BreedFacadeController extends BizController
{
    public HenhouseInfo getWarehsHenhouse(Context ctx, String warehouseId) throws BOSException, RemoteException;
    public BreedBatchDetailInfo getBreedBatchDetailInfos(Context ctx, String batchID, String costObjectID, Date bizDate) throws BOSException, RemoteException;
    public BreedModelInfo getBreedModelByHouseType(Context ctx, String henHouseType) throws BOSException, RemoteException;
    public BreedBatchInfo getBreedBatchInfoByCostObjID(Context ctx, String costObjectID) throws BOSException, RemoteException;
    public HashMap getBatchWeekages(Context ctx, String batchID, Date bizDate) throws BOSException, RemoteException;
    public BreedModelEntryInfo getBreedModelEntryInfo(Context ctx, String modelID, int week, int days) throws BOSException, RemoteException;
    public boolean isBatchGeneratedDailyInfos(Context ctx, String batchID, String henHouseType) throws BOSException, RemoteException;
    public int getCommecialBatchDayage(Context ctx, String breedBatchID, String henhouseID, Date bizDate) throws BOSException, RemoteException;
    public Map getBatchBreedingStock(Context ctx, String batchID, Date bizDate) throws BOSException, RemoteException;
    public boolean checkDateDailyState(Context ctx, String breedBatchID, Date bizDate, String henhouseType, String dailyID) throws BOSException, RemoteException;
    public int getBatchEntryEditInfos(Context ctx, String batchID, String henhouseID, Date bizDate, String chikenType) throws BOSException, RemoteException;
    public CostObjectInfo getFarmLatestCostObject(Context ctx, String farmID) throws BOSException, RemoteException;
    public boolean updateBatchEntryOutState(Context ctx, String batchID, String houseID, boolean isAllOut, int outQty, Date outDate) throws BOSException, RemoteException;
    public void updateBatchOutState(Context ctx, String batchID) throws BOSException, RemoteException;
    public Map getCCBatchAgeAndQty(Context ctx, Date bizDate, int breedDays, int count) throws BOSException, RemoteException;
    public BreedBatchInfo getBreedBatchByOrgAndOutDate(Context ctx, String stoOrgID, Date outDate) throws BOSException, RemoteException;
    public int getBatchEntryTransQty(Context ctx, String batchID, String henhouseID, Date bizDate) throws BOSException, RemoteException;
    public int getMaterialResidueDays(Context ctx, String materialID) throws BOSException, RemoteException;
    public ResidueSetInfo getMaterialResidueSet(Context ctx, String materialID) throws BOSException, RemoteException;
    public String getPermission(Context ctx, UserInfo user) throws BOSException, RemoteException;
    public BreedStoorgSetInfo getStorageFarmInfo(Context ctx, String storageID) throws BOSException, RemoteException;
}