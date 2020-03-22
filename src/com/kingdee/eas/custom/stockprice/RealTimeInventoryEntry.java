package com.kingdee.eas.custom.stockprice;

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
import com.kingdee.eas.custom.stockprice.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class RealTimeInventoryEntry extends CoreBillEntryBase implements IRealTimeInventoryEntry
{
    public RealTimeInventoryEntry()
    {
        super();
        registerInterface(IRealTimeInventoryEntry.class, this);
    }
    public RealTimeInventoryEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IRealTimeInventoryEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6EAC3B51");
    }
    private RealTimeInventoryEntryController getController() throws BOSException
    {
        return (RealTimeInventoryEntryController)getBizController();
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@return
     */
    public RealTimeInventoryEntryInfo getRealTimeInventoryEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRealTimeInventoryEntryInfo(getContext(), pk);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
     *@return
     */
    public RealTimeInventoryEntryInfo getRealTimeInventoryEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRealTimeInventoryEntryInfo(getContext(), pk, selector);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡֵ-System defined method
     *@param oql ȡֵ
     *@return
     */
    public RealTimeInventoryEntryInfo getRealTimeInventoryEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRealTimeInventoryEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@return
     */
    public RealTimeInventoryEntryCollection getRealTimeInventoryEntryCollection() throws BOSException
    {
        try {
            return getController().getRealTimeInventoryEntryCollection(getContext());
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param view ȡ����
     *@return
     */
    public RealTimeInventoryEntryCollection getRealTimeInventoryEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRealTimeInventoryEntryCollection(getContext(), view);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *ȡ����-System defined method
     *@param oql ȡ����
     *@return
     */
    public RealTimeInventoryEntryCollection getRealTimeInventoryEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getRealTimeInventoryEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}