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

public class TransFodderBillEntry extends CoreBillEntryBase implements ITransFodderBillEntry
{
    public TransFodderBillEntry()
    {
        super();
        registerInterface(ITransFodderBillEntry.class, this);
    }
    public TransFodderBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ITransFodderBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4A9502F2");
    }
    private TransFodderBillEntryController getController() throws BOSException
    {
        return (TransFodderBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TransFodderBillEntryInfo getTransFodderBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTransFodderBillEntryInfo(getContext(), pk);
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
    public TransFodderBillEntryInfo getTransFodderBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTransFodderBillEntryInfo(getContext(), pk, selector);
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
    public TransFodderBillEntryInfo getTransFodderBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTransFodderBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TransFodderBillEntryCollection getTransFodderBillEntryCollection() throws BOSException
    {
        try {
            return getController().getTransFodderBillEntryCollection(getContext());
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
    public TransFodderBillEntryCollection getTransFodderBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTransFodderBillEntryCollection(getContext(), view);
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
    public TransFodderBillEntryCollection getTransFodderBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getTransFodderBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}