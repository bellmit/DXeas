package com.kingdee.eas.custom.salediscount;

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
import com.kingdee.eas.custom.salediscount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DiscountCustomerRel extends DataBase implements IDiscountCustomerRel
{
    public DiscountCustomerRel()
    {
        super();
        registerInterface(IDiscountCustomerRel.class, this);
    }
    public DiscountCustomerRel(Context ctx)
    {
        super(ctx);
        registerInterface(IDiscountCustomerRel.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F808C6FF");
    }
    private DiscountCustomerRelController getController() throws BOSException
    {
        return (DiscountCustomerRelController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DiscountCustomerRelInfo getDiscountCustomerRelInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountCustomerRelInfo(getContext(), pk);
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
    public DiscountCustomerRelInfo getDiscountCustomerRelInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountCustomerRelInfo(getContext(), pk, selector);
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
    public DiscountCustomerRelInfo getDiscountCustomerRelInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountCustomerRelInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DiscountCustomerRelCollection getDiscountCustomerRelCollection() throws BOSException
    {
        try {
            return getController().getDiscountCustomerRelCollection(getContext());
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
    public DiscountCustomerRelCollection getDiscountCustomerRelCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDiscountCustomerRelCollection(getContext(), view);
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
    public DiscountCustomerRelCollection getDiscountCustomerRelCollection(String oql) throws BOSException
    {
        try {
            return getController().getDiscountCustomerRelCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}