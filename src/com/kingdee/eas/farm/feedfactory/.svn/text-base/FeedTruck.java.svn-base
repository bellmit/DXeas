package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.feedfactory.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FeedTruck extends DataBase implements IFeedTruck
{
    public FeedTruck()
    {
        super();
        registerInterface(IFeedTruck.class, this);
    }
    public FeedTruck(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedTruck.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6C0C89BF");
    }
    private FeedTruckController getController() throws BOSException
    {
        return (FeedTruckController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FeedTruckInfo getFeedTruckInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedTruckInfo(getContext(), pk);
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
    public FeedTruckInfo getFeedTruckInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedTruckInfo(getContext(), pk, selector);
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
    public FeedTruckInfo getFeedTruckInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedTruckInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedTruckCollection getFeedTruckCollection() throws BOSException
    {
        try {
            return getController().getFeedTruckCollection(getContext());
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
    public FeedTruckCollection getFeedTruckCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedTruckCollection(getContext(), view);
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
    public FeedTruckCollection getFeedTruckCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedTruckCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}