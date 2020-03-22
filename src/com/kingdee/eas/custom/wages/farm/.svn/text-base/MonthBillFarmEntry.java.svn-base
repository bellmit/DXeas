package com.kingdee.eas.custom.wages.farm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.wages.farm.app.*;
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

public class MonthBillFarmEntry extends CoreBillEntryBase implements IMonthBillFarmEntry
{
    public MonthBillFarmEntry()
    {
        super();
        registerInterface(IMonthBillFarmEntry.class, this);
    }
    public MonthBillFarmEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IMonthBillFarmEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A3E85C9F");
    }
    private MonthBillFarmEntryController getController() throws BOSException
    {
        return (MonthBillFarmEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MonthBillFarmEntryInfo getMonthBillFarmEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthBillFarmEntryInfo(getContext(), pk);
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
    public MonthBillFarmEntryInfo getMonthBillFarmEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthBillFarmEntryInfo(getContext(), pk, selector);
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
    public MonthBillFarmEntryInfo getMonthBillFarmEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMonthBillFarmEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MonthBillFarmEntryCollection getMonthBillFarmEntryCollection() throws BOSException
    {
        try {
            return getController().getMonthBillFarmEntryCollection(getContext());
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
    public MonthBillFarmEntryCollection getMonthBillFarmEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMonthBillFarmEntryCollection(getContext(), view);
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
    public MonthBillFarmEntryCollection getMonthBillFarmEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getMonthBillFarmEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}