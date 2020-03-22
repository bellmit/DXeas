package com.kingdee.eas.farm.dayratecost;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.dayratecost.app.*;
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

public class ArAmountOffsetDetailBillEntry extends CoreBillEntryBase implements IArAmountOffsetDetailBillEntry
{
    public ArAmountOffsetDetailBillEntry()
    {
        super();
        registerInterface(IArAmountOffsetDetailBillEntry.class, this);
    }
    public ArAmountOffsetDetailBillEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IArAmountOffsetDetailBillEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("ECC53E99");
    }
    private ArAmountOffsetDetailBillEntryController getController() throws BOSException
    {
        return (ArAmountOffsetDetailBillEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ArAmountOffsetDetailBillEntryInfo getArAmountOffsetDetailBillEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getArAmountOffsetDetailBillEntryInfo(getContext(), pk);
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
    public ArAmountOffsetDetailBillEntryInfo getArAmountOffsetDetailBillEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getArAmountOffsetDetailBillEntryInfo(getContext(), pk, selector);
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
    public ArAmountOffsetDetailBillEntryInfo getArAmountOffsetDetailBillEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getArAmountOffsetDetailBillEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ArAmountOffsetDetailBillEntryCollection getArAmountOffsetDetailBillEntryCollection() throws BOSException
    {
        try {
            return getController().getArAmountOffsetDetailBillEntryCollection(getContext());
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
    public ArAmountOffsetDetailBillEntryCollection getArAmountOffsetDetailBillEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getArAmountOffsetDetailBillEntryCollection(getContext(), view);
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
    public ArAmountOffsetDetailBillEntryCollection getArAmountOffsetDetailBillEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getArAmountOffsetDetailBillEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}