package com.kingdee.eas.custom.bsxbudget.app;

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
import com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.custom.bsxbudget.BSXBudgetGroupCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BSXBudgetGroupController extends CoreBillBaseController
{
    public BSXBudgetGroupCollection getBSXBudgetGroupCollection(Context ctx) throws BOSException, RemoteException;
    public BSXBudgetGroupCollection getBSXBudgetGroupCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BSXBudgetGroupCollection getBSXBudgetGroupCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public BSXBudgetGroupInfo getBSXBudgetGroupInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BSXBudgetGroupInfo getBSXBudgetGroupInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BSXBudgetGroupInfo getBSXBudgetGroupInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, BSXBudgetGroupInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, BSXBudgetGroupInfo model) throws BOSException, EASBizException, RemoteException;
}