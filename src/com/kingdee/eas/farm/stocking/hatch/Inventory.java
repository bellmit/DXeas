package com.kingdee.eas.farm.stocking.hatch;

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
import com.kingdee.eas.farm.stocking.hatch.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class Inventory extends CoreBillBase implements IInventory
{
    public Inventory()
    {
        super();
        registerInterface(IInventory.class, this);
    }
    public Inventory(Context ctx)
    {
        super(ctx);
        registerInterface(IInventory.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("224A9CB2");
    }
    private InventoryController getController() throws BOSException
    {
        return (InventoryController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InventoryCollection getInventoryCollection() throws BOSException
    {
        try {
            return getController().getInventoryCollection(getContext());
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
    public InventoryCollection getInventoryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInventoryCollection(getContext(), view);
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
    public InventoryCollection getInventoryCollection(String oql) throws BOSException
    {
        try {
            return getController().getInventoryCollection(getContext(), oql);
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
    public InventoryInfo getInventoryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInventoryInfo(getContext(), pk);
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
    public InventoryInfo getInventoryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInventoryInfo(getContext(), pk, selector);
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
    public InventoryInfo getInventoryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInventoryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}