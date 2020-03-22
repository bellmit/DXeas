package com.kingdee.eas.farm.carnivorous.basedata.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.eas.farm.carnivorous.basedata.YieldDataBaseInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface YieldDataBaseController extends DataBaseController
{
    public YieldDataBaseInfo getYieldDataBaseInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public YieldDataBaseInfo getYieldDataBaseInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public YieldDataBaseInfo getYieldDataBaseInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public YieldDataBaseCollection getYieldDataBaseCollection(Context ctx) throws BOSException, RemoteException;
    public YieldDataBaseCollection getYieldDataBaseCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public YieldDataBaseCollection getYieldDataBaseCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, YieldDataBaseInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, YieldDataBaseInfo model) throws BOSException, EASBizException, RemoteException;
}