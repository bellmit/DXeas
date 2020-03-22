package com.kingdee.eas.farm.breed.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import java.util.ArrayList;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface farmingFacadeController extends BizController
{
    public ArrayList getBreedPlan(Context ctx, Date date, PeriodInfo period, StorageOrgUnitInfo stoOrgUnit, String planType) throws BOSException, RemoteException;
    public ArrayList getSlaughterPlan(Context ctx, StorageOrgUnitInfo storageUnit, PeriodInfo period) throws BOSException, RemoteException;
}