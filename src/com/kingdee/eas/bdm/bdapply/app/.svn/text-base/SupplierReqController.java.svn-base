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
import com.kingdee.eas.bdm.bdapply.SupplierReqCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.bdm.bdapply.SupplierReqInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface SupplierReqController extends CoreBillBaseController
{
    public SupplierReqCollection getSupplierReqCollection(Context ctx) throws BOSException, RemoteException;
    public SupplierReqCollection getSupplierReqCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SupplierReqCollection getSupplierReqCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public SupplierReqInfo getSupplierReqInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SupplierReqInfo getSupplierReqInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SupplierReqInfo getSupplierReqInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void supplierAudit(Context ctx, SupplierReqInfo model) throws BOSException, RemoteException;
    public void basenotby(Context ctx, SupplierReqInfo model) throws BOSException, RemoteException;
    public void allAudit(Context ctx, SupplierReqInfo model) throws BOSException, RemoteException;
}