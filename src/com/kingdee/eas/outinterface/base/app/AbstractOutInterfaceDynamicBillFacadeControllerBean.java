package com.kingdee.eas.outinterface.base.app;

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

import com.kingdee.eas.outinterface.base.utils.IDynamicDeal;
import java.lang.String;
import com.kingdee.eas.common.EASBizException;
import com.alibaba.fastjson.JSONObject;



public abstract class AbstractOutInterfaceDynamicBillFacadeControllerBean extends AbstractBizControllerBean implements OutInterfaceDynamicBillFacadeController
{
    protected AbstractOutInterfaceDynamicBillFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("EA163209");
    }

    public JSONObject getDataByID(Context ctx, String jsonStr, IDynamicDeal ideal) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3050ae12-957b-44c4-a1e7-4f118d6500a5"), new Object[]{ctx, jsonStr, ideal});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_getDataByID(ctx, jsonStr, ideal);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _getDataByID(Context ctx, String jsonStr, IDynamicDeal ideal) throws BOSException, EASBizException;

    public JSONObject uploadDataByBosType(Context ctx, String bosType, String jsonStr, IDynamicDeal iupload) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("597a45d8-1ac6-46c1-9c5a-0c5cec335dbf"), new Object[]{ctx, bosType, jsonStr, iupload});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_uploadDataByBosType(ctx, bosType, jsonStr, iupload);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _uploadDataByBosType(Context ctx, String bosType, String jsonStr, IDynamicDeal iupload) throws BOSException, EASBizException;

    public JSONObject getBillList(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("fbc07262-42e9-4ea7-bb97-a1f2ae942911"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_getBillList(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _getBillList(Context ctx, String jsonStr) throws BOSException, EASBizException;

    public JSONObject getEumInfo(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3d0da9c0-02e8-46e9-8f0e-90c4661e6452"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_getEumInfo(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected JSONObject _getEumInfo(Context ctx, String jsonStr) throws BOSException, EASBizException
    {    	
        return null;
    }

    public JSONObject exeFunciton(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("e5007768-d3cd-459f-be9f-53bd8934cc64"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_exeFunciton(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _exeFunciton(Context ctx, String jsonStr) throws BOSException, EASBizException;

    public JSONObject uploadData(Context ctx, String bosType, String jsonStr, IDynamicDeal iupload) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("855e3c59-1d2f-45a3-acbc-f8e3bdea5732"), new Object[]{ctx, bosType, jsonStr, iupload});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_uploadData(ctx, bosType, jsonStr, iupload);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _uploadData(Context ctx, String bosType, String jsonStr, IDynamicDeal iupload) throws BOSException, EASBizException;

    public JSONObject deleteData(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("8b296807-f0fa-4bb4-90e7-7cc90f5d92bd"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_deleteData(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _deleteData(Context ctx, String jsonStr) throws BOSException, EASBizException;

    public JSONObject uploadAttachment(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("99f01d85-e1ea-49c9-a6a1-d51bb4cd3f70"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_uploadAttachment(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _uploadAttachment(Context ctx, String jsonStr) throws BOSException, EASBizException;

    public JSONObject getAttachmentList(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b0dda17c-0679-40a3-8884-690902103616"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_getAttachmentList(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _getAttachmentList(Context ctx, String jsonStr) throws BOSException, EASBizException;

    public JSONObject getAttachmentData(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("cd76ab2a-72ad-46e5-9071-0b4cf5e5dfea"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_getAttachmentData(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _getAttachmentData(Context ctx, String jsonStr) throws BOSException, EASBizException;

    public JSONObject deleteAttachment(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d3f29a21-96d6-4d4d-a583-2f97c9849e85"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_deleteAttachment(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _deleteAttachment(Context ctx, String jsonStr) throws BOSException, EASBizException;

    public JSONObject getRptData(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d83fccc5-3a44-4c85-a19f-253dc84c61bb"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_getRptData(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _getRptData(Context ctx, String jsonStr) throws BOSException, EASBizException;

    public JSONObject getDataByNumber(Context ctx, String jsonStr, IDynamicDeal ideal) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("80ec77ae-68d7-4f31-88da-0516897bafdf"), new Object[]{ctx, jsonStr, ideal});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_getDataByNumber(ctx, jsonStr, ideal);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _getDataByNumber(Context ctx, String jsonStr, IDynamicDeal ideal) throws BOSException, EASBizException;

    public JSONObject updateData(Context ctx, String jsonStr) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3a16b365-6a1f-4441-ad54-9487806861c7"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            JSONObject retValue = (JSONObject)_updateData(ctx, jsonStr);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (JSONObject)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract JSONObject _updateData(Context ctx, String jsonStr) throws BOSException, EASBizException;

}