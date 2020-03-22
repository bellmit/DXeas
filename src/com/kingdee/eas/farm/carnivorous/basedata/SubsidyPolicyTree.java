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

public class SubsidyPolicyTree extends TreeBase implements ISubsidyPolicyTree
{
    public SubsidyPolicyTree()
    {
        super();
        registerInterface(ISubsidyPolicyTree.class, this);
    }
    public SubsidyPolicyTree(Context ctx)
    {
        super(ctx);
        registerInterface(ISubsidyPolicyTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("45C7C899");
    }
    private SubsidyPolicyTreeController getController() throws BOSException
    {
        return (SubsidyPolicyTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SubsidyPolicyTreeInfo getSubsidyPolicyTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSubsidyPolicyTreeInfo(getContext(), pk);
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
    public SubsidyPolicyTreeInfo getSubsidyPolicyTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSubsidyPolicyTreeInfo(getContext(), pk, selector);
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
    public SubsidyPolicyTreeInfo getSubsidyPolicyTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSubsidyPolicyTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SubsidyPolicyTreeCollection getSubsidyPolicyTreeCollection() throws BOSException
    {
        try {
            return getController().getSubsidyPolicyTreeCollection(getContext());
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
    public SubsidyPolicyTreeCollection getSubsidyPolicyTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSubsidyPolicyTreeCollection(getContext(), view);
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
    public SubsidyPolicyTreeCollection getSubsidyPolicyTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getSubsidyPolicyTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}