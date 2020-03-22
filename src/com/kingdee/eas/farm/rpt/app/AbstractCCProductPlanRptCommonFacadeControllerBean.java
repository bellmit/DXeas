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

import java.util.List;
import com.kingdee.eas.farm.breed.BreedModelInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.eas.farm.breed.HenhouseType;
import java.util.HashMap;



public abstract class AbstractCCProductPlanRptCommonFacadeControllerBean extends AbstractBizControllerBean implements CCProductPlanRptCommonFacadeController
{
    protected AbstractCCProductPlanRptCommonFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("553402DB");
    }

    public List getRptBeanStorageInfos(Context ctx, HashMap param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("ac92b5cb-7c05-464a-a203-893cde24d761"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getRptBeanStorageInfos(ctx, param);
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
    protected List _getRptBeanStorageInfos(Context ctx, HashMap param) throws BOSException
    {    	
        return null;
    }

    public List getStoorgPlanInfo(Context ctx, CCProductPlanRptBean ccRptBean, List inValidPlanIDs, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b3a376ec-b7b6-4a57-bca2-4a651e2470d3"), new Object[]{ctx, ccRptBean, inValidPlanIDs, filterBeginDate, filterEndDate, new Integer(breedDays)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getStoorgPlanInfo(ctx, ccRptBean, inValidPlanIDs, filterBeginDate, filterEndDate, breedDays);
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
    protected List _getStoorgPlanInfo(Context ctx, CCProductPlanRptBean ccRptBean, List inValidPlanIDs, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException
    {    	
        return null;
    }

    public List getStoorgBatchInfo(Context ctx, CCProductPlanRptBean ccRptBean, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("47bb2861-9bd4-4621-a518-082db7e9a46e"), new Object[]{ctx, ccRptBean, filterBeginDate, filterEndDate, new Integer(breedDays)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getStoorgBatchInfo(ctx, ccRptBean, filterBeginDate, filterEndDate, breedDays);
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
    protected List _getStoorgBatchInfo(Context ctx, CCProductPlanRptBean ccRptBean, Date filterBeginDate, Date filterEndDate, int breedDays) throws BOSException
    {    	
        return null;
    }

    public BreedModelInfo getCurrentBreedModelInfo(Context ctx, HenhouseType houseType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("2d5dd361-d1a6-4b00-97cf-d9999245b067"), new Object[]{ctx, houseType});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BreedModelInfo retValue = (BreedModelInfo)_getCurrentBreedModelInfo(ctx, houseType);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BreedModelInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BreedModelInfo _getCurrentBreedModelInfo(Context ctx, HenhouseType houseType) throws BOSException
    {    	
        return null;
    }

    public int getCCPredateHenqty(Context ctx, String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs, int theoryQty) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d372588d-ea85-4ab2-9427-cf6b47d7362b"), new Object[]{ctx, stoorgID, batchID, bizdate, henhouseID, henhouseIDs, new Integer(theoryQty)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            int retValue = (int)_getCCPredateHenqty(ctx, stoorgID, batchID, bizdate, henhouseID, henhouseIDs, theoryQty);
            svcCtx.setMethodReturnValue(new Integer(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Integer)svcCtx.getMethodReturnValue()).intValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected int _getCCPredateHenqty(Context ctx, String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs, int theoryQty) throws BOSException
    {    	
        return 0;
    }

    public int getCCActualOutHenqty(Context ctx, String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("cdc05063-deff-4cc5-8942-7181dc346913"), new Object[]{ctx, stoorgID, batchID, bizdate, henhouseID, henhouseIDs});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            int retValue = (int)_getCCActualOutHenqty(ctx, stoorgID, batchID, bizdate, henhouseID, henhouseIDs);
            svcCtx.setMethodReturnValue(new Integer(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Integer)svcCtx.getMethodReturnValue()).intValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected int _getCCActualOutHenqty(Context ctx, String stoorgID, String batchID, Date bizdate, String henhouseID, String henhouseIDs) throws BOSException
    {    	
        return 0;
    }

}