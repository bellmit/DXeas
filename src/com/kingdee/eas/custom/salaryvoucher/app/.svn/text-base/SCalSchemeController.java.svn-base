package com.kingdee.eas.custom.salaryvoucher.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.salaryvoucher.SCalSchemeInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.salaryvoucher.SCalSchemeCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SCalSchemeController extends DataBaseController
{
    public SCalSchemeInfo getSCalSchemeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SCalSchemeInfo getSCalSchemeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SCalSchemeInfo getSCalSchemeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SCalSchemeCollection getSCalSchemeCollection(Context ctx) throws BOSException, RemoteException;
    public SCalSchemeCollection getSCalSchemeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SCalSchemeCollection getSCalSchemeCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void getSCalScheme(Context ctx, SCalSchemeInfo model) throws BOSException, RemoteException;
}