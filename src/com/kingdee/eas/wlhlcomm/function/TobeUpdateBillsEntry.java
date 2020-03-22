package com.kingdee.eas.wlhlcomm.function;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.wlhlcomm.function.app.*;
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

public class TobeUpdateBillsEntry extends CoreBillEntryBase implements ITobeUpdateBillsEntry
{
    public TobeUpdateBillsEntry()
    {
        super();
        registerInterface(ITobeUpdateBillsEntry.class, this);
    }
    public TobeUpdateBillsEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ITobeUpdateBillsEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("11F369EC");
    }
    private TobeUpdateBillsEntryController getController() throws BOSException
    {
        return (TobeUpdateBillsEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TobeUpdateBillsEntryInfo getTobeUpdateBillsEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTobeUpdateBillsEntryInfo(getContext(), pk);
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
    public TobeUpdateBillsEntryInfo getTobeUpdateBillsEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTobeUpdateBillsEntryInfo(getContext(), pk, selector);
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
    public TobeUpdateBillsEntryInfo getTobeUpdateBillsEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTobeUpdateBillsEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TobeUpdateBillsEntryCollection getTobeUpdateBillsEntryCollection() throws BOSException
    {
        try {
            return getController().getTobeUpdateBillsEntryCollection(getContext());
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
    public TobeUpdateBillsEntryCollection getTobeUpdateBillsEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTobeUpdateBillsEntryCollection(getContext(), view);
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
    public TobeUpdateBillsEntryCollection getTobeUpdateBillsEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getTobeUpdateBillsEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}