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

public class BSXBudgetFood extends CoreBillBase implements IBSXBudgetFood
{
    public BSXBudgetFood()
    {
        super();
        registerInterface(IBSXBudgetFood.class, this);
    }
    public BSXBudgetFood(Context ctx)
    {
        super(ctx);
        registerInterface(IBSXBudgetFood.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("855505A3");
    }
    private BSXBudgetFoodController getController() throws BOSException
    {
        return (BSXBudgetFoodController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BSXBudgetFoodCollection getBSXBudgetFoodCollection() throws BOSException
    {
        try {
            return getController().getBSXBudgetFoodCollection(getContext());
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
    public BSXBudgetFoodCollection getBSXBudgetFoodCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBSXBudgetFoodCollection(getContext(), view);
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
    public BSXBudgetFoodCollection getBSXBudgetFoodCollection(String oql) throws BOSException
    {
        try {
            return getController().getBSXBudgetFoodCollection(getContext(), oql);
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
    public BSXBudgetFoodInfo getBSXBudgetFoodInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBSXBudgetFoodInfo(getContext(), pk);
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
    public BSXBudgetFoodInfo getBSXBudgetFoodInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBSXBudgetFoodInfo(getContext(), pk, selector);
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
    public BSXBudgetFoodInfo getBSXBudgetFoodInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBSXBudgetFoodInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BSXBudgetFoodInfo model) throws BOSException, EASBizException
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
    public void unAudit(BSXBudgetFoodInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}