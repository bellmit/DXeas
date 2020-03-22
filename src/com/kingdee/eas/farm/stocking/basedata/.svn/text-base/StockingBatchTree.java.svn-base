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

public class StockingBatchTree extends TreeBase implements IStockingBatchTree
{
    public StockingBatchTree()
    {
        super();
        registerInterface(IStockingBatchTree.class, this);
    }
    public StockingBatchTree(Context ctx)
    {
        super(ctx);
        registerInterface(IStockingBatchTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("62F0CF1B");
    }
    private StockingBatchTreeController getController() throws BOSException
    {
        return (StockingBatchTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public StockingBatchTreeInfo getStockingBatchTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBatchTreeInfo(getContext(), pk);
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
    public StockingBatchTreeInfo getStockingBatchTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBatchTreeInfo(getContext(), pk, selector);
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
    public StockingBatchTreeInfo getStockingBatchTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getStockingBatchTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public StockingBatchTreeCollection getStockingBatchTreeCollection() throws BOSException
    {
        try {
            return getController().getStockingBatchTreeCollection(getContext());
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
    public StockingBatchTreeCollection getStockingBatchTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getStockingBatchTreeCollection(getContext(), view);
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
    public StockingBatchTreeCollection getStockingBatchTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getStockingBatchTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}