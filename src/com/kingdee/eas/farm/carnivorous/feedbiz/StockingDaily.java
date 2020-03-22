package com.kingdee.eas.farm.carnivorous.feedbiz;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.farm.carnivorous.feedbiz.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StockingDaily extends CoreBillBase implements IStockingDaily
{
    public StockingDaily()
    {
        super();
        registerInterface(IStockingDaily.class, this);
    }
    public StockingDaily(Context ctx)
    {
        super(ctx);
        registerInterface(IStockingDaily.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CA396C89");
    }
    private StockingDailyController getController() throws BOSException
    {
        return (StockingDailyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StockingDailyCollection getStockingDailyCollection() throws BOSException
    {
        try {
            return getController().getStockingDailyCollection(getContext());
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
    public StockingDailyCollection getStockingDailyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStockingDailyCollection(getContext(), view);
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
    public StockingDailyCollection getStockingDailyCollection(String oql) throws BOSException
    {
        try {
            return getController().getStockingDailyCollection(getContext(), oql);
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
    public StockingDailyInfo getStockingDailyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingDailyInfo(getContext(), pk);
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
    public StockingDailyInfo getStockingDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingDailyInfo(getContext(), pk, selector);
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
    public StockingDailyInfo getStockingDailyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingDailyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(StockingDailyInfo model) throws BOSException, EASBizException
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
    public void unAudit(StockingDailyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成下游单据-User defined method
     *@param model model
     *@return
     */
    public List genNextBill(StockingDailyInfo model) throws BOSException
    {
        try {
            return getController().genNextBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *重新分摊煤和柴油-User defined method
     *@param model model
     */
    public void reShareCoalAndDiesel(StockingDailyInfo model) throws BOSException
    {
        try {
            getController().reShareCoalAndDiesel(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *重算批次存栏-User defined method
     *@param String 批次ID
     *@return
     */
    public String recalStockingByBatchID(String String) throws BOSException, EASBizException
    {
        try {
            return getController().recalStockingByBatchID(getContext(), String);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}