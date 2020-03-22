package com.kingdee.eas.farm.breed.brood;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.farm.breed.brood.app.*;
import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.util.List;
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

public class BroodDaily extends CoreBillBase implements IBroodDaily
{
    public BroodDaily()
    {
        super();
        registerInterface(IBroodDaily.class, this);
    }
    public BroodDaily(Context ctx)
    {
        super(ctx);
        registerInterface(IBroodDaily.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("AD159A59");
    }
    private BroodDailyController getController() throws BOSException
    {
        return (BroodDailyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BroodDailyCollection getBroodDailyCollection() throws BOSException
    {
        try {
            return getController().getBroodDailyCollection(getContext());
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
    public BroodDailyCollection getBroodDailyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBroodDailyCollection(getContext(), view);
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
    public BroodDailyCollection getBroodDailyCollection(String oql) throws BOSException
    {
        try {
            return getController().getBroodDailyCollection(getContext(), oql);
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
    public BroodDailyInfo getBroodDailyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodDailyInfo(getContext(), pk);
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
    public BroodDailyInfo getBroodDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodDailyInfo(getContext(), pk, selector);
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
    public BroodDailyInfo getBroodDailyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBroodDailyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(BroodDailyInfo model) throws BOSException
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
    public void unAudit(BroodDailyInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成下游单据-User defined method
     *@param model model
     *@return
     */
    public List genNextBill(BroodDailyInfo model) throws BOSException
    {
        try {
            return getController().genNextBill(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *重新分摊煤和柴油-User defined method
     *@param model model
     */
    public void reShareCoalAndDiesel(BroodDailyInfo model) throws BOSException
    {
        try {
            getController().reShareCoalAndDiesel(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}