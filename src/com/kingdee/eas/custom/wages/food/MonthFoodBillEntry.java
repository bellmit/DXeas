package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.custom.wages.food.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MonthFoodBillEntry extends CoreBillEntryBase implements IMonthFoodBillEntry
{
    public MonthFoodBillEntry()
    {
        super();
        registerInterface(IMonthFoodBillEntry.class, this);
    }
    public MonthFoodBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IMonthFoodBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("08A1F3CF");
    }
    private MonthFoodBillEntryController getController() throws BOSException
    {
        return (MonthFoodBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MonthFoodBillEntryInfo getMonthFoodBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFoodBillEntryInfo(getContext(), pk);
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
    public MonthFoodBillEntryInfo getMonthFoodBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFoodBillEntryInfo(getContext(), pk, selector);
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
    public MonthFoodBillEntryInfo getMonthFoodBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthFoodBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MonthFoodBillEntryCollection getMonthFoodBillEntryCollection() throws BOSException
    {
        try {
            return getController().getMonthFoodBillEntryCollection(getContext());
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
    public MonthFoodBillEntryCollection getMonthFoodBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMonthFoodBillEntryCollection(getContext(), view);
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
    public MonthFoodBillEntryCollection getMonthFoodBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getMonthFoodBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}