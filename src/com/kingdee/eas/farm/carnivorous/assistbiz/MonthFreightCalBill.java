package com.kingdee.eas.farm.carnivorous.assistbiz;

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
import com.kingdee.eas.farm.carnivorous.assistbiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MonthFreightCalBill extends CoreBillBase implements IMonthFreightCalBill
{
    public MonthFreightCalBill()
    {
        super();
        registerInterface(IMonthFreightCalBill.class, this);
    }
    public MonthFreightCalBill(Context ctx)
    {
        super(ctx);
        registerInterface(IMonthFreightCalBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A2E4E9C3");
    }
    private MonthFreightCalBillController getController() throws BOSException
    {
        return (MonthFreightCalBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MonthFreightCalBillCollection getMonthFreightCalBillCollection() throws BOSException
    {
        try {
            return getController().getMonthFreightCalBillCollection(getContext());
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
    public MonthFreightCalBillCollection getMonthFreightCalBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMonthFreightCalBillCollection(getContext(), view);
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
    public MonthFreightCalBillCollection getMonthFreightCalBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getMonthFreightCalBillCollection(getContext(), oql);
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
    public MonthFreightCalBillInfo getMonthFreightCalBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFreightCalBillInfo(getContext(), pk);
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
    public MonthFreightCalBillInfo getMonthFreightCalBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFreightCalBillInfo(getContext(), pk, selector);
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
    public MonthFreightCalBillInfo getMonthFreightCalBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFreightCalBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行核算-User defined method
     *@param model model
     */
    public void monthCal(MonthFreightCalBillInfo model) throws BOSException, EASBizException
    {
        try {
            getController().monthCal(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}