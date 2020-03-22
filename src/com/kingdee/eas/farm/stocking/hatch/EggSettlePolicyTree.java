package com.kingdee.eas.farm.stocking.hatch;

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
import com.kingdee.eas.farm.stocking.hatch.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class EggSettlePolicyTree extends TreeBase implements IEggSettlePolicyTree
{
    public EggSettlePolicyTree()
    {
        super();
        registerInterface(IEggSettlePolicyTree.class, this);
    }
    public EggSettlePolicyTree(Context ctx)
    {
        super(ctx);
        registerInterface(IEggSettlePolicyTree.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8A7DA196");
    }
    private EggSettlePolicyTreeController getController() throws BOSException
    {
        return (EggSettlePolicyTreeController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public EggSettlePolicyTreeInfo getEggSettlePolicyTreeInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettlePolicyTreeInfo(getContext(), pk);
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
    public EggSettlePolicyTreeInfo getEggSettlePolicyTreeInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettlePolicyTreeInfo(getContext(), pk, selector);
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
    public EggSettlePolicyTreeInfo getEggSettlePolicyTreeInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getEggSettlePolicyTreeInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public EggSettlePolicyTreeCollection getEggSettlePolicyTreeCollection() throws BOSException
    {
        try {
            return getController().getEggSettlePolicyTreeCollection(getContext());
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
    public EggSettlePolicyTreeCollection getEggSettlePolicyTreeCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getEggSettlePolicyTreeCollection(getContext(), view);
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
    public EggSettlePolicyTreeCollection getEggSettlePolicyTreeCollection(String oql) throws BOSException
    {
        try {
            return getController().getEggSettlePolicyTreeCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}