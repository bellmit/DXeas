package com.kingdee.eas.custom.tocloud;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.tocloud.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SynDateLogEntry extends CoreBillEntryBase implements ISynDateLogEntry
{
    public SynDateLogEntry()
    {
        super();
        registerInterface(ISynDateLogEntry.class, this);
    }
    public SynDateLogEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISynDateLogEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EC86100B");
    }
    private SynDateLogEntryController getController() throws BOSException
    {
        return (SynDateLogEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SynDateLogEntryInfo getSynDateLogEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSynDateLogEntryInfo(getContext(), pk);
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
    public SynDateLogEntryInfo getSynDateLogEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSynDateLogEntryInfo(getContext(), pk, selector);
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
    public SynDateLogEntryInfo getSynDateLogEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSynDateLogEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SynDateLogEntryCollection getSynDateLogEntryCollection() throws BOSException
    {
        try {
            return getController().getSynDateLogEntryCollection(getContext());
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
    public SynDateLogEntryCollection getSynDateLogEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSynDateLogEntryCollection(getContext(), view);
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
    public SynDateLogEntryCollection getSynDateLogEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSynDateLogEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}