package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.dayratecost.app.*;
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

public class CostAllocationEntry extends CoreBillEntryBase implements ICostAllocationEntry
{
    public CostAllocationEntry()
    {
        super();
        registerInterface(ICostAllocationEntry.class, this);
    }
    public CostAllocationEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICostAllocationEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5F7CAA60");
    }
    private CostAllocationEntryController getController() throws BOSException
    {
        return (CostAllocationEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CostAllocationEntryInfo getCostAllocationEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCostAllocationEntryInfo(getContext(), pk);
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
    public CostAllocationEntryInfo getCostAllocationEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCostAllocationEntryInfo(getContext(), pk, selector);
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
    public CostAllocationEntryInfo getCostAllocationEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCostAllocationEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CostAllocationEntryCollection getCostAllocationEntryCollection() throws BOSException
    {
        try {
            return getController().getCostAllocationEntryCollection(getContext());
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
    public CostAllocationEntryCollection getCostAllocationEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCostAllocationEntryCollection(getContext(), view);
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
    public CostAllocationEntryCollection getCostAllocationEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCostAllocationEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}