package com.kingdee.eas.publicdata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.publicdata.CarTreeInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;
import com.kingdee.eas.publicdata.CarTreeCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CarTreeController extends TreeBaseController
{
    public CarTreeInfo getCarTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CarTreeInfo getCarTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CarTreeInfo getCarTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public CarTreeCollection getCarTreeCollection(Context ctx) throws BOSException, RemoteException;
    public CarTreeCollection getCarTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CarTreeCollection getCarTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}