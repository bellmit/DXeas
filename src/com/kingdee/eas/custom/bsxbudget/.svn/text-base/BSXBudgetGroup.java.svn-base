package com.kingdee.eas.custom.bsxbudget;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.bsxbudget.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BSXBudgetGroup extends CoreBillBase implements IBSXBudgetGroup
{
    public BSXBudgetGroup()
    {
        super();
        registerInterface(IBSXBudgetGroup.class, this);
    }
    public BSXBudgetGroup(Context ctx)
    {
        super(ctx);
        registerInterface(IBSXBudgetGroup.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("255B25DA");
    }
    private BSXBudgetGroupController getController() throws BOSException
    {
        return (BSXBudgetGroupController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BSXBudgetGroupCollection getBSXBudgetGroupCollection() throws BOSException
    {
        try {
            return getController().getBSXBudgetGroupCollection(getContext());
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
    public BSXBudgetGroupCollection getBSXBudgetGroupCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBSXBudgetGroupCollection(getContext(), view);
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
    public BSXBudgetGroupCollection getBSXBudgetGroupCollection(String oql) throws BOSException
    {
        try {
            return getController().getBSXBudgetGroupCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BSXBudgetGroupInfo getBSXBudgetGroupInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBSXBudgetGroupInfo(getContext(), pk);
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
    public BSXBudgetGroupInfo getBSXBudgetGroupInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBSXBudgetGroupInfo(getContext(), pk, selector);
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
    public BSXBudgetGroupInfo getBSXBudgetGroupInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBSXBudgetGroupInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BSXBudgetGroupInfo model) throws BOSException, EASBizException
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
    public void unAudit(BSXBudgetGroupInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}