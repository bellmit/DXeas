package com.kingdee.eas.farm.hatch.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.hatch.EarlyEggStockCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.eas.farm.hatch.EarlyEggStockInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface EarlyEggStockController extends CoreBillBaseController
{
    public EarlyEggStockCollection getEarlyEggStockCollection(Context ctx) throws BOSException, RemoteException;
    public EarlyEggStockCollection getEarlyEggStockCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public EarlyEggStockCollection getEarlyEggStockCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public EarlyEggStockInfo getEarlyEggStockInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public EarlyEggStockInfo getEarlyEggStockInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public EarlyEggStockInfo getEarlyEggStockInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, IObjectValue Info) throws BOSException, EASBizException, RemoteException;
}