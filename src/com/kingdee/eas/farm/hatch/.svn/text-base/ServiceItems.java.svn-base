package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
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

public class ServiceItems extends DataBase implements IServiceItems
{
    public ServiceItems()
    {
        super();
        registerInterface(IServiceItems.class, this);
    }
    public ServiceItems(Context ctx)
    {
        super(ctx);
        registerInterface(IServiceItems.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("29354319");
    }
    private ServiceItemsController getController() throws BOSException
    {
        return (ServiceItemsController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ServiceItemsInfo getServiceItemsInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getServiceItemsInfo(getContext(), pk);
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
    public ServiceItemsInfo getServiceItemsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getServiceItemsInfo(getContext(), pk, selector);
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
    public ServiceItemsInfo getServiceItemsInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getServiceItemsInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ServiceItemsCollection getServiceItemsCollection() throws BOSException
    {
        try {
            return getController().getServiceItemsCollection(getContext());
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
    public ServiceItemsCollection getServiceItemsCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getServiceItemsCollection(getContext(), view);
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
    public ServiceItemsCollection getServiceItemsCollection(String oql) throws BOSException
    {
        try {
            return getController().getServiceItemsCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}