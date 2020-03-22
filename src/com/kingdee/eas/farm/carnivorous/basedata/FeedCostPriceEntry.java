package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
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

public class FeedCostPriceEntry extends CoreBillEntryBase implements IFeedCostPriceEntry
{
    public FeedCostPriceEntry()
    {
        super();
        registerInterface(IFeedCostPriceEntry.class, this);
    }
    public FeedCostPriceEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedCostPriceEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0A79EEB6");
    }
    private FeedCostPriceEntryController getController() throws BOSException
    {
        return (FeedCostPriceEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FeedCostPriceEntryInfo getFeedCostPriceEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedCostPriceEntryInfo(getContext(), pk);
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
    public FeedCostPriceEntryInfo getFeedCostPriceEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedCostPriceEntryInfo(getContext(), pk, selector);
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
    public FeedCostPriceEntryInfo getFeedCostPriceEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedCostPriceEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedCostPriceEntryCollection getFeedCostPriceEntryCollection() throws BOSException
    {
        try {
            return getController().getFeedCostPriceEntryCollection(getContext());
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
    public FeedCostPriceEntryCollection getFeedCostPriceEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedCostPriceEntryCollection(getContext(), view);
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
    public FeedCostPriceEntryCollection getFeedCostPriceEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedCostPriceEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}