package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedBatchEditBillEntry extends CoreBillEntryBase implements IBreedBatchEditBillEntry
{
    public BreedBatchEditBillEntry()
    {
        super();
        registerInterface(IBreedBatchEditBillEntry.class, this);
    }
    public BreedBatchEditBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedBatchEditBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B040E6A1");
    }
    private BreedBatchEditBillEntryController getController() throws BOSException
    {
        return (BreedBatchEditBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BreedBatchEditBillEntryInfo getBreedBatchEditBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedBatchEditBillEntryInfo(getContext(), pk);
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
    public BreedBatchEditBillEntryInfo getBreedBatchEditBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedBatchEditBillEntryInfo(getContext(), pk, selector);
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
    public BreedBatchEditBillEntryInfo getBreedBatchEditBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedBatchEditBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedBatchEditBillEntryCollection getBreedBatchEditBillEntryCollection() throws BOSException
    {
        try {
            return getController().getBreedBatchEditBillEntryCollection(getContext());
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
    public BreedBatchEditBillEntryCollection getBreedBatchEditBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedBatchEditBillEntryCollection(getContext(), view);
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
    public BreedBatchEditBillEntryCollection getBreedBatchEditBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedBatchEditBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}