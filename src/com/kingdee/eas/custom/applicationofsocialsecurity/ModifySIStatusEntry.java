package com.kingdee.eas.custom.applicationofsocialsecurity;

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
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.custom.applicationofsocialsecurity.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ModifySIStatusEntry extends CoreBillEntryBase implements IModifySIStatusEntry
{
    public ModifySIStatusEntry()
    {
        super();
        registerInterface(IModifySIStatusEntry.class, this);
    }
    public ModifySIStatusEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IModifySIStatusEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5583E331");
    }
    private ModifySIStatusEntryController getController() throws BOSException
    {
        return (ModifySIStatusEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ModifySIStatusEntryInfo getModifySIStatusEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getModifySIStatusEntryInfo(getContext(), pk);
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
    public ModifySIStatusEntryInfo getModifySIStatusEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getModifySIStatusEntryInfo(getContext(), pk, selector);
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
    public ModifySIStatusEntryInfo getModifySIStatusEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getModifySIStatusEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ModifySIStatusEntryCollection getModifySIStatusEntryCollection() throws BOSException
    {
        try {
            return getController().getModifySIStatusEntryCollection(getContext());
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
    public ModifySIStatusEntryCollection getModifySIStatusEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getModifySIStatusEntryCollection(getContext(), view);
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
    public ModifySIStatusEntryCollection getModifySIStatusEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getModifySIStatusEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}