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

public class StockingBRelationTree extends TreeBase implements IStockingBRelationTree
{
    public StockingBRelationTree()
    {
        super();
        registerInterface(IStockingBRelationTree.class, this);
    }
    public StockingBRelationTree(Context ctx)
    {
        super(ctx);
        registerInterface(IStockingBRelationTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("5F1948DF");
    }
    private StockingBRelationTreeController getController() throws BOSException
    {
        return (StockingBRelationTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public StockingBRelationTreeInfo getStockingBRelationTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBRelationTreeInfo(getContext(), pk);
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
    public StockingBRelationTreeInfo getStockingBRelationTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBRelationTreeInfo(getContext(), pk, selector);
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
    public StockingBRelationTreeInfo getStockingBRelationTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBRelationTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StockingBRelationTreeCollection getStockingBRelationTreeCollection() throws BOSException
    {
        try {
            return getController().getStockingBRelationTreeCollection(getContext());
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
    public StockingBRelationTreeCollection getStockingBRelationTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStockingBRelationTreeCollection(getContext(), view);
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
    public StockingBRelationTreeCollection getStockingBRelationTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getStockingBRelationTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}