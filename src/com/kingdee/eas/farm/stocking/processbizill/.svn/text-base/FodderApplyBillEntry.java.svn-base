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

public class FodderApplyBillEntry extends CoreBillEntryBase implements IFodderApplyBillEntry
{
    public FodderApplyBillEntry()
    {
        super();
        registerInterface(IFodderApplyBillEntry.class, this);
    }
    public FodderApplyBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFodderApplyBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2E6C0ED8");
    }
    private FodderApplyBillEntryController getController() throws BOSException
    {
        return (FodderApplyBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FodderApplyBillEntryInfo getFodderApplyBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderApplyBillEntryInfo(getContext(), pk);
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
    public FodderApplyBillEntryInfo getFodderApplyBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderApplyBillEntryInfo(getContext(), pk, selector);
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
    public FodderApplyBillEntryInfo getFodderApplyBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFodderApplyBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FodderApplyBillEntryCollection getFodderApplyBillEntryCollection() throws BOSException
    {
        try {
            return getController().getFodderApplyBillEntryCollection(getContext());
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
    public FodderApplyBillEntryCollection getFodderApplyBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFodderApplyBillEntryCollection(getContext(), view);
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
    public FodderApplyBillEntryCollection getFodderApplyBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFodderApplyBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}