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

public class FeedTruckTree extends TreeBase implements IFeedTruckTree
{
    public FeedTruckTree()
    {
        super();
        registerInterface(IFeedTruckTree.class, this);
    }
    public FeedTruckTree(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedTruckTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1B4B79FD");
    }
    private FeedTruckTreeController getController() throws BOSException
    {
        return (FeedTruckTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FeedTruckTreeInfo getFeedTruckTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedTruckTreeInfo(getContext(), pk);
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
    public FeedTruckTreeInfo getFeedTruckTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedTruckTreeInfo(getContext(), pk, selector);
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
    public FeedTruckTreeInfo getFeedTruckTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedTruckTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedTruckTreeCollection getFeedTruckTreeCollection() throws BOSException
    {
        try {
            return getController().getFeedTruckTreeCollection(getContext());
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
    public FeedTruckTreeCollection getFeedTruckTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedTruckTreeCollection(getContext(), view);
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
    public FeedTruckTreeCollection getFeedTruckTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedTruckTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}