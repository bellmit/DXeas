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

public class Injuryinsurance extends CoreBillBase implements IInjuryinsurance
{
    public Injuryinsurance()
    {
        super();
        registerInterface(IInjuryinsurance.class, this);
    }
    public Injuryinsurance(Context ctx)
    {
        super(ctx);
        registerInterface(IInjuryinsurance.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7C52483B");
    }
    private InjuryinsuranceController getController() throws BOSException
    {
        return (InjuryinsuranceController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InjuryinsuranceCollection getInjuryinsuranceCollection() throws BOSException
    {
        try {
            return getController().getInjuryinsuranceCollection(getContext());
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
    public InjuryinsuranceCollection getInjuryinsuranceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInjuryinsuranceCollection(getContext(), view);
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
    public InjuryinsuranceCollection getInjuryinsuranceCollection(String oql) throws BOSException
    {
        try {
            return getController().getInjuryinsuranceCollection(getContext(), oql);
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
    public InjuryinsuranceInfo getInjuryinsuranceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInjuryinsuranceInfo(getContext(), pk);
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
    public InjuryinsuranceInfo getInjuryinsuranceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInjuryinsuranceInfo(getContext(), pk, selector);
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
    public InjuryinsuranceInfo getInjuryinsuranceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInjuryinsuranceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(InjuryinsuranceInfo model) throws BOSException
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
    public void unaudit(InjuryinsuranceInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}