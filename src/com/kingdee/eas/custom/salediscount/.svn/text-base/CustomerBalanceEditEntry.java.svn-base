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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.eas.custom.salediscount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CustomerBalanceEditEntry extends CoreBillEntryBase implements ICustomerBalanceEditEntry
{
    public CustomerBalanceEditEntry()
    {
        super();
        registerInterface(ICustomerBalanceEditEntry.class, this);
    }
    public CustomerBalanceEditEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICustomerBalanceEditEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3F459505");
    }
    private CustomerBalanceEditEntryController getController() throws BOSException
    {
        return (CustomerBalanceEditEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CustomerBalanceEditEntryInfo getCustomerBalanceEditEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceEditEntryInfo(getContext(), pk);
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
    public CustomerBalanceEditEntryInfo getCustomerBalanceEditEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceEditEntryInfo(getContext(), pk, selector);
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
    public CustomerBalanceEditEntryInfo getCustomerBalanceEditEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceEditEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CustomerBalanceEditEntryCollection getCustomerBalanceEditEntryCollection() throws BOSException
    {
        try {
            return getController().getCustomerBalanceEditEntryCollection(getContext());
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
    public CustomerBalanceEditEntryCollection getCustomerBalanceEditEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCustomerBalanceEditEntryCollection(getContext(), view);
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
    public CustomerBalanceEditEntryCollection getCustomerBalanceEditEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCustomerBalanceEditEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}