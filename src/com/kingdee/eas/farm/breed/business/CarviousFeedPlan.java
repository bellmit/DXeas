package com.kingdee.eas.farm.breed.business;

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
import com.kingdee.eas.farm.breed.business.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CarviousFeedPlan extends CoreBillBase implements ICarviousFeedPlan
{
    public CarviousFeedPlan()
    {
        super();
        registerInterface(ICarviousFeedPlan.class, this);
    }
    public CarviousFeedPlan(Context ctx)
    {
        super(ctx);
        registerInterface(ICarviousFeedPlan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C6D0BFBB");
    }
    private CarviousFeedPlanController getController() throws BOSException
    {
        return (CarviousFeedPlanController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CarviousFeedPlanCollection getCarviousFeedPlanCollection() throws BOSException
    {
        try {
            return getController().getCarviousFeedPlanCollection(getContext());
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
    public CarviousFeedPlanCollection getCarviousFeedPlanCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarviousFeedPlanCollection(getContext(), view);
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
    public CarviousFeedPlanCollection getCarviousFeedPlanCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarviousFeedPlanCollection(getContext(), oql);
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
    public CarviousFeedPlanInfo getCarviousFeedPlanInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarviousFeedPlanInfo(getContext(), pk);
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
    public CarviousFeedPlanInfo getCarviousFeedPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarviousFeedPlanInfo(getContext(), pk, selector);
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
    public CarviousFeedPlanInfo getCarviousFeedPlanInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarviousFeedPlanInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(CarviousFeedPlanInfo model) throws BOSException, EASBizException
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
    public void unAudit(CarviousFeedPlanInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}