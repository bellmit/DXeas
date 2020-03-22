package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WagesPersonInfoEntry extends CoreBillEntryBase implements IWagesPersonInfoEntry
{
    public WagesPersonInfoEntry()
    {
        super();
        registerInterface(IWagesPersonInfoEntry.class, this);
    }
    public WagesPersonInfoEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IWagesPersonInfoEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("B84190CC");
    }
    private WagesPersonInfoEntryController getController() throws BOSException
    {
        return (WagesPersonInfoEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WagesPersonInfoEntryInfo getWagesPersonInfoEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWagesPersonInfoEntryInfo(getContext(), pk);
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
    public WagesPersonInfoEntryInfo getWagesPersonInfoEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWagesPersonInfoEntryInfo(getContext(), pk, selector);
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
    public WagesPersonInfoEntryInfo getWagesPersonInfoEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWagesPersonInfoEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WagesPersonInfoEntryCollection getWagesPersonInfoEntryCollection() throws BOSException
    {
        try {
            return getController().getWagesPersonInfoEntryCollection(getContext());
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
    public WagesPersonInfoEntryCollection getWagesPersonInfoEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWagesPersonInfoEntryCollection(getContext(), view);
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
    public WagesPersonInfoEntryCollection getWagesPersonInfoEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getWagesPersonInfoEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}