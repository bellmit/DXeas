package com.kingdee.eas.farm.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import com.kingdee.eas.farm.hatch.HatchBaseDataInfo;
import java.lang.String;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface hatchFacadeController extends BizController
{
    public Map getLayEggPlan(Context ctx, PeriodInfo period) throws BOSException, RemoteException;
    public HatchBaseDataInfo getHatchBaseData(Context ctx) throws BOSException, RemoteException;
    public Map getCCBreedInfo(Context ctx, Date pkDate) throws BOSException, RemoteException;
    public Map getLayEggPlanTotal(Context ctx, PeriodInfo period) throws BOSException, RemoteException;
    public HatchBaseDataInfo getHatchBaseData(Context ctx, StorageOrgUnitInfo stoOrg) throws BOSException, RemoteException;
    public void excuteSql(Context ctx, String sql) throws BOSException, EASBizException, RemoteException;
}