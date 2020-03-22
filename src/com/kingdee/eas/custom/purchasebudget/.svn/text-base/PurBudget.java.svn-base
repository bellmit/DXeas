package com.kingdee.eas.custom.purchasebudget;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.eas.framework.CoreBillBase;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.framework.ICoreBillBase;
import com.kingdee.bos.Context;
import com.kingdee.eas.custom.purchasebudget.app.*;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class PurBudget extends CoreBillBase implements IPurBudget
{
    public PurBudget()
    {
        super();
        registerInterface(IPurBudget.class, this);
    }
    public PurBudget(Context ctx)
    {
        super(ctx);
        registerInterface(IPurBudget.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8E873495");
    }
    private PurBudgetController getController() throws BOSException
    {
        return (PurBudgetController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public PurBudgetCollection getPurBudgetCollection() throws BOSException
    {
        try {
            return getController().getPurBudgetCollection(getContext());
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
    public PurBudgetCollection getPurBudgetCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getPurBudgetCollection(getContext(), view);
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
    public PurBudgetCollection getPurBudgetCollection(String oql) throws BOSException
    {
        try {
            return getController().getPurBudgetCollection(getContext(), oql);
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
    public PurBudgetInfo getPurBudgetInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getPurBudgetInfo(getContext(), pk);
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
    public PurBudgetInfo getPurBudgetInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getPurBudgetInfo(getContext(), pk, selector);
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
    public PurBudgetInfo getPurBudgetInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getPurBudgetInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(PurBudgetInfo model) throws BOSException, EASBizException
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
    public void unAudit(PurBudgetInfo model) throws BOSException, EASBizException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *设置审批不通过-User defined method
     *@param model model
     */
    public void noPass(PurBudgetInfo model) throws BOSException, EASBizException
    {
        try {
            getController().noPass(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *导入-User defined method
     *@param model model
     */
    public void importFormExcel(PurBudgetInfo model) throws BOSException
    {
        try {
            getController().importFormExcel(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}