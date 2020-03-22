package com.kingdee.eas.custom.festival;

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
import com.kingdee.eas.custom.festival.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FactoryCalendarEntry extends CoreBillEntryBase implements IFactoryCalendarEntry
{
    public FactoryCalendarEntry()
    {
        super();
        registerInterface(IFactoryCalendarEntry.class, this);
    }
    public FactoryCalendarEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFactoryCalendarEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E06E2375");
    }
    private FactoryCalendarEntryController getController() throws BOSException
    {
        return (FactoryCalendarEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FactoryCalendarEntryInfo getFactoryCalendarEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFactoryCalendarEntryInfo(getContext(), pk);
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
    public FactoryCalendarEntryInfo getFactoryCalendarEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFactoryCalendarEntryInfo(getContext(), pk, selector);
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
    public FactoryCalendarEntryInfo getFactoryCalendarEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFactoryCalendarEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FactoryCalendarEntryCollection getFactoryCalendarEntryCollection() throws BOSException
    {
        try {
            return getController().getFactoryCalendarEntryCollection(getContext());
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
    public FactoryCalendarEntryCollection getFactoryCalendarEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFactoryCalendarEntryCollection(getContext(), view);
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
    public FactoryCalendarEntryCollection getFactoryCalendarEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFactoryCalendarEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}