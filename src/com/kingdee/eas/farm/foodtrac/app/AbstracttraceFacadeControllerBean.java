package com.kingdee.eas.farm.foodtrac.app;

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

import com.kingdee.eas.farm.breed.BreedBatchInfo;
import java.util.List;
import java.lang.String;



public abstract class AbstracttraceFacadeControllerBean extends AbstractBizControllerBean implements traceFacadeController
{
    protected AbstracttraceFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("10772615");
    }

    public String getBatchDetailInfos(Context ctx, String batchNumber) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7f07eef2-507b-4249-9536-2eface7da58f"), new Object[]{ctx, batchNumber});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getBatchDetailInfos(ctx, batchNumber);
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
    protected String _getBatchDetailInfos(Context ctx, String batchNumber) throws BOSException
    {    	
        return null;
    }

    public List getBatchHatchBills(Context ctx, BreedBatchInfo batchInfo) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("96be6341-7afd-41e5-872b-2a8b272d613b"), new Object[]{ctx, batchInfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getBatchHatchBills(ctx, batchInfo);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (List)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected List _getBatchHatchBills(Context ctx, BreedBatchInfo batchInfo) throws BOSException
    {    	
        return null;
    }

}