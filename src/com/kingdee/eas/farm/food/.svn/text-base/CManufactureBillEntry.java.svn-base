package com.kingdee.eas.farm.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.scm.im.inv.InvBillBaseEntry;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.scm.im.inv.IInvBillBaseEntry;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CManufactureBillEntry extends InvBillBaseEntry implements ICManufactureBillEntry
{
    public CManufactureBillEntry()
    {
        super();
        registerInterface(ICManufactureBillEntry.class, this);
    }
    public CManufactureBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICManufactureBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7FE40B83");
    }
    private CManufactureBillEntryController getController() throws BOSException
    {
        return (CManufactureBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CManufactureBillEntryInfo getCManufactureBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCManufactureBillEntryInfo(getContext(), pk);
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
    public CManufactureBillEntryInfo getCManufactureBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCManufactureBillEntryInfo(getContext(), pk, selector);
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
    public CManufactureBillEntryInfo getCManufactureBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCManufactureBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CManufactureBillEntryCollection getCManufactureBillEntryCollection() throws BOSException
    {
        try {
            return getController().getCManufactureBillEntryCollection(getContext());
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
    public CManufactureBillEntryCollection getCManufactureBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCManufactureBillEntryCollection(getContext(), view);
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
    public CManufactureBillEntryCollection getCManufactureBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCManufactureBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}