package com.kingdee.eas.farm.hatch;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.hatch.app.*;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EarlyEggStock extends CoreBillBase implements IEarlyEggStock
{
    public EarlyEggStock()
    {
        super();
        registerInterface(IEarlyEggStock.class, this);
    }
    public EarlyEggStock(Context ctx)
    {
        super(ctx);
        registerInterface(IEarlyEggStock.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("FBBB1B46");
    }
    private EarlyEggStockController getController() throws BOSException
    {
        return (EarlyEggStockController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EarlyEggStockCollection getEarlyEggStockCollection() throws BOSException
    {
        try {
            return getController().getEarlyEggStockCollection(getContext());
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
    public EarlyEggStockCollection getEarlyEggStockCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEarlyEggStockCollection(getContext(), view);
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
    public EarlyEggStockCollection getEarlyEggStockCollection(String oql) throws BOSException
    {
        try {
            return getController().getEarlyEggStockCollection(getContext(), oql);
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
    public EarlyEggStockInfo getEarlyEggStockInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEarlyEggStockInfo(getContext(), pk);
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
    public EarlyEggStockInfo getEarlyEggStockInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEarlyEggStockInfo(getContext(), pk, selector);
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
    public EarlyEggStockInfo getEarlyEggStockInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEarlyEggStockInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param Info Info
     */
    public void audit(IObjectValue Info) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), Info);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}