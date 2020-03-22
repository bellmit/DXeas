package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.dayratecost.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DayRateInitBillEntry extends CoreBillEntryBase implements IDayRateInitBillEntry
{
    public DayRateInitBillEntry()
    {
        super();
        registerInterface(IDayRateInitBillEntry.class, this);
    }
    public DayRateInitBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDayRateInitBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("56685124");
    }
    private DayRateInitBillEntryController getController() throws BOSException
    {
        return (DayRateInitBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DayRateInitBillEntryInfo getDayRateInitBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateInitBillEntryInfo(getContext(), pk);
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
    public DayRateInitBillEntryInfo getDayRateInitBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateInitBillEntryInfo(getContext(), pk, selector);
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
    public DayRateInitBillEntryInfo getDayRateInitBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDayRateInitBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DayRateInitBillEntryCollection getDayRateInitBillEntryCollection() throws BOSException
    {
        try {
            return getController().getDayRateInitBillEntryCollection(getContext());
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
    public DayRateInitBillEntryCollection getDayRateInitBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDayRateInitBillEntryCollection(getContext(), view);
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
    public DayRateInitBillEntryCollection getDayRateInitBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDayRateInitBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}