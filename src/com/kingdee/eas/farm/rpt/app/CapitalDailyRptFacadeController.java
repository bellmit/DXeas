package com.kingdee.eas.farm.rpt.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CapitalDailyRptFacadeController extends BizController
{
    public HashMap getCapitalDailyInfos(Context ctx, Date beginDate, Date endDate, String companyId) throws BOSException, RemoteException;
    public void releaseTempTable(Context ctx, String temptableName) throws BOSException, RemoteException;
    public HashMap getAllCompanysCapitalDailyInfos(Context ctx, Date beginDate, Date endDate, int isGather, String capitalType) throws BOSException, RemoteException;
}