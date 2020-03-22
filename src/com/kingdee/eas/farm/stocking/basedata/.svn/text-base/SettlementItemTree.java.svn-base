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

public class SettlementItemTree extends TreeBase implements ISettlementItemTree
{
    public SettlementItemTree()
    {
        super();
        registerInterface(ISettlementItemTree.class, this);
    }
    public SettlementItemTree(Context ctx)
    {
        super(ctx);
        registerInterface(ISettlementItemTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("A1567EAB");
    }
    private SettlementItemTreeController getController() throws BOSException
    {
        return (SettlementItemTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SettlementItemTreeInfo getSettlementItemTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlementItemTreeInfo(getContext(), pk);
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
    public SettlementItemTreeInfo getSettlementItemTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlementItemTreeInfo(getContext(), pk, selector);
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
    public SettlementItemTreeInfo getSettlementItemTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlementItemTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SettlementItemTreeCollection getSettlementItemTreeCollection() throws BOSException
    {
        try {
            return getController().getSettlementItemTreeCollection(getContext());
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
    public SettlementItemTreeCollection getSettlementItemTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSettlementItemTreeCollection(getContext(), view);
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
    public SettlementItemTreeCollection getSettlementItemTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getSettlementItemTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}