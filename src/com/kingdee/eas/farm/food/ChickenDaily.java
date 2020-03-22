package com.kingdee.eas.farm.food;

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
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class ChickenDaily extends CoreBillBase implements IChickenDaily
{
    public ChickenDaily()
    {
        super();
        registerInterface(IChickenDaily.class, this);
    }
    public ChickenDaily(Context ctx)
    {
        super(ctx);
        registerInterface(IChickenDaily.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C522B70E");
    }
    private ChickenDailyController getController() throws BOSException
    {
        return (ChickenDailyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public ChickenDailyCollection getChickenDailyCollection() throws BOSException
    {
        try {
            return getController().getChickenDailyCollection(getContext());
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
    public ChickenDailyCollection getChickenDailyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getChickenDailyCollection(getContext(), view);
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
    public ChickenDailyCollection getChickenDailyCollection(String oql) throws BOSException
    {
        try {
            return getController().getChickenDailyCollection(getContext(), oql);
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
    public ChickenDailyInfo getChickenDailyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenDailyInfo(getContext(), pk);
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
    public ChickenDailyInfo getChickenDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenDailyInfo(getContext(), pk, selector);
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
    public ChickenDailyInfo getChickenDailyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getChickenDailyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *审核-User defined method
     *@param model model
     */
    public void audit(ChickenDailyInfo model) throws BOSException
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
    public void unAudit(ChickenDailyInfo model) throws BOSException
    {
        try {
            getController().unAudit(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}