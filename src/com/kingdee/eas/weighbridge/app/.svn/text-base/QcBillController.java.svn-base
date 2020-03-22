package com.kingdee.eas.weighbridge.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.weighbridge.QcBillCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.weighbridge.QcBillInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface QcBillController extends CoreBillBaseController
{
    public QcBillCollection getQcBillCollection(Context ctx) throws BOSException, RemoteException;
    public QcBillCollection getQcBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public QcBillCollection getQcBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public QcBillInfo getQcBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public QcBillInfo getQcBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public QcBillInfo getQcBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, QcBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, QcBillInfo model) throws BOSException, RemoteException;
}