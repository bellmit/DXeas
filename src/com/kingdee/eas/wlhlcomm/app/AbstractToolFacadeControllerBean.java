package com.kingdee.eas.wlhlcomm.app;

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

import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.jdbc.rowset.IRowSet;
import java.util.List;
import com.kingdee.eas.basedata.org.StorageOrgUnitInfo;
import java.lang.String;
import java.util.Date;
import com.kingdee.eas.basedata.scm.sd.sale.MaterialBasePriceInfo;



public abstract class AbstractToolFacadeControllerBean extends AbstractBizControllerBean implements ToolFacadeController
{
    protected AbstractToolFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("D0C1A963");
    }

    public void execute(Context ctx, String sql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("8972519b-e0ac-444d-94d3-2730285295ee"), new Object[]{ctx, sql});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _execute(ctx, sql);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _execute(Context ctx, String sql) throws BOSException
    {    	
        return;
    }

    public IRowSet executeQuery(Context ctx, String sql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f16c207a-9742-40c2-ba48-3d77c954387a"), new Object[]{ctx, sql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IRowSet retValue = (IRowSet)_executeQuery(ctx, sql);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (IRowSet)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IRowSet _executeQuery(Context ctx, String sql) throws BOSException
    {    	
        return null;
    }

    public void execute(Context ctx, String sql, Object[] params) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("e837ab9b-d182-4d31-86fc-b00cdd50dfdf"), new Object[]{ctx, sql, params});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _execute(ctx, sql, params);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _execute(Context ctx, String sql, Object[] params) throws BOSException
    {    	
        return;
    }

    public IRowSet executeQuery(Context ctx, String sql, Object[] params) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("868882af-b61f-4c2a-8cde-f4bafa6dcc39"), new Object[]{ctx, sql, params});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IRowSet retValue = (IRowSet)_executeQuery(ctx, sql, params);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (IRowSet)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected IRowSet _executeQuery(Context ctx, String sql, Object[] params) throws BOSException
    {    	
        return null;
    }

    public MaterialBasePriceInfo getMaterialBasePrice(Context ctx, String adminCUID, String priceTypeID, String materialID, String unitID, String currencyID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("dfacf288-e8e5-485d-81cb-8cc1e6664a4b"), new Object[]{ctx, adminCUID, priceTypeID, materialID, unitID, currencyID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            MaterialBasePriceInfo retValue = (MaterialBasePriceInfo)_getMaterialBasePrice(ctx, adminCUID, priceTypeID, materialID, unitID, currencyID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (MaterialBasePriceInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected MaterialBasePriceInfo _getMaterialBasePrice(Context ctx, String adminCUID, String priceTypeID, String materialID, String unitID, String currencyID) throws BOSException
    {    	
        return null;
    }

    public List getEnableJobs(Context ctx, String jobName) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("0ceb0f43-6a48-47d8-8556-7036a66bcc8e"), new Object[]{ctx, jobName});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getEnableJobs(ctx, jobName);
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
    protected List _getEnableJobs(Context ctx, String jobName) throws BOSException
    {    	
        return null;
    }

    public List getJobByNames(Context ctx, String[] jobNames) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("2738b43a-2c51-4264-b730-dec251c1c37b"), new Object[]{ctx, jobNames});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getJobByNames(ctx, jobNames);
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
    protected List _getJobByNames(Context ctx, String[] jobNames) throws BOSException
    {    	
        return null;
    }

    public RptParams getInOutStoreGatherParam(Context ctx, String stoorgID, String warehouseID, Date beginDate, Date endDate, String matid) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("bce50988-f3c9-4fe8-a1c7-77c7c2c3c619"), new Object[]{ctx, stoorgID, warehouseID, beginDate, endDate, matid});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            RptParams retValue = (RptParams)_getInOutStoreGatherParam(ctx, stoorgID, warehouseID, beginDate, endDate, matid);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (RptParams)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected RptParams _getInOutStoreGatherParam(Context ctx, String stoorgID, String warehouseID, Date beginDate, Date endDate, String matid) throws BOSException
    {    	
        return null;
    }

    public RptParams getInOutStoreGatherParamArray(Context ctx, StorageOrgUnitInfo[] stoArray, String wareid, Date beginDate, Date endDate, String matid) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("be77582d-9860-4b39-975b-fae3bbe3387a"), new Object[]{ctx, stoArray, wareid, beginDate, endDate, matid});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            RptParams retValue = (RptParams)_getInOutStoreGatherParamArray(ctx, stoArray, wareid, beginDate, endDate, matid);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (RptParams)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected RptParams _getInOutStoreGatherParamArray(Context ctx, StorageOrgUnitInfo[] stoArray, String wareid, Date beginDate, Date endDate, String matid) throws BOSException
    {    	
        return null;
    }

}