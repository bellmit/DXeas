package com.kingdee.eas.custom.lhsm.app;

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
import java.lang.String;
import com.kingdee.eas.common.EASBizException;



public abstract class AbstractForecastOrderFacadeControllerBean extends AbstractBizControllerBean implements ForecastOrderFacadeController
{
    protected AbstractForecastOrderFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("C1925C00");
    }

    public IRowSet getSqlData(Context ctx, String sql) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("128918ea-7e9b-4998-bf83-14c73a41c600"), new Object[]{ctx, sql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            IRowSet retValue = (IRowSet)_getSqlData(ctx, sql);
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
    protected IRowSet _getSqlData(Context ctx, String sql) throws BOSException, EASBizException
    {    	
        return null;
    }

    public String[] transToOrder(Context ctx, String forecastId, String storageOrgId, String currOrgUnitId) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7470153a-14ec-4aa9-9d83-1b3f1c65329e"), new Object[]{ctx, forecastId, storageOrgId, currOrgUnitId});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String[] retValue = (String[])_transToOrder(ctx, forecastId, storageOrgId, currOrgUnitId);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected String[] _transToOrder(Context ctx, String forecastId, String storageOrgId, String currOrgUnitId) throws BOSException, EASBizException
    {    	
        return null;
    }

    public String[] rejectForecast(Context ctx, String forecasId) throws BOSException, EASBizException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5487adde-2d33-466d-8ed7-40b88e74b562"), new Object[]{ctx, forecasId});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String[] retValue = (String[])_rejectForecast(ctx, forecasId);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (String[])svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } catch (EASBizException ex0) {
            throw ex0;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected String[] _rejectForecast(Context ctx, String forecasId) throws BOSException, EASBizException
    {    	
        return null;
    }

    public boolean execSql(Context ctx, String sql) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("323482f9-5c20-4971-801d-c8cbb00e8bd3"), new Object[]{ctx, sql});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_execSql(ctx, sql);
            svcCtx.setMethodReturnValue(new Boolean(retValue));
            }
            invokeServiceAfter(svcCtx);
            return ((Boolean)svcCtx.getMethodReturnValue()).booleanValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected boolean _execSql(Context ctx, String sql) throws BOSException
    {    	
        return false;
    }

    public void saleorder(Context ctx, String id) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9e84b192-8e1f-4bbf-b7d5-b9962a85b6f6"), new Object[]{ctx, id});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _saleorder(ctx, id);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _saleorder(Context ctx, String id) throws BOSException
    {    	
        return;
    }

    public void companyInv(Context ctx, String cuid, String materialid) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b4375a74-066e-4ed5-80dc-65f3f71fc4ec"), new Object[]{ctx, cuid, materialid});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _companyInv(ctx, cuid, materialid);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _companyInv(Context ctx, String cuid, String materialid) throws BOSException
    {    	
        return;
    }

    public void addSaleForecast(Context ctx) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("138d1ae4-b729-48e9-a538-831e5e711d5f"), new Object[]{ctx});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _addSaleForecast(ctx);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _addSaleForecast(Context ctx) throws BOSException
    {    	
        return;
    }

    public void updateSaleForecast(Context ctx, String id) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("8ed32b71-367a-4025-974d-aacb19639c4f"), new Object[]{ctx, id});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _updateSaleForecast(ctx, id);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _updateSaleForecast(Context ctx, String id) throws BOSException
    {    	
        return;
    }

    public void exportData(Context ctx, String cuid, int type, String fid, String fstatus) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("14d5ebca-578d-43bf-9a67-38750574ca8d"), new Object[]{ctx, cuid, new Integer(type), fid, fstatus});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _exportData(ctx, cuid, type, fid, fstatus);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _exportData(Context ctx, String cuid, int type, String fid, String fstatus) throws BOSException
    {    	
        return;
    }

    public String downloadBillData(Context ctx, String jsonStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("86a47c8d-a0fe-4570-b4e3-7b42ccc12f6b"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_downloadBillData(ctx, jsonStr);
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
    protected abstract String _downloadBillData(Context ctx, String jsonStr) throws BOSException;

    public String uploadBillData(Context ctx, String jsonStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("30d1f499-07b9-4a40-8df3-ef7f22dd8110"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_uploadBillData(ctx, jsonStr);
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
    protected abstract String _uploadBillData(Context ctx, String jsonStr) throws BOSException;

    public String downloadBillList(Context ctx, String jsonStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c249041f-45af-4bc7-9e0b-82f0c64db0f2"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_downloadBillList(ctx, jsonStr);
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
    protected abstract String _downloadBillList(Context ctx, String jsonStr) throws BOSException;

    public String getOrgUnitRangeByUserNum(Context ctx, String parma) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9a57b22c-9af8-4bed-8553-84ee73d7e91d"), new Object[]{ctx, parma});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getOrgUnitRangeByUserNum(ctx, parma);
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
    protected abstract String _getOrgUnitRangeByUserNum(Context ctx, String parma) throws BOSException;

    public String getMaterialByOrg(Context ctx, String jsonStr) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("3aac8b52-facd-4f10-82d7-6beb11f32fe3"), new Object[]{ctx, jsonStr});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getMaterialByOrg(ctx, jsonStr);
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
    protected abstract String _getMaterialByOrg(Context ctx, String jsonStr) throws BOSException;

    public String createNewForecastOrder(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d5a7703a-3800-4a76-b380-3ea9eb270dbd"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_createNewForecastOrder(ctx, param);
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
    protected abstract String _createNewForecastOrder(Context ctx, String param) throws BOSException;

    public String getPaymentType(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a4aff5f0-6b57-4235-ad5c-de1b9a48787a"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getPaymentType(ctx, param);
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
    protected abstract String _getPaymentType(Context ctx, String param) throws BOSException;

    public String getCustomerBySaleOrg(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a329db47-4b74-4d89-bb0d-f9c233197b45"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getCustomerBySaleOrg(ctx, param);
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
    protected abstract String _getCustomerBySaleOrg(Context ctx, String param) throws BOSException;

    public String getSaleGroupBySaleOrg(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("e3e5137b-c1f4-49ec-b759-a10ba1960714"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getSaleGroupBySaleOrg(ctx, param);
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
    protected abstract String _getSaleGroupBySaleOrg(Context ctx, String param) throws BOSException;

    public String getSalePerson(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("813b3bc9-2f28-4613-9385-fee9341f87ac"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getSalePerson(ctx, param);
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
    protected abstract String _getSalePerson(Context ctx, String param) throws BOSException;

    public String getForecastDetailInfo(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("204ac159-a1b3-4188-937a-016b9772023e"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getForecastDetailInfo(ctx, param);
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
    protected abstract String _getForecastDetailInfo(Context ctx, String param) throws BOSException;

    public String getMaterialPrice(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("48a61fec-7f47-420a-a9ea-dd6f58c6cb06"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getMaterialPrice(ctx, param);
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
    protected abstract String _getMaterialPrice(Context ctx, String param) throws BOSException;

    public String getWareHouseList(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d1455e91-38b8-45ad-b3e2-bb1be224a4fd"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getWareHouseList(ctx, param);
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
    protected abstract String _getWareHouseList(Context ctx, String param) throws BOSException;

    public String getSalePersonOrgUnitRange(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c4a8b95c-fba6-498a-aa55-aa1c6f2ddd96"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getSalePersonOrgUnitRange(ctx, param);
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
    protected abstract String _getSalePersonOrgUnitRange(Context ctx, String param) throws BOSException;

    public String getSaleForecastBillPro(Context ctx, String param) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("af6091cd-b87a-4403-a6c9-eaff8a0b1e47"), new Object[]{ctx, param});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getSaleForecastBillPro(ctx, param);
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
    protected abstract String _getSaleForecastBillPro(Context ctx, String param) throws BOSException;

}