package com.kingdee.eas.custom.wages.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.BasicPostCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.eas.custom.wages.BasicPostInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BasicPostController extends DataBaseController
{
    public BasicPostInfo getBasicPostInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BasicPostInfo getBasicPostInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BasicPostInfo getBasicPostInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BasicPostCollection getBasicPostCollection(Context ctx) throws BOSException, RemoteException;
    public BasicPostCollection getBasicPostCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BasicPostCollection getBasicPostCollection(Context ctx, String oql) throws BOSException, RemoteException;
}