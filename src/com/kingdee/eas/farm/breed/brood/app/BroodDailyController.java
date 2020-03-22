package com.kingdee.eas.farm.breed.brood.app;

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
import com.kingdee.eas.farm.breed.brood.BroodDailyCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.brood.BroodDailyInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BroodDailyController extends CoreBillBaseController
{
    public BroodDailyCollection getBroodDailyCollection(Context ctx) throws BOSException, RemoteException;
    public BroodDailyCollection getBroodDailyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BroodDailyCollection getBroodDailyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public BroodDailyInfo getBroodDailyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BroodDailyInfo getBroodDailyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BroodDailyInfo getBroodDailyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, BroodDailyInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, BroodDailyInfo model) throws BOSException, RemoteException;
    public List genNextBill(Context ctx, BroodDailyInfo model) throws BOSException, RemoteException;
    public void reShareCoalAndDiesel(Context ctx, BroodDailyInfo model) throws BOSException, RemoteException;
}