package com.kingdee.eas.farm.breed.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.breed.FeedFettleEntryCollection;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.breed.FeedFettleEntryInfo;
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

public interface FeedFettleEntryController extends CoreBillEntryBaseController
{
    public FeedFettleEntryInfo getFeedFettleEntryInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FeedFettleEntryInfo getFeedFettleEntryInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FeedFettleEntryInfo getFeedFettleEntryInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public FeedFettleEntryCollection getFeedFettleEntryCollection(Context ctx) throws BOSException, RemoteException;
    public FeedFettleEntryCollection getFeedFettleEntryCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FeedFettleEntryCollection getFeedFettleEntryCollection(Context ctx, String oql) throws BOSException, RemoteException;
}