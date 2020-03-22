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

public class OutStorageBillEntry extends CoreBillEntryBase implements IOutStorageBillEntry
{
    public OutStorageBillEntry()
    {
        super();
        registerInterface(IOutStorageBillEntry.class, this);
    }
    public OutStorageBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IOutStorageBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7E37CC23");
    }
    private OutStorageBillEntryController getController() throws BOSException
    {
        return (OutStorageBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public OutStorageBillEntryInfo getOutStorageBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getOutStorageBillEntryInfo(getContext(), pk);
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
    public OutStorageBillEntryInfo getOutStorageBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getOutStorageBillEntryInfo(getContext(), pk, selector);
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
    public OutStorageBillEntryInfo getOutStorageBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getOutStorageBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public OutStorageBillEntryCollection getOutStorageBillEntryCollection() throws BOSException
    {
        try {
            return getController().getOutStorageBillEntryCollection(getContext());
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
    public OutStorageBillEntryCollection getOutStorageBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getOutStorageBillEntryCollection(getContext(), view);
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
    public OutStorageBillEntryCollection getOutStorageBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getOutStorageBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}