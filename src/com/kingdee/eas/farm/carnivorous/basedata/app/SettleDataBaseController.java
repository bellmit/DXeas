package com.kingdee.eas.farm.carnivorous.basedata.app;

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
import com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseInfo;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.eas.farm.carnivorous.basedata.SettleDataBaseCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SettleDataBaseController extends DataBaseController
{
    public SettleDataBaseInfo getSettleDataBaseInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SettleDataBaseInfo getSettleDataBaseInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SettleDataBaseInfo getSettleDataBaseInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SettleDataBaseCollection getSettleDataBaseCollection(Context ctx) throws BOSException, RemoteException;
    public SettleDataBaseCollection getSettleDataBaseCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SettleDataBaseCollection getSettleDataBaseCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, SettleDataBaseInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, SettleDataBaseInfo model) throws BOSException, EASBizException, RemoteException;
}