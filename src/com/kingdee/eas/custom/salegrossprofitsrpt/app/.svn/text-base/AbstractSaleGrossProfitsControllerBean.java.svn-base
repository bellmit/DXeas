package com.kingdee.eas.custom.salegrossprofitsrpt.app;

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

import com.kingdee.jdbc.rowset.IRowSet;
import com.kingdee.eas.framework.report.util.RptParams;
import com.kingdee.eas.framework.report.app.CommRptBaseControllerBean;
import com.kingdee.eas.common.EASBizException;



public abstract class AbstractSaleGrossProfitsControllerBean extends CommRptBaseControllerBean implements SaleGrossProfitsController
{
    protected AbstractSaleGrossProfitsControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("8A092EA1");
    }

    public int getMaxCustomerLevel(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a962e0be-625f-4851-81cd-1dda5fc554b3"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            int retValue = (int)_getMaxCustomerLevel(ctx);
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
    protected abstract int _getMaxCustomerLevel(Context ctx) throws BOSException;

    public int getMaxMaterialLevel(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3d50b4d7-d030-490b-b3ac-8b41f3b3e308"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            int retValue = (int)_getMaxMaterialLevel(ctx);
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
    protected abstract int _getMaxMaterialLevel(Context ctx) throws BOSException;

    public int[] getMaxLevels(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("4c64722e-d658-45f3-be25-6991e80b2e3f"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            int[] retValue = (int[])_getMaxLevels(ctx);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (int[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract int[] _getMaxLevels(Context ctx) throws BOSException;

    public IRowSet getQueryResultByParams(Context ctx, RptParams rptparams) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5b3acc03-5b07-4f41-8e17-e4e3bbefd854"), new Object[]{ctx, rptparams});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IRowSet retValue = (IRowSet)_getQueryResultByParams(ctx, rptparams);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (IRowSet)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract IRowSet _getQueryResultByParams(Context ctx, RptParams rptparams) throws BOSException, EASBizException;

    public RptParams createTempTable(Context ctx, RptParams RptParams) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("212c6b56-c99c-4ef5-8a69-ccf2ce5c194e"), new Object[]{ctx, RptParams});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            RptParams retValue = (RptParams)_createTempTable(ctx, RptParams);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (RptParams)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }

}