package com.kingdee.eas.farm.feedfactory.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FeedFactoryTruckPlanController extends CoreBillBaseController
{
    public FeedFactoryTruckPlanCollection getFeedFactoryTruckPlanCollection(Context ctx) throws BOSException, RemoteException;
    public FeedFactoryTruckPlanCollection getFeedFactoryTruckPlanCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FeedFactoryTruckPlanCollection getFeedFactoryTruckPlanCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public FeedFactoryTruckPlanInfo getFeedFactoryTruckPlanInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FeedFactoryTruckPlanInfo getFeedFactoryTruckPlanInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FeedFactoryTruckPlanInfo getFeedFactoryTruckPlanInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void getFodderPlan(Context ctx, FeedFactoryTruckPlanInfo model) throws BOSException, RemoteException;
    public void generateTruckPlan(Context ctx, FeedFactoryTruckPlanInfo model) throws BOSException, RemoteException;
    public void audit(Context ctx, FeedFactoryTruckPlanInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, FeedFactoryTruckPlanInfo model) throws BOSException, RemoteException;
}