package com.kingdee.eas.farm.breed;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FeedFettle extends CoreBillBase implements IFeedFettle
{
    public FeedFettle()
    {
        super();
        registerInterface(IFeedFettle.class, this);
    }
    public FeedFettle(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedFettle.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E6EF4550");
    }
    private FeedFettleController getController() throws BOSException
    {
        return (FeedFettleController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedFettleCollection getFeedFettleCollection() throws BOSException
    {
        try {
            return getController().getFeedFettleCollection(getContext());
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
    public FeedFettleCollection getFeedFettleCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedFettleCollection(getContext(), view);
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
    public FeedFettleCollection getFeedFettleCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedFettleCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FeedFettleInfo getFeedFettleInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFettleInfo(getContext(), pk);
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
    public FeedFettleInfo getFeedFettleInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFettleInfo(getContext(), pk, selector);
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
    public FeedFettleInfo getFeedFettleInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFettleInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}