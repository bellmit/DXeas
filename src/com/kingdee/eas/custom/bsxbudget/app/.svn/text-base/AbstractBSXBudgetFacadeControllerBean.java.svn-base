package com.kingdee.eas.custom.bsxbudget.app;

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

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import java.math.BigDecimal;
import java.lang.String;



public abstract class AbstractBSXBudgetFacadeControllerBean extends AbstractBizControllerBean implements BSXBudgetFacadeController
{
    protected AbstractBSXBudgetFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("835F6C9F");
    }

    public PeriodInfo getCurrentPeriod(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d2053906-8544-40cd-bdcb-a68f0684a840"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            PeriodInfo retValue = (PeriodInfo)_getCurrentPeriod(ctx);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (PeriodInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract PeriodInfo _getCurrentPeriod(Context ctx) throws BOSException;

    public String[] getInventoryValue(Context ctx, PeriodInfo period) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5df0a1cb-f44c-4da3-b09b-b58d144603b1"), new Object[]{ctx, period});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String[] retValue = (String[])_getInventoryValue(ctx, period);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String[] _getInventoryValue(Context ctx, IObjectValue period) throws BOSException;

    public BigDecimal getTotalWeightFromBugetFeed(Context ctx, PeriodInfo periodInfo) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6653de97-4904-4e76-a073-4075bf8acd0d"), new Object[]{ctx, periodInfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BigDecimal retValue = (BigDecimal)_getTotalWeightFromBugetFeed(ctx, periodInfo);
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
    protected abstract BigDecimal _getTotalWeightFromBugetFeed(Context ctx, IObjectValue periodInfo) throws BOSException;

    public BigDecimal getLairageQty(Context ctx, String beginDate, String endDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7dc0a75c-bdcc-48a0-9e9a-30109afb7a57"), new Object[]{ctx, beginDate, endDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BigDecimal retValue = (BigDecimal)_getLairageQty(ctx, beginDate, endDate);
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
    protected abstract BigDecimal _getLairageQty(Context ctx, String beginDate, String endDate) throws BOSException;

}