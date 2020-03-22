package com.kingdee.eas.weighbridge.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.weighbridge.TaraStorageBillCollection;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.weighbridge.TaraStorageBillInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TaraStorageBillController extends CoreBillBaseController
{
    public TaraStorageBillCollection getTaraStorageBillCollection(Context ctx) throws BOSException, RemoteException;
    public TaraStorageBillCollection getTaraStorageBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public TaraStorageBillCollection getTaraStorageBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public TaraStorageBillInfo getTaraStorageBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public TaraStorageBillInfo getTaraStorageBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public TaraStorageBillInfo getTaraStorageBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, TaraStorageBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, TaraStorageBillInfo model) throws BOSException, RemoteException;
    public void updateSourceBill(Context ctx, TaraStorageBillInfo model) throws BOSException, RemoteException;
}