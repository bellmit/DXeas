package com.kingdee.eas.custom.wages.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.wages.food.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WageFoodOrganTree extends TreeBase implements IWageFoodOrganTree
{
    public WageFoodOrganTree()
    {
        super();
        registerInterface(IWageFoodOrganTree.class, this);
    }
    public WageFoodOrganTree(Context ctx)
    {
        super(ctx);
        registerInterface(IWageFoodOrganTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("03027587");
    }
    private WageFoodOrganTreeController getController() throws BOSException
    {
        return (WageFoodOrganTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WageFoodOrganTreeInfo getWageFoodOrganTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWageFoodOrganTreeInfo(getContext(), pk);
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
    public WageFoodOrganTreeInfo getWageFoodOrganTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWageFoodOrganTreeInfo(getContext(), pk, selector);
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
    public WageFoodOrganTreeInfo getWageFoodOrganTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWageFoodOrganTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WageFoodOrganTreeCollection getWageFoodOrganTreeCollection() throws BOSException
    {
        try {
            return getController().getWageFoodOrganTreeCollection(getContext());
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
    public WageFoodOrganTreeCollection getWageFoodOrganTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWageFoodOrganTreeCollection(getContext(), view);
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
    public WageFoodOrganTreeCollection getWageFoodOrganTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getWageFoodOrganTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}