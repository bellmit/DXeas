package com.kingdee.eas.farm.breed.brood.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.breed.brood.BroodCoopSetCollection;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.brood.BroodCoopSetInfo;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface BroodCoopSetController extends CoreBillBaseController
{
    public BroodCoopSetCollection getBroodCoopSetCollection(Context ctx) throws BOSException, RemoteException;
    public BroodCoopSetCollection getBroodCoopSetCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public BroodCoopSetCollection getBroodCoopSetCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public BroodCoopSetInfo getBroodCoopSetInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public BroodCoopSetInfo getBroodCoopSetInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public BroodCoopSetInfo getBroodCoopSetInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}