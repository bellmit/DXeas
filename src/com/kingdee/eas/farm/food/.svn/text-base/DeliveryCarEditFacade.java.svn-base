package com.kingdee.eas.farm.food;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import java.lang.String;
import com.kingdee.eas.farm.food.app.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class DeliveryCarEditFacade extends AbstractBizCtrl implements IDeliveryCarEditFacade
{
    public DeliveryCarEditFacade()
    {
        super();
        registerInterface(IDeliveryCarEditFacade.class, this);
    }
    public DeliveryCarEditFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IDeliveryCarEditFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("61ADB03A");
    }
    private DeliveryCarEditFacadeController getController() throws BOSException
    {
        return (DeliveryCarEditFacadeController)getBizController();
    }
    /**
     *根据车牌号获得送货车辆-User defined method
     *@param carNumber carNumber
     *@return
     */
    public DeliveryCarInfo getDeliveryCarDetails(String carNumber) throws BOSException
    {
        try {
            return getController().getDeliveryCarDetails(getContext(), carNumber);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *saveOrUpdateCarInfo-User defined method
     *@param car car
     */
    public void saveOrUpdateCarInfo(DeliveryCarInfo car) throws BOSException
    {
        try {
            getController().saveOrUpdateCarInfo(getContext(), car);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getDeliveryCarDetailsByPersonName-User defined method
     *@param personName personName
     *@return
     */
    public DeliveryCarInfo getDeliveryCarDetailsByPersonName(String personName) throws BOSException
    {
        try {
            return getController().getDeliveryCarDetailsByPersonName(getContext(), personName);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}