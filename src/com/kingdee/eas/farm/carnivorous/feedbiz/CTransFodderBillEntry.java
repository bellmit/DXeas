package com.kingdee.eas.farm.carnivorous.feedbiz;

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
import com.kingdee.eas.farm.carnivorous.feedbiz.app.*;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CTransFodderBillEntry extends CoreBillEntryBase implements ICTransFodderBillEntry
{
    public CTransFodderBillEntry()
    {
        super();
        registerInterface(ICTransFodderBillEntry.class, this);
    }
    public CTransFodderBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ICTransFodderBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("BCC3AD2C");
    }
    private CTransFodderBillEntryController getController() throws BOSException
    {
        return (CTransFodderBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CTransFodderBillEntryInfo getCTransFodderBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransFodderBillEntryInfo(getContext(), pk);
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
    public CTransFodderBillEntryInfo getCTransFodderBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransFodderBillEntryInfo(getContext(), pk, selector);
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
    public CTransFodderBillEntryInfo getCTransFodderBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCTransFodderBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CTransFodderBillEntryCollection getCTransFodderBillEntryCollection() throws BOSException
    {
        try {
            return getController().getCTransFodderBillEntryCollection(getContext());
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
    public CTransFodderBillEntryCollection getCTransFodderBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCTransFodderBillEntryCollection(getContext(), view);
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
    public CTransFodderBillEntryCollection getCTransFodderBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getCTransFodderBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}