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
import com.kingdee.eas.custom.wages.WelfarecategoryCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.wages.WelfarecategoryInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface WelfarecategoryController extends DataBaseController
{
    public WelfarecategoryInfo getWelfarecategoryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public WelfarecategoryInfo getWelfarecategoryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public WelfarecategoryInfo getWelfarecategoryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public WelfarecategoryCollection getWelfarecategoryCollection(Context ctx) throws BOSException, RemoteException;
    public WelfarecategoryCollection getWelfarecategoryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public WelfarecategoryCollection getWelfarecategoryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}