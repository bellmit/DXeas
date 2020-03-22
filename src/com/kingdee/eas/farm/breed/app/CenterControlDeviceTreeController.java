package com.kingdee.eas.farm.breed.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.breed.CenterControlDeviceTreeInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.breed.CenterControlDeviceTreeCollection;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CenterControlDeviceTreeController extends TreeBaseController
{
    public CenterControlDeviceTreeInfo getCenterControlDeviceTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CenterControlDeviceTreeInfo getCenterControlDeviceTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CenterControlDeviceTreeInfo getCenterControlDeviceTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CenterControlDeviceTreeCollection getCenterControlDeviceTreeCollection(Context ctx) throws BOSException, RemoteException;
    public CenterControlDeviceTreeCollection getCenterControlDeviceTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CenterControlDeviceTreeCollection getCenterControlDeviceTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}