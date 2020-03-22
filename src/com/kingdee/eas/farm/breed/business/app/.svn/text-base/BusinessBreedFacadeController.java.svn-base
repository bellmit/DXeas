package com.kingdee.eas.farm.breed.business.app;

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
import com.kingdee.eas.farm.breed.business.CCBreedPlanInfo;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BusinessBreedFacadeController extends BizController
{
    public BreedBatchInfo getFarmBreedDailyByDate(Context ctx, String farmID, Date searchDate) throws BOSException, RemoteException;
    public List getBatchHouseAllAdjustInfos(Context ctx, String batchID, List rptBeans) throws BOSException, RemoteException;
    public void updateImmDaysOldData(Context ctx) throws BOSException, RemoteException;
    public void getCCBreedPlan(Context ctx) throws BOSException, RemoteException;
    public CCSendFodderStandard getCCSendFodderStandard(Context ctx, String companyNumber) throws BOSException, RemoteException;
    public WarehouseInfo getHenhouseTowerInfo(Context ctx, String henhouseID) throws BOSException, RemoteException;
    public BatchTowerInhouseInfo getBreedPlanTowerInhouseInfo(Context ctx, CCBreedPlanInfo breedPlanInfo) throws BOSException, RemoteException;
}