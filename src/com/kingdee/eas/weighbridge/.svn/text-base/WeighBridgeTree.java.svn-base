package com.kingdee.eas.weighbridge;

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
import com.kingdee.eas.weighbridge.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class WeighBridgeTree extends TreeBase implements IWeighBridgeTree
{
    public WeighBridgeTree()
    {
        super();
        registerInterface(IWeighBridgeTree.class, this);
    }
    public WeighBridgeTree(Context ctx)
    {
        super(ctx);
        registerInterface(IWeighBridgeTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("DEC58428");
    }
    private WeighBridgeTreeController getController() throws BOSException
    {
        return (WeighBridgeTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public WeighBridgeTreeInfo getWeighBridgeTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getWeighBridgeTreeInfo(getContext(), pk);
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
    public WeighBridgeTreeInfo getWeighBridgeTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getWeighBridgeTreeInfo(getContext(), pk, selector);
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
    public WeighBridgeTreeInfo getWeighBridgeTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getWeighBridgeTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public WeighBridgeTreeCollection getWeighBridgeTreeCollection() throws BOSException
    {
        try {
            return getController().getWeighBridgeTreeCollection(getContext());
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
    public WeighBridgeTreeCollection getWeighBridgeTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getWeighBridgeTreeCollection(getContext(), view);
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
    public WeighBridgeTreeCollection getWeighBridgeTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getWeighBridgeTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}