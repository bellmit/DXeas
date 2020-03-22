package com.kingdee.eas.custom.wages;

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
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EmploySecurity extends CoreBillBase implements IEmploySecurity
{
    public EmploySecurity()
    {
        super();
        registerInterface(IEmploySecurity.class, this);
    }
    public EmploySecurity(Context ctx)
    {
        super(ctx);
        registerInterface(IEmploySecurity.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9D8420F6");
    }
    private EmploySecurityController getController() throws BOSException
    {
        return (EmploySecurityController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EmploySecurityCollection getEmploySecurityCollection() throws BOSException
    {
        try {
            return getController().getEmploySecurityCollection(getContext());
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
    public EmploySecurityCollection getEmploySecurityCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEmploySecurityCollection(getContext(), view);
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
    public EmploySecurityCollection getEmploySecurityCollection(String oql) throws BOSException
    {
        try {
            return getController().getEmploySecurityCollection(getContext(), oql);
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
    public EmploySecurityInfo getEmploySecurityInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEmploySecurityInfo(getContext(), pk);
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
    public EmploySecurityInfo getEmploySecurityInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEmploySecurityInfo(getContext(), pk, selector);
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
    public EmploySecurityInfo getEmploySecurityInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEmploySecurityInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(EmploySecurityInfo model) throws BOSException
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
    public void unaudit(EmploySecurityInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}