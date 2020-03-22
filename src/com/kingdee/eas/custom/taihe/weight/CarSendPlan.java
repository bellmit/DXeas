package com.kingdee.eas.custom.taihe.weight;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.taihe.weight.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CarSendPlan extends WlhlBillBase implements ICarSendPlan
{
    public CarSendPlan()
    {
        super();
        registerInterface(ICarSendPlan.class, this);
    }
    public CarSendPlan(Context ctx)
    {
        super(ctx);
        registerInterface(ICarSendPlan.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("106F56CF");
    }
    private CarSendPlanController getController() throws BOSException
    {
        return (CarSendPlanController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CarSendPlanCollection getCarSendPlanCollection() throws BOSException
    {
        try {
            return getController().getCarSendPlanCollection(getContext());
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
    public CarSendPlanCollection getCarSendPlanCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCarSendPlanCollection(getContext(), view);
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
    public CarSendPlanCollection getCarSendPlanCollection(String oql) throws BOSException
    {
        try {
            return getController().getCarSendPlanCollection(getContext(), oql);
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
    public CarSendPlanInfo getCarSendPlanInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCarSendPlanInfo(getContext(), pk);
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
    public CarSendPlanInfo getCarSendPlanInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCarSendPlanInfo(getContext(), pk, selector);
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
    public CarSendPlanInfo getCarSendPlanInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCarSendPlanInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}