package com.kingdee.eas.farm.rpt.app;

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
import java.util.Date;
import java.util.HashMap;



public abstract class AbstractCapitalDailyRptFacadeControllerBean extends AbstractBizControllerBean implements CapitalDailyRptFacadeController
{
    protected AbstractCapitalDailyRptFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("D7FC0FC7");
    }

    public HashMap getCapitalDailyInfos(Context ctx, Date beginDate, Date endDate, String companyId) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9a30e5eb-3073-449d-8005-ce1b47506614"), new Object[]{ctx, beginDate, endDate, companyId});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            HashMap retValue = (HashMap)_getCapitalDailyInfos(ctx, beginDate, endDate, companyId);
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
    protected HashMap _getCapitalDailyInfos(Context ctx, Date beginDate, Date endDate, String companyId) throws BOSException
    {    	
        return null;
    }

    public void releaseTempTable(Context ctx, String temptableName) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a655d95f-2679-4ec6-97cf-79d652507ef7"), new Object[]{ctx, temptableName});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _releaseTempTable(ctx, temptableName);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _releaseTempTable(Context ctx, String temptableName) throws BOSException
    {    	
        return;
    }

    public HashMap getAllCompanysCapitalDailyInfos(Context ctx, Date beginDate, Date endDate, int isGather, String capitalType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b2d4d3b2-2548-4f1d-bb58-e784929c58b8"), new Object[]{ctx, beginDate, endDate, new Integer(isGather), capitalType});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            HashMap retValue = (HashMap)_getAllCompanysCapitalDailyInfos(ctx, beginDate, endDate, isGather, capitalType);
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
    protected HashMap _getAllCompanysCapitalDailyInfos(Context ctx, Date beginDate, Date endDate, int isGather, String capitalType) throws BOSException
    {    	
        return null;
    }

}