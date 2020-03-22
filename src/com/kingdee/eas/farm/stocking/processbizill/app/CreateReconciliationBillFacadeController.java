package com.kingdee.eas.farm.stocking.processbizill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.lang.String;
import com.kingdee.bos.framework.*;
import java.util.HashMap;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CreateReconciliationBillFacadeController extends BizController
{
    public HashMap CreateReconciliationBill(Context ctx, Map param) throws BOSException, EASBizException, RemoteException;
    public String CarryoverSettleBill(Context ctx, String param) throws BOSException, RemoteException;
}