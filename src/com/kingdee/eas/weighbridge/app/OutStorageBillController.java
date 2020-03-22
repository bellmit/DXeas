package com.kingdee.eas.weighbridge.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.weighbridge.OutStorageBillCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.weighbridge.OutStorageBillInfo;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface OutStorageBillController extends CoreBillBaseController
{
    public OutStorageBillCollection getOutStorageBillCollection(Context ctx) throws BOSException, RemoteException;
    public OutStorageBillCollection getOutStorageBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public OutStorageBillCollection getOutStorageBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public OutStorageBillInfo getOutStorageBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public OutStorageBillInfo getOutStorageBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public OutStorageBillInfo getOutStorageBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, OutStorageBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, OutStorageBillInfo model) throws BOSException, RemoteException;
}