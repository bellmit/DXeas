package com.kingdee.eas.farm.food;

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
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FreshCountBillEntry extends CoreBillEntryBase implements IFreshCountBillEntry
{
    public FreshCountBillEntry()
    {
        super();
        registerInterface(IFreshCountBillEntry.class, this);
    }
    public FreshCountBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFreshCountBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C88B4C40");
    }
    private FreshCountBillEntryController getController() throws BOSException
    {
        return (FreshCountBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FreshCountBillEntryInfo getFreshCountBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFreshCountBillEntryInfo(getContext(), pk);
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
    public FreshCountBillEntryInfo getFreshCountBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFreshCountBillEntryInfo(getContext(), pk, selector);
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
    public FreshCountBillEntryInfo getFreshCountBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFreshCountBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FreshCountBillEntryCollection getFreshCountBillEntryCollection() throws BOSException
    {
        try {
            return getController().getFreshCountBillEntryCollection(getContext());
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
    public FreshCountBillEntryCollection getFreshCountBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFreshCountBillEntryCollection(getContext(), view);
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
    public FreshCountBillEntryCollection getFreshCountBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFreshCountBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}