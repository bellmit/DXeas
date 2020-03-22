package com.kingdee.eas.farm.feedfactory.app;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataTreeCollection;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.app.TreeBaseController;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataTreeInfo;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface FeedFactoryBaseDataTreeController extends TreeBaseController
{
    public FeedFactoryBaseDataTreeInfo getFeedFactoryBaseDataTreeInfo(Context ctx, IObjectPK pk) throws BOSException, EASBizException, RemoteException;
    public FeedFactoryBaseDataTreeInfo getFeedFactoryBaseDataTreeInfo(Context ctx, IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException, RemoteException;
    public FeedFactoryBaseDataTreeInfo getFeedFactoryBaseDataTreeInfo(Context ctx, String oql) throws BOSException, EASBizException, RemoteException;
    public FeedFactoryBaseDataTreeCollection getFeedFactoryBaseDataTreeCollection(Context ctx) throws BOSException, RemoteException;
    public FeedFactoryBaseDataTreeCollection getFeedFactoryBaseDataTreeCollection(Context ctx, EntityViewInfo view) throws BOSException, RemoteException;
    public FeedFactoryBaseDataTreeCollection getFeedFactoryBaseDataTreeCollection(Context ctx, String oql) throws BOSException, RemoteException;
}