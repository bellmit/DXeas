package com.kingdee.eas.custom.farmpolling;

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
import com.kingdee.eas.custom.farmpolling.app.*;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PollingRecordBillEntry extends CoreBillEntryBase implements IPollingRecordBillEntry
{
    public PollingRecordBillEntry()
    {
        super();
        registerInterface(IPollingRecordBillEntry.class, this);
    }
    public PollingRecordBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IPollingRecordBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F8A9115D");
    }
    private PollingRecordBillEntryController getController() throws BOSException
    {
        return (PollingRecordBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PollingRecordBillEntryInfo getPollingRecordBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPollingRecordBillEntryInfo(getContext(), pk);
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
    public PollingRecordBillEntryInfo getPollingRecordBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPollingRecordBillEntryInfo(getContext(), pk, selector);
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
    public PollingRecordBillEntryInfo getPollingRecordBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPollingRecordBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PollingRecordBillEntryCollection getPollingRecordBillEntryCollection() throws BOSException
    {
        try {
            return getController().getPollingRecordBillEntryCollection(getContext());
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
    public PollingRecordBillEntryCollection getPollingRecordBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPollingRecordBillEntryCollection(getContext(), view);
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
    public PollingRecordBillEntryCollection getPollingRecordBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPollingRecordBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}