package com.kingdee.eas.custom.tocloud;

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
import com.kingdee.eas.custom.tocloud.app.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BizTypeTree extends TreeBase implements IBizTypeTree
{
    public BizTypeTree()
    {
        super();
        registerInterface(IBizTypeTree.class, this);
    }
    public BizTypeTree(Context ctx)
    {
        super(ctx);
        registerInterface(IBizTypeTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("D467A772");
    }
    private BizTypeTreeController getController() throws BOSException
    {
        return (BizTypeTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BizTypeTreeInfo getBizTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBizTypeTreeInfo(getContext(), pk);
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
    public BizTypeTreeInfo getBizTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBizTypeTreeInfo(getContext(), pk, selector);
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
    public BizTypeTreeInfo getBizTypeTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBizTypeTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BizTypeTreeCollection getBizTypeTreeCollection() throws BOSException
    {
        try {
            return getController().getBizTypeTreeCollection(getContext());
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
    public BizTypeTreeCollection getBizTypeTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBizTypeTreeCollection(getContext(), view);
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
    public BizTypeTreeCollection getBizTypeTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getBizTypeTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}