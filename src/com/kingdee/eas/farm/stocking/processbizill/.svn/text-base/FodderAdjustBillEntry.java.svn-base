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

public class FodderAdjustBillEntry extends CoreBillEntryBase implements IFodderAdjustBillEntry
{
    public FodderAdjustBillEntry()
    {
        super();
        registerInterface(IFodderAdjustBillEntry.class, this);
    }
    public FodderAdjustBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFodderAdjustBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("62110341");
    }
    private FodderAdjustBillEntryController getController() throws BOSException
    {
        return (FodderAdjustBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FodderAdjustBillEntryInfo getFodderAdjustBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderAdjustBillEntryInfo(getContext(), pk);
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
    public FodderAdjustBillEntryInfo getFodderAdjustBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderAdjustBillEntryInfo(getContext(), pk, selector);
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
    public FodderAdjustBillEntryInfo getFodderAdjustBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderAdjustBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FodderAdjustBillEntryCollection getFodderAdjustBillEntryCollection() throws BOSException
    {
        try {
            return getController().getFodderAdjustBillEntryCollection(getContext());
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
    public FodderAdjustBillEntryCollection getFodderAdjustBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFodderAdjustBillEntryCollection(getContext(), view);
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
    public FodderAdjustBillEntryCollection getFodderAdjustBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFodderAdjustBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}