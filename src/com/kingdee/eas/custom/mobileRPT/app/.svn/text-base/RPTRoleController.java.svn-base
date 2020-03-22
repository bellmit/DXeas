package com.kingdee.eas.custom.mobileRPT.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.mobileRPT.RPTRoleInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.eas.custom.mobileRPT.RPTRoleCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface RPTRoleController extends DataBaseController
{
    public RPTRoleInfo getRPTRoleInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public RPTRoleInfo getRPTRoleInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public RPTRoleInfo getRPTRoleInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public RPTRoleCollection getRPTRoleCollection(Context ctx) throws BOSException, RemoteException;
    public RPTRoleCollection getRPTRoleCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public RPTRoleCollection getRPTRoleCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void sendMessage(Context ctx, RPTRoleInfo model) throws BOSException, RemoteException;
}