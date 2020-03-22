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

public class CheckItemTree extends TreeBase implements ICheckItemTree
{
    public CheckItemTree()
    {
        super();
        registerInterface(ICheckItemTree.class, this);
    }
    public CheckItemTree(Context ctx)
    {
        super(ctx);
        registerInterface(ICheckItemTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2B3012C8");
    }
    private CheckItemTreeController getController() throws BOSException
    {
        return (CheckItemTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public CheckItemTreeInfo getCheckItemTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckItemTreeInfo(getContext(), pk);
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
    public CheckItemTreeInfo getCheckItemTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckItemTreeInfo(getContext(), pk, selector);
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
    public CheckItemTreeInfo getCheckItemTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getCheckItemTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public CheckItemTreeCollection getCheckItemTreeCollection() throws BOSException
    {
        try {
            return getController().getCheckItemTreeCollection(getContext());
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
    public CheckItemTreeCollection getCheckItemTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getCheckItemTreeCollection(getContext(), view);
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
    public CheckItemTreeCollection getCheckItemTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getCheckItemTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}