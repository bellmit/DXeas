package com.kingdee.eas.weighbridge.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.weighbridge.InStorageBillInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.weighbridge.InStorageBillCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface InStorageBillController extends CoreBillBaseController
{
    public InStorageBillCollection getInStorageBillCollection(Context ctx) throws BOSException, RemoteException;
    public InStorageBillCollection getInStorageBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public InStorageBillCollection getInStorageBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public InStorageBillInfo getInStorageBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public InStorageBillInfo getInStorageBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public InStorageBillInfo getInStorageBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, InStorageBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, InStorageBillInfo model) throws BOSException, RemoteException;
    public void updateSourceBill(Context ctx, InStorageBillInfo model) throws BOSException, RemoteException;
}