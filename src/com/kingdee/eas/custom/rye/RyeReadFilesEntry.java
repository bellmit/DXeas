package com.kingdee.eas.custom.rye;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.rye.app.*;
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

public class RyeReadFilesEntry extends CoreBillEntryBase implements IRyeReadFilesEntry
{
    public RyeReadFilesEntry()
    {
        super();
        registerInterface(IRyeReadFilesEntry.class, this);
    }
    public RyeReadFilesEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IRyeReadFilesEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("36861A7A");
    }
    private RyeReadFilesEntryController getController() throws BOSException
    {
        return (RyeReadFilesEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public RyeReadFilesEntryInfo getRyeReadFilesEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRyeReadFilesEntryInfo(getContext(), pk);
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
    public RyeReadFilesEntryInfo getRyeReadFilesEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRyeReadFilesEntryInfo(getContext(), pk, selector);
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
    public RyeReadFilesEntryInfo getRyeReadFilesEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRyeReadFilesEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public RyeReadFilesEntryCollection getRyeReadFilesEntryCollection() throws BOSException
    {
        try {
            return getController().getRyeReadFilesEntryCollection(getContext());
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
    public RyeReadFilesEntryCollection getRyeReadFilesEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRyeReadFilesEntryCollection(getContext(), view);
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
    public RyeReadFilesEntryCollection getRyeReadFilesEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getRyeReadFilesEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}