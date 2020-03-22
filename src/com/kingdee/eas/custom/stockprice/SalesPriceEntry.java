package com.kingdee.eas.custom.stockprice;

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
import com.kingdee.eas.custom.stockprice.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SalesPriceEntry extends CoreBillEntryBase implements ISalesPriceEntry
{
    public SalesPriceEntry()
    {
        super();
        registerInterface(ISalesPriceEntry.class, this);
    }
    public SalesPriceEntry(Context ctx)
    {
        super(ctx);
        registerInterface(ISalesPriceEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2E254C65");
    }
    private SalesPriceEntryController getController() throws BOSException
    {
        return (SalesPriceEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SalesPriceEntryInfo getSalesPriceEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSalesPriceEntryInfo(getContext(), pk);
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
    public SalesPriceEntryInfo getSalesPriceEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSalesPriceEntryInfo(getContext(), pk, selector);
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
    public SalesPriceEntryInfo getSalesPriceEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSalesPriceEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SalesPriceEntryCollection getSalesPriceEntryCollection() throws BOSException
    {
        try {
            return getController().getSalesPriceEntryCollection(getContext());
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
    public SalesPriceEntryCollection getSalesPriceEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSalesPriceEntryCollection(getContext(), view);
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
    public SalesPriceEntryCollection getSalesPriceEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getSalesPriceEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}