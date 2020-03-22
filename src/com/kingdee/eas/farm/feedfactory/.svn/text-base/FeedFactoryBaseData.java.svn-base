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

public class FeedFactoryBaseData extends DataBase implements IFeedFactoryBaseData
{
    public FeedFactoryBaseData()
    {
        super();
        registerInterface(IFeedFactoryBaseData.class, this);
    }
    public FeedFactoryBaseData(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedFactoryBaseData.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E9089AA5");
    }
    private FeedFactoryBaseDataController getController() throws BOSException
    {
        return (FeedFactoryBaseDataController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FeedFactoryBaseDataInfo getFeedFactoryBaseDataInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryBaseDataInfo(getContext(), pk);
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
    public FeedFactoryBaseDataInfo getFeedFactoryBaseDataInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryBaseDataInfo(getContext(), pk, selector);
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
    public FeedFactoryBaseDataInfo getFeedFactoryBaseDataInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryBaseDataInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedFactoryBaseDataCollection getFeedFactoryBaseDataCollection() throws BOSException
    {
        try {
            return getController().getFeedFactoryBaseDataCollection(getContext());
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
    public FeedFactoryBaseDataCollection getFeedFactoryBaseDataCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedFactoryBaseDataCollection(getContext(), view);
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
    public FeedFactoryBaseDataCollection getFeedFactoryBaseDataCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedFactoryBaseDataCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}