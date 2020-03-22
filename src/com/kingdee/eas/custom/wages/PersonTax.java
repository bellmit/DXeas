package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PersonTax extends DataBase implements IPersonTax
{
    public PersonTax()
    {
        super();
        registerInterface(IPersonTax.class, this);
    }
    public PersonTax(Context ctx)
    {
        super(ctx);
        registerInterface(IPersonTax.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B7AF1D0E");
    }
    private PersonTaxController getController() throws BOSException
    {
        return (PersonTaxController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PersonTaxInfo getPersonTaxInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonTaxInfo(getContext(), pk);
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
    public PersonTaxInfo getPersonTaxInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonTaxInfo(getContext(), pk, selector);
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
    public PersonTaxInfo getPersonTaxInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPersonTaxInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PersonTaxCollection getPersonTaxCollection() throws BOSException
    {
        try {
            return getController().getPersonTaxCollection(getContext());
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
    public PersonTaxCollection getPersonTaxCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPersonTaxCollection(getContext(), view);
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
    public PersonTaxCollection getPersonTaxCollection(String oql) throws BOSException
    {
        try {
            return getController().getPersonTaxCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void approve(PersonTaxInfo model) throws BOSException
    {
        try {
            getController().approve(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unApprove(PersonTaxInfo model) throws BOSException
    {
        try {
            getController().unApprove(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}