package com.kingdee.eas.custom.shr;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.shr.app.*;
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

public class RecordBusChangeEntry extends CoreBillEntryBase implements IRecordBusChangeEntry
{
    public RecordBusChangeEntry()
    {
        super();
        registerInterface(IRecordBusChangeEntry.class, this);
    }
    public RecordBusChangeEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IRecordBusChangeEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("08A4C489");
    }
    private RecordBusChangeEntryController getController() throws BOSException
    {
        return (RecordBusChangeEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public RecordBusChangeEntryInfo getRecordBusChangeEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRecordBusChangeEntryInfo(getContext(), pk);
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
    public RecordBusChangeEntryInfo getRecordBusChangeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRecordBusChangeEntryInfo(getContext(), pk, selector);
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
    public RecordBusChangeEntryInfo getRecordBusChangeEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRecordBusChangeEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public RecordBusChangeEntryCollection getRecordBusChangeEntryCollection() throws BOSException
    {
        try {
            return getController().getRecordBusChangeEntryCollection(getContext());
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
    public RecordBusChangeEntryCollection getRecordBusChangeEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRecordBusChangeEntryCollection(getContext(), view);
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
    public RecordBusChangeEntryCollection getRecordBusChangeEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getRecordBusChangeEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}