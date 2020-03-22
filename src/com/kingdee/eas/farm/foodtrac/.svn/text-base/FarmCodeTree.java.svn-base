package com.kingdee.eas.farm.foodtrac;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.farm.foodtrac.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FarmCodeTree extends TreeBase implements IFarmCodeTree
{
    public FarmCodeTree()
    {
        super();
        registerInterface(IFarmCodeTree.class, this);
    }
    public FarmCodeTree(Context ctx)
    {
        super(ctx);
        registerInterface(IFarmCodeTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6F0B6C8B");
    }
    private FarmCodeTreeController getController() throws BOSException
    {
        return (FarmCodeTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FarmCodeTreeInfo getFarmCodeTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmCodeTreeInfo(getContext(), pk);
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
    public FarmCodeTreeInfo getFarmCodeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmCodeTreeInfo(getContext(), pk, selector);
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
    public FarmCodeTreeInfo getFarmCodeTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFarmCodeTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FarmCodeTreeCollection getFarmCodeTreeCollection() throws BOSException
    {
        try {
            return getController().getFarmCodeTreeCollection(getContext());
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
    public FarmCodeTreeCollection getFarmCodeTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFarmCodeTreeCollection(getContext(), view);
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
    public FarmCodeTreeCollection getFarmCodeTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getFarmCodeTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}