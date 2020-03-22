package com.kingdee.eas.custom.wages.farm.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.farm.AdjustFarmmoneyCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.eas.custom.wages.farm.AdjustFarmmoneyInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface AdjustFarmmoneyController extends CoreBillBaseController
{
    public AdjustFarmmoneyCollection getAdjustFarmmoneyCollection(Context ctx) throws BOSException, RemoteException;
    public AdjustFarmmoneyCollection getAdjustFarmmoneyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public AdjustFarmmoneyCollection getAdjustFarmmoneyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public AdjustFarmmoneyInfo getAdjustFarmmoneyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public AdjustFarmmoneyInfo getAdjustFarmmoneyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public AdjustFarmmoneyInfo getAdjustFarmmoneyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, AdjustFarmmoneyInfo model) throws BOSException, RemoteException;
    public void unaudit(Context ctx, AdjustFarmmoneyInfo model) throws BOSException, RemoteException;
}