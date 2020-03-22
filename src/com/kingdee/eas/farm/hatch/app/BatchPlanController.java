package com.kingdee.eas.farm.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.hatch.BatchPlanInfo;
import java.lang.String;
import com.kingdee.eas.farm.hatch.BatchPlanCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BatchPlanController extends CoreBillBaseController
{
    public BatchPlanCollection getBatchPlanCollection(Context ctx) throws BOSException, RemoteException;
    public BatchPlanCollection getBatchPlanCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BatchPlanCollection getBatchPlanCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public BatchPlanInfo getBatchPlanInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BatchPlanInfo getBatchPlanInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BatchPlanInfo getBatchPlanInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, BatchPlanInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, BatchPlanInfo model) throws BOSException, RemoteException;
    public void getLayEggPlan(Context ctx, BatchPlanInfo model) throws BOSException, RemoteException;
}