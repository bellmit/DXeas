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

public class YieldDataBaseTree extends TreeBase implements IYieldDataBaseTree
{
    public YieldDataBaseTree()
    {
        super();
        registerInterface(IYieldDataBaseTree.class, this);
    }
    public YieldDataBaseTree(Context ctx)
    {
        super(ctx);
        registerInterface(IYieldDataBaseTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("89E016A4");
    }
    private YieldDataBaseTreeController getController() throws BOSException
    {
        return (YieldDataBaseTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public YieldDataBaseTreeInfo getYieldDataBaseTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getYieldDataBaseTreeInfo(getContext(), pk);
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
    public YieldDataBaseTreeInfo getYieldDataBaseTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getYieldDataBaseTreeInfo(getContext(), pk, selector);
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
    public YieldDataBaseTreeInfo getYieldDataBaseTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getYieldDataBaseTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public YieldDataBaseTreeCollection getYieldDataBaseTreeCollection() throws BOSException
    {
        try {
            return getController().getYieldDataBaseTreeCollection(getContext());
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
    public YieldDataBaseTreeCollection getYieldDataBaseTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getYieldDataBaseTreeCollection(getContext(), view);
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
    public YieldDataBaseTreeCollection getYieldDataBaseTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getYieldDataBaseTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}