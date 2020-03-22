package com.kingdee.eas.farm.stocking.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.eas.farm.stocking.hatch.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class InventoryEntry extends CoreBillEntryBase implements IInventoryEntry
{
    public InventoryEntry()
    {
        super();
        registerInterface(IInventoryEntry.class, this);
    }
    public InventoryEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IInventoryEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("23B59AE0");
    }
    private InventoryEntryController getController() throws BOSException
    {
        return (InventoryEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public InventoryEntryInfo getInventoryEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInventoryEntryInfo(getContext(), pk);
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
    public InventoryEntryInfo getInventoryEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInventoryEntryInfo(getContext(), pk, selector);
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
    public InventoryEntryInfo getInventoryEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInventoryEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InventoryEntryCollection getInventoryEntryCollection() throws BOSException
    {
        try {
            return getController().getInventoryEntryCollection(getContext());
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
    public InventoryEntryCollection getInventoryEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInventoryEntryCollection(getContext(), view);
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
    public InventoryEntryCollection getInventoryEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getInventoryEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}