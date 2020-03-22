package com.kingdee.eas.farm.breed.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.breed.FeedFettleInfo;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.FeedFettleCollection;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.CoreBillBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FeedFettleController extends CoreBillBaseController
{
    public FeedFettleCollection getFeedFettleCollection(Context ctx) throws BOSException, RemoteException;
    public FeedFettleCollection getFeedFettleCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FeedFettleCollection getFeedFettleCollection(Context ctx, String oql) throws BOSException, RemoteException;
    public FeedFettleInfo getFeedFettleInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FeedFettleInfo getFeedFettleInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FeedFettleInfo getFeedFettleInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
}