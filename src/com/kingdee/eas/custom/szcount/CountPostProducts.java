package com.kingdee.eas.custom.szcount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlDataBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.szcount.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CountPostProducts extends WlhlDataBase implements ICountPostProducts
{
    public CountPostProducts()
    {
        super();
        registerInterface(ICountPostProducts.class, this);
    }
    public CountPostProducts(Context ctx)
    {
        super(ctx);
        registerInterface(ICountPostProducts.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1E0202C8");
    }
    private CountPostProductsController getController() throws BOSException
    {
        return (CountPostProductsController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CountPostProductsInfo getCountPostProductsInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCountPostProductsInfo(getContext(), pk);
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
    public CountPostProductsInfo getCountPostProductsInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCountPostProductsInfo(getContext(), pk, selector);
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
    public CountPostProductsInfo getCountPostProductsInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCountPostProductsInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CountPostProductsCollection getCountPostProductsCollection() throws BOSException
    {
        try {
            return getController().getCountPostProductsCollection(getContext());
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
    public CountPostProductsCollection getCountPostProductsCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCountPostProductsCollection(getContext(), view);
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
    public CountPostProductsCollection getCountPostProductsCollection(String oql) throws BOSException
    {
        try {
            return getController().getCountPostProductsCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}