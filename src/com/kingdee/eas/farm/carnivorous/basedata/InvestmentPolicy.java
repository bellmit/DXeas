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

public class InvestmentPolicy extends DataBase implements IInvestmentPolicy
{
    public InvestmentPolicy()
    {
        super();
        registerInterface(IInvestmentPolicy.class, this);
    }
    public InvestmentPolicy(Context ctx)
    {
        super(ctx);
        registerInterface(IInvestmentPolicy.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("CEEDA787");
    }
    private InvestmentPolicyController getController() throws BOSException
    {
        return (InvestmentPolicyController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public InvestmentPolicyInfo getInvestmentPolicyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getInvestmentPolicyInfo(getContext(), pk);
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
    public InvestmentPolicyInfo getInvestmentPolicyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getInvestmentPolicyInfo(getContext(), pk, selector);
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
    public InvestmentPolicyInfo getInvestmentPolicyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getInvestmentPolicyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public InvestmentPolicyCollection getInvestmentPolicyCollection() throws BOSException
    {
        try {
            return getController().getInvestmentPolicyCollection(getContext());
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
    public InvestmentPolicyCollection getInvestmentPolicyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getInvestmentPolicyCollection(getContext(), view);
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
    public InvestmentPolicyCollection getInvestmentPolicyCollection(String oql) throws BOSException
    {
        try {
            return getController().getInvestmentPolicyCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(InvestmentPolicyInfo model) throws BOSException, EASBizException
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
    public void unAudit(InvestmentPolicyInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}