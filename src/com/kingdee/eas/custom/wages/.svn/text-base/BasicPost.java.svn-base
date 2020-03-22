package com.kingdee.eas.custom.wages;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.custom.wages.app.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BasicPost extends DataBase implements IBasicPost
{
    public BasicPost()
    {
        super();
        registerInterface(IBasicPost.class, this);
    }
    public BasicPost(Context ctx)
    {
        super(ctx);
        registerInterface(IBasicPost.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("1F8BC6E6");
    }
    private BasicPostController getController() throws BOSException
    {
        return (BasicPostController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BasicPostInfo getBasicPostInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBasicPostInfo(getContext(), pk);
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
    public BasicPostInfo getBasicPostInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBasicPostInfo(getContext(), pk, selector);
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
    public BasicPostInfo getBasicPostInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBasicPostInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BasicPostCollection getBasicPostCollection() throws BOSException
    {
        try {
            return getController().getBasicPostCollection(getContext());
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
    public BasicPostCollection getBasicPostCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBasicPostCollection(getContext(), view);
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
    public BasicPostCollection getBasicPostCollection(String oql) throws BOSException
    {
        try {
            return getController().getBasicPostCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}