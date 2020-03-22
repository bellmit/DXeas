package com.kingdee.eas.custom.applicationofsocialsecurity.app;

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
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionCollection;
import com.kingdee.eas.framework.app.DataBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.applicationofsocialsecurity.DataBaseConnectionInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DataBaseConnectionController extends DataBaseController
{
    public DataBaseConnectionInfo getDataBaseConnectionInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public DataBaseConnectionInfo getDataBaseConnectionInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public DataBaseConnectionInfo getDataBaseConnectionInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public DataBaseConnectionCollection getDataBaseConnectionCollection(Context ctx) throws BOSException, RemoteException;
    public DataBaseConnectionCollection getDataBaseConnectionCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public DataBaseConnectionCollection getDataBaseConnectionCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public void audit(Context ctx, DataBaseConnectionInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, DataBaseConnectionInfo model) throws BOSException, RemoteException;
}