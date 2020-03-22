package com.kingdee.eas.farm.feedfactory;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.feedfactory.app.*;
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

public class FeedBusinessDaily extends CoreBillBase implements IFeedBusinessDaily
{
    public FeedBusinessDaily()
    {
        super();
        registerInterface(IFeedBusinessDaily.class, this);
    }
    public FeedBusinessDaily(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedBusinessDaily.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0489F399");
    }
    private FeedBusinessDailyController getController() throws BOSException
    {
        return (FeedBusinessDailyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedBusinessDailyCollection getFeedBusinessDailyCollection() throws BOSException
    {
        try {
            return getController().getFeedBusinessDailyCollection(getContext());
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
    public FeedBusinessDailyCollection getFeedBusinessDailyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedBusinessDailyCollection(getContext(), view);
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
    public FeedBusinessDailyCollection getFeedBusinessDailyCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedBusinessDailyCollection(getContext(), oql);
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
    public FeedBusinessDailyInfo getFeedBusinessDailyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedBusinessDailyInfo(getContext(), pk);
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
    public FeedBusinessDailyInfo getFeedBusinessDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedBusinessDailyInfo(getContext(), pk, selector);
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
    public FeedBusinessDailyInfo getFeedBusinessDailyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedBusinessDailyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(FeedBusinessDailyInfo model) throws BOSException
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
    public void unAudit(FeedBusinessDailyInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}