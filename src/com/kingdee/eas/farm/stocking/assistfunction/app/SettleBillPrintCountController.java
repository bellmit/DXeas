package com.kingdee.eas.farm.stocking.assistfunction.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.stocking.assistfunction.SettleBillPrintCountInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.stocking.assistfunction.SettleBillPrintCountCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SettleBillPrintCountController extends CoreBillBaseController
{
    public SettleBillPrintCountCollection getSettleBillPrintCountCollection(Context ctx) throws BOSException, RemoteException;
    public SettleBillPrintCountCollection getSettleBillPrintCountCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SettleBillPrintCountCollection getSettleBillPrintCountCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public SettleBillPrintCountInfo getSettleBillPrintCountInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SettleBillPrintCountInfo getSettleBillPrintCountInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SettleBillPrintCountInfo getSettleBillPrintCountInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}