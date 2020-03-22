package com.kingdee.eas.spray.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.spray.CustomerSprayInvCollection;
import com.kingdee.bos.Context;
import com.kingdee.eas.spray.CustomerSprayInvInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CustomerSprayInvController extends CoreBillBaseController
{
    public CustomerSprayInvCollection getCustomerSprayInvCollection(Context ctx) throws BOSException, RemoteException;
    public CustomerSprayInvCollection getCustomerSprayInvCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CustomerSprayInvCollection getCustomerSprayInvCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CustomerSprayInvInfo getCustomerSprayInvInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CustomerSprayInvInfo getCustomerSprayInvInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CustomerSprayInvInfo getCustomerSprayInvInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}