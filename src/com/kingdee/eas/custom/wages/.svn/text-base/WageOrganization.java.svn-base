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

public class WageOrganization extends DataBase implements IWageOrganization
{
    public WageOrganization()
    {
        super();
        registerInterface(IWageOrganization.class, this);
    }
    public WageOrganization(Context ctx)
    {
        super(ctx);
        registerInterface(IWageOrganization.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("41E4A283");
    }
    private WageOrganizationController getController() throws BOSException
    {
        return (WageOrganizationController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WageOrganizationInfo getWageOrganizationInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWageOrganizationInfo(getContext(), pk);
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
    public WageOrganizationInfo getWageOrganizationInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWageOrganizationInfo(getContext(), pk, selector);
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
    public WageOrganizationInfo getWageOrganizationInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWageOrganizationInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WageOrganizationCollection getWageOrganizationCollection() throws BOSException
    {
        try {
            return getController().getWageOrganizationCollection(getContext());
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
    public WageOrganizationCollection getWageOrganizationCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWageOrganizationCollection(getContext(), view);
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
    public WageOrganizationCollection getWageOrganizationCollection(String oql) throws BOSException
    {
        try {
            return getController().getWageOrganizationCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}