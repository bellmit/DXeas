package com.kingdee.eas.farm.food.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.food.FuleDaliyInfo;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.food.FuleDaliyCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FuleDaliyController extends CoreBillBaseController
{
    public FuleDaliyCollection getFuleDaliyCollection(Context ctx) throws BOSException, RemoteException;
    public FuleDaliyCollection getFuleDaliyCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FuleDaliyCollection getFuleDaliyCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public FuleDaliyInfo getFuleDaliyInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FuleDaliyInfo getFuleDaliyInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FuleDaliyInfo getFuleDaliyInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, FuleDaliyInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, FuleDaliyInfo model) throws BOSException, RemoteException;
}