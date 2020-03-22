package com.kingdee.eas.custom.workflow.app;

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
import com.kingdee.eas.common.EASBizException;



public abstract class AbstractWSWorkFlowFacadeControllerBean extends AbstractBizControllerBean implements WSWorkFlowFacadeController
{
    protected AbstractWSWorkFlowFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("58F23959");
    }

    public String getMessageList(Context ctx, String userNumber) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("fda92cc1-8bdd-476c-9cfb-3e008e1389a5"), new Object[]{ctx, userNumber});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getMessageList(ctx, userNumber);
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
    protected String _getMessageList(Context ctx, String userNumber) throws BOSException
    {    	
        return null;
    }

    public String quickApprove(Context ctx, String assignIds, String ifpass, String opinion, String policy, String userNumber) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f0997fe4-a80e-4529-be8e-5c0d9ff3e975"), new Object[]{ctx, assignIds, ifpass, opinion, policy, userNumber});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_quickApprove(ctx, assignIds, ifpass, opinion, policy, userNumber);
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
    protected String _quickApprove(Context ctx, String assignIds, String ifpass, String opinion, String policy, String userNumber) throws BOSException
    {    	
        return null;
    }

    public String getApproveHistory(Context ctx, String billId) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c9177512-8f13-48d4-8ed0-b27b30dad170"), new Object[]{ctx, billId});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getApproveHistory(ctx, billId);
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
    protected abstract String _getApproveHistory(Context ctx, String billId) throws BOSException;

    public String getMessageDetailList(Context ctx, String userNumber) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7adc71d7-87e8-4e24-8b02-c35b870af2d4"), new Object[]{ctx, userNumber});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getMessageDetailList(ctx, userNumber);
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
    protected String _getMessageDetailList(Context ctx, String userNumber) throws BOSException
    {    	
        return null;
    }

    public void updateMesStatusById(Context ctx, String messageId) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("6b5aa7ec-d336-49ba-9e9b-ae5f1d660f7c"), new Object[]{ctx, messageId});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _updateMesStatusById(ctx, messageId);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _updateMesStatusById(Context ctx, String messageId) throws BOSException
    {    	
        return;
    }

    public String getUserInfoByXtId(Context ctx, String xtId) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("2d6d071f-4847-477f-bcdb-d4962f2f2590"), new Object[]{ctx, xtId});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getUserInfoByXtId(ctx, xtId);
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
    protected String _getUserInfoByXtId(Context ctx, String xtId) throws BOSException
    {    	
        return null;
    }

    public String getFNumberByPhone(Context ctx, String phone) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ce05b282-750e-47b5-9f8f-08b02ead7087"), new Object[]{ctx, phone});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getFNumberByPhone(ctx, phone);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected String _getFNumberByPhone(Context ctx, String phone) throws BOSException, EASBizException
    {    	
        return null;
    }

    public String submitApprove(Context ctx, String jsonStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("dedbe6cb-abd7-4859-af9b-25512ea90c2f"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_submitApprove(ctx, jsonStr);
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
    protected String _submitApprove(Context ctx, String jsonStr) throws BOSException
    {    	
        return null;
    }

}