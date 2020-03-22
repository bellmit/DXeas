package com.kingdee.eas.custom.salediscount;

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
import com.kingdee.eas.custom.salediscount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CustomerBalanceEdit extends CoreBillBase implements ICustomerBalanceEdit
{
    public CustomerBalanceEdit()
    {
        super();
        registerInterface(ICustomerBalanceEdit.class, this);
    }
    public CustomerBalanceEdit(Context ctx)
    {
        super(ctx);
        registerInterface(ICustomerBalanceEdit.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("26B61F6D");
    }
    private CustomerBalanceEditController getController() throws BOSException
    {
        return (CustomerBalanceEditController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CustomerBalanceEditCollection getCustomerBalanceEditCollection() throws BOSException
    {
        try {
            return getController().getCustomerBalanceEditCollection(getContext());
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
    public CustomerBalanceEditCollection getCustomerBalanceEditCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCustomerBalanceEditCollection(getContext(), view);
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
    public CustomerBalanceEditCollection getCustomerBalanceEditCollection(String oql) throws BOSException
    {
        try {
            return getController().getCustomerBalanceEditCollection(getContext(), oql);
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
    public CustomerBalanceEditInfo getCustomerBalanceEditInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceEditInfo(getContext(), pk);
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
    public CustomerBalanceEditInfo getCustomerBalanceEditInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceEditInfo(getContext(), pk, selector);
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
    public CustomerBalanceEditInfo getCustomerBalanceEditInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerBalanceEditInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CustomerBalanceEditInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(CustomerBalanceEditInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}