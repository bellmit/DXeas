package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
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

public class BatchPlanEntry extends CoreBillEntryBase implements IBatchPlanEntry
{
    public BatchPlanEntry()
    {
        super();
        registerInterface(IBatchPlanEntry.class, this);
    }
    public BatchPlanEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBatchPlanEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C4F5063D");
    }
    private BatchPlanEntryController getController() throws BOSException
    {
        return (BatchPlanEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BatchPlanEntryInfo getBatchPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchPlanEntryInfo(getContext(), pk);
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
    public BatchPlanEntryInfo getBatchPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchPlanEntryInfo(getContext(), pk, selector);
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
    public BatchPlanEntryInfo getBatchPlanEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchPlanEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BatchPlanEntryCollection getBatchPlanEntryCollection() throws BOSException
    {
        try {
            return getController().getBatchPlanEntryCollection(getContext());
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
    public BatchPlanEntryCollection getBatchPlanEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBatchPlanEntryCollection(getContext(), view);
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
    public BatchPlanEntryCollection getBatchPlanEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBatchPlanEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}