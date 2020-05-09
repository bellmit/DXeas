package com.kingdee.eas.farm.carnivorous.feedbiz.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FarmPollingBillController extends CoreBillBaseController
{
    public FarmPollingBillCollection getFarmPollingBillCollection(Context ctx) throws BOSException, RemoteException;
    public FarmPollingBillCollection getFarmPollingBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FarmPollingBillCollection getFarmPollingBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public FarmPollingBillInfo getFarmPollingBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FarmPollingBillInfo getFarmPollingBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FarmPollingBillInfo getFarmPollingBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void displayPic(Context ctx, FarmPollingBillInfo model) throws BOSException, RemoteException;
    public void audit(Context ctx, FarmPollingBillInfo model) throws BOSException, EASBizException, RemoteException;
    public void unAudit(Context ctx, FarmPollingBillInfo model) throws BOSException, EASBizException, RemoteException;
}