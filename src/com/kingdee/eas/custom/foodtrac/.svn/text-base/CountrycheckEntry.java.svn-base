package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.foodtrac.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CountrycheckEntry extends CoreBillEntryBase implements ICountrycheckEntry
{
    public CountrycheckEntry()
    {
        super();
        registerInterface(ICountrycheckEntry.class, this);
    }
    public CountrycheckEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICountrycheckEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D175BE3B");
    }
    private CountrycheckEntryController getController() throws BOSException
    {
        return (CountrycheckEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CountrycheckEntryInfo getCountrycheckEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCountrycheckEntryInfo(getContext(), pk);
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
    public CountrycheckEntryInfo getCountrycheckEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCountrycheckEntryInfo(getContext(), pk, selector);
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
    public CountrycheckEntryInfo getCountrycheckEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCountrycheckEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CountrycheckEntryCollection getCountrycheckEntryCollection() throws BOSException
    {
        try {
            return getController().getCountrycheckEntryCollection(getContext());
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
    public CountrycheckEntryCollection getCountrycheckEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCountrycheckEntryCollection(getContext(), view);
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
    public CountrycheckEntryCollection getCountrycheckEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCountrycheckEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}