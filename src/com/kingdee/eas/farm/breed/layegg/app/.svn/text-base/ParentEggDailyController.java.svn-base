package com.kingdee.eas.farm.breed.layegg.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.eas.farm.breed.layegg.ParentEggDailyCollection;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ParentEggDailyController extends CoreBillBaseController
{
    public ParentEggDailyCollection getParentEggDailyCollection(Context ctx) throws BOSException, RemoteException;
    public ParentEggDailyCollection getParentEggDailyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ParentEggDailyCollection getParentEggDailyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ParentEggDailyInfo getParentEggDailyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ParentEggDailyInfo getParentEggDailyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ParentEggDailyInfo getParentEggDailyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, ParentEggDailyInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, ParentEggDailyInfo model) throws BOSException, RemoteException;
    public List genNextBill(Context ctx, ParentEggDailyInfo model) throws BOSException, RemoteException;
    public void reShareInfos(Context ctx, ParentEggDailyInfo model) throws BOSException, RemoteException;
    public void refreshInventory(Context ctx, ParentEggDailyInfo model) throws BOSException, RemoteException;
}