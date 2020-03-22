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

public class MarginPolicyTree extends TreeBase implements IMarginPolicyTree
{
    public MarginPolicyTree()
    {
        super();
        registerInterface(IMarginPolicyTree.class, this);
    }
    public MarginPolicyTree(Context ctx)
    {
        super(ctx);
        registerInterface(IMarginPolicyTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("79F4D1E0");
    }
    private MarginPolicyTreeController getController() throws BOSException
    {
        return (MarginPolicyTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public MarginPolicyTreeInfo getMarginPolicyTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginPolicyTreeInfo(getContext(), pk);
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
    public MarginPolicyTreeInfo getMarginPolicyTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginPolicyTreeInfo(getContext(), pk, selector);
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
    public MarginPolicyTreeInfo getMarginPolicyTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getMarginPolicyTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public MarginPolicyTreeCollection getMarginPolicyTreeCollection() throws BOSException
    {
        try {
            return getController().getMarginPolicyTreeCollection(getContext());
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
    public MarginPolicyTreeCollection getMarginPolicyTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getMarginPolicyTreeCollection(getContext(), view);
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
    public MarginPolicyTreeCollection getMarginPolicyTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getMarginPolicyTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}