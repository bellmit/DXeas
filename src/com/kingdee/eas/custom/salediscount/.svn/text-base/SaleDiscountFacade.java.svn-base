package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

import com.kingdee.bos.Context;
import com.kingdee.bos.BOSException;
import com.kingdee.eas.custom.salediscount.app.*;
import java.math.BigDecimal;
import java.lang.String;
import com.kingdee.bos.framework.*;
import com.kingdee.eas.wlhlcomm.bean.ResultInfo;
import com.kingdee.bos.util.*;

public class SaleDiscountFacade extends AbstractBizCtrl implements ISaleDiscountFacade
{
    public SaleDiscountFacade()
    {
        super();
        registerInterface(ISaleDiscountFacade.class, this);
    }
    public SaleDiscountFacade(Context ctx)
    {
        super(ctx);
        registerInterface(ISaleDiscountFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("8CBD7D9D");
    }
    private SaleDiscountFacadeController getController() throws BOSException
    {
        return (SaleDiscountFacadeController)getBizController();
    }
    /**
     *getCustomerBalanceInfo-User defined method
     *@param companyID 公司ID
     *@param customerID 客户ID
     *@return
     */
    public CustomerBalanceInfo getCustomerBalanceInfo(String companyID, String customerID) throws BOSException
    {
        try {
            return getController().getCustomerBalanceInfo(getContext(), companyID, customerID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *更新客户折让余额-User defined method
     *@param companyID 公司ID
     *@param customerID 客户ID
     *@param substractAmount 扣减金额
     *@param addAmount 增加金额
     *@return
     */
    public ResultInfo updateCustomerBalance(String companyID, String customerID, BigDecimal substractAmount, BigDecimal addAmount) throws BOSException
    {
        try {
            return getController().updateCustomerBalance(getContext(), companyID, customerID, substractAmount, addAmount);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *重算客户余额-User defined method
     *@param companyID 公司ID
     *@param customerID 客户ID
     *@return
     */
    public ResultInfo recountCustomerBalance(String companyID, String customerID) throws BOSException
    {
        try {
            return getController().recountCustomerBalance(getContext(), companyID, customerID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}