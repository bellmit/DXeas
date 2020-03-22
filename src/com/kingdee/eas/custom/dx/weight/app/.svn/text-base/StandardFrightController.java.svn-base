package com.kingdee.eas.custom.dx.weight.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.custom.wlhllicensemanager.app.WlhlDataBaseController;
import com.kingdee.eas.custom.dx.weight.StandardFrightCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.dx.weight.StandardFrightInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface StandardFrightController extends WlhlDataBaseController
{
    public StandardFrightInfo getStandardFrightInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public StandardFrightInfo getStandardFrightInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public StandardFrightInfo getStandardFrightInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public StandardFrightCollection getStandardFrightCollection(Context ctx) throws BOSException, RemoteException;
    public StandardFrightCollection getStandardFrightCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public StandardFrightCollection getStandardFrightCollection(Context ctx, String oql) throws BOSException, RemoteException;
}