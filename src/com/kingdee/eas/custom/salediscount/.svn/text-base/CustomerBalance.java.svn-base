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

public class CustomerBalance extends DataBase implements ICustomerBalance
{
    public CustomerBalance()
    {
        super();
        registerInterface(ICustomerBalance.class, this);
    }
    public CustomerBalance(Context ctx)
    {
        super(ctx);
        registerInterface(ICustomerBalance.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("79F456C3");
    }
    private CustomerBalanceController getController() throws BOSException
    {
        return (CustomerBalanceController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CustomerBalanceInfo getCustomerBalanceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceInfo(getContext(), pk);
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
    public CustomerBalanceInfo getCustomerBalanceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceInfo(getContext(), pk, selector);
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
    public CustomerBalanceInfo getCustomerBalanceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CustomerBalanceCollection getCustomerBalanceCollection() throws BOSException
    {
        try {
            return getController().getCustomerBalanceCollection(getContext());
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
    public CustomerBalanceCollection getCustomerBalanceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCustomerBalanceCollection(getContext(), view);
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
    public CustomerBalanceCollection getCustomerBalanceCollection(String oql) throws BOSException
    {
        try {
            return getController().getCustomerBalanceCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}