package com.kingdee.eas.farm.carnivorous.recyclebiz;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.farm.carnivorous.recyclebiz.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CKCostAllocateBillEntry extends CoreBillEntryBase implements ICKCostAllocateBillEntry
{
    public CKCostAllocateBillEntry()
    {
        super();
        registerInterface(ICKCostAllocateBillEntry.class, this);
    }
    public CKCostAllocateBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICKCostAllocateBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DCB4D8FC");
    }
    private CKCostAllocateBillEntryController getController() throws BOSException
    {
        return (CKCostAllocateBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CKCostAllocateBillEntryInfo getCKCostAllocateBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCKCostAllocateBillEntryInfo(getContext(), pk);
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
    public CKCostAllocateBillEntryInfo getCKCostAllocateBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCKCostAllocateBillEntryInfo(getContext(), pk, selector);
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
    public CKCostAllocateBillEntryInfo getCKCostAllocateBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCKCostAllocateBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CKCostAllocateBillEntryCollection getCKCostAllocateBillEntryCollection() throws BOSException
    {
        try {
            return getController().getCKCostAllocateBillEntryCollection(getContext());
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
    public CKCostAllocateBillEntryCollection getCKCostAllocateBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCKCostAllocateBillEntryCollection(getContext(), view);
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
    public CKCostAllocateBillEntryCollection getCKCostAllocateBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCKCostAllocateBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}