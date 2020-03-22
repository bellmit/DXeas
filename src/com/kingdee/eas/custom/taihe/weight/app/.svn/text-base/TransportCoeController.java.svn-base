package com.kingdee.eas.custom.taihe.weight.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlDataBaseController;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.taihe.weight.TransportCoeCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.taihe.weight.TransportCoeInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TransportCoeController extends WlhlDataBaseController
{
    public TransportCoeInfo getTransportCoeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public TransportCoeInfo getTransportCoeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public TransportCoeInfo getTransportCoeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public TransportCoeCollection getTransportCoeCollection(Context ctx) throws BOSException, RemoteException;
    public TransportCoeCollection getTransportCoeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public TransportCoeCollection getTransportCoeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}