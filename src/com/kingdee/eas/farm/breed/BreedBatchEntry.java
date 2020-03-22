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

public class BreedBatchEntry extends CoreBillEntryBase implements IBreedBatchEntry
{
    public BreedBatchEntry()
    {
        super();
        registerInterface(IBreedBatchEntry.class, this);
    }
    public BreedBatchEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedBatchEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AE939152");
    }
    private BreedBatchEntryController getController() throws BOSException
    {
        return (BreedBatchEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BreedBatchEntryInfo getBreedBatchEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedBatchEntryInfo(getContext(), pk);
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
    public BreedBatchEntryInfo getBreedBatchEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedBatchEntryInfo(getContext(), pk, selector);
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
    public BreedBatchEntryInfo getBreedBatchEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedBatchEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedBatchEntryCollection getBreedBatchEntryCollection() throws BOSException
    {
        try {
            return getController().getBreedBatchEntryCollection(getContext());
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
    public BreedBatchEntryCollection getBreedBatchEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedBatchEntryCollection(getContext(), view);
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
    public BreedBatchEntryCollection getBreedBatchEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedBatchEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}