package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class MarginTypeTree extends TreeBase implements IMarginTypeTree
{
    public MarginTypeTree()
    {
        super();
        registerInterface(IMarginTypeTree.class, this);
    }
    public MarginTypeTree(Context ctx)
    {
        super(ctx);
        registerInterface(IMarginTypeTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F0A7FF57");
    }
    private MarginTypeTreeController getController() throws BOSException
    {
        return (MarginTypeTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MarginTypeTreeInfo getMarginTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginTypeTreeInfo(getContext(), pk);
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
    public MarginTypeTreeInfo getMarginTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginTypeTreeInfo(getContext(), pk, selector);
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
    public MarginTypeTreeInfo getMarginTypeTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginTypeTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MarginTypeTreeCollection getMarginTypeTreeCollection() throws BOSException
    {
        try {
            return getController().getMarginTypeTreeCollection(getContext());
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
    public MarginTypeTreeCollection getMarginTypeTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMarginTypeTreeCollection(getContext(), view);
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
    public MarginTypeTreeCollection getMarginTypeTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getMarginTypeTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}