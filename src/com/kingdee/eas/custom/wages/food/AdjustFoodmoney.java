package com.kingdee.eas.custom.wages.food;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.custom.wages.food.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class AdjustFoodmoney extends CoreBillBase implements IAdjustFoodmoney
{
    public AdjustFoodmoney()
    {
        super();
        registerInterface(IAdjustFoodmoney.class, this);
    }
    public AdjustFoodmoney(Context ctx)
    {
        super(ctx);
        registerInterface(IAdjustFoodmoney.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("F07F5F11");
    }
    private AdjustFoodmoneyController getController() throws BOSException
    {
        return (AdjustFoodmoneyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public AdjustFoodmoneyCollection getAdjustFoodmoneyCollection() throws BOSException
    {
        try {
            return getController().getAdjustFoodmoneyCollection(getContext());
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
    public AdjustFoodmoneyCollection getAdjustFoodmoneyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getAdjustFoodmoneyCollection(getContext(), view);
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
    public AdjustFoodmoneyCollection getAdjustFoodmoneyCollection(String oql) throws BOSException
    {
        try {
            return getController().getAdjustFoodmoneyCollection(getContext(), oql);
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
    public AdjustFoodmoneyInfo getAdjustFoodmoneyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustFoodmoneyInfo(getContext(), pk);
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
    public AdjustFoodmoneyInfo getAdjustFoodmoneyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustFoodmoneyInfo(getContext(), pk, selector);
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
    public AdjustFoodmoneyInfo getAdjustFoodmoneyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getAdjustFoodmoneyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(AdjustFoodmoneyInfo model) throws BOSException
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
    public void unaudit(AdjustFoodmoneyInfo model) throws BOSException
    {
        try {
            getController().unaudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}