package com.kingdee.eas.custom.stockprice;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.stockprice.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SalesPrice extends CoreBillBase implements ISalesPrice
{
    public SalesPrice()
    {
        super();
        registerInterface(ISalesPrice.class, this);
    }
    public SalesPrice(Context ctx)
    {
        super(ctx);
        registerInterface(ISalesPrice.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AFF94C0D");
    }
    private SalesPriceController getController() throws BOSException
    {
        return (SalesPriceController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SalesPriceCollection getSalesPriceCollection() throws BOSException
    {
        try {
            return getController().getSalesPriceCollection(getContext());
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
    public SalesPriceCollection getSalesPriceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSalesPriceCollection(getContext(), view);
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
    public SalesPriceCollection getSalesPriceCollection(String oql) throws BOSException
    {
        try {
            return getController().getSalesPriceCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SalesPriceInfo getSalesPriceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSalesPriceInfo(getContext(), pk);
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
    public SalesPriceInfo getSalesPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSalesPriceInfo(getContext(), pk, selector);
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
    public SalesPriceInfo getSalesPriceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSalesPriceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}