package com.kingdee.eas.custom.salediscount.app;

import org.apache.log4j.Logger;
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

import com.kingdee.eas.basedata.assistant.PeriodInfo;
import java.lang.String;
import com.kingdee.eas.custom.ResultInfo;
import java.util.Map;
import java.math.BigDecimal;
import java.util.Date;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import java.util.List;
import com.kingdee.eas.custom.salediscount.DiscountCompanyInfo;

public class DiscountFacadeControllerBeanEx extends com.kingdee.eas.custom.salediscount.app.DiscountFacadeControllerBean
{
    private static Logger logger =
        Logger.getLogger("com.kingdee.eas.custom.salediscount.app.DiscountFacadeControllerBeanEx");
    protected DiscountCompanyInfo _getCompanyDSSet(Context ctx, String companyID)throws BOSException
    {
	    return  super._getCompanyDSSet(ctx, companyID);
    }
    protected BigDecimal _getMaterialBasePrice(Context ctx, String CUid, String materialID, String unitID)throws BOSException
    {
	    return  super._getMaterialBasePrice(ctx, CUid, materialID, unitID);
    }
   
    protected BigDecimal _getMaterialPolicyPrice(Context ctx, String companyID, String customerID, String materialID, String bizDate, BigDecimal orderQty, String unitID)throws BOSException
    {
	    return  super._getMaterialPolicyPrice(ctx, companyID, customerID, materialID, bizDate, orderQty, unitID);
    }
    protected void _updateDSEntryState(Context ctx, List entryIDs, String entryState)throws BOSException
    {
	     super._updateDSEntryState(ctx, entryIDs, entryState);
    }
    protected boolean _isEnableDiscount(Context ctx, String saleOrgUnitID)throws BOSException
    {
	    return  super._isEnableDiscount(ctx, saleOrgUnitID);
    }
    protected void _removeOrderDsgridLogs(Context ctx, String orderID)throws BOSException
    {
	     super._removeOrderDsgridLogs(ctx, orderID);
    }
    protected String _getParentCustomer(Context ctx, String customerID)throws BOSException
    {
	    return  super._getParentCustomer(ctx, customerID);
    }
   
    protected List _getOrderDiscountGridLogs(Context ctx, String orderID)throws BOSException
    {
	    return  super._getOrderDiscountGridLogs(ctx, orderID);
    }
    protected void _removeOrderEntryDsgridLogs(Context ctx, String saleOrderID, String validSaleOrderEntryID)throws BOSException
    {
	     super._removeOrderEntryDsgridLogs(ctx, saleOrderID, validSaleOrderEntryID);
    }
    protected boolean _isDiscountUsed(Context ctx, String dsBillID, String dsEntryID)throws BOSException
    {
	    return  super._isDiscountUsed(ctx, dsBillID, dsEntryID);
    }
    protected boolean _isCheckCustomerBalance(Context ctx, String companyID)throws BOSException
    {
	    return  super._isCheckCustomerBalance(ctx, companyID);
    }
    protected boolean _isCheckMaterialInventory(Context ctx, String companyID)throws BOSException
    {
	    return  super._isCheckMaterialInventory(ctx, companyID);
    }
    protected Map _getDiscountInfos(Context ctx, String companyID, Date beginTime, Date entTime, String discountType, PeriodInfo periodInfo)throws BOSException
    {
	    return  super._getDiscountInfos(ctx, companyID, beginTime, entTime, discountType, periodInfo);
    }
    protected ResultInfo _addDiscountRecords(Context ctx, CompanyOrgUnitInfo companyInfo, String discountType, Date bizDate, List adjustDSInfos,String adjustType)throws BOSException
    {
	    return  super._addDiscountRecords(ctx, companyInfo, discountType, bizDate, adjustDSInfos,adjustType);
    }
    protected boolean _generateDiscountRecordbill(Context ctx, String companyID, List discountTypes,List customers, Date beginDate, Date endDate)throws BOSException
    {
	    return  super._generateDiscountRecordbill(ctx, companyID, discountTypes,customers, beginDate, endDate);
    }
    protected List _getDiscountCashInfos(Context ctx, String companyID, List discountTypes, Date beginDate, Date endDate, List customers,boolean isNotReceiving,boolean isHaveReceiving)throws BOSException
    {
	    return  super._getDiscountCashInfos(ctx, companyID, discountTypes, beginDate, endDate, customers,isNotReceiving,isHaveReceiving);
    }
    protected boolean _generateReceiveBills(Context ctx, String companyID, Map receivRecords)throws BOSException
    {
	    return  super._generateReceiveBills(ctx, companyID, receivRecords);
    }
    protected boolean _isExistDestBill(Context ctx, String srcBillID, String SrcBosType)throws BOSException
    {
	    return  super._isExistDestBill(ctx, srcBillID, SrcBosType);
    }
    protected boolean _isExistDSInfos(Context ctx, String customerID, String materialID, String dsType, String dsNameType, String beginDate, String endDate, String dsInfoID)throws BOSException
    {
	    return  super._isExistDSInfos(ctx, customerID, materialID, dsType, dsNameType, beginDate, endDate, dsInfoID);
    }
    protected ResultInfo _isExistDSInfos(Context ctx, String discountSetID)throws BOSException
    {
	    return  super._isExistDSInfos(ctx, discountSetID);
    }
}				
