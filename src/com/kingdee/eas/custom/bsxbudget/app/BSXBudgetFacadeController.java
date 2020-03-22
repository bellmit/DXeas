package com.kingdee.eas.custom.bsxbudget.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.math.BigDecimal;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BSXBudgetFacadeController extends BizController
{
    public PeriodInfo getCurrentPeriod(Context ctx) throws BOSException, RemoteException;
    public String[] getInventoryValue(Context ctx, PeriodInfo period) throws BOSException, RemoteException;
    public BigDecimal getTotalWeightFromBugetFeed(Context ctx, PeriodInfo periodInfo) throws BOSException, RemoteException;
    public BigDecimal getLairageQty(Context ctx, String beginDate, String endDate) throws BOSException, RemoteException;
}