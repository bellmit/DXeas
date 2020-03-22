package com.kingdee.eas.custom.wages.food;

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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.custom.wages.food.app.*;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class BasicPostFood extends DataBase implements IBasicPostFood
{
    public BasicPostFood()
    {
        super();
        registerInterface(IBasicPostFood.class, this);
    }
    public BasicPostFood(Context ctx)
    {
        super(ctx);
        registerInterface(IBasicPostFood.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("C5FBD1AA");
    }
    private BasicPostFoodController getController() throws BOSException
    {
        return (BasicPostFoodController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public BasicPostFoodInfo getBasicPostFoodInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getBasicPostFoodInfo(getContext(), pk);
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
    public BasicPostFoodInfo getBasicPostFoodInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getBasicPostFoodInfo(getContext(), pk, selector);
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
    public BasicPostFoodInfo getBasicPostFoodInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getBasicPostFoodInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public BasicPostFoodCollection getBasicPostFoodCollection() throws BOSException
    {
        try {
            return getController().getBasicPostFoodCollection(getContext());
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
    public BasicPostFoodCollection getBasicPostFoodCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getBasicPostFoodCollection(getContext(), view);
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
    public BasicPostFoodCollection getBasicPostFoodCollection(String oql) throws BOSException
    {
        try {
            return getController().getBasicPostFoodCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}