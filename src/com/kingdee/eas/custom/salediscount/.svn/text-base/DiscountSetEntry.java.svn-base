package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.CoreBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.salediscount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.ICoreBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DiscountSetEntry extends CoreBase implements IDiscountSetEntry
{
    public DiscountSetEntry()
    {
        super();
        registerInterface(IDiscountSetEntry.class, this);
    }
    public DiscountSetEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDiscountSetEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C518C08C");
    }
    private DiscountSetEntryController getController() throws BOSException
    {
        return (DiscountSetEntryController)getBizController();
    }
    /**
     *明细审核-User defined method
     *@param pks pks
     */
    public void auditForEntries(IObjectPK[] pks) throws BOSException, EASBizException
    {
        try {
            getController().auditForEntries(getContext(), pks);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *明细反审核-User defined method
     *@param pks pks
     */
    public void unAuditForEntries(IObjectPK[] pks) throws BOSException, EASBizException
    {
        try {
            getController().unAuditForEntries(getContext(), pks);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DiscountSetEntryInfo getDiscountSetEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountSetEntryInfo(getContext(), pk);
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
    public DiscountSetEntryInfo getDiscountSetEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountSetEntryInfo(getContext(), pk, selector);
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
    public DiscountSetEntryInfo getDiscountSetEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountSetEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DiscountSetEntryCollection getDiscountSetEntryCollection() throws BOSException
    {
        try {
            return getController().getDiscountSetEntryCollection(getContext());
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
    public DiscountSetEntryCollection getDiscountSetEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDiscountSetEntryCollection(getContext(), view);
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
    public DiscountSetEntryCollection getDiscountSetEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDiscountSetEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}