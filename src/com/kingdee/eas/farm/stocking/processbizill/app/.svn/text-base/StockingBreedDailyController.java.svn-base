package com.kingdee.eas.farm.stocking.processbizill.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface StockingBreedDailyController extends CoreBillBaseController
{
    public StockingBreedDailyCollection getStockingBreedDailyCollection(Context ctx) throws BOSException, RemoteException;
    public StockingBreedDailyCollection getStockingBreedDailyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public StockingBreedDailyCollection getStockingBreedDailyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public StockingBreedDailyInfo getStockingBreedDailyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public StockingBreedDailyInfo getStockingBreedDailyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public StockingBreedDailyInfo getStockingBreedDailyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, StockingBreedDailyInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, StockingBreedDailyInfo model) throws BOSException, EASBizException, RemoteException;
    public List genNextBill(Context ctx, StockingBreedDailyInfo model) throws BOSException, RemoteException;
    public void reShareCoalAndDiesel(Context ctx, StockingBreedDailyInfo model) throws BOSException, RemoteException;
    public String recalStockingByBatchID(Context ctx, String String) throws BOSException, EASBizException, RemoteException;
}