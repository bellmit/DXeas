package com.kingdee.eas.wlhlcomm.function.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.wlhlcomm.function.BillUpdateLogEntryCollection;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.wlhlcomm.function.BillUpdateLogEntryInfo;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BillUpdateLogEntryController extends CoreBillEntryBaseController
{
    public BillUpdateLogEntryInfo getBillUpdateLogEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BillUpdateLogEntryInfo getBillUpdateLogEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BillUpdateLogEntryInfo getBillUpdateLogEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BillUpdateLogEntryCollection getBillUpdateLogEntryCollection(Context ctx) throws BOSException, RemoteException;
    public BillUpdateLogEntryCollection getBillUpdateLogEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BillUpdateLogEntryCollection getBillUpdateLogEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}