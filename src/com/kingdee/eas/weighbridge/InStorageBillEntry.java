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

public class InStorageBillEntry extends CoreBillEntryBase implements IInStorageBillEntry
{
    public InStorageBillEntry()
    {
        super();
        registerInterface(IInStorageBillEntry.class, this);
    }
    public InStorageBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IInStorageBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B759C6D0");
    }
    private InStorageBillEntryController getController() throws BOSException
    {
        return (InStorageBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public InStorageBillEntryInfo getInStorageBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInStorageBillEntryInfo(getContext(), pk);
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
    public InStorageBillEntryInfo getInStorageBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInStorageBillEntryInfo(getContext(), pk, selector);
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
    public InStorageBillEntryInfo getInStorageBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInStorageBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InStorageBillEntryCollection getInStorageBillEntryCollection() throws BOSException
    {
        try {
            return getController().getInStorageBillEntryCollection(getContext());
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
    public InStorageBillEntryCollection getInStorageBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInStorageBillEntryCollection(getContext(), view);
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
    public InStorageBillEntryCollection getInStorageBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getInStorageBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}