package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wages.farm.app.*;
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

public class MonthBillFarm extends CoreBillBase implements IMonthBillFarm
{
    public MonthBillFarm()
    {
        super();
        registerInterface(IMonthBillFarm.class, this);
    }
    public MonthBillFarm(Context ctx)
    {
        super(ctx);
        registerInterface(IMonthBillFarm.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("36C77F93");
    }
    private MonthBillFarmController getController() throws BOSException
    {
        return (MonthBillFarmController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MonthBillFarmCollection getMonthBillFarmCollection() throws BOSException
    {
        try {
            return getController().getMonthBillFarmCollection(getContext());
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
    public MonthBillFarmCollection getMonthBillFarmCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMonthBillFarmCollection(getContext(), view);
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
    public MonthBillFarmCollection getMonthBillFarmCollection(String oql) throws BOSException
    {
        try {
            return getController().getMonthBillFarmCollection(getContext(), oql);
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
    public MonthBillFarmInfo getMonthBillFarmInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthBillFarmInfo(getContext(), pk);
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
    public MonthBillFarmInfo getMonthBillFarmInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthBillFarmInfo(getContext(), pk, selector);
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
    public MonthBillFarmInfo getMonthBillFarmInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthBillFarmInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(MonthBillFarmInfo model) throws BOSException
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
    public void unaudit(MonthBillFarmInfo model) throws BOSException
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
    public void getPerson(MonthBillFarmInfo model) throws BOSException
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
    public void wagecalculation(MonthBillFarmInfo model) throws BOSException
    {
        try {
            getController().wagecalculation(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}