package com.kingdee.eas.farm.food.stocount.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.food.stocount.SemiProductCountEntryInfo;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.food.stocount.SemiProductCountEntryCollection;
import java.lang.String;
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

public interface SemiProductCountEntryController extends CoreBillEntryBaseController
{
    public SemiProductCountEntryInfo getSemiProductCountEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public SemiProductCountEntryInfo getSemiProductCountEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public SemiProductCountEntryInfo getSemiProductCountEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public SemiProductCountEntryCollection getSemiProductCountEntryCollection(Context ctx) throws BOSException, RemoteException;
    public SemiProductCountEntryCollection getSemiProductCountEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public SemiProductCountEntryCollection getSemiProductCountEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}