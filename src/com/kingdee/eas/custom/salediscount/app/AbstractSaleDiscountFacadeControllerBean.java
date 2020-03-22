package com.kingdee.eas.custom.salediscount.app;

import javax.ejb.*;
import java.rmi.RemoteException;
import com.kingdee.bos.*;
import com.kingdee.bos.util.BOSObjectType;
import com.kingdee.bos.metadata.IMetaDataPK;
import com.kingdee.bos.metadata.rule.RuleExecutor;
import com.kingdee.bos.metadata.MetaDataPK;
//import com.kingdee.bos.metadata.entity.EntityViewInfo;
import com.kingdee.bos.framework.ejb.AbstractEntityControllerBean;
import com.kingdee.bos.framework.ejb.AbstractBizControllerBean;
//import com.kingdee.bos.dao.IObjectPK;
import com.kingdee.bos.dao.IObjectValue;
import com.kingdee.bos.dao.IObjectCollection;
import com.kingdee.bos.service.ServiceContext;
import com.kingdee.bos.service.IServiceContext;
import com.kingdee.eas.framework.Result;
import com.kingdee.eas.framework.LineResult;
import com.kingdee.eas.framework.exception.EASMultiException;
import com.kingdee.bos.dao.ormapping.ObjectUuidPK;

import java.math.BigDecimal;
import java.lang.String;
import com.kingdee.eas.wlhlcomm.bean.ResultInfo;
import com.kingdee.eas.custom.salediscount.CustomerBalanceInfo;



public abstract class AbstractSaleDiscountFacadeControllerBean extends AbstractBizControllerBean implements SaleDiscountFacadeController
{
    protected AbstractSaleDiscountFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("8CBD7D9D");
    }

    public CustomerBalanceInfo getCustomerBalanceInfo(Context ctx, String companyID, String customerID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("68ef7256-616b-43c4-a02c-9acfd1ef524a"), new Object[]{ctx, companyID, customerID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CustomerBalanceInfo retValue = (CustomerBalanceInfo)_getCustomerBalanceInfo(ctx, companyID, customerID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CustomerBalanceInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CustomerBalanceInfo _getCustomerBalanceInfo(Context ctx, String companyID, String customerID) throws BOSException
    {    	
        return null;
    }

    public ResultInfo updateCustomerBalance(Context ctx, String companyID, String customerID, BigDecimal substractAmount, BigDecimal addAmount) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("480736e3-f565-41eb-a6c1-d37e8ad631e0"), new Object[]{ctx, companyID, customerID, substractAmount, addAmount});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ResultInfo retValue = (ResultInfo)_updateCustomerBalance(ctx, companyID, customerID, substractAmount, addAmount);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ResultInfo _updateCustomerBalance(Context ctx, String companyID, String customerID, BigDecimal substractAmount, BigDecimal addAmount) throws BOSException
    {    	
        return null;
    }

    public ResultInfo recountCustomerBalance(Context ctx, String companyID, String customerID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6ef41e24-6434-44bd-8e84-5b922f30685d"), new Object[]{ctx, companyID, customerID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ResultInfo retValue = (ResultInfo)_recountCustomerBalance(ctx, companyID, customerID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ResultInfo _recountCustomerBalance(Context ctx, String companyID, String customerID) throws BOSException
    {    	
        return null;
    }

}