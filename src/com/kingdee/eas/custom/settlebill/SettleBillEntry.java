package com.kingdee.eas.custom.settlebill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.settlebill.app.*;
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

public class SettleBillEntry extends CoreBillEntryBase implements ISettleBillEntry
{
    public SettleBillEntry()
    {
        super();
        registerInterface(ISettleBillEntry.class, this);
    }
    public SettleBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISettleBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6D70278F");
    }
    private SettleBillEntryController getController() throws BOSException
    {
        return (SettleBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SettleBillEntryInfo getSettleBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleBillEntryInfo(getContext(), pk);
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
    public SettleBillEntryInfo getSettleBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleBillEntryInfo(getContext(), pk, selector);
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
    public SettleBillEntryInfo getSettleBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSettleBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SettleBillEntryCollection getSettleBillEntryCollection() throws BOSException
    {
        try {
            return getController().getSettleBillEntryCollection(getContext());
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
    public SettleBillEntryCollection getSettleBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSettleBillEntryCollection(getContext(), view);
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
    public SettleBillEntryCollection getSettleBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSettleBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}