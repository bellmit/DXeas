package com.kingdee.eas.farm.food.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import java.util.LinkedHashMap;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SlaughterPlanFacadeController extends BizController
{
    public LinkedHashMap getSlaughterPlan(Context ctx, PeriodInfo fiscalPeriod, int ageOfDaysBeginFrom, int ageOfDaysBeginTo) throws BOSException, EASBizException, RemoteException;
    public Map getCullAndDeathFromFeedModel(Context ctx) throws BOSException, EASBizException, RemoteException;
    public String[] getSlaughterQtyInOneDay(Context ctx, String sroOrgUnitID, String henHouseID, String breedBatchID) throws BOSException, EASBizException, RemoteException;
}