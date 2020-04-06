package com.kingdee.eas.farm.carnivorous.feedbiz.app;

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
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FodderReceptionController extends CoreBillBaseController
{
    public FodderReceptionCollection getFodderReceptionCollection(Context ctx) throws BOSException, RemoteException;
    public FodderReceptionCollection getFodderReceptionCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FodderReceptionCollection getFodderReceptionCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public FodderReceptionInfo getFodderReceptionInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FodderReceptionInfo getFodderReceptionInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FodderReceptionInfo getFodderReceptionInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, FodderReceptionInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, FodderReceptionInfo model) throws BOSException, EASBizException, RemoteException;
    public void viewStdUse(Context ctx, FodderReceptionInfo model) throws BOSException, RemoteException;
    public void chkVoucherFlag(Context ctx, FodderReceptionInfo model) throws BOSException, RemoteException;
    public void chkVoucherAll(Context ctx, FodderReceptionInfo model) throws BOSException, RemoteException;
    public void batchSubmit(Context ctx, FodderReceptionInfo model) throws BOSException, RemoteException;
    public void close(Context ctx, FodderReceptionInfo model) throws BOSException, EASBizException, RemoteException;
    public void unClose(Context ctx, FodderReceptionInfo model) throws BOSException, EASBizException, RemoteException;
    public void updatePrice(Context ctx, FodderReceptionInfo model) throws BOSException, RemoteException;
}