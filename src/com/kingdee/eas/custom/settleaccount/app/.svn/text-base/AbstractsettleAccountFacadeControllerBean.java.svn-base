package com.kingdee.eas.custom.settleaccount.app;

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

import java.lang.String;
import com.kingdee.eas.custom.settleaccount.util.CheckResultInfo;



public abstract class AbstractsettleAccountFacadeControllerBean extends AbstractBizControllerBean implements settleAccountFacadeController
{
    protected AbstractsettleAccountFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("6059DDEB");
    }

    public CheckResultInfo receivingBillCheck(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("48cbcdef-7850-4f53-acef-8447998fc329"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_receivingBillCheck(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _receivingBillCheck(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

    public CheckResultInfo paymentBillCheck(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d9f2719d-9303-42c5-ae69-d411fe619c83"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_paymentBillCheck(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _paymentBillCheck(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

    public CheckResultInfo purInWarehsBillCheck(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9dfa855b-1057-41e7-bfcf-d04118bda8ac"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_purInWarehsBillCheck(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _purInWarehsBillCheck(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

    public CheckResultInfo faCurCardCheck(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9a5660a4-5906-4a11-a23d-21600c2de70b"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_faCurCardCheck(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _faCurCardCheck(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

    public CheckResultInfo LCMCurCardCheck(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("bd4ec7f2-3c77-437e-b5fa-ca25fe024eb5"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_LCMCurCardCheck(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _LCMCurCardCheck(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

    public CheckResultInfo purInWarehsACost0Check(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5ff7bea3-3736-45ff-956f-989440f0a7e5"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_purInWarehsACost0Check(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _purInWarehsACost0Check(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

    public CheckResultInfo saleOrderNotCloseCheck(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3b4f7e18-97d4-47e2-89e0-cd5022a891e4"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_saleOrderNotCloseCheck(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _saleOrderNotCloseCheck(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

    public CheckResultInfo saleIssueBillNoOtherBillCheck(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("99ef6c22-701f-4ff8-9ce7-0069c41248a3"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_saleIssueBillNoOtherBillCheck(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _saleIssueBillNoOtherBillCheck(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

    public CheckResultInfo materialReqCCReWorkCheck(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("859f16a5-44e5-4bb8-a90c-34c9122ca396"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_materialReqCCReWorkCheck(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _materialReqCCReWorkCheck(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

    public CheckResultInfo materialReqNotAuditCheck(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a1316792-88dd-49ea-9e07-b2710c6b976a"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_materialReqNotAuditCheck(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _materialReqNotAuditCheck(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

    public CheckResultInfo otherIssueCCenterNot1Check(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("e9e173da-1a93-4cc2-8418-7446fd21f680"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_otherIssueCCenterNot1Check(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _otherIssueCCenterNot1Check(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

    public CheckResultInfo otherIssueACost0Check(Context ctx, String companyID, String periodID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6bd19007-5820-4cd3-ba1a-1f25389b9dd7"), new Object[]{ctx, companyID, periodID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            CheckResultInfo retValue = (CheckResultInfo)_otherIssueACost0Check(ctx, companyID, periodID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (CheckResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected CheckResultInfo _otherIssueACost0Check(Context ctx, String companyID, String periodID) throws BOSException
    {    	
        return null;
    }

}