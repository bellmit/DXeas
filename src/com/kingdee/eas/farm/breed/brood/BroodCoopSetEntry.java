package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.breed.brood.app.*;
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

public class BroodCoopSetEntry extends CoreBillEntryBase implements IBroodCoopSetEntry
{
    public BroodCoopSetEntry()
    {
        super();
        registerInterface(IBroodCoopSetEntry.class, this);
    }
    public BroodCoopSetEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBroodCoopSetEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("58873B5D");
    }
    private BroodCoopSetEntryController getController() throws BOSException
    {
        return (BroodCoopSetEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BroodCoopSetEntryInfo getBroodCoopSetEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodCoopSetEntryInfo(getContext(), pk);
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
    public BroodCoopSetEntryInfo getBroodCoopSetEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodCoopSetEntryInfo(getContext(), pk, selector);
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
    public BroodCoopSetEntryInfo getBroodCoopSetEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodCoopSetEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BroodCoopSetEntryCollection getBroodCoopSetEntryCollection() throws BOSException
    {
        try {
            return getController().getBroodCoopSetEntryCollection(getContext());
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
    public BroodCoopSetEntryCollection getBroodCoopSetEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBroodCoopSetEntryCollection(getContext(), view);
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
    public BroodCoopSetEntryCollection getBroodCoopSetEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBroodCoopSetEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}