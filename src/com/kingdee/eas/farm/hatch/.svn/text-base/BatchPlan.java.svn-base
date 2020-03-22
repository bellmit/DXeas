package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
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

public class BatchPlan extends CoreBillBase implements IBatchPlan
{
    public BatchPlan()
    {
        super();
        registerInterface(IBatchPlan.class, this);
    }
    public BatchPlan(Context ctx)
    {
        super(ctx);
        registerInterface(IBatchPlan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4282CB35");
    }
    private BatchPlanController getController() throws BOSException
    {
        return (BatchPlanController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BatchPlanCollection getBatchPlanCollection() throws BOSException
    {
        try {
            return getController().getBatchPlanCollection(getContext());
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
    public BatchPlanCollection getBatchPlanCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBatchPlanCollection(getContext(), view);
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
    public BatchPlanCollection getBatchPlanCollection(String oql) throws BOSException
    {
        try {
            return getController().getBatchPlanCollection(getContext(), oql);
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
    public BatchPlanInfo getBatchPlanInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchPlanInfo(getContext(), pk);
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
    public BatchPlanInfo getBatchPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchPlanInfo(getContext(), pk, selector);
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
    public BatchPlanInfo getBatchPlanInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBatchPlanInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BatchPlanInfo model) throws BOSException
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
    public void unAudit(BatchPlanInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取产蛋计划-User defined method
     *@param model model
     */
    public void getLayEggPlan(BatchPlanInfo model) throws BOSException
    {
        try {
            getController().getLayEggPlan(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}