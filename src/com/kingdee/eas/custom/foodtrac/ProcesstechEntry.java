package com.kingdee.eas.custom.foodtrac;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.foodtrac.app.*;
import com.kingdee.bos.BOSException;
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

public class ProcesstechEntry extends CoreBillEntryBase implements IProcesstechEntry
{
    public ProcesstechEntry()
    {
        super();
        registerInterface(IProcesstechEntry.class, this);
    }
    public ProcesstechEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IProcesstechEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("066338B2");
    }
    private ProcesstechEntryController getController() throws BOSException
    {
        return (ProcesstechEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ProcesstechEntryInfo getProcesstechEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getProcesstechEntryInfo(getContext(), pk);
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
    public ProcesstechEntryInfo getProcesstechEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getProcesstechEntryInfo(getContext(), pk, selector);
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
    public ProcesstechEntryInfo getProcesstechEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getProcesstechEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ProcesstechEntryCollection getProcesstechEntryCollection() throws BOSException
    {
        try {
            return getController().getProcesstechEntryCollection(getContext());
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
    public ProcesstechEntryCollection getProcesstechEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getProcesstechEntryCollection(getContext(), view);
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
    public ProcesstechEntryCollection getProcesstechEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getProcesstechEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}