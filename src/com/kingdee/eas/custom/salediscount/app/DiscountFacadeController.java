package com.kingdee.eas.custom.salediscount.app;

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
import com.kingdee.eas.custom.salediscount.DiscountCompanyInfo;
import java.math.BigDecimal;
import com.kingdee.eas.custom.ResultInfo;
import com.kingdee.bos.util.*;

import java.rmi.RemoteException;
import com.kingdee.bos.framework.ejb.BizController;

public interface DiscountFacadeController extends BizController
{
    public DiscountCompanyInfo getCompanyDSSet(Context ctx, String companyID) throws BOSException, RemoteException;
    public BigDecimal getMaterialBasePrice(Context ctx, String CUid, String materialID, String unitID) throws BOSException, RemoteException;
    public ResultInfo getLiDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException, RemoteException;
    public ResultInfo getZengBaoDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException, RemoteException;
    public ResultInfo getMonthDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException, RemoteException;
    public ResultInfo getYearDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException, RemoteException;
    public BigDecimal getMaterialPolicyPrice(Context ctx, String companyID, String customerID, String materialID, String bizDate, BigDecimal orderQty, String unitID) throws BOSException, RemoteException;
    public void updateDSEntryState(Context ctx, List entryIDs, String entryState) throws BOSException, RemoteException;
    public boolean isEnableDiscount(Context ctx, String saleOrgUnitID) throws BOSException, RemoteException;
    public void removeOrderDsgridLogs(Context ctx, String orderID) throws BOSException, RemoteException;
    public String getParentCustomer(Context ctx, String customerID) throws BOSException, RemoteException;
    public ResultInfo getFenxiaoDiscountValue(Context ctx, String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException, RemoteException;
    public List getOrderDiscountGridLogs(Context ctx, String orderID) throws BOSException, RemoteException;
    public void removeOrderEntryDsgridLogs(Context ctx, String saleOrderID, String validSaleOrderEntryID) throws BOSException, RemoteException;
    public boolean isDiscountUsed(Context ctx, String dsBillID, String dsEntryID) throws BOSException, RemoteException;
    public boolean isCheckCustomerBalance(Context ctx, String companyID) throws BOSException, RemoteException;
    public boolean isCheckMaterialInventory(Context ctx, String companyID) throws BOSException, RemoteException;
    public Map getDiscountInfos(Context ctx, String companyID, Date beginTime, Date entTime, String discountType, PeriodInfo periodInfo) throws BOSException, RemoteException;
    public ResultInfo addDiscountRecords(Context ctx, CompanyOrgUnitInfo companyInfo, String discountType, Date bizDate, List adjustDSInfos, String adjustType) throws BOSException, RemoteException;
    public boolean generateDiscountRecordbill(Context ctx, String companyID, List discountTypes, List customerList, Date beginDate, Date endDate) throws BOSException, RemoteException;
    public List getDiscountCashInfos(Context ctx, String companyID, List discountTypes, Date beginDate, Date endDate, List customers, boolean isNotReceiving, boolean isHaveReceiving) throws BOSException, RemoteException;
    public boolean generateReceiveBills(Context ctx, String companyID, Map receivRecords) throws BOSException, RemoteException;
    public boolean isExistDestBill(Context ctx, String srcBillID, String SrcBosType) throws BOSException, RemoteException;
    public boolean isExistDSInfos(Context ctx, String customerID, String materialID, String dsType, String dsNameType, String beginDate, String endDate, String dsInfoID) throws BOSException, RemoteException;
    public Object isExistDSInfos(Context ctx, String discountSetID) throws BOSException, RemoteException;
    public MaterialSalesInfo getMaterialSaleinfo(Context ctx, String materialID, String companyID) throws BOSException, RemoteException;
    public MaterialInventoryInfo getInventoryInfo(Context ctx, String matid, String ouid) throws BOSException, RemoteException;
    public BigDecimal getCusMaterialGroupSaleBaseQty(Context ctx, String companyID, String customerID, String materialGroupLongNumber, String materialID, Date accumulateBeginDate, Date accumulateEndDate, Date billBizDate) throws BOSException, RemoteException;
    public BigDecimal getMaterialBagQty(Context ctx, String saleOrgUnitID, String materialID) throws BOSException, RemoteException;
}