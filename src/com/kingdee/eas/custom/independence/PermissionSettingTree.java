package com.kingdee.eas.custom.independence;

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
import com.kingdee.eas.custom.independence.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PermissionSettingTree extends TreeBase implements IPermissionSettingTree
{
    public PermissionSettingTree()
    {
        super();
        registerInterface(IPermissionSettingTree.class, this);
    }
    public PermissionSettingTree(Context ctx)
    {
        super(ctx);
        registerInterface(IPermissionSettingTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C32A6538");
    }
    private PermissionSettingTreeController getController() throws BOSException
    {
        return (PermissionSettingTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public PermissionSettingTreeInfo getPermissionSettingTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPermissionSettingTreeInfo(getContext(), pk);
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
    public PermissionSettingTreeInfo getPermissionSettingTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPermissionSettingTreeInfo(getContext(), pk, selector);
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
    public PermissionSettingTreeInfo getPermissionSettingTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPermissionSettingTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PermissionSettingTreeCollection getPermissionSettingTreeCollection() throws BOSException
    {
        try {
            return getController().getPermissionSettingTreeCollection(getContext());
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
    public PermissionSettingTreeCollection getPermissionSettingTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPermissionSettingTreeCollection(getContext(), view);
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
    public PermissionSettingTreeCollection getPermissionSettingTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getPermissionSettingTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}