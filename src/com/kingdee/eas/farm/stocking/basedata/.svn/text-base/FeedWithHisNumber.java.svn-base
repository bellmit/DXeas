package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FeedWithHisNumber extends DataBase implements IFeedWithHisNumber
{
    public FeedWithHisNumber()
    {
        super();
        registerInterface(IFeedWithHisNumber.class, this);
    }
    public FeedWithHisNumber(Context ctx)
    {
        super(ctx);
        registerInterface(IFeedWithHisNumber.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A2239F26");
    }
    private FeedWithHisNumberController getController() throws BOSException
    {
        return (FeedWithHisNumberController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FeedWithHisNumberInfo getFeedWithHisNumberInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedWithHisNumberInfo(getContext(), pk);
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
    public FeedWithHisNumberInfo getFeedWithHisNumberInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedWithHisNumberInfo(getContext(), pk, selector);
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
    public FeedWithHisNumberInfo getFeedWithHisNumberInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFeedWithHisNumberInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FeedWithHisNumberCollection getFeedWithHisNumberCollection() throws BOSException
    {
        try {
            return getController().getFeedWithHisNumberCollection(getContext());
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
    public FeedWithHisNumberCollection getFeedWithHisNumberCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFeedWithHisNumberCollection(getContext(), view);
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
    public FeedWithHisNumberCollection getFeedWithHisNumberCollection(String oql) throws BOSException
    {
        try {
            return getController().getFeedWithHisNumberCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}