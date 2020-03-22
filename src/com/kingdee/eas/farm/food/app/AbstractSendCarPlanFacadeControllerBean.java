package com.kingdee.eas.farm.food.app;

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

import java.util.ArrayList;
import java.util.Date;
import com.kingdee.eas.common.EASBizException;
import java.util.HashMap;



public abstract class AbstractSendCarPlanFacadeControllerBean extends AbstractBizControllerBean implements SendCarPlanFacadeController
{
    protected AbstractSendCarPlanFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("23E13205");
    }

    public ArrayList getRowSet(Context ctx, HashMap hashMap) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("eef8b832-5e22-4aaf-99ca-ec4a78ede9cf"), new Object[]{ctx, hashMap});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getRowSet(ctx, hashMap);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ArrayList)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ArrayList _getRowSet(Context ctx, HashMap hashMap) throws BOSException, EASBizException
    {    	
        return null;
    }

    public ArrayList getCCBatchAgeAndQty(Context ctx, Date bizDate, int breedDays, int count) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("1b22e904-1364-4ff8-9e6c-458eb42d7446"), new Object[]{ctx, bizDate, new Integer(breedDays), new Integer(count)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ArrayList retValue = (ArrayList)_getCCBatchAgeAndQty(ctx, bizDate, breedDays, count);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ArrayList)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ArrayList _getCCBatchAgeAndQty(Context ctx, Date bizDate, int breedDays, int count) throws BOSException
    {    	
        return null;
    }

}