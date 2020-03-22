package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.wlhlcomm.function.app.*;
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

public class BillUpdateLogEntry extends CoreBillEntryBase implements IBillUpdateLogEntry
{
    public BillUpdateLogEntry()
    {
        super();
        registerInterface(IBillUpdateLogEntry.class, this);
    }
    public BillUpdateLogEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IBillUpdateLogEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9DE738BD");
    }
    private BillUpdateLogEntryController getController() throws BOSException
    {
        return (BillUpdateLogEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BillUpdateLogEntryInfo getBillUpdateLogEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBillUpdateLogEntryInfo(getContext(), pk);
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
    public BillUpdateLogEntryInfo getBillUpdateLogEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBillUpdateLogEntryInfo(getContext(), pk, selector);
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
    public BillUpdateLogEntryInfo getBillUpdateLogEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBillUpdateLogEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BillUpdateLogEntryCollection getBillUpdateLogEntryCollection() throws BOSException
    {
        try {
            return getController().getBillUpdateLogEntryCollection(getContext());
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
    public BillUpdateLogEntryCollection getBillUpdateLogEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBillUpdateLogEntryCollection(getContext(), view);
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
    public BillUpdateLogEntryCollection getBillUpdateLogEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getBillUpdateLogEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}