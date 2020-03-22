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
import com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusCollection;
import com.kingdee.eas.custom.applicationofsocialsecurity.ModifySIStatusInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface ModifySIStatusController extends CoreBillBaseController
{
    public ModifySIStatusCollection getModifySIStatusCollection(Context ctx) throws BOSException, RemoteException;
    public ModifySIStatusCollection getModifySIStatusCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public ModifySIStatusCollection getModifySIStatusCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public ModifySIStatusInfo getModifySIStatusInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public ModifySIStatusInfo getModifySIStatusInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public ModifySIStatusInfo getModifySIStatusInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void undoAll(Context ctx, ModifySIStatusInfo model) throws BOSException, RemoteException;
    public void undoSelected(Context ctx, ModifySIStatusInfo model) throws BOSException, RemoteException;
}