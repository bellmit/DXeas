package com.kingdee.eas.wlhlcomm.app;

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



public abstract class AbstractSalePriceFacadeControllerBean extends AbstractBizControllerBean implements SalePriceFacadeController
{
    protected AbstractSalePriceFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("2F20860B");
    }

    public BigDecimal getMaterialPolicyPrice(Context ctx, String companyID, String customerID, String materialID, String bizDateStr, BigDecimal orderQty, String unitID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c93a602e-2575-461d-bf45-1c27ac26f2ea"), new Object[]{ctx, companyID, customerID, materialID, bizDateStr, orderQty, unitID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BigDecimal retValue = (BigDecimal)_getMaterialPolicyPrice(ctx, companyID, customerID, materialID, bizDateStr, orderQty, unitID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BigDecimal)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BigDecimal _getMaterialPolicyPrice(Context ctx, String companyID, String customerID, String materialID, String bizDateStr, BigDecimal orderQty, String unitID) throws BOSException
    {    	
        return null;
    }

    public BigDecimal getMaterialBasePrice(Context ctx, String adminCUid, String materialID, String unitID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d38d9390-7f75-4809-8fbe-ad0afd875c67"), new Object[]{ctx, adminCUid, materialID, unitID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BigDecimal retValue = (BigDecimal)_getMaterialBasePrice(ctx, adminCUid, materialID, unitID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BigDecimal)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BigDecimal _getMaterialBasePrice(Context ctx, String adminCUid, String materialID, String unitID) throws BOSException
    {    	
        return null;
    }

}