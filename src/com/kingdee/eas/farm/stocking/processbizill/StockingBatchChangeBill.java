package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StockingBatchChangeBill extends CoreBillBase implements IStockingBatchChangeBill
{
    public StockingBatchChangeBill()
    {
        super();
        registerInterface(IStockingBatchChangeBill.class, this);
    }
    public StockingBatchChangeBill(Context ctx)
    {
        super(ctx);
        registerInterface(IStockingBatchChangeBill.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1CCA4700");
    }
    private StockingBatchChangeBillController getController() throws BOSException
    {
        return (StockingBatchChangeBillController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StockingBatchChangeBillCollection getStockingBatchChangeBillCollection() throws BOSException
    {
        try {
            return getController().getStockingBatchChangeBillCollection(getContext());
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
    public StockingBatchChangeBillCollection getStockingBatchChangeBillCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStockingBatchChangeBillCollection(getContext(), view);
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
    public StockingBatchChangeBillCollection getStockingBatchChangeBillCollection(String oql) throws BOSException
    {
        try {
            return getController().getStockingBatchChangeBillCollection(getContext(), oql);
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
    public StockingBatchChangeBillInfo getStockingBatchChangeBillInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBatchChangeBillInfo(getContext(), pk);
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
    public StockingBatchChangeBillInfo getStockingBatchChangeBillInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBatchChangeBillInfo(getContext(), pk, selector);
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
    public StockingBatchChangeBillInfo getStockingBatchChangeBillInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBatchChangeBillInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(StockingBatchChangeBillInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(StockingBatchChangeBillInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}