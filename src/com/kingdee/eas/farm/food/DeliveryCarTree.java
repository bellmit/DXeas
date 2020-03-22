package com.kingdee.eas.farm.food;

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
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DeliveryCarTree extends TreeBase implements IDeliveryCarTree
{
    public DeliveryCarTree()
    {
        super();
        registerInterface(IDeliveryCarTree.class, this);
    }
    public DeliveryCarTree(Context ctx)
    {
        super(ctx);
        registerInterface(IDeliveryCarTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("88F0B914");
    }
    private DeliveryCarTreeController getController() throws BOSException
    {
        return (DeliveryCarTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DeliveryCarTreeInfo getDeliveryCarTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryCarTreeInfo(getContext(), pk);
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
    public DeliveryCarTreeInfo getDeliveryCarTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryCarTreeInfo(getContext(), pk, selector);
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
    public DeliveryCarTreeInfo getDeliveryCarTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryCarTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DeliveryCarTreeCollection getDeliveryCarTreeCollection() throws BOSException
    {
        try {
            return getController().getDeliveryCarTreeCollection(getContext());
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
    public DeliveryCarTreeCollection getDeliveryCarTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDeliveryCarTreeCollection(getContext(), view);
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
    public DeliveryCarTreeCollection getDeliveryCarTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getDeliveryCarTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}