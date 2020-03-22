package com.kingdee.eas.custom.salediscount.app;

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

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialSalesInfo;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import java.util.Map;
import java.util.List;
import com.kingdee.eas.custom.salediscount.DiscountCompanyInfo;
import java.math.BigDecimal;
import java.lang.String;
import java.util.Date;
import com.kingdee.eas.custom.ResultInfo;



public abstract class AbstractDiscountFacadeControllerBean extends AbstractBizControllerBean implements DiscountFacadeController
{
    protected AbstractDiscountFacadeControllerBean()
    {
    }

    protected BOSObjectType getBOSType()
    {
        return new BOSObjectType("334BCEF6");
    }

    public DiscountCompanyInfo getCompanyDSSet(Context ctx, String companyID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("c49c7aa7-1998-45df-b7d1-1087d6da1a9a"), new Object[]{ctx, companyID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            DiscountCompanyInfo retValue = (DiscountCompanyInfo)_getCompanyDSSet(ctx, companyID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (DiscountCompanyInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected DiscountCompanyInfo _getCompanyDSSet(Context ctx, String companyID) throws BOSException
    {    	
        return null;
    }

    public BigDecimal getMaterialBasePrice(Context ctx, String CUid, String materialID, String unitID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("654239bb-105b-48c4-99e5-c1a47de7b62b"), new Object[]{ctx, CUid, materialID, unitID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BigDecimal retValue = (BigDecimal)_getMaterialBasePrice(ctx, CUid, materialID, unitID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BigDecimal)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BigDecimal _getMaterialBasePrice(Context ctx, String CUid, String materialID, String unitID) throws BOSException
    {    	
        return null;
    }

    public ResultInfo getLiDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("4b6db0d0-7581-467b-88cc-dc536cff7116"), new Object[]{ctx, saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, new Integer(seq), saleOrderID, validOrderEntryIDs, new Boolean(isSaleReturns), materialQtyMap});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ResultInfo retValue = (ResultInfo)_getLiDiscountValue(ctx, saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ResultInfo _getLiDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {    	
        return null;
    }

    public ResultInfo getZengBaoDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7b34fe80-f61c-49b5-b023-b20940be1b44"), new Object[]{ctx, saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, new Integer(seq), saleOrderID, validOrderEntryIDs, new Boolean(isSaleReturns), materialQtyMap});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ResultInfo retValue = (ResultInfo)_getZengBaoDiscountValue(ctx, saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ResultInfo _getZengBaoDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {    	
        return null;
    }

    public ResultInfo getMonthDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("0ea663b2-0bdb-4d00-aed2-445e1511a239"), new Object[]{ctx, saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, new Integer(seq), saleOrderID, validOrderEntryIDs, new Boolean(isSaleReturns), materialQtyMap});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ResultInfo retValue = (ResultInfo)_getMonthDiscountValue(ctx, saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ResultInfo _getMonthDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {    	
        return null;
    }

    public ResultInfo getYearDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("b7c33948-3748-47ba-8f04-e633ce7804f1"), new Object[]{ctx, saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, new Integer(seq), saleOrderID, validOrderEntryIDs, new Boolean(isSaleReturns), materialQtyMap});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ResultInfo retValue = (ResultInfo)_getYearDiscountValue(ctx, saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ResultInfo _getYearDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {    	
        return null;
    }

    public BigDecimal getMaterialPolicyPrice(Context ctx, String companyID, String customerID, String materialID, String bizDate, BigDecimal orderQty, String unitID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("0283da83-ab72-48ba-a3ce-1a540b506ffe"), new Object[]{ctx, companyID, customerID, materialID, bizDate, orderQty, unitID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BigDecimal retValue = (BigDecimal)_getMaterialPolicyPrice(ctx, companyID, customerID, materialID, bizDate, orderQty, unitID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BigDecimal)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BigDecimal _getMaterialPolicyPrice(Context ctx, String companyID, String customerID, String materialID, String bizDate, BigDecimal orderQty, String unitID) throws BOSException
    {    	
        return null;
    }

    public void updateDSEntryState(Context ctx, List entryIDs, String entryState) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("28bfcc6d-1c76-4961-bcef-ea03eb09bc72"), new Object[]{ctx, entryIDs, entryState});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _updateDSEntryState(ctx, entryIDs, entryState);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _updateDSEntryState(Context ctx, List entryIDs, String entryState) throws BOSException
    {    	
        return;
    }

    public boolean isEnableDiscount(Context ctx, String saleOrgUnitID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("602de2ff-1ec7-4348-9a08-fd17296af167"), new Object[]{ctx, saleOrgUnitID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isEnableDiscount(ctx, saleOrgUnitID);
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
    protected boolean _isEnableDiscount(Context ctx, String saleOrgUnitID) throws BOSException
    {    	
        return false;
    }

    public void removeOrderDsgridLogs(Context ctx, String orderID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("76c38b49-9bd9-4185-9dec-ea84b4a947e0"), new Object[]{ctx, orderID});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _removeOrderDsgridLogs(ctx, orderID);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _removeOrderDsgridLogs(Context ctx, String orderID) throws BOSException
    {    	
        return;
    }

    public String getParentCustomer(Context ctx, String customerID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("af42457e-89fe-4e3e-8953-f03a556b5bbd"), new Object[]{ctx, customerID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            String retValue = (String)_getParentCustomer(ctx, customerID);
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
    protected String _getParentCustomer(Context ctx, String customerID) throws BOSException
    {    	
        return null;
    }

    public ResultInfo getFenxiaoDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("4175aca1-5513-43f8-bbe5-ce9fd77139f8"), new Object[]{ctx, saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, new Integer(seq), saleOrderID, validOrderEntryIDs, new Boolean(isSaleReturns), materialQtyMap});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ResultInfo retValue = (ResultInfo)_getFenxiaoDiscountValue(ctx, saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ResultInfo _getFenxiaoDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {    	
        return null;
    }

    public List getOrderDiscountGridLogs(Context ctx, String orderID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("94b1cd8f-4f06-465c-ae27-fd9539f57412"), new Object[]{ctx, orderID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getOrderDiscountGridLogs(ctx, orderID);
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
    protected List _getOrderDiscountGridLogs(Context ctx, String orderID) throws BOSException
    {    	
        return null;
    }

    public void removeOrderEntryDsgridLogs(Context ctx, String saleOrderID, String validSaleOrderEntryID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("5a628e07-f8f8-4076-8c6d-6492c1b4aeda"), new Object[]{ctx, saleOrderID, validSaleOrderEntryID});
            invokeServiceBefore(svcCtx);
              if(!svcCtx.invokeBreak()) {
            _removeOrderEntryDsgridLogs(ctx, saleOrderID, validSaleOrderEntryID);
            }
            invokeServiceAfter(svcCtx);
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected void _removeOrderEntryDsgridLogs(Context ctx, String saleOrderID, String validSaleOrderEntryID) throws BOSException
    {    	
        return;
    }

    public boolean isDiscountUsed(Context ctx, String dsBillID, String dsEntryID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9577d59d-630b-41da-98b9-20fbb9d3fb1e"), new Object[]{ctx, dsBillID, dsEntryID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isDiscountUsed(ctx, dsBillID, dsEntryID);
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
    protected boolean _isDiscountUsed(Context ctx, String dsBillID, String dsEntryID) throws BOSException
    {    	
        return false;
    }

    public boolean isCheckCustomerBalance(Context ctx, String companyID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("bc9cfb4e-0b49-4037-b5d3-8cb34526d918"), new Object[]{ctx, companyID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isCheckCustomerBalance(ctx, companyID);
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
    protected boolean _isCheckCustomerBalance(Context ctx, String companyID) throws BOSException
    {    	
        return false;
    }

    public boolean isCheckMaterialInventory(Context ctx, String companyID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("23f881a8-93a6-4b22-818d-79f4576139e8"), new Object[]{ctx, companyID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isCheckMaterialInventory(ctx, companyID);
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
    protected boolean _isCheckMaterialInventory(Context ctx, String companyID) throws BOSException
    {    	
        return false;
    }

    public Map getDiscountInfos(Context ctx, String companyID, Date beginTime, Date entTime, String discountType, PeriodInfo periodInfo) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("7302930b-2666-487d-a8a5-ed957cd1b0cf"), new Object[]{ctx, companyID, beginTime, entTime, discountType, periodInfo});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Map retValue = (Map)_getDiscountInfos(ctx, companyID, beginTime, entTime, discountType, periodInfo);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Map)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Map _getDiscountInfos(Context ctx, String companyID, Date beginTime, Date entTime, String discountType, PeriodInfo periodInfo) throws BOSException
    {    	
        return null;
    }

    public ResultInfo addDiscountRecords(Context ctx, CompanyOrgUnitInfo companyInfo, String discountType, Date bizDate, List adjustDSInfos, String adjustType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("855ebeeb-a916-4c98-933b-431de78f71f3"), new Object[]{ctx, companyInfo, discountType, bizDate, adjustDSInfos, adjustType});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            ResultInfo retValue = (ResultInfo)_addDiscountRecords(ctx, companyInfo, discountType, bizDate, adjustDSInfos, adjustType);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (ResultInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected ResultInfo _addDiscountRecords(Context ctx, CompanyOrgUnitInfo companyInfo, String discountType, Date bizDate, List adjustDSInfos, String adjustType) throws BOSException
    {    	
        return null;
    }

    public boolean generateDiscountRecordbill(Context ctx, String companyID, List discountTypes, List customerList, Date beginDate, Date endDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("4cdb93e8-11e9-4979-a7cf-a68fc069346f"), new Object[]{ctx, companyID, discountTypes, customerList, beginDate, endDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_generateDiscountRecordbill(ctx, companyID, discountTypes, customerList, beginDate, endDate);
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
    protected boolean _generateDiscountRecordbill(Context ctx, String companyID, List discountTypes, List customerList, Date beginDate, Date endDate) throws BOSException
    {    	
        return false;
    }

    public List getDiscountCashInfos(Context ctx, String companyID, List discountTypes, Date beginDate, Date endDate, List customers, boolean isNotReceiving, boolean isHaveReceiving) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("f8458752-e07b-45ea-84b7-30bc936cfd21"), new Object[]{ctx, companyID, discountTypes, beginDate, endDate, customers, new Boolean(isNotReceiving), new Boolean(isHaveReceiving)});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            List retValue = (List)_getDiscountCashInfos(ctx, companyID, discountTypes, beginDate, endDate, customers, isNotReceiving, isHaveReceiving);
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
    protected List _getDiscountCashInfos(Context ctx, String companyID, List discountTypes, Date beginDate, Date endDate, List customers, boolean isNotReceiving, boolean isHaveReceiving) throws BOSException
    {    	
        return null;
    }

    public boolean generateReceiveBills(Context ctx, String companyID, Map receivRecords) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("dee16e52-4970-4e36-bb0b-45da6c716066"), new Object[]{ctx, companyID, receivRecords});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_generateReceiveBills(ctx, companyID, receivRecords);
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
    protected boolean _generateReceiveBills(Context ctx, String companyID, Map receivRecords) throws BOSException
    {    	
        return false;
    }

    public boolean isExistDestBill(Context ctx, String srcBillID, String SrcBosType) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("d1722029-4ce0-4bc3-8022-5475335afa6b"), new Object[]{ctx, srcBillID, SrcBosType});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isExistDestBill(ctx, srcBillID, SrcBosType);
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
    protected boolean _isExistDestBill(Context ctx, String srcBillID, String SrcBosType) throws BOSException
    {    	
        return false;
    }

    public boolean isExistDSInfos(Context ctx, String customerID, String materialID, String dsType, String dsNameType, String beginDate, String endDate, String dsInfoID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("9d81a0a6-719f-4529-9cd3-b841bce0472b"), new Object[]{ctx, customerID, materialID, dsType, dsNameType, beginDate, endDate, dsInfoID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            boolean retValue = (boolean)_isExistDSInfos(ctx, customerID, materialID, dsType, dsNameType, beginDate, endDate, dsInfoID);
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
    protected boolean _isExistDSInfos(Context ctx, String customerID, String materialID, String dsType, String dsNameType, String beginDate, String endDate, String dsInfoID) throws BOSException
    {    	
        return false;
    }

    public Object isExistDSInfos(Context ctx, String discountSetID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("07283d2c-a500-4524-bd7b-304ed3fb0934"), new Object[]{ctx, discountSetID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            Object retValue = (Object)_isExistDSInfos(ctx, discountSetID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (Object)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected Object _isExistDSInfos(Context ctx, String discountSetID) throws BOSException
    {    	
        return null;
    }

    public MaterialSalesInfo getMaterialSaleinfo(Context ctx, String materialID, String companyID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("46c63d5c-01e2-4f74-b8cc-aba0d41d5fe3"), new Object[]{ctx, materialID, companyID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            MaterialSalesInfo retValue = (MaterialSalesInfo)_getMaterialSaleinfo(ctx, materialID, companyID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (MaterialSalesInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected MaterialSalesInfo _getMaterialSaleinfo(Context ctx, String materialID, String companyID) throws BOSException
    {    	
        return null;
    }

    public MaterialInventoryInfo getInventoryInfo(Context ctx, String matid, String ouid) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("8aee49bc-8d20-4743-bf03-480b073455c9"), new Object[]{ctx, matid, ouid});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            MaterialInventoryInfo retValue = (MaterialInventoryInfo)_getInventoryInfo(ctx, matid, ouid);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (MaterialInventoryInfo)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected MaterialInventoryInfo _getInventoryInfo(Context ctx, String matid, String ouid) throws BOSException
    {    	
        return null;
    }

    public BigDecimal getCusMaterialGroupSaleBaseQty(Context ctx, String companyID, String customerID, String materialGroupLongNumber, String materialID, Date accumulateBeginDate, Date accumulateEndDate, Date billBizDate) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("a40adcb3-c842-4c41-882e-028ce7c04aac"), new Object[]{ctx, companyID, customerID, materialGroupLongNumber, materialID, accumulateBeginDate, accumulateEndDate, billBizDate});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BigDecimal retValue = (BigDecimal)_getCusMaterialGroupSaleBaseQty(ctx, companyID, customerID, materialGroupLongNumber, materialID, accumulateBeginDate, accumulateEndDate, billBizDate);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BigDecimal)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected abstract BigDecimal _getCusMaterialGroupSaleBaseQty(Context ctx, String companyID, String customerID, String materialGroupLongNumber, String materialID, Date accumulateBeginDate, Date accumulateEndDate, Date billBizDate) throws BOSException;

    public BigDecimal getMaterialBagQty(Context ctx, String saleOrgUnitID, String materialID) throws BOSException
    {
        try {
            ServiceContext svcCtx = createServiceContext(new MetaDataPK("42f664f6-e292-4e5e-9e2a-a8f435081746"), new Object[]{ctx, saleOrgUnitID, materialID});
            invokeServiceBefore(svcCtx);
            if(!svcCtx.invokeBreak()) {
            BigDecimal retValue = (BigDecimal)_getMaterialBagQty(ctx, saleOrgUnitID, materialID);
            svcCtx.setMethodReturnValue(retValue);
            }
            invokeServiceAfter(svcCtx);
            return (BigDecimal)svcCtx.getMethodReturnValue();
        } catch (BOSException ex) {
            throw ex;
        } finally {
            super.cleanUpServiceState();
        }
    }
    protected BigDecimal _getMaterialBagQty(Context ctx, String saleOrgUnitID, String materialID) throws BOSException
    {    	
        return null;
    }

}