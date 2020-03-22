package com.kingdee.eas.farm.stocking.processbizill.app;

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

import java.util.Map;
import java.lang.String;
import java.util.HashMap;
import com.kingdee.eas.common.EASBizException;



public abstract class AbstractCreateReconciliationBillFacadeControllerBean extends AbstractBizControllerBean implements CreateReconciliationBillFacadeController
{
    protected AbstractCreateReconciliationBillFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("F4409C85");
    }

    public HashMap CreateReconciliationBill(Context ctx, Map param) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("83664fd3-56c0-4757-8eed-6ed80e35bc5d"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            HashMap retValue = (HashMap)_CreateReconciliationBill(ctx, param);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (HashMap)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected HashMap _CreateReconciliationBill(Context ctx, Map param) throws BOSException, EASBizException
    {    	
        return null;
    }

    public String CarryoverSettleBill(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a5a21f9d-55af-456c-ab27-54591c2c8161"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_CarryoverSettleBill(ctx, param);
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
    protected abstract String _CarryoverSettleBill(Context ctx, String param) throws BOSException;

}