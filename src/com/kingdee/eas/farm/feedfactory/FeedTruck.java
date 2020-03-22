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
     *ȡֵ-System defined method
     *@param pk ȡֵ
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
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
     *ȡֵ-System defined method
     *@param oql ȡֵ
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
     *ȡ����-System defined method
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
     *ȡ����-System defined method
     *@param view ȡ����
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
     *ȡ����-System defined method
     *@param oql ȡ����
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