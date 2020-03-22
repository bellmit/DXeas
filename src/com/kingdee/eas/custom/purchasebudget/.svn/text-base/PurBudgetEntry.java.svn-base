package com.kingdee.eas.custom.purchasebudget;

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
import com.kingdee.eas.custom.purchasebudget.app.*;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PurBudgetEntry extends CoreBillEntryBase implements IPurBudgetEntry
{
    public PurBudgetEntry()
    {
        super();
        registerInterface(IPurBudgetEntry.class, this);
    }
    public PurBudgetEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IPurBudgetEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2C1B78DD");
    }
    private PurBudgetEntryController getController() throws BOSException
    {
        return (PurBudgetEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PurBudgetEntryInfo getPurBudgetEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPurBudgetEntryInfo(getContext(), pk);
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
    public PurBudgetEntryInfo getPurBudgetEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPurBudgetEntryInfo(getContext(), pk, selector);
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
    public PurBudgetEntryInfo getPurBudgetEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPurBudgetEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PurBudgetEntryCollection getPurBudgetEntryCollection() throws BOSException
    {
        try {
            return getController().getPurBudgetEntryCollection(getContext());
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
    public PurBudgetEntryCollection getPurBudgetEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPurBudgetEntryCollection(getContext(), view);
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
    public PurBudgetEntryCollection getPurBudgetEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getPurBudgetEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}