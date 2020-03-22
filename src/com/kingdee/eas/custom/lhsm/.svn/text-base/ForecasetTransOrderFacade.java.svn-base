package com.kingdee.eas.custom.lhsm;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.lhsm.app.*;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;

public class ForecasetTransOrderFacade extends AbstractBizCtrl implements IForecasetTransOrderFacade
{
    public ForecasetTransOrderFacade()
    {
        super();
        registerInterface(IForecasetTransOrderFacade.class, this);
    }
    public ForecasetTransOrderFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IForecasetTransOrderFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("6A8DFB1B");
    }
    private ForecasetTransOrderFacadeController getController() throws BOSException
    {
        return (ForecasetTransOrderFacadeController)getBizController();
    }
    /**
     *预报转订单获取初始数据-User defined method
     *@param param 参数
     *@return
     */
    public String getAllData(String param) throws BOSException
    {
        try {
            return getController().getAllData(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取单张预报单-User defined method
     *@param param 参数
     *@return
     */
    public String getSingleForecastData(String param) throws BOSException
    {
        try {
            return getController().getSingleForecastData(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成销售订单-User defined method
     *@param param 参数
     *@return
     */
    public String addSaleOrderBill(String param) throws BOSException
    {
        try {
            return getController().addSaleOrderBill(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取物料的库存信息-User defined method
     *@param param 参数
     *@return
     */
    public String getMaterialInventory(String param) throws BOSException
    {
        try {
            return getController().getMaterialInventory(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行查询语句-User defined method
     *@param param 参数
     *@return
     */
    public String excuteQuerySql(String param) throws BOSException
    {
        try {
            return getController().excuteQuerySql(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行插入语句-User defined method
     *@param param 参数
     *@return
     */
    public String excuteInsertSql(String param) throws BOSException
    {
        try {
            return getController().excuteInsertSql(getContext(), param);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *执行插入语句-User defined method
     *@param sql 参数
     *@param obj 参数
     *@return
     */
    public String excuteInsertSql(String sql, Object[] obj) throws BOSException
    {
        try {
            return getController().excuteInsertSql(getContext(), sql, obj);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}