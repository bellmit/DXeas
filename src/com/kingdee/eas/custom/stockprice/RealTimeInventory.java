package com.kingdee.eas.custom.stockprice;

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
import com.kingdee.eas.custom.stockprice.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class RealTimeInventory extends CoreBillBase implements IRealTimeInventory
{
    public RealTimeInventory()
    {
        super();
        registerInterface(IRealTimeInventory.class, this);
    }
    public RealTimeInventory(Context ctx)
    {
        super(ctx);
        registerInterface(IRealTimeInventory.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8D7BB9A1");
    }
    private RealTimeInventoryController getController() throws BOSException
    {
        return (RealTimeInventoryController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public RealTimeInventoryCollection getRealTimeInventoryCollection() throws BOSException
    {
        try {
            return getController().getRealTimeInventoryCollection(getContext());
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
    public RealTimeInventoryCollection getRealTimeInventoryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRealTimeInventoryCollection(getContext(), view);
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
    public RealTimeInventoryCollection getRealTimeInventoryCollection(String oql) throws BOSException
    {
        try {
            return getController().getRealTimeInventoryCollection(getContext(), oql);
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
    public RealTimeInventoryInfo getRealTimeInventoryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRealTimeInventoryInfo(getContext(), pk);
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
    public RealTimeInventoryInfo getRealTimeInventoryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRealTimeInventoryInfo(getContext(), pk, selector);
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
    public RealTimeInventoryInfo getRealTimeInventoryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRealTimeInventoryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}