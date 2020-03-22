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
     *ȡֵ-System defined method
     *@param pk ȡֵ
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
     *ȡֵ-System defined method
     *@param pk ȡֵ
     *@param selector ȡֵ
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
     *ȡֵ-System defined method
     *@param oql ȡֵ
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
     *ȡ����-System defined method
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
     *ȡ����-System defined method
     *@param view ȡ����
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
     *ȡ����-System defined method
     *@param oql ȡ����
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