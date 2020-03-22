package com.kingdee.eas.weighbridge.app;

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
import com.kingdee.eas.weighbridge.TaraStorageBillEntryCollection;
import com.kingdee.eas.weighbridge.TaraStorageBillEntryInfo;
import com.kingdee.eas.framework.app.CoreBillEntryBaseController;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface TaraStorageBillEntryController extends CoreBillEntryBaseController
{
    public TaraStorageBillEntryInfo getTaraStorageBillEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public TaraStorageBillEntryInfo getTaraStorageBillEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public TaraStorageBillEntryInfo getTaraStorageBillEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public TaraStorageBillEntryCollection getTaraStorageBillEntryCollection(Context ctx) throws BOSException, RemoteException;
    public TaraStorageBillEntryCollection getTaraStorageBillEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public TaraStorageBillEntryCollection getTaraStorageBillEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}