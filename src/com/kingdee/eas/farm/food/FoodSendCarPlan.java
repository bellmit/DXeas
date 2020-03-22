package com.kingdee.eas.farm.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FoodSendCarPlan extends CoreBillBase implements IFoodSendCarPlan
{
    public FoodSendCarPlan()
    {
        super();
        registerInterface(IFoodSendCarPlan.class, this);
    }
    public FoodSendCarPlan(Context ctx)
    {
        super(ctx);
        registerInterface(IFoodSendCarPlan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8291834D");
    }
    private FoodSendCarPlanController getController() throws BOSException
    {
        return (FoodSendCarPlanController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FoodSendCarPlanCollection getFoodSendCarPlanCollection() throws BOSException
    {
        try {
            return getController().getFoodSendCarPlanCollection(getContext());
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
    public FoodSendCarPlanCollection getFoodSendCarPlanCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFoodSendCarPlanCollection(getContext(), view);
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
    public FoodSendCarPlanCollection getFoodSendCarPlanCollection(String oql) throws BOSException
    {
        try {
            return getController().getFoodSendCarPlanCollection(getContext(), oql);
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
    public FoodSendCarPlanInfo getFoodSendCarPlanInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFoodSendCarPlanInfo(getContext(), pk);
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
    public FoodSendCarPlanInfo getFoodSendCarPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFoodSendCarPlanInfo(getContext(), pk, selector);
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
    public FoodSendCarPlanInfo getFoodSendCarPlanInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFoodSendCarPlanInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FoodSendCarPlanInfo model) throws BOSException
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
    public void unAudit(FoodSendCarPlanInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}