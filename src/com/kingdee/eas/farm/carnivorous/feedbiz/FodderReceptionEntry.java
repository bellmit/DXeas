package com.kingdee.eas.farm.carnivorous.feedbiz;

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
import com.kingdee.eas.farm.carnivorous.feedbiz.app.*;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FodderReceptionEntry extends CoreBillEntryBase implements IFodderReceptionEntry
{
    public FodderReceptionEntry()
    {
        super();
        registerInterface(IFodderReceptionEntry.class, this);
    }
    public FodderReceptionEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFodderReceptionEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B2A4525D");
    }
    private FodderReceptionEntryController getController() throws BOSException
    {
        return (FodderReceptionEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FodderReceptionEntryInfo getFodderReceptionEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderReceptionEntryInfo(getContext(), pk);
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
    public FodderReceptionEntryInfo getFodderReceptionEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderReceptionEntryInfo(getContext(), pk, selector);
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
    public FodderReceptionEntryInfo getFodderReceptionEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderReceptionEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FodderReceptionEntryCollection getFodderReceptionEntryCollection() throws BOSException
    {
        try {
            return getController().getFodderReceptionEntryCollection(getContext());
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
    public FodderReceptionEntryCollection getFodderReceptionEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFodderReceptionEntryCollection(getContext(), view);
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
    public FodderReceptionEntryCollection getFodderReceptionEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFodderReceptionEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}