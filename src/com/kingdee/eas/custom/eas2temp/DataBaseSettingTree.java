package com.kingdee.eas.custom.eas2temp;

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
import com.kingdee.eas.custom.eas2temp.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DataBaseSettingTree extends TreeBase implements IDataBaseSettingTree
{
    public DataBaseSettingTree()
    {
        super();
        registerInterface(IDataBaseSettingTree.class, this);
    }
    public DataBaseSettingTree(Context ctx)
    {
        super(ctx);
        registerInterface(IDataBaseSettingTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5F5A871F");
    }
    private DataBaseSettingTreeController getController() throws BOSException
    {
        return (DataBaseSettingTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DataBaseSettingTreeInfo getDataBaseSettingTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDataBaseSettingTreeInfo(getContext(), pk);
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
    public DataBaseSettingTreeInfo getDataBaseSettingTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDataBaseSettingTreeInfo(getContext(), pk, selector);
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
    public DataBaseSettingTreeInfo getDataBaseSettingTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDataBaseSettingTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DataBaseSettingTreeCollection getDataBaseSettingTreeCollection() throws BOSException
    {
        try {
            return getController().getDataBaseSettingTreeCollection(getContext());
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
    public DataBaseSettingTreeCollection getDataBaseSettingTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDataBaseSettingTreeCollection(getContext(), view);
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
    public DataBaseSettingTreeCollection getDataBaseSettingTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDataBaseSettingTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}