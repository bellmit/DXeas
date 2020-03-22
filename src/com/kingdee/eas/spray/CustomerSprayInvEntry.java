package com.kingdee.eas.spray;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.spray.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CustomerSprayInvEntry extends CoreBillEntryBase implements ICustomerSprayInvEntry
{
    public CustomerSprayInvEntry()
    {
        super();
        registerInterface(ICustomerSprayInvEntry.class, this);
    }
    public CustomerSprayInvEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICustomerSprayInvEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("87D2997D");
    }
    private CustomerSprayInvEntryController getController() throws BOSException
    {
        return (CustomerSprayInvEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CustomerSprayInvEntryInfo getCustomerSprayInvEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerSprayInvEntryInfo(getContext(), pk);
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
    public CustomerSprayInvEntryInfo getCustomerSprayInvEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerSprayInvEntryInfo(getContext(), pk, selector);
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
    public CustomerSprayInvEntryInfo getCustomerSprayInvEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerSprayInvEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CustomerSprayInvEntryCollection getCustomerSprayInvEntryCollection() throws BOSException
    {
        try {
            return getController().getCustomerSprayInvEntryCollection(getContext());
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
    public CustomerSprayInvEntryCollection getCustomerSprayInvEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCustomerSprayInvEntryCollection(getContext(), view);
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
    public CustomerSprayInvEntryCollection getCustomerSprayInvEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCustomerSprayInvEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}