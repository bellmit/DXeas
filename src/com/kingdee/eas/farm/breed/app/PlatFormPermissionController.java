package com.kingdee.eas.farm.breed.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.breed.PlatFormPermissionCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.PlatFormPermissionInfo;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PlatFormPermissionController extends CoreBillBaseController
{
    public PlatFormPermissionCollection getPlatFormPermissionCollection(Context ctx) throws BOSException, RemoteException;
    public PlatFormPermissionCollection getPlatFormPermissionCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PlatFormPermissionCollection getPlatFormPermissionCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public PlatFormPermissionInfo getPlatFormPermissionInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PlatFormPermissionInfo getPlatFormPermissionInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PlatFormPermissionInfo getPlatFormPermissionInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void layEggPlanPer(Context ctx, PlatFormPermissionInfo model) throws BOSException, RemoteException;
    public void hatchPlanPer(Context ctx, PlatFormPermissionInfo model) throws BOSException, RemoteException;
    public void cCBreedPlanPer(Context ctx, PlatFormPermissionInfo model) throws BOSException, RemoteException;
    public void slaughterPlanPer(Context ctx, PlatFormPermissionInfo model) throws BOSException, RemoteException;
}