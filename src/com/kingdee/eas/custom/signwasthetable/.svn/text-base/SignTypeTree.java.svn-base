package com.kingdee.eas.custom.signwasthetable;

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
import com.kingdee.eas.custom.signwasthetable.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SignTypeTree extends TreeBase implements ISignTypeTree
{
    public SignTypeTree()
    {
        super();
        registerInterface(ISignTypeTree.class, this);
    }
    public SignTypeTree(Context ctx)
    {
        super(ctx);
        registerInterface(ISignTypeTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("184B7ADF");
    }
    private SignTypeTreeController getController() throws BOSException
    {
        return (SignTypeTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SignTypeTreeInfo getSignTypeTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSignTypeTreeInfo(getContext(), pk);
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
    public SignTypeTreeInfo getSignTypeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSignTypeTreeInfo(getContext(), pk, selector);
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
    public SignTypeTreeInfo getSignTypeTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSignTypeTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SignTypeTreeCollection getSignTypeTreeCollection() throws BOSException
    {
        try {
            return getController().getSignTypeTreeCollection(getContext());
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
    public SignTypeTreeCollection getSignTypeTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSignTypeTreeCollection(getContext(), view);
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
    public SignTypeTreeCollection getSignTypeTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getSignTypeTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}