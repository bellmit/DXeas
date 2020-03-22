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

public class TargetSystemTree extends TreeBase implements ITargetSystemTree
{
    public TargetSystemTree()
    {
        super();
        registerInterface(ITargetSystemTree.class, this);
    }
    public TargetSystemTree(Context ctx)
    {
        super(ctx);
        registerInterface(ITargetSystemTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C3F52BF7");
    }
    private TargetSystemTreeController getController() throws BOSException
    {
        return (TargetSystemTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public TargetSystemTreeInfo getTargetSystemTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getTargetSystemTreeInfo(getContext(), pk);
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
    public TargetSystemTreeInfo getTargetSystemTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getTargetSystemTreeInfo(getContext(), pk, selector);
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
    public TargetSystemTreeInfo getTargetSystemTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getTargetSystemTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public TargetSystemTreeCollection getTargetSystemTreeCollection() throws BOSException
    {
        try {
            return getController().getTargetSystemTreeCollection(getContext());
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
    public TargetSystemTreeCollection getTargetSystemTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getTargetSystemTreeCollection(getContext(), view);
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
    public TargetSystemTreeCollection getTargetSystemTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getTargetSystemTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}