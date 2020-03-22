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

public class BrowerItemTree extends TreeBase implements IBrowerItemTree
{
    public BrowerItemTree()
    {
        super();
        registerInterface(IBrowerItemTree.class, this);
    }
    public BrowerItemTree(Context ctx)
    {
        super(ctx);
        registerInterface(IBrowerItemTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("9DC98378");
    }
    private BrowerItemTreeController getController() throws BOSException
    {
        return (BrowerItemTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BrowerItemTreeInfo getBrowerItemTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBrowerItemTreeInfo(getContext(), pk);
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
    public BrowerItemTreeInfo getBrowerItemTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBrowerItemTreeInfo(getContext(), pk, selector);
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
    public BrowerItemTreeInfo getBrowerItemTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBrowerItemTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BrowerItemTreeCollection getBrowerItemTreeCollection() throws BOSException
    {
        try {
            return getController().getBrowerItemTreeCollection(getContext());
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
    public BrowerItemTreeCollection getBrowerItemTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBrowerItemTreeCollection(getContext(), view);
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
    public BrowerItemTreeCollection getBrowerItemTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getBrowerItemTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}