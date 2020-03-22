package com.kingdee.eas.farm.breed.layegg;

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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.eas.farm.breed.layegg.app.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class LayEggPlanEntry extends CoreBillEntryBase implements ILayEggPlanEntry
{
    public LayEggPlanEntry()
    {
        super();
        registerInterface(ILayEggPlanEntry.class, this);
    }
    public LayEggPlanEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ILayEggPlanEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5C8F0BDB");
    }
    private LayEggPlanEntryController getController() throws BOSException
    {
        return (LayEggPlanEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public LayEggPlanEntryInfo getLayEggPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggPlanEntryInfo(getContext(), pk);
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
    public LayEggPlanEntryInfo getLayEggPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggPlanEntryInfo(getContext(), pk, selector);
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
    public LayEggPlanEntryInfo getLayEggPlanEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getLayEggPlanEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public LayEggPlanEntryCollection getLayEggPlanEntryCollection() throws BOSException
    {
        try {
            return getController().getLayEggPlanEntryCollection(getContext());
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
    public LayEggPlanEntryCollection getLayEggPlanEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getLayEggPlanEntryCollection(getContext(), view);
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
    public LayEggPlanEntryCollection getLayEggPlanEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getLayEggPlanEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}