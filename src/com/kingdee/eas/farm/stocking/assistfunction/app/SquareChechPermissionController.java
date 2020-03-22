package com.kingdee.eas.farm.stocking.assistfunction.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.stocking.assistfunction.SquareChechPermissionInfo;
import com.kingdee.eas.farm.stocking.assistfunction.SquareChechPermissionCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SquareChechPermissionController extends DataBaseController
{
    public SquareChechPermissionInfo getSquareChechPermissionInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SquareChechPermissionInfo getSquareChechPermissionInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SquareChechPermissionInfo getSquareChechPermissionInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SquareChechPermissionCollection getSquareChechPermissionCollection(Context ctx) throws BOSException, RemoteException;
    public SquareChechPermissionCollection getSquareChechPermissionCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SquareChechPermissionCollection getSquareChechPermissionCollection(Context ctx, String oql) throws BOSException, RemoteException;
}