package com.kingdee.eas.farm.breed.business;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.BreedBatchInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo;
import java.util.List;
import com.kingdee.eas.farm.breed.comm.BatchTowerInhouseInfo;
import java.lang.String;
import com.kingdee.eas.farm.breed.comm.CCSendFodderStandard;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public interface IBusinessBreedFacade extends IBizCtrl
{
    public BreedBatchInfo getFarmBreedDailyByDate(String farmID, Date searchDate) throws BOSException;
    public List getBatchHouseAllAdjustInfos(String batchID, List rptBeans) throws BOSException;
    public void updateImmDaysOldData() throws BOSException;
    public void getCCBreedPlan() throws BOSException;
    public CCSendFodderStandard getCCSendFodderStandard(String companyNumber) throws BOSException;
    public WarehouseInfo getHenhouseTowerInfo(String henhouseID) throws BOSException;
    public BatchTowerInhouseInfo getBreedPlanTowerInhouseInfo(CCBreedPlanInfo breedPlanInfo) throws BOSException;
}