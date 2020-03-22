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

public class SubsidyTree extends TreeBase implements ISubsidyTree
{
    public SubsidyTree()
    {
        super();
        registerInterface(ISubsidyTree.class, this);
    }
    public SubsidyTree(Context ctx)
    {
        super(ctx);
        registerInterface(ISubsidyTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("4C1C0DF8");
    }
    private SubsidyTreeController getController() throws BOSException
    {
        return (SubsidyTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SubsidyTreeInfo getSubsidyTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSubsidyTreeInfo(getContext(), pk);
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
    public SubsidyTreeInfo getSubsidyTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSubsidyTreeInfo(getContext(), pk, selector);
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
    public SubsidyTreeInfo getSubsidyTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSubsidyTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SubsidyTreeCollection getSubsidyTreeCollection() throws BOSException
    {
        try {
            return getController().getSubsidyTreeCollection(getContext());
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
    public SubsidyTreeCollection getSubsidyTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSubsidyTreeCollection(getContext(), view);
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
    public SubsidyTreeCollection getSubsidyTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getSubsidyTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}