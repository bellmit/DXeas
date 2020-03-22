package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.feedfactory.app.*;
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

public class FeedFactoryTruckPlanEntry extends CoreBillEntryBase implements IFeedFactoryTruckPlanEntry
{
    public FeedFactoryTruckPlanEntry()
    {
        super();
        registerInterface(IFeedFactoryTruckPlanEntry.class, this);
    }
    public FeedFactoryTruckPlanEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedFactoryTruckPlanEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("18476E34");
    }
    private FeedFactoryTruckPlanEntryController getController() throws BOSException
    {
        return (FeedFactoryTruckPlanEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FeedFactoryTruckPlanEntryInfo getFeedFactoryTruckPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryTruckPlanEntryInfo(getContext(), pk);
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
    public FeedFactoryTruckPlanEntryInfo getFeedFactoryTruckPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryTruckPlanEntryInfo(getContext(), pk, selector);
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
    public FeedFactoryTruckPlanEntryInfo getFeedFactoryTruckPlanEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryTruckPlanEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedFactoryTruckPlanEntryCollection getFeedFactoryTruckPlanEntryCollection() throws BOSException
    {
        try {
            return getController().getFeedFactoryTruckPlanEntryCollection(getContext());
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
    public FeedFactoryTruckPlanEntryCollection getFeedFactoryTruckPlanEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedFactoryTruckPlanEntryCollection(getContext(), view);
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
    public FeedFactoryTruckPlanEntryCollection getFeedFactoryTruckPlanEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedFactoryTruckPlanEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}