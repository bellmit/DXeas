package com.kingdee.eas.custom.wages.food.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.wages.food.AdjustFoodmoneyInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wages.food.AdjustFoodmoneyCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface AdjustFoodmoneyController extends CoreBillBaseController
{
    public AdjustFoodmoneyCollection getAdjustFoodmoneyCollection(Context ctx) throws BOSException, RemoteException;
    public AdjustFoodmoneyCollection getAdjustFoodmoneyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public AdjustFoodmoneyCollection getAdjustFoodmoneyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public AdjustFoodmoneyInfo getAdjustFoodmoneyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public AdjustFoodmoneyInfo getAdjustFoodmoneyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public AdjustFoodmoneyInfo getAdjustFoodmoneyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, AdjustFoodmoneyInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, AdjustFoodmoneyInfo model) throws BOSException, RemoteException;
}