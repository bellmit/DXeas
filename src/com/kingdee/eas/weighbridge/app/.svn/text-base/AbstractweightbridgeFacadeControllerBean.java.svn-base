package com.kingdee.eas.weighbridge.app;

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

import com.kingdee.eas.weighbridge.InStorageBillInfo;
import java.util.Map;
import java.math.BigDecimal;
import com.kingdee.eas.weighbridge.bean.OrderWeightInfo;
import java.lang.String;



public abstract class AbstractweightbridgeFacadeControllerBean extends AbstractBizControllerBean implements weightbridgeFacadeController
{
    protected AbstractweightbridgeFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("2452CEF6");
    }

    public Map getPurorderInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c9e25605-0076-4a28-93bd-3d16de1e2136"), new Object[]{ctx, number, carNumber, beginDate, endDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getPurorderInfoByNumber(ctx, number, carNumber, beginDate, endDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Map _getPurorderInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException
    {    	
        return null;
    }

    public Map getSaleorderInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("144973be-8efc-4a5c-96bb-8ffcd7d67f5d"), new Object[]{ctx, number, carNumber, beginDate, endDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getSaleorderInfoByNumber(ctx, number, carNumber, beginDate, endDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Map _getSaleorderInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException
    {    	
        return null;
    }

    public void updateInweightSourceBillInfo(Context ctx, InStorageBillInfo billInfo, OrderWeightInfo orderWeightInfo, BigDecimal newGrossWeight, BigDecimal newTare) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("0088fe9c-32f4-429e-8697-65bb469ecbf7"), new Object[]{ctx, billInfo, orderWeightInfo, newGrossWeight, newTare});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _updateInweightSourceBillInfo(ctx, billInfo, orderWeightInfo, newGrossWeight, newTare);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _updateInweightSourceBillInfo(Context ctx, InStorageBillInfo billInfo, OrderWeightInfo orderWeightInfo, BigDecimal newGrossWeight, BigDecimal newTare) throws BOSException
    {    	
        return;
    }

    public Map getCarSendTara(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("fa3f25cc-22c5-4f5a-80ab-881580d58eed"), new Object[]{ctx, number, carNumber, beginDate, endDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getCarSendTara(ctx, number, carNumber, beginDate, endDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Map _getCarSendTara(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException
    {    	
        return null;
    }

    public Map getNewPurorderInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6d5996d5-866b-463a-8c9e-d6e917fe1b33"), new Object[]{ctx, number, carNumber, beginDate, endDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getNewPurorderInfoByNumber(ctx, number, carNumber, beginDate, endDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Map _getNewPurorderInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException
    {    	
        return null;
    }

    public Map getQCInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9b4b5875-1ec1-4014-a85f-824254a081cf"), new Object[]{ctx, number, carNumber, beginDate, endDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getQCInfoByNumber(ctx, number, carNumber, beginDate, endDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Map _getQCInfoByNumber(Context ctx, String number, String carNumber, String beginDate, String endDate) throws BOSException
    {    	
        return null;
    }

}