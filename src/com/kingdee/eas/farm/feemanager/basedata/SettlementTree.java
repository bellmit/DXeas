package com.kingdee.eas.farm.feemanager.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.feemanager.basedata.app.*;
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
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SettlementTree extends TreeBase implements ISettlementTree
{
    public SettlementTree()
    {
        super();
        registerInterface(ISettlementTree.class, this);
    }
    public SettlementTree(Context ctx)
    {
        super(ctx);
        registerInterface(ISettlementTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6B65AF13");
    }
    private SettlementTreeController getController() throws BOSException
    {
        return (SettlementTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SettlementTreeInfo getSettlementTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlementTreeInfo(getContext(), pk);
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
    public SettlementTreeInfo getSettlementTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlementTreeInfo(getContext(), pk, selector);
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
    public SettlementTreeInfo getSettlementTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlementTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SettlementTreeCollection getSettlementTreeCollection() throws BOSException
    {
        try {
            return getController().getSettlementTreeCollection(getContext());
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
    public SettlementTreeCollection getSettlementTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSettlementTreeCollection(getContext(), view);
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
    public SettlementTreeCollection getSettlementTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getSettlementTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}