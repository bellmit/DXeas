package com.kingdee.eas.weighbridge;

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
import com.kingdee.eas.weighbridge.app.*;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class OtherStorageBillEntry extends CoreBillEntryBase implements IOtherStorageBillEntry
{
    public OtherStorageBillEntry()
    {
        super();
        registerInterface(IOtherStorageBillEntry.class, this);
    }
    public OtherStorageBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IOtherStorageBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("299EDAA5");
    }
    private OtherStorageBillEntryController getController() throws BOSException
    {
        return (OtherStorageBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public OtherStorageBillEntryInfo getOtherStorageBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherStorageBillEntryInfo(getContext(), pk);
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
    public OtherStorageBillEntryInfo getOtherStorageBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherStorageBillEntryInfo(getContext(), pk, selector);
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
    public OtherStorageBillEntryInfo getOtherStorageBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOtherStorageBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OtherStorageBillEntryCollection getOtherStorageBillEntryCollection() throws BOSException
    {
        try {
            return getController().getOtherStorageBillEntryCollection(getContext());
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
    public OtherStorageBillEntryCollection getOtherStorageBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOtherStorageBillEntryCollection(getContext(), view);
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
    public OtherStorageBillEntryCollection getOtherStorageBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getOtherStorageBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}