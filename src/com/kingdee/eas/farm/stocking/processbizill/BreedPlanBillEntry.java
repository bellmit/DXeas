package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BreedPlanBillEntry extends CoreBillEntryBase implements IBreedPlanBillEntry
{
    public BreedPlanBillEntry()
    {
        super();
        registerInterface(IBreedPlanBillEntry.class, this);
    }
    public BreedPlanBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBreedPlanBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A8145293");
    }
    private BreedPlanBillEntryController getController() throws BOSException
    {
        return (BreedPlanBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BreedPlanBillEntryInfo getBreedPlanBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedPlanBillEntryInfo(getContext(), pk);
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
    public BreedPlanBillEntryInfo getBreedPlanBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedPlanBillEntryInfo(getContext(), pk, selector);
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
    public BreedPlanBillEntryInfo getBreedPlanBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBreedPlanBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BreedPlanBillEntryCollection getBreedPlanBillEntryCollection() throws BOSException
    {
        try {
            return getController().getBreedPlanBillEntryCollection(getContext());
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
    public BreedPlanBillEntryCollection getBreedPlanBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBreedPlanBillEntryCollection(getContext(), view);
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
    public BreedPlanBillEntryCollection getBreedPlanBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBreedPlanBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}