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

public class RewardsPolicyTree extends TreeBase implements IRewardsPolicyTree
{
    public RewardsPolicyTree()
    {
        super();
        registerInterface(IRewardsPolicyTree.class, this);
    }
    public RewardsPolicyTree(Context ctx)
    {
        super(ctx);
        registerInterface(IRewardsPolicyTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("7C956B03");
    }
    private RewardsPolicyTreeController getController() throws BOSException
    {
        return (RewardsPolicyTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public RewardsPolicyTreeInfo getRewardsPolicyTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getRewardsPolicyTreeInfo(getContext(), pk);
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
    public RewardsPolicyTreeInfo getRewardsPolicyTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getRewardsPolicyTreeInfo(getContext(), pk, selector);
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
    public RewardsPolicyTreeInfo getRewardsPolicyTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getRewardsPolicyTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public RewardsPolicyTreeCollection getRewardsPolicyTreeCollection() throws BOSException
    {
        try {
            return getController().getRewardsPolicyTreeCollection(getContext());
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
    public RewardsPolicyTreeCollection getRewardsPolicyTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getRewardsPolicyTreeCollection(getContext(), view);
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
    public RewardsPolicyTreeCollection getRewardsPolicyTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getRewardsPolicyTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}