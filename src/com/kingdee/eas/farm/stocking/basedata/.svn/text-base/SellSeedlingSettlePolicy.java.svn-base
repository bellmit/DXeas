package com.kingdee.eas.farm.stocking.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.eas.farm.stocking.basedata.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class SellSeedlingSettlePolicy extends DataBase implements ISellSeedlingSettlePolicy
{
    public SellSeedlingSettlePolicy()
    {
        super();
        registerInterface(ISellSeedlingSettlePolicy.class, this);
    }
    public SellSeedlingSettlePolicy(Context ctx)
    {
        super(ctx);
        registerInterface(ISellSeedlingSettlePolicy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("91B14CA7");
    }
    private SellSeedlingSettlePolicyController getController() throws BOSException
    {
        return (SellSeedlingSettlePolicyController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SellSeedlingSettlePolicyInfo getSellSeedlingSettlePolicyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSellSeedlingSettlePolicyInfo(getContext(), pk);
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
    public SellSeedlingSettlePolicyInfo getSellSeedlingSettlePolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSellSeedlingSettlePolicyInfo(getContext(), pk, selector);
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
    public SellSeedlingSettlePolicyInfo getSellSeedlingSettlePolicyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSellSeedlingSettlePolicyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SellSeedlingSettlePolicyCollection getSellSeedlingSettlePolicyCollection() throws BOSException
    {
        try {
            return getController().getSellSeedlingSettlePolicyCollection(getContext());
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
    public SellSeedlingSettlePolicyCollection getSellSeedlingSettlePolicyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSellSeedlingSettlePolicyCollection(getContext(), view);
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
    public SellSeedlingSettlePolicyCollection getSellSeedlingSettlePolicyCollection(String oql) throws BOSException
    {
        try {
            return getController().getSellSeedlingSettlePolicyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(SellSeedlingSettlePolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反核准-User defined method
     *@param model model
     */
    public void unAudit(SellSeedlingSettlePolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}