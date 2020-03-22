package com.kingdee.eas.weighbridge.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.eas.weighbridge.FeInStorageBillInfo;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.weighbridge.FeInStorageBillCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FeInStorageBillController extends CoreBillBaseController
{
    public FeInStorageBillCollection getFeInStorageBillCollection(Context ctx) throws BOSException, RemoteException;
    public FeInStorageBillCollection getFeInStorageBillCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FeInStorageBillCollection getFeInStorageBillCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public FeInStorageBillInfo getFeInStorageBillInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FeInStorageBillInfo getFeInStorageBillInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FeInStorageBillInfo getFeInStorageBillInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public void audit(Context ctx, FeInStorageBillInfo model) throws BOSException, RemoteException;
    public void unAudit(Context ctx, FeInStorageBillInfo model) throws BOSException, RemoteException;
}