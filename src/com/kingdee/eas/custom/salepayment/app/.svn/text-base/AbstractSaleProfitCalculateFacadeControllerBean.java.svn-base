package com.kingdee.eas.custom.salepayment.app;

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

import com.kingdee.eas.custom.salepayment.SalePaymentSetInfo;
import com.kingdee.bos.dao.IObjectCollection;
import java.lang.String;
import java.util.HashMap;
import com.kingdee.eas.wlhlcomm.bean.ResultInfo;



public abstract class AbstractSaleProfitCalculateFacadeControllerBean extends AbstractBizControllerBean implements SaleProfitCalculateFacadeController
{
    protected AbstractSaleProfitCalculateFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("7CDAA241");
    }

    public ResultInfo calculateCompanyTarget(Context ctx, String companyID, String companyTargetID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("0dbcfd7f-d711-43c3-8b68-114078963680"), new Object[]{ctx, companyID, companyTargetID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ResultInfo retValue = (ResultInfo)_calculateCompanyTarget(ctx, companyID, companyTargetID);
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
    protected ResultInfo _calculateCompanyTarget(Context ctx, String companyID, String companyTargetID) throws BOSException
    {    	
        return null;
    }

    public IObjectCollection getSalerTargetInfos(Context ctx, String companyTargetID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c9550a84-a0f4-4bf0-b7a5-267fb2b8215c"), new Object[]{ctx, companyTargetID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IObjectCollection retValue = (IObjectCollection)_getSalerTargetInfos(ctx, companyTargetID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (IObjectCollection)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IObjectCollection _getSalerTargetInfos(Context ctx, String companyTargetID) throws BOSException
    {    	
        return null;
    }

    public SalePaymentSetInfo getCompanySetInfo(Context ctx, String companyID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("4ae7bfdb-a6e9-4153-9aa7-aff3bf28fb80"), new Object[]{ctx, companyID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            SalePaymentSetInfo retValue = (SalePaymentSetInfo)_getCompanySetInfo(ctx, companyID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (SalePaymentSetInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected SalePaymentSetInfo _getCompanySetInfo(Context ctx, String companyID) throws BOSException
    {    	
        return null;
    }

    public HashMap getCompanyStandardCost(Context ctx, String companyID, int year) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7bd8d6bc-34ee-447e-93c5-3c9d5a2b3842"), new Object[]{ctx, companyID, new Integer(year)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            HashMap retValue = (HashMap)_getCompanyStandardCost(ctx, companyID, year);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (HashMap)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected HashMap _getCompanyStandardCost(Context ctx, String companyID, int year) throws BOSException
    {    	
        return null;
    }

}