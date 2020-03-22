package com.kingdee.eas.farm.stocking.processbizill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FodderReceiveBillEntry extends CoreBillEntryBase implements IFodderReceiveBillEntry
{
    public FodderReceiveBillEntry()
    {
        super();
        registerInterface(IFodderReceiveBillEntry.class, this);
    }
    public FodderReceiveBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFodderReceiveBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D4752043");
    }
    private FodderReceiveBillEntryController getController() throws BOSException
    {
        return (FodderReceiveBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FodderReceiveBillEntryInfo getFodderReceiveBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderReceiveBillEntryInfo(getContext(), pk);
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
    public FodderReceiveBillEntryInfo getFodderReceiveBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderReceiveBillEntryInfo(getContext(), pk, selector);
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
    public FodderReceiveBillEntryInfo getFodderReceiveBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderReceiveBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FodderReceiveBillEntryCollection getFodderReceiveBillEntryCollection() throws BOSException
    {
        try {
            return getController().getFodderReceiveBillEntryCollection(getContext());
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
    public FodderReceiveBillEntryCollection getFodderReceiveBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFodderReceiveBillEntryCollection(getContext(), view);
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
    public FodderReceiveBillEntryCollection getFodderReceiveBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFodderReceiveBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}