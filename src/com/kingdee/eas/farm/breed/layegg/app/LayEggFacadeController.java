package com.kingdee.eas.farm.breed.layegg.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.util.List;
import com.kingdee.eas.farm.breed.ParentBreedBatchInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface LayEggFacadeController extends BizController
{
    public Object getHouseLayEggSet(Context ctx, String henhouseID) throws BOSException, RemoteException;
    public List getConveyors(Context ctx, String stoOrgID) throws BOSException, RemoteException;
    public Map getLayeggStandard(Context ctx, String henType) throws BOSException, RemoteException;
    public Map getFeedStandard(Context ctx, String henType) throws BOSException, RemoteException;
    public boolean isBatchFixed(Context ctx, String batchID, Date bizDate) throws BOSException, RemoteException;
    public ParentBreedBatchInfo getCurrentParentBatch(Context ctx, String internalFarmID, Date bizDate) throws BOSException, RemoteException;
    public boolean checkDateDailyState(Context ctx, String breedBatchID, Date bizDate, String batchID) throws BOSException, RemoteException;
    public void toStockDaily(Context ctx) throws BOSException, RemoteException;
}