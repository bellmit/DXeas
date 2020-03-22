package com.kingdee.eas.custom.salediscount;

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
import com.kingdee.eas.custom.salediscount.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DiscountGridLogEntry extends CoreBillEntryBase implements IDiscountGridLogEntry
{
    public DiscountGridLogEntry()
    {
        super();
        registerInterface(IDiscountGridLogEntry.class, this);
    }
    public DiscountGridLogEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDiscountGridLogEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D1031250");
    }
    private DiscountGridLogEntryController getController() throws BOSException
    {
        return (DiscountGridLogEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DiscountGridLogEntryInfo getDiscountGridLogEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountGridLogEntryInfo(getContext(), pk);
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
    public DiscountGridLogEntryInfo getDiscountGridLogEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountGridLogEntryInfo(getContext(), pk, selector);
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
    public DiscountGridLogEntryInfo getDiscountGridLogEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountGridLogEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DiscountGridLogEntryCollection getDiscountGridLogEntryCollection() throws BOSException
    {
        try {
            return getController().getDiscountGridLogEntryCollection(getContext());
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
    public DiscountGridLogEntryCollection getDiscountGridLogEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDiscountGridLogEntryCollection(getContext(), view);
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
    public DiscountGridLogEntryCollection getDiscountGridLogEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDiscountGridLogEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}