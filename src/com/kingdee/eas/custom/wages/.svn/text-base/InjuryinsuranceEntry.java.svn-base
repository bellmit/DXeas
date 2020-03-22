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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class InjuryinsuranceEntry extends CoreBillEntryBase implements IInjuryinsuranceEntry
{
    public InjuryinsuranceEntry()
    {
        super();
        registerInterface(IInjuryinsuranceEntry.class, this);
    }
    public InjuryinsuranceEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IInjuryinsuranceEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AC88BCF7");
    }
    private InjuryinsuranceEntryController getController() throws BOSException
    {
        return (InjuryinsuranceEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public InjuryinsuranceEntryInfo getInjuryinsuranceEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInjuryinsuranceEntryInfo(getContext(), pk);
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
    public InjuryinsuranceEntryInfo getInjuryinsuranceEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInjuryinsuranceEntryInfo(getContext(), pk, selector);
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
    public InjuryinsuranceEntryInfo getInjuryinsuranceEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInjuryinsuranceEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InjuryinsuranceEntryCollection getInjuryinsuranceEntryCollection() throws BOSException
    {
        try {
            return getController().getInjuryinsuranceEntryCollection(getContext());
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
    public InjuryinsuranceEntryCollection getInjuryinsuranceEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInjuryinsuranceEntryCollection(getContext(), view);
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
    public InjuryinsuranceEntryCollection getInjuryinsuranceEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getInjuryinsuranceEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}