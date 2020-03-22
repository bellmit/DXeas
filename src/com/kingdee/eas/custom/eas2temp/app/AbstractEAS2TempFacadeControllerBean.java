package com.kingdee.eas.custom.eas2temp.app;

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



public abstract class AbstractEAS2TempFacadeControllerBean extends AbstractBizControllerBean implements EAS2TempFacadeController
{
    protected AbstractEAS2TempFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("AAF6567D");
    }

    public String exportBill(Context ctx, String companyID, String jsonStr, int sourceType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f6caeb3c-ed15-4559-b48d-9de1aacc0f94"), new Object[]{ctx, companyID, jsonStr, new Integer(sourceType)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_exportBill(ctx, companyID, jsonStr, sourceType);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected String _exportBill(Context ctx, String companyID, String jsonStr, int sourceType) throws BOSException
    {    	
        return null;
    }

    public String importBill(Context ctx, String companyID, String jsonStr, int sourceType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c89c3806-001e-4843-85ee-d1717a14b175"), new Object[]{ctx, companyID, jsonStr, new Integer(sourceType)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_importBill(ctx, companyID, jsonStr, sourceType);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            this.setRollbackOnly();
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected String _importBill(Context ctx, String companyID, String jsonStr, int sourceType) throws BOSException
    {    	
        return null;
    }

    public boolean testConn(Context ctx, String companyID, int targetSystem) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("27c1e852-2618-49af-a132-c62b5b1926e8"), new Object[]{ctx, companyID, new Integer(targetSystem)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_testConn(ctx, companyID, targetSystem);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Boolean)svcCtx.getMethodReturnValue()).booleanValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected boolean _testConn(Context ctx, String companyID, int targetSystem) throws BOSException
    {    	
        return false;
    }

    public String exportBillByID(Context ctx, String companyID, String billID, int sourceType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b8e08292-ec6c-4513-a0e7-3c2b2988aa62"), new Object[]{ctx, companyID, billID, new Integer(sourceType)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_exportBillByID(ctx, companyID, billID, sourceType);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected String _exportBillByID(Context ctx, String companyID, String billID, int sourceType) throws BOSException
    {    	
        return null;
    }

    public void initBarEASRel(Context ctx, String easMaterialID, String storageUnitOrgID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("637c6251-b64b-41ab-9339-5f7d1d42e0ff"), new Object[]{ctx, easMaterialID, storageUnitOrgID});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _initBarEASRel(ctx, easMaterialID, storageUnitOrgID);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _initBarEASRel(Context ctx, String easMaterialID, String storageUnitOrgID) throws BOSException
    {    	
        return;
    }

    public String deleteBarAndMyData(Context ctx, Object obj) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("aeeff37c-10af-4573-b873-368b84bd5ecd"), new Object[]{ctx, obj});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_deleteBarAndMyData(ctx, obj);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract String _deleteBarAndMyData(Context ctx, Object obj) throws BOSException;

    public void retryWeight(Context ctx, String PurId) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5e04daac-ddd7-42b3-8324-b281a36ba562"), new Object[]{ctx, PurId});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _retryWeight(ctx, PurId);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _retryWeight(Context ctx, String PurId) throws BOSException
    {    	
        return;
    }

}