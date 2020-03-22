package com.kingdee.eas.custom.dx.baseset;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBase;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.dx.baseset.app.*;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.custom.wlhllicensemanager.IWlhlBillBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FoodDaily extends WlhlBillBase implements IFoodDaily
{
    public FoodDaily()
    {
        super();
        registerInterface(IFoodDaily.class, this);
    }
    public FoodDaily(Context ctx)
    {
        super(ctx);
        registerInterface(IFoodDaily.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("3BA82B8F");
    }
    private FoodDailyController getController() throws BOSException
    {
        return (FoodDailyController)getBizController();
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FoodDailyCollection getFoodDailyCollection() throws BOSException
    {
        try {
            return getController().getFoodDailyCollection(getContext());
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
    public FoodDailyCollection getFoodDailyCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFoodDailyCollection(getContext(), view);
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
    public FoodDailyCollection getFoodDailyCollection(String oql) throws BOSException
    {
        try {
            return getController().getFoodDailyCollection(getContext(), oql);
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
    public FoodDailyInfo getFoodDailyInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFoodDailyInfo(getContext(), pk);
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
    public FoodDailyInfo getFoodDailyInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFoodDailyInfo(getContext(), pk, selector);
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
    public FoodDailyInfo getFoodDailyInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFoodDailyInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取数据-User defined method
     *@param model model
     */
    public void getData(FoodDailyInfo model) throws BOSException
    {
        try {
            getController().getData(getContext(), model);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}