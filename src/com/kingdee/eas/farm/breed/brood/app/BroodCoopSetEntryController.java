package com.kingdee.eas.farm.breed.brood.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.breed.brood.BroodCoopSetEntryCollection;
import java.lang.String;
import com.kingdee.eas.farm.breed.brood.BroodCoopSetEntryInfo;
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

public interface BroodCoopSetEntryController extends CoreBillEntryBaseController
{
    public BroodCoopSetEntryInfo getBroodCoopSetEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BroodCoopSetEntryInfo getBroodCoopSetEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BroodCoopSetEntryInfo getBroodCoopSetEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public BroodCoopSetEntryCollection getBroodCoopSetEntryCollection(Context ctx) throws BOSException, RemoteException;
    public BroodCoopSetEntryCollection getBroodCoopSetEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BroodCoopSetEntryCollection getBroodCoopSetEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}