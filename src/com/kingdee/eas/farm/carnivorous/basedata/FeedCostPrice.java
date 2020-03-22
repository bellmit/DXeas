package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FeedCostPrice extends CoreBillBase implements IFeedCostPrice
{
    public FeedCostPrice()
    {
        super();
        registerInterface(IFeedCostPrice.class, this);
    }
    public FeedCostPrice(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedCostPrice.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D1CABB1C");
    }
    private FeedCostPriceController getController() throws BOSException
    {
        return (FeedCostPriceController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedCostPriceCollection getFeedCostPriceCollection() throws BOSException
    {
        try {
            return getController().getFeedCostPriceCollection(getContext());
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
    public FeedCostPriceCollection getFeedCostPriceCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedCostPriceCollection(getContext(), view);
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
    public FeedCostPriceCollection getFeedCostPriceCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedCostPriceCollection(getContext(), oql);
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
    public FeedCostPriceInfo getFeedCostPriceInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedCostPriceInfo(getContext(), pk);
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
    public FeedCostPriceInfo getFeedCostPriceInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedCostPriceInfo(getContext(), pk, selector);
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
    public FeedCostPriceInfo getFeedCostPriceInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedCostPriceInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(FeedCostPriceInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *未核准-User defined method
     *@param model model
     */
    public void unAudit(FeedCostPriceInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}