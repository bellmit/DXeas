package com.kingdee.eas.farm.carnivorous.basebiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.farm.carnivorous.basebiz.CustomerViewReqBillCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface CustomerViewReqBillController extends CoreBillBaseController
{
    public CustomerViewReqBillCollection getCustomerViewReqBillCollection(Context ctx) throws BOSException, RemoteException;
    public CustomerViewReqBillCollection getCustomerViewReqBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public CustomerViewReqBillCollection getCustomerViewReqBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public CustomerViewReqBillInfo getCustomerViewReqBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public CustomerViewReqBillInfo getCustomerViewReqBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public CustomerViewReqBillInfo getCustomerViewReqBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, CustomerViewReqBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, CustomerViewReqBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void revoke(Context ctx, CustomerViewReqBillInfo model) throws BOSException, EASBizException, RemoteException;
}