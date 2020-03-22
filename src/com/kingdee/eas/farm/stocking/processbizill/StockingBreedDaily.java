package com.kingdee.eas.farm.stocking.processbizill;

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
import com.kingdee.eas.farm.stocking.processbizill.app.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class StockingBreedDaily extends CoreBillBase implements IStockingBreedDaily
{
    public StockingBreedDaily()
    {
        super();
        registerInterface(IStockingBreedDaily.class, this);
    }
    public StockingBreedDaily(Context ctx)
    {
        super(ctx);
        registerInterface(IStockingBreedDaily.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2859A756");
    }
    private StockingBreedDailyController getController() throws BOSException
    {
        return (StockingBreedDailyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StockingBreedDailyCollection getStockingBreedDailyCollection() throws BOSException
    {
        try {
            return getController().getStockingBreedDailyCollection(getContext());
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
    public StockingBreedDailyCollection getStockingBreedDailyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStockingBreedDailyCollection(getContext(), view);
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
    public StockingBreedDailyCollection getStockingBreedDailyCollection(String oql) throws BOSException
    {
        try {
            return getController().getStockingBreedDailyCollection(getContext(), oql);
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
    public StockingBreedDailyInfo getStockingBreedDailyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBreedDailyInfo(getContext(), pk);
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
    public StockingBreedDailyInfo getStockingBreedDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBreedDailyInfo(getContext(), pk, selector);
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
    public StockingBreedDailyInfo getStockingBreedDailyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBreedDailyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(StockingBreedDailyInfo model) throws BOSException, EASBizException
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
    public void unAudit(StockingBreedDailyInfo model) throws BOSException, EASBizException
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
    public List genNextBill(StockingBreedDailyInfo model) throws BOSException
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
    public void reShareCoalAndDiesel(StockingBreedDailyInfo model) throws BOSException
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