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
import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.eas.framework.DataBase;
import com.kingdee.eas.framework.CoreBaseCollection;
import com.kingdee.eas.framework.CoreBaseInfo;
import com.kingdee.eas.framework.IDataBase;
import com.kingdee.eas.common.EASBizException;
import com.kingdee.bos.util.*;
import com.kingdee.bos.metadata.entity.SelectorItemCollection;

public class DeliveryCar extends DataBase implements IDeliveryCar
{
    public DeliveryCar()
    {
        super();
        registerInterface(IDeliveryCar.class, this);
    }
    public DeliveryCar(Context ctx)
    {
        super(ctx);
        registerInterface(IDeliveryCar.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("0762EC56");
    }
    private DeliveryCarController getController() throws BOSException
    {
        return (DeliveryCarController)getBizController();
    }
    /**
     *取值-System defined method
     *@param pk 取值
     *@return
     */
    public DeliveryCarInfo getDeliveryCarInfo(IObjectPK pk) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryCarInfo(getContext(), pk);
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
    public DeliveryCarInfo getDeliveryCarInfo(IObjectPK pk, SelectorItemCollection selector) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryCarInfo(getContext(), pk, selector);
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
    public DeliveryCarInfo getDeliveryCarInfo(String oql) throws BOSException, EASBizException
    {
        try {
            return getController().getDeliveryCarInfo(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *取集合-System defined method
     *@return
     */
    public DeliveryCarCollection getDeliveryCarCollection() throws BOSException
    {
        try {
            return getController().getDeliveryCarCollection(getContext());
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
    public DeliveryCarCollection getDeliveryCarCollection(EntityViewInfo view) throws BOSException
    {
        try {
            return getController().getDeliveryCarCollection(getContext(), view);
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
    public DeliveryCarCollection getDeliveryCarCollection(String oql) throws BOSException
    {
        try {
            return getController().getDeliveryCarCollection(getContext(), oql);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}