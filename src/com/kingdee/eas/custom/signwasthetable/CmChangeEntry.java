package com.kingdee.eas.custom.signwasthetable;

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
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CmChangeEntry extends CoreBillEntryBase implements ICmChangeEntry
{
    public CmChangeEntry()
    {
        super();
        registerInterface(ICmChangeEntry.class, this);
    }
    public CmChangeEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICmChangeEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B1B7ED0E");
    }
    private CmChangeEntryController getController() throws BOSException
    {
        return (CmChangeEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CmChangeEntryInfo getCmChangeEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCmChangeEntryInfo(getContext(), pk);
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
    public CmChangeEntryInfo getCmChangeEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCmChangeEntryInfo(getContext(), pk, selector);
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
    public CmChangeEntryInfo getCmChangeEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCmChangeEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CmChangeEntryCollection getCmChangeEntryCollection() throws BOSException
    {
        try {
            return getController().getCmChangeEntryCollection(getContext());
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
    public CmChangeEntryCollection getCmChangeEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCmChangeEntryCollection(getContext(), view);
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
    public CmChangeEntryCollection getCmChangeEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCmChangeEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}