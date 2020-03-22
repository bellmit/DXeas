package com.kingdee.eas.custom.purchasebudget.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.purchasebudget.PurBudgetInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.purchasebudget.PurBudgetCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PurBudgetController extends CoreBillBaseController
{
    public PurBudgetCollection getPurBudgetCollection(Context ctx) throws BOSException, RemoteException;
    public PurBudgetCollection getPurBudgetCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PurBudgetCollection getPurBudgetCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public PurBudgetInfo getPurBudgetInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PurBudgetInfo getPurBudgetInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PurBudgetInfo getPurBudgetInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, PurBudgetInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, PurBudgetInfo model) throws BOSException, EASBizException, RemoteException;
    public void noPass(Context ctx, PurBudgetInfo model) throws BOSException, EASBizException, RemoteException;
    public void importFormExcel(Context ctx, PurBudgetInfo model) throws BOSException, RemoteException;
}