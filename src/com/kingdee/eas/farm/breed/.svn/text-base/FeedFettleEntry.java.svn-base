package com.kingdee.eas.farm.breed;

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
import com.kingdee.eas.farm.breed.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FeedFettleEntry extends CoreBillEntryBase implements IFeedFettleEntry
{
    public FeedFettleEntry()
    {
        super();
        registerInterface(IFeedFettleEntry.class, this);
    }
    public FeedFettleEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedFettleEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6157A502");
    }
    private FeedFettleEntryController getController() throws BOSException
    {
        return (FeedFettleEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FeedFettleEntryInfo getFeedFettleEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFettleEntryInfo(getContext(), pk);
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
    public FeedFettleEntryInfo getFeedFettleEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFettleEntryInfo(getContext(), pk, selector);
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
    public FeedFettleEntryInfo getFeedFettleEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedFettleEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedFettleEntryCollection getFeedFettleEntryCollection() throws BOSException
    {
        try {
            return getController().getFeedFettleEntryCollection(getContext());
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
    public FeedFettleEntryCollection getFeedFettleEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedFettleEntryCollection(getContext(), view);
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
    public FeedFettleEntryCollection getFeedFettleEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedFettleEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}