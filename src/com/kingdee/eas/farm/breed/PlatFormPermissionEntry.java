package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PlatFormPermissionEntry extends CoreBillEntryBase implements IPlatFormPermissionEntry
{
    public PlatFormPermissionEntry()
    {
        super();
        registerInterface(IPlatFormPermissionEntry.class, this);
    }
    public PlatFormPermissionEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IPlatFormPermissionEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8C358036");
    }
    private PlatFormPermissionEntryController getController() throws BOSException
    {
        return (PlatFormPermissionEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PlatFormPermissionEntryInfo getPlatFormPermissionEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPlatFormPermissionEntryInfo(getContext(), pk);
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
    public PlatFormPermissionEntryInfo getPlatFormPermissionEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPlatFormPermissionEntryInfo(getContext(), pk, selector);
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
    public PlatFormPermissionEntryInfo getPlatFormPermissionEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPlatFormPermissionEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PlatFormPermissionEntryCollection getPlatFormPermissionEntryCollection() throws BOSException
    {
        try {
            return getController().getPlatFormPermissionEntryCollection(getContext());
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
    public PlatFormPermissionEntryCollection getPlatFormPermissionEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPlatFormPermissionEntryCollection(getContext(), view);
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
    public PlatFormPermissionEntryCollection getPlatFormPermissionEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPlatFormPermissionEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}