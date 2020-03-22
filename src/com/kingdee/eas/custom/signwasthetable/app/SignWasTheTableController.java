package com.kingdee.eas.custom.signwasthetable.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SignWasTheTableController extends CoreBillBaseController
{
    public SignWasTheTableCollection getSignWasTheTableCollection(Context ctx) throws BOSException, RemoteException;
    public SignWasTheTableCollection getSignWasTheTableCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SignWasTheTableCollection getSignWasTheTableCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public SignWasTheTableInfo getSignWasTheTableInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SignWasTheTableInfo getSignWasTheTableInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SignWasTheTableInfo getSignWasTheTableInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void check(Context ctx, SignWasTheTableInfo model) throws BOSException, EASBizException, RemoteException;
    public void deleteLine(Context ctx, SignWasTheTableInfo model) throws BOSException, RemoteException;
    public void listener(Context ctx, SignWasTheTableInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, SignWasTheTableInfo model) throws BOSException, EASBizException, RemoteException;
    public void btnRefresh(Context ctx, SignWasTheTableInfo model) throws BOSException, RemoteException;
}