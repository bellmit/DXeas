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



public abstract class AbstractWSBizAccountBillFacadeControllerBean extends AbstractBizControllerBean implements WSBizAccountBillFacadeController
{
    protected AbstractWSBizAccountBillFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("3497D0BB");
    }

    public String importBizAccountBill(Context ctx, String dataXml) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("16ab84c6-5b77-4985-ba99-92dc067b2d4c"), new Object[]{ctx, dataXml});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_importBizAccountBill(ctx, dataXml);
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
    protected String _importBizAccountBill(Context ctx, String dataXml) throws BOSException
    {    	
        return null;
    }

    public String getOrgInfoByUser(Context ctx, String user) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("fe6e9f2e-df86-41f2-b595-7a9a1239d36a"), new Object[]{ctx, user});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getOrgInfoByUser(ctx, user);
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
    protected String _getOrgInfoByUser(Context ctx, String user) throws BOSException
    {    	
        return null;
    }

    public String getOrgListByUser(Context ctx, String userId) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7e4f2cc2-83f7-46bc-a3f9-42a6e35d2539"), new Object[]{ctx, userId});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getOrgListByUser(ctx, userId);
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
    protected String _getOrgListByUser(Context ctx, String userId) throws BOSException
    {    	
        return null;
    }

    public String getDeptListByCompany(Context ctx, String company) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("54f2c710-fd10-4ed0-a580-0f034a2050cf"), new Object[]{ctx, company});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getDeptListByCompany(ctx, company);
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
    protected String _getDeptListByCompany(Context ctx, String company) throws BOSException
    {    	
        return null;
    }

    public String getBizType(Context ctx, String userId) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("eca1b194-f52a-410a-bbe5-9b8a40d5d980"), new Object[]{ctx, userId});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getBizType(ctx, userId);
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
    protected String _getBizType(Context ctx, String userId) throws BOSException
    {    	
        return null;
    }

    public String getExpTypeByBizType(Context ctx, String bizType, String userNumber) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("2f1fdbb6-7ac9-4139-b125-0bf64a9d68e8"), new Object[]{ctx, bizType, userNumber});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getExpTypeByBizType(ctx, bizType, userNumber);
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
    protected String _getExpTypeByBizType(Context ctx, String bizType, String userNumber) throws BOSException
    {    	
        return null;
    }

    public String getBizAccountBillByAssignId(Context ctx, String assignId) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7cfb5936-adef-447c-b50e-56fdb34597fc"), new Object[]{ctx, assignId});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getBizAccountBillByAssignId(ctx, assignId);
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
    protected abstract String _getBizAccountBillByAssignId(Context ctx, String assignId) throws BOSException;

    public String getBizAccountBillList(Context ctx, String dataJson) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("dcd0b526-d516-426c-a0c9-9e320c4006da"), new Object[]{ctx, dataJson});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getBizAccountBillList(ctx, dataJson);
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
    protected String _getBizAccountBillList(Context ctx, String dataJson) throws BOSException
    {    	
        return null;
    }

}