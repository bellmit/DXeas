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

public class BaseDataRelTree extends TreeBase implements IBaseDataRelTree
{
    public BaseDataRelTree()
    {
        super();
        registerInterface(IBaseDataRelTree.class, this);
    }
    public BaseDataRelTree(Context ctx)
    {
        super(ctx);
        registerInterface(IBaseDataRelTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A5596903");
    }
    private BaseDataRelTreeController getController() throws BOSException
    {
        return (BaseDataRelTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BaseDataRelTreeInfo getBaseDataRelTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseDataRelTreeInfo(getContext(), pk);
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
    public BaseDataRelTreeInfo getBaseDataRelTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseDataRelTreeInfo(getContext(), pk, selector);
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
    public BaseDataRelTreeInfo getBaseDataRelTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBaseDataRelTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BaseDataRelTreeCollection getBaseDataRelTreeCollection() throws BOSException
    {
        try {
            return getController().getBaseDataRelTreeCollection(getContext());
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
    public BaseDataRelTreeCollection getBaseDataRelTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBaseDataRelTreeCollection(getContext(), view);
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
    public BaseDataRelTreeCollection getBaseDataRelTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getBaseDataRelTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}