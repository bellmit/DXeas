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

public class DatabaseSettingTree extends TreeBase implements IDatabaseSettingTree
{
    public DatabaseSettingTree()
    {
        super();
        registerInterface(IDatabaseSettingTree.class, this);
    }
    public DatabaseSettingTree(Context ctx)
    {
        super(ctx);
        registerInterface(IDatabaseSettingTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("850BD0D0");
    }
    private DatabaseSettingTreeController getController() throws BOSException
    {
        return (DatabaseSettingTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DatabaseSettingTreeInfo getDatabaseSettingTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDatabaseSettingTreeInfo(getContext(), pk);
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
    public DatabaseSettingTreeInfo getDatabaseSettingTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDatabaseSettingTreeInfo(getContext(), pk, selector);
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
    public DatabaseSettingTreeInfo getDatabaseSettingTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDatabaseSettingTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DatabaseSettingTreeCollection getDatabaseSettingTreeCollection() throws BOSException
    {
        try {
            return getController().getDatabaseSettingTreeCollection(getContext());
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
    public DatabaseSettingTreeCollection getDatabaseSettingTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDatabaseSettingTreeCollection(getContext(), view);
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
    public DatabaseSettingTreeCollection getDatabaseSettingTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDatabaseSettingTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}