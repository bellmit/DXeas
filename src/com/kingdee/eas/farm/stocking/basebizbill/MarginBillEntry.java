package com.kingdee.eas.farm.stocking.basebizbill;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.stocking.basebizbill.app.*;
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

public class MarginBillEntry extends CoreBillEntryBase implements IMarginBillEntry
{
    public MarginBillEntry()
    {
        super();
        registerInterface(IMarginBillEntry.class, this);
    }
    public MarginBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IMarginBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9710199C");
    }
    private MarginBillEntryController getController() throws BOSException
    {
        return (MarginBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MarginBillEntryInfo getMarginBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginBillEntryInfo(getContext(), pk);
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
    public MarginBillEntryInfo getMarginBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginBillEntryInfo(getContext(), pk, selector);
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
    public MarginBillEntryInfo getMarginBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MarginBillEntryCollection getMarginBillEntryCollection() throws BOSException
    {
        try {
            return getController().getMarginBillEntryCollection(getContext());
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
    public MarginBillEntryCollection getMarginBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMarginBillEntryCollection(getContext(), view);
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
    public MarginBillEntryCollection getMarginBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getMarginBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}