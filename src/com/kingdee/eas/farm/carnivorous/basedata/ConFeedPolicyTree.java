package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.framework.ITreeBase;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.TreeBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ConFeedPolicyTree extends TreeBase implements IConFeedPolicyTree
{
    public ConFeedPolicyTree()
    {
        super();
        registerInterface(IConFeedPolicyTree.class, this);
    }
    public ConFeedPolicyTree(Context ctx)
    {
        super(ctx);
        registerInterface(IConFeedPolicyTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8AEE20EE");
    }
    private ConFeedPolicyTreeController getController() throws BOSException
    {
        return (ConFeedPolicyTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public ConFeedPolicyTreeInfo getConFeedPolicyTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getConFeedPolicyTreeInfo(getContext(), pk);
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
    public ConFeedPolicyTreeInfo getConFeedPolicyTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getConFeedPolicyTreeInfo(getContext(), pk, selector);
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
    public ConFeedPolicyTreeInfo getConFeedPolicyTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getConFeedPolicyTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ConFeedPolicyTreeCollection getConFeedPolicyTreeCollection() throws BOSException
    {
        try {
            return getController().getConFeedPolicyTreeCollection(getContext());
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
    public ConFeedPolicyTreeCollection getConFeedPolicyTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getConFeedPolicyTreeCollection(getContext(), view);
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
    public ConFeedPolicyTreeCollection getConFeedPolicyTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getConFeedPolicyTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}