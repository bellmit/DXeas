package com.kingdee.eas.custom.wages.food;

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
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.wages.food.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MonthFoodBill extends CoreBillBase implements IMonthFoodBill
{
    public MonthFoodBill()
    {
        super();
        registerInterface(IMonthFoodBill.class, this);
    }
    public MonthFoodBill(Context ctx)
    {
        super(ctx);
        registerInterface(IMonthFoodBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D6D82A63");
    }
    private MonthFoodBillController getController() throws BOSException
    {
        return (MonthFoodBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MonthFoodBillCollection getMonthFoodBillCollection() throws BOSException
    {
        try {
            return getController().getMonthFoodBillCollection(getContext());
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
    public MonthFoodBillCollection getMonthFoodBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMonthFoodBillCollection(getContext(), view);
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
    public MonthFoodBillCollection getMonthFoodBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getMonthFoodBillCollection(getContext(), oql);
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
    public MonthFoodBillInfo getMonthFoodBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFoodBillInfo(getContext(), pk);
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
    public MonthFoodBillInfo getMonthFoodBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFoodBillInfo(getContext(), pk, selector);
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
    public MonthFoodBillInfo getMonthFoodBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFoodBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(MonthFoodBillInfo model) throws BOSException
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
    public void unaudit(MonthFoodBillInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取员工-User defined method
     *@param model model
     */
    public void getPerson(MonthFoodBillInfo model) throws BOSException
    {
        try {
            getController().getPerson(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *工资计算-User defined method
     *@param model model
     */
    public void wagecalculation(MonthFoodBillInfo model) throws BOSException
    {
        try {
            getController().wagecalculation(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}