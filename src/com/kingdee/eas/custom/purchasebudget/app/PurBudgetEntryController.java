package com.kingdee.eas.custom.purchasebudget.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.purchasebudget.PurBudgetEntryInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.purchasebudget.PurBudgetEntryCollection;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PurBudgetEntryController extends CoreBillEntryBaseController
{
    public PurBudgetEntryInfo getPurBudgetEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PurBudgetEntryInfo getPurBudgetEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PurBudgetEntryInfo getPurBudgetEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PurBudgetEntryCollection getPurBudgetEntryCollection(Context ctx) throws BOSException, RemoteException;
    public PurBudgetEntryCollection getPurBudgetEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PurBudgetEntryCollection getPurBudgetEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}