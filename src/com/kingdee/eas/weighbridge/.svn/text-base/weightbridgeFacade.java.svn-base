package com.kingdee.eas.weighbridge;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.eas.weighbridge.app.*;
import com.kingdee.bos.BOSException;
import java.util.Map;
import java.math.BigDecimal;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class weightbridgeFacade extends AbstractBizCtrl implements IweightbridgeFacade
{
    public weightbridgeFacade()
    {
        super();
        registerInterface(IweightbridgeFacade.class, this);
    }
    public weightbridgeFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IweightbridgeFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("2452CEF6");
    }
    private weightbridgeFacadeController getController() throws BOSException
    {
        return (weightbridgeFacadeController)getBizController();
    }
    /**
     *派车单-User defined method
     *@param number number
     *@param carNumber 车牌号
     *@param beginDate 开始日期
     *@param endDate endDate
     *@return
     */
    public Map getPurorderInfoByNumber(String number, String carNumber, String beginDate, String endDate) throws BOSException
    {
        try {
            return getController().getPurorderInfoByNumber(getContext(), number, carNumber, beginDate, endDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getSaleorderInfoByNumber-User defined method
     *@param number number
     *@param carNumber carNumber
     *@param beginDate beginDate
     *@param endDate endDate
     *@return
     */
    public Map getSaleorderInfoByNumber(String number, String carNumber, String beginDate, String endDate) throws BOSException
    {
        try {
            return getController().getSaleorderInfoByNumber(getContext(), number, carNumber, beginDate, endDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *updateInweightSourceBillInfo-User defined method
     *@param billInfo 采购过磅单信息
     *@param orderWeightInfo 订单相关信息
     *@param newGrossWeight 新毛重
     *@param newTare 新皮重
     */
    public void updateInweightSourceBillInfo(InStorageBillInfo billInfo, OrderWeightInfo orderWeightInfo, BigDecimal newGrossWeight, BigDecimal newTare) throws BOSException
    {
        try {
            getController().updateInweightSourceBillInfo(getContext(), billInfo, orderWeightInfo, newGrossWeight, newTare);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据派车单车牌号获取派车单-User defined method
     *@param number number
     *@param carNumber carNumber
     *@param beginDate beginDate
     *@param endDate endDate
     *@return
     */
    public Map getCarSendTara(String number, String carNumber, String beginDate, String endDate) throws BOSException
    {
        try {
            return getController().getCarSendTara(getContext(), number, carNumber, beginDate, endDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *根据采购订单编码获得 采购订单相关信息-User defined method
     *@param number number
     *@param carNumber carNumber
     *@param beginDate beginDate
     *@param endDate endDate
     *@return
     */
    public Map getNewPurorderInfoByNumber(String number, String carNumber, String beginDate, String endDate) throws BOSException
    {
        try {
            return getController().getNewPurorderInfoByNumber(getContext(), number, carNumber, beginDate, endDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取质检单信息-User defined method
     *@param number number
     *@param carNumber carNumber
     *@param beginDate beginDate
     *@param endDate endDate
     *@return
     */
    public Map getQCInfoByNumber(String number, String carNumber, String beginDate, String endDate) throws BOSException
    {
        try {
            return getController().getQCInfoByNumber(getContext(), number, carNumber, beginDate, endDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}