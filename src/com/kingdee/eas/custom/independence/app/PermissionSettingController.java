package com.kingdee.eas.custom.independence.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.custom.independence.PermissionSettingInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.independence.PermissionSettingCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface PermissionSettingController extends DataBaseController
{
    public PermissionSettingInfo getPermissionSettingInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public PermissionSettingInfo getPermissionSettingInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public PermissionSettingInfo getPermissionSettingInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public PermissionSettingCollection getPermissionSettingCollection(Context ctx) throws BOSException, RemoteException;
    public PermissionSettingCollection getPermissionSettingCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public PermissionSettingCollection getPermissionSettingCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void purOrderUpdateTax(Context ctx, PermissionSettingInfo model) throws BOSException, RemoteException;
    public void purOrderCheck(Context ctx, PermissionSettingInfo model) throws BOSException, RemoteException;
    public void purOrderUnCheck(Context ctx, PermissionSettingInfo model) throws BOSException, RemoteException;
}