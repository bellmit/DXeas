package com.kingdee.eas.farm.breed.freedplan;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.farm.breed.freedplan.app.*;
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

public class BreedFodderPlanEntry extends CoreBillEntryBase implements IBreedFodderPlanEntry
{
    public BreedFodderPlanEntry()
    {
        super();
        registerInterface(IBreedFodderPlanEntry.class, this);
    }
    public BreedFodderPlanEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedFodderPlanEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3824A4A6");
    }
    private BreedFodderPlanEntryController getController() throws BOSException
    {
        return (BreedFodderPlanEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BreedFodderPlanEntryInfo getBreedFodderPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedFodderPlanEntryInfo(getContext(), pk);
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
    public BreedFodderPlanEntryInfo getBreedFodderPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedFodderPlanEntryInfo(getContext(), pk, selector);
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
    public BreedFodderPlanEntryInfo getBreedFodderPlanEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedFodderPlanEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedFodderPlanEntryCollection getBreedFodderPlanEntryCollection() throws BOSException
    {
        try {
            return getController().getBreedFodderPlanEntryCollection(getContext());
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
    public BreedFodderPlanEntryCollection getBreedFodderPlanEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedFodderPlanEntryCollection(getContext(), view);
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
    public BreedFodderPlanEntryCollection getBreedFodderPlanEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedFodderPlanEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}