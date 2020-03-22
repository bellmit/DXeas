package com.kingdee.eas.bdm.bdapply.app;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.bdm.bdapply.CustomerInfoReqCollection;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.bdm.bdapply.CustomerInfoReqInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CustomerInfoReqController extends CoreBillBaseController
{
    public CustomerInfoReqCollection getCustomerInfoReqCollection(Context ctx) throws BOSException, RemoteException;
    public CustomerInfoReqCollection getCustomerInfoReqCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CustomerInfoReqCollection getCustomerInfoReqCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CustomerInfoReqInfo getCustomerInfoReqInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CustomerInfoReqInfo getCustomerInfoReqInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CustomerInfoReqInfo getCustomerInfoReqInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void customerInfoReqAudit(Context ctx, CustomerInfoReqInfo model) throws BOSException, RemoteException;
    public void notby(Context ctx, CustomerInfoReqInfo model) throws BOSException, RemoteException;
    public void allAudit(Context ctx, CustomerInfoReqInfo model) throws BOSException, RemoteException;
}