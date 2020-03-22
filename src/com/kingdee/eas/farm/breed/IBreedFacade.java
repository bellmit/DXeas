package com.kingdee.eas.farm.breed;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import com.kingdee.eas.base.permission.UserInfo;
import com.kingdee.eas.basedata.assistant.CostObjectInfo;
import com.kingdee.eas.farm.breed.comm.BreedBatchDetailInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

public interface IBreedFacade extends IBizCtrl
{
    public HenhouseInfo getWarehsHenhouse(String warehouseId) throws BOSException;
    public BreedBatchDetailInfo getBreedBatchDetailInfos(String batchID, String costObjectID, Date bizDate) throws BOSException;
    public BreedModelInfo getBreedModelByHouseType(String henHouseType) throws BOSException;
    public BreedBatchInfo getBreedBatchInfoByCostObjID(String costObjectID) throws BOSException;
    public HashMap getBatchWeekages(String batchID, Date bizDate) throws BOSException;
    public BreedModelEntryInfo getBreedModelEntryInfo(String modelID, int week, int days) throws BOSException;
    public boolean isBatchGeneratedDailyInfos(String batchID, String henHouseType) throws BOSException;
    public int getCommecialBatchDayage(String breedBatchID, String henhouseID, Date bizDate) throws BOSException;
    public Map getBatchBreedingStock(String batchID, Date bizDate) throws BOSException;
    public boolean checkDateDailyState(String breedBatchID, Date bizDate, String henhouseType, String dailyID) throws BOSException;
    public int getBatchEntryEditInfos(String batchID, String henhouseID, Date bizDate, String chikenType) throws BOSException;
    public CostObjectInfo getFarmLatestCostObject(String farmID) throws BOSException;
    public boolean updateBatchEntryOutState(String batchID, String houseID, boolean isAllOut, int outQty, Date outDate) throws BOSException;
    public void updateBatchOutState(String batchID) throws BOSException;
    public Map getCCBatchAgeAndQty(Date bizDate, int breedDays, int count) throws BOSException;
    public BreedBatchInfo getBreedBatchByOrgAndOutDate(String stoOrgID, Date outDate) throws BOSException;
    public int getBatchEntryTransQty(String batchID, String henhouseID, Date bizDate) throws BOSException;
    public int getMaterialResidueDays(String materialID) throws BOSException;
    public ResidueSetInfo getMaterialResidueSet(String materialID) throws BOSException;
    public String getPermission(UserInfo user) throws BOSException;
    public BreedStoorgSetInfo getStorageFarmInfo(String storageID) throws BOSException;
}