package com.kingdee.eas.farm.carnivorous.basedata;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.farm.carnivorous.basedata.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
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

public class SettlePolicy extends DataBase implements ISettlePolicy
{
    public SettlePolicy()
    {
        super();
        registerInterface(ISettlePolicy.class, this);
    }
    public SettlePolicy(Context ctx)
    {
        super(ctx);
        registerInterface(ISettlePolicy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("E1DFECFF");
    }
    private SettlePolicyController getController() throws BOSException
    {
        return (SettlePolicyController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public SettlePolicyInfo getSettlePolicyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlePolicyInfo(getContext(), pk);
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
    public SettlePolicyInfo getSettlePolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlePolicyInfo(getContext(), pk, selector);
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
    public SettlePolicyInfo getSettlePolicyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getSettlePolicyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public SettlePolicyCollection getSettlePolicyCollection() throws BOSException
    {
        try {
            return getController().getSettlePolicyCollection(getContext());
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
    public SettlePolicyCollection getSettlePolicyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getSettlePolicyCollection(getContext(), view);
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
    public SettlePolicyCollection getSettlePolicyCollection(String oql) throws BOSException
    {
        try {
            return getController().getSettlePolicyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *是否模板-User defined method
     *@param model model
     */
    public void isTemplate(SettlePolicyInfo model) throws BOSException
    {
        try {
            getController().isTemplate(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *核准-User defined method
     *@param model model
     */
    public void audit(SettlePolicyInfo model) throws BOSException, EASBizException
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
    public void unAudit(SettlePolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批量更新-User defined method
     *@param model model
     */
    public void mulUpdate(SettlePolicyInfo model) throws BOSException
    {
        try {
            getController().mulUpdate(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}