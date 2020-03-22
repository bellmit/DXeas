package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.BOSException;
//import com.kingdee.bos.metadata.*;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.util.*;
import com.kingdee.bos.Context;

import com.kingdee.bos.BOSException;
import com.kingdee.eas.basedata.master.material.MaterialInventoryInfo;
import java.util.Map;
import java.util.List;
import java.lang.String;
import java.util.Date;
import com.kingdee.bos.framework.*;
import com.kingdee.bos.Context;
import com.kingdee.eas.basedata.assistant.PeriodInfo;
import com.kingdee.eas.basedata.org.CompanyOrgUnitInfo;
import com.kingdee.eas.basedata.master.material.MaterialSalesInfo;
import java.math.BigDecimal;
import com.kingdee.eas.custom.ResultInfo;
import com.kingdee.bos.util.*;

public interface IDiscountFacade extends IBizCtrl
{
    public DiscountCompanyInfo getCompanyDSSet(String companyID) throws BOSException;
    public BigDecimal getMaterialBasePrice(String CUid, String materialID, String unitID) throws BOSException;
    public ResultInfo getLiDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException;
    public ResultInfo getZengBaoDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException;
    public ResultInfo getMonthDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException;
    public ResultInfo getYearDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException;
    public BigDecimal getMaterialPolicyPrice(String companyID, String customerID, String materialID, String bizDate, BigDecimal orderQty, String unitID) throws BOSException;
    public void updateDSEntryState(List entryIDs, String entryState) throws BOSException;
    public boolean isEnableDiscount(String saleOrgUnitID) throws BOSException;
    public void removeOrderDsgridLogs(String orderID) throws BOSException;
    public String getParentCustomer(String customerID) throws BOSException;
    public ResultInfo getFenxiaoDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException;
    public List getOrderDiscountGridLogs(String orderID) throws BOSException;
    public void removeOrderEntryDsgridLogs(String saleOrderID, String validSaleOrderEntryID) throws BOSException;
    public boolean isDiscountUsed(String dsBillID, String dsEntryID) throws BOSException;
    public boolean isCheckCustomerBalance(String companyID) throws BOSException;
    public boolean isCheckMaterialInventory(String companyID) throws BOSException;
    public Map getDiscountInfos(String companyID, Date beginTime, Date entTime, String discountType, PeriodInfo periodInfo) throws BOSException;
    public ResultInfo addDiscountRecords(CompanyOrgUnitInfo companyInfo, String discountType, Date bizDate, List adjustDSInfos, String adjustType) throws BOSException;
    public boolean generateDiscountRecordbill(String companyID, List discountTypes, List customerList, Date beginDate, Date endDate) throws BOSException;
    public List getDiscountCashInfos(String companyID, List discountTypes, Date beginDate, Date endDate, List customers, boolean isNotReceiving, boolean isHaveReceiving) throws BOSException;
    public boolean generateReceiveBills(String companyID, Map receivRecords) throws BOSException;
    public boolean isExistDestBill(String srcBillID, String SrcBosType) throws BOSException;
    public boolean isExistDSInfos(String customerID, String materialID, String dsType, String dsNameType, String beginDate, String endDate, String dsInfoID) throws BOSException;
    public Object isExistDSInfos(String discountSetID) throws BOSException;
    public MaterialSalesInfo getMaterialSaleinfo(String materialID, String companyID) throws BOSException;
    public MaterialInventoryInfo getInventoryInfo(String matid, String ouid) throws BOSException;
    public BigDecimal getCusMaterialGroupSaleBaseQty(String companyID, String customerID, String materialGroupLongNumber, String materialID, Date accumulateBeginDate, Date accumulateEndDate, Date billBizDate) throws BOSException;
    public BigDecimal getMaterialBagQty(String saleOrgUnitID, String materialID) throws BOSException;
}