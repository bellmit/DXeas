package com.kingdee.eas.spray;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.spray.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CustomerSprayInv extends CoreBillBase implements ICustomerSprayInv
{
    public CustomerSprayInv()
    {
        super();
        registerInterface(ICustomerSprayInv.class, this);
    }
    public CustomerSprayInv(Context ctx)
    {
        super(ctx);
        registerInterface(ICustomerSprayInv.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FDC62FF5");
    }
    private CustomerSprayInvController getController() throws BOSException
    {
        return (CustomerSprayInvController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CustomerSprayInvCollection getCustomerSprayInvCollection() throws BOSException
    {
        try {
            return getController().getCustomerSprayInvCollection(getContext());
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
    public CustomerSprayInvCollection getCustomerSprayInvCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCustomerSprayInvCollection(getContext(), view);
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
    public CustomerSprayInvCollection getCustomerSprayInvCollection(String oql) throws BOSException
    {
        try {
            return getController().getCustomerSprayInvCollection(getContext(), oql);
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
    public CustomerSprayInvInfo getCustomerSprayInvInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerSprayInvInfo(getContext(), pk);
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
    public CustomerSprayInvInfo getCustomerSprayInvInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerSprayInvInfo(getContext(), pk, selector);
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
    public CustomerSprayInvInfo getCustomerSprayInvInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCustomerSprayInvInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}