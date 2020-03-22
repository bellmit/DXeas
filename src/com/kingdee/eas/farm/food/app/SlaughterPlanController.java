package com.kingdee.eas.farm.food.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.food.SlaughterPlanInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.eas.farm.food.SlaughterPlanCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SlaughterPlanController extends CoreBillBaseController
{
    public SlaughterPlanCollection getSlaughterPlanCollection(Context ctx) throws BOSException, RemoteException;
    public SlaughterPlanCollection getSlaughterPlanCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SlaughterPlanCollection getSlaughterPlanCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public SlaughterPlanInfo getSlaughterPlanInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SlaughterPlanInfo getSlaughterPlanInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SlaughterPlanInfo getSlaughterPlanInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void getSlaughterPlan(Context ctx, SlaughterPlanInfo model) throws BOSException, RemoteException;
    public void audit(Context ctx, SlaughterPlanInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, SlaughterPlanInfo model) throws BOSException, RemoteException;
    public void refresh(Context ctx, SlaughterPlanInfo model) throws BOSException, RemoteException;
}