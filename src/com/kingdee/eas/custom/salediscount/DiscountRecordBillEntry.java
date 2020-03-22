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

public class DiscountRecordBillEntry extends CoreBillEntryBase implements IDiscountRecordBillEntry
{
    public DiscountRecordBillEntry()
    {
        super();
        registerInterface(IDiscountRecordBillEntry.class, this);
    }
    public DiscountRecordBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IDiscountRecordBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("64CAA87E");
    }
    private DiscountRecordBillEntryController getController() throws BOSException
    {
        return (DiscountRecordBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DiscountRecordBillEntryInfo getDiscountRecordBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountRecordBillEntryInfo(getContext(), pk);
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
    public DiscountRecordBillEntryInfo getDiscountRecordBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountRecordBillEntryInfo(getContext(), pk, selector);
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
    public DiscountRecordBillEntryInfo getDiscountRecordBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDiscountRecordBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DiscountRecordBillEntryCollection getDiscountRecordBillEntryCollection() throws BOSException
    {
        try {
            return getController().getDiscountRecordBillEntryCollection(getContext());
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
    public DiscountRecordBillEntryCollection getDiscountRecordBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDiscountRecordBillEntryCollection(getContext(), view);
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
    public DiscountRecordBillEntryCollection getDiscountRecordBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getDiscountRecordBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}