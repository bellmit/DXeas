package com.kingdee.eas.publicdata;

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
import com.kingdee.eas.publicdata.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class CardRelationTree extends TreeBase implements ICardRelationTree
{
    public CardRelationTree()
    {
        super();
        registerInterface(ICardRelationTree.class, this);
    }
    public CardRelationTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICardRelationTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("73EAB4CD");
    }
    private CardRelationTreeController getController() throws BOSException
    {
        return (CardRelationTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CardRelationTreeInfo getCardRelationTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCardRelationTreeInfo(getContext(), pk);
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
    public CardRelationTreeInfo getCardRelationTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCardRelationTreeInfo(getContext(), pk, selector);
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
    public CardRelationTreeInfo getCardRelationTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCardRelationTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CardRelationTreeCollection getCardRelationTreeCollection() throws BOSException
    {
        try {
            return getController().getCardRelationTreeCollection(getContext());
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
    public CardRelationTreeCollection getCardRelationTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCardRelationTreeCollection(getContext(), view);
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
    public CardRelationTreeCollection getCardRelationTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCardRelationTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}