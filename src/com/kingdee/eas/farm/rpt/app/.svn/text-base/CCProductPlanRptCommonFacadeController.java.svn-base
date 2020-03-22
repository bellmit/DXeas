package com.kingdee.eas.farm.rpt.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.List;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.breed.HenhouseType;
import java.util.HashMap;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CCProductPlanRptCommonFacadeController extends BizController
{
    public List getRptBeanStorageInfos(Context ctx, HashMap param) throws BOSException, RemoteException;
    public List getStoorgPlanInfo(Context ctx, CCProductPlanRptBean ccRptBean, List inValidPlanIDs, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException, RemoteException;
    public List getStoorgBatchInfo(Context ctx, CCProductPlanRptBean ccRptBean, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException, RemoteException;
    public BreedModelInfo getCurrentBreedModelInfo(Context ctx, HenhouseType houseType) throws BOSException, RemoteException;
    public int getCCPredateHenqty(Context ctx, String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs, int theoryQty) throws BOSException, RemoteException;
    public int getCCActualOutHenqty(Context ctx, String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs) throws BOSException, RemoteException;
}