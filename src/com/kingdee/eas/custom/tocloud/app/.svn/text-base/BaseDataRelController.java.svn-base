package com.kingdee.eas.custom.tocloud.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.tocloud.BaseDataRelCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.eas.custom.tocloud.BaseDataRelInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BaseDataRelController extends DataBaseController
{
    public BaseDataRelInfo getBaseDataRelInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BaseDataRelInfo getBaseDataRelInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BaseDataRelInfo getBaseDataRelInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BaseDataRelCollection getBaseDataRelCollection(Context ctx) throws BOSException, RemoteException;
    public BaseDataRelCollection getBaseDataRelCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BaseDataRelCollection getBaseDataRelCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, BaseDataRelInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, BaseDataRelInfo model) throws BOSException, RemoteException;
}