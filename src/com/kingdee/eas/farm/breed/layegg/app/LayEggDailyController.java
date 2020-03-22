package com.kingdee.eas.farm.breed.layegg.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface LayEggDailyController extends CoreBillBaseController
{
    public LayEggDailyCollection getLayEggDailyCollection(Context ctx) throws BOSException, RemoteException;
    public LayEggDailyCollection getLayEggDailyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public LayEggDailyCollection getLayEggDailyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public LayEggDailyInfo getLayEggDailyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public LayEggDailyInfo getLayEggDailyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public LayEggDailyInfo getLayEggDailyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, LayEggDailyInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, LayEggDailyInfo model) throws BOSException, RemoteException;
    public List genNextBill(Context ctx, LayEggDailyInfo model) throws BOSException, RemoteException;
    public void reShareInfos(Context ctx, LayEggDailyInfo model) throws BOSException, RemoteException;
    public void refreshInventory(Context ctx, LayEggDailyInfo model) throws BOSException, RemoteException;
    public void toStockDaily(Context ctx, LayEggDailyInfo model) throws BOSException, RemoteException;
}