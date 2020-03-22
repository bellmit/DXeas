package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.feedfactory.app.*;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FeedFactoryTruckPlan extends CoreBillBase implements IFeedFactoryTruckPlan
{
    public FeedFactoryTruckPlan()
    {
        super();
        registerInterface(IFeedFactoryTruckPlan.class, this);
    }
    public FeedFactoryTruckPlan(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedFactoryTruckPlan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F34F04DE");
    }
    private FeedFactoryTruckPlanController getController() throws BOSException
    {
        return (FeedFactoryTruckPlanController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedFactoryTruckPlanCollection getFeedFactoryTruckPlanCollection() throws BOSException
    {
        try {
            return getController().getFeedFactoryTruckPlanCollection(getContext());
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
    public FeedFactoryTruckPlanCollection getFeedFactoryTruckPlanCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedFactoryTruckPlanCollection(getContext(), view);
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
    public FeedFactoryTruckPlanCollection getFeedFactoryTruckPlanCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedFactoryTruckPlanCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FeedFactoryTruckPlanInfo getFeedFactoryTruckPlanInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryTruckPlanInfo(getContext(), pk);
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
    public FeedFactoryTruckPlanInfo getFeedFactoryTruckPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryTruckPlanInfo(getContext(), pk, selector);
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
    public FeedFactoryTruckPlanInfo getFeedFactoryTruckPlanInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFactoryTruckPlanInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查询要料计划-User defined method
     *@param model model
     */
    public void getFodderPlan(FeedFactoryTruckPlanInfo model) throws BOSException
    {
        try {
            getController().getFodderPlan(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成派车计划-User defined method
     *@param model model
     */
    public void generateTruckPlan(FeedFactoryTruckPlanInfo model) throws BOSException
    {
        try {
            getController().generateTruckPlan(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FeedFactoryTruckPlanInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(FeedFactoryTruckPlanInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}