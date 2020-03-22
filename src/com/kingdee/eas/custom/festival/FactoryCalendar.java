package com.kingdee.eas.custom.festival;

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
import com.kingdee.eas.custom.festival.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FactoryCalendar extends CoreBillBase implements IFactoryCalendar
{
    public FactoryCalendar()
    {
        super();
        registerInterface(IFactoryCalendar.class, this);
    }
    public FactoryCalendar(Context ctx)
    {
        super(ctx);
        registerInterface(IFactoryCalendar.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("242A4AFD");
    }
    private FactoryCalendarController getController() throws BOSException
    {
        return (FactoryCalendarController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FactoryCalendarCollection getFactoryCalendarCollection() throws BOSException
    {
        try {
            return getController().getFactoryCalendarCollection(getContext());
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
    public FactoryCalendarCollection getFactoryCalendarCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFactoryCalendarCollection(getContext(), view);
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
    public FactoryCalendarCollection getFactoryCalendarCollection(String oql) throws BOSException
    {
        try {
            return getController().getFactoryCalendarCollection(getContext(), oql);
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
    public FactoryCalendarInfo getFactoryCalendarInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFactoryCalendarInfo(getContext(), pk);
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
    public FactoryCalendarInfo getFactoryCalendarInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFactoryCalendarInfo(getContext(), pk, selector);
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
    public FactoryCalendarInfo getFactoryCalendarInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFactoryCalendarInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}