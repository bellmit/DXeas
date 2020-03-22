package com.kingdee.eas.custom.taihe.contract;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.custom.taihe.contract.app.*;
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

public class AssureAmtPolicy extends DataBase implements IAssureAmtPolicy
{
    public AssureAmtPolicy()
    {
        super();
        registerInterface(IAssureAmtPolicy.class, this);
    }
    public AssureAmtPolicy(Context ctx)
    {
        super(ctx);
        registerInterface(IAssureAmtPolicy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8D77C2F7");
    }
    private AssureAmtPolicyController getController() throws BOSException
    {
        return (AssureAmtPolicyController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public AssureAmtPolicyInfo getAssureAmtPolicyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAssureAmtPolicyInfo(getContext(), pk);
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
    public AssureAmtPolicyInfo getAssureAmtPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAssureAmtPolicyInfo(getContext(), pk, selector);
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
    public AssureAmtPolicyInfo getAssureAmtPolicyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAssureAmtPolicyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AssureAmtPolicyCollection getAssureAmtPolicyCollection() throws BOSException
    {
        try {
            return getController().getAssureAmtPolicyCollection(getContext());
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
    public AssureAmtPolicyCollection getAssureAmtPolicyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAssureAmtPolicyCollection(getContext(), view);
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
    public AssureAmtPolicyCollection getAssureAmtPolicyCollection(String oql) throws BOSException
    {
        try {
            return getController().getAssureAmtPolicyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(AssureAmtPolicyInfo model) throws BOSException
    {
        try {
            getController().audit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *反审核-User defined method
     *@param model model
     */
    public void unAudit(AssureAmtPolicyInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}