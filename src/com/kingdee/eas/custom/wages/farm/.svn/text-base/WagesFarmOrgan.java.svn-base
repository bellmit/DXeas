package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wages.farm.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WagesFarmOrgan extends DataBase implements IWagesFarmOrgan
{
    public WagesFarmOrgan()
    {
        super();
        registerInterface(IWagesFarmOrgan.class, this);
    }
    public WagesFarmOrgan(Context ctx)
    {
        super(ctx);
        registerInterface(IWagesFarmOrgan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4B36CA1A");
    }
    private WagesFarmOrganController getController() throws BOSException
    {
        return (WagesFarmOrganController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WagesFarmOrganInfo getWagesFarmOrganInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWagesFarmOrganInfo(getContext(), pk);
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
    public WagesFarmOrganInfo getWagesFarmOrganInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWagesFarmOrganInfo(getContext(), pk, selector);
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
    public WagesFarmOrganInfo getWagesFarmOrganInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWagesFarmOrganInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WagesFarmOrganCollection getWagesFarmOrganCollection() throws BOSException
    {
        try {
            return getController().getWagesFarmOrganCollection(getContext());
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
    public WagesFarmOrganCollection getWagesFarmOrganCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWagesFarmOrganCollection(getContext(), view);
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
    public WagesFarmOrganCollection getWagesFarmOrganCollection(String oql) throws BOSException
    {
        try {
            return getController().getWagesFarmOrganCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}