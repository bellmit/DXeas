package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.eas.farm.feedfactory.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FeedFactoryBaseDataTree extends TreeBase implements IFeedFactoryBaseDataTree
{
    public FeedFactoryBaseDataTree()
    {
        super();
        registerInterface(IFeedFactoryBaseDataTree.class, this);
    }
    public FeedFactoryBaseDataTree(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedFactoryBaseDataTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A868A7E3");
    }
    private FeedFactoryBaseDataTreeController getController() throws BOSException
    {
        return (FeedFactoryBaseDataTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FeedFactoryBaseDataTreeInfo getFeedFactoryBaseDataTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryBaseDataTreeInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@param selector 取值
     *@return
     */
    public FeedFactoryBaseDataTreeInfo getFeedFactoryBaseDataTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryBaseDataTreeInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param oql 取值
     *@return
     */
    public FeedFactoryBaseDataTreeInfo getFeedFactoryBaseDataTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryBaseDataTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedFactoryBaseDataTreeCollection getFeedFactoryBaseDataTreeCollection() throws BOSException
    {
        try {
            return getController().getFeedFactoryBaseDataTreeCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param view 取集合
     *@return
     */
    public FeedFactoryBaseDataTreeCollection getFeedFactoryBaseDataTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedFactoryBaseDataTreeCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@param oql 取集合
     *@return
     */
    public FeedFactoryBaseDataTreeCollection getFeedFactoryBaseDataTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedFactoryBaseDataTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}