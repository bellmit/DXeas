package com.kingdee.eas.farm.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.BOSException;
import com.kingdee.bos.dao.IObjectPK;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.framework.ICoreBillEntryBase;
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.CoreBillEntryBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class FoodSendCarPlanEntry extends CoreBillEntryBase implements IFoodSendCarPlanEntry
{
    public FoodSendCarPlanEntry()
    {
        super();
        registerInterface(IFoodSendCarPlanEntry.class, this);
    }
    public FoodSendCarPlanEntry(Context ctx)
    {
        super(ctx);
        registerInterface(IFoodSendCarPlanEntry.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("824D9D25");
    }
    private FoodSendCarPlanEntryController getController() throws BOSException
    {
        return (FoodSendCarPlanEntryController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public FoodSendCarPlanEntryInfo getFoodSendCarPlanEntryInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getFoodSendCarPlanEntryInfo(getContext(), pk);
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
    public FoodSendCarPlanEntryInfo getFoodSendCarPlanEntryInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getFoodSendCarPlanEntryInfo(getContext(), pk, selector);
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
    public FoodSendCarPlanEntryInfo getFoodSendCarPlanEntryInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getFoodSendCarPlanEntryInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public FoodSendCarPlanEntryCollection getFoodSendCarPlanEntryCollection() throws BOSException
    {
        try {
            return getController().getFoodSendCarPlanEntryCollection(getContext());
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
    public FoodSendCarPlanEntryCollection getFoodSendCarPlanEntryCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getFoodSendCarPlanEntryCollection(getContext(), view);
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
    public FoodSendCarPlanEntryCollection getFoodSendCarPlanEntryCollection(String oql) throws BOSException
    {
        try {
            return getController().getFoodSendCarPlanEntryCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}