package com.kingdee.eas.custom.salepayment;

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
import com.kingdee.eas.custom.salepayment.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AreaTargetTree extends TreeBase implements IAreaTargetTree
{
    public AreaTargetTree()
    {
        super();
        registerInterface(IAreaTargetTree.class, this);
    }
    public AreaTargetTree(Context ctx)
    {
        super(ctx);
        registerInterface(IAreaTargetTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("EFA25D30");
    }
    private AreaTargetTreeController getController() throws BOSException
    {
        return (AreaTargetTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AreaTargetTreeInfo getAreaTargetTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAreaTargetTreeInfo(getContext(), pk);
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
    public AreaTargetTreeInfo getAreaTargetTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAreaTargetTreeInfo(getContext(), pk, selector);
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
    public AreaTargetTreeInfo getAreaTargetTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAreaTargetTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AreaTargetTreeCollection getAreaTargetTreeCollection() throws BOSException
    {
        try {
            return getController().getAreaTargetTreeCollection(getContext());
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
    public AreaTargetTreeCollection getAreaTargetTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAreaTargetTreeCollection(getContext(), view);
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
    public AreaTargetTreeCollection getAreaTargetTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getAreaTargetTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}