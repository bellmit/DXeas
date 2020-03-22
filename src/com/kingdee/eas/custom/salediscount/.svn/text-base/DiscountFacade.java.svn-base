package com.kingdee.eas.custom.salediscount;

import com.kingdee.bos.framework.ejb.EJBRemoteException;
import com.kingdee.bos.util.BOSObjectType;
import java.rmi.RemoteException;
import com.kingdee.bos.framework.AbstractBizCtrl;
import com.kingdee.bos.orm.template.ORMObject;

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
import com.kingdee.eas.custom.salediscount.app.*;
import java.math.BigDecimal;
import com.kingdee.eas.custom.ResultInfo;
import com.kingdee.bos.util.*;

public class DiscountFacade extends AbstractBizCtrl implements IDiscountFacade
{
    public DiscountFacade()
    {
        super();
        registerInterface(IDiscountFacade.class, this);
    }
    public DiscountFacade(Context ctx)
    {
        super(ctx);
        registerInterface(IDiscountFacade.class, this);
    }
    public BOSObjectType getType()
    {
        return new BOSObjectType("334BCEF6");
    }
    private DiscountFacadeController getController() throws BOSException
    {
        return (DiscountFacadeController)getBizController();
    }
    /**
     *查询公司折让设置信息-User defined method
     *@param companyID 公司ID
     *@return
     */
    public DiscountCompanyInfo getCompanyDSSet(String companyID) throws BOSException
    {
        try {
            return getController().getCompanyDSSet(getContext(), companyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得指定物料的基本价格-User defined method
     *@param CUid 管理控制单元
     *@param materialID 物料id
     *@param unitID 计量单位ID
     *@return
     */
    public BigDecimal getMaterialBasePrice(String CUid, String materialID, String unitID) throws BOSException
    {
        try {
            return getController().getMaterialBasePrice(getContext(), CUid, materialID, unitID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得立折表达式和折让金额-User defined method
     *@param saleOrgUnitID 销售组织ID
     *@param customerID 客户ID
     *@param materialID 物料ID
     *@param noDSQty 折让前数量
     *@param basePrice 基本价格
     *@param date 日期
     *@param coefficient 换算系数
     *@param dsGridLogs 前台计算的日志
     *@param seq 行号
     *@param saleOrderID 订单ID
     *@param validOrderEntryIDs 有效的订单分录ID
     *@param isSaleReturns 是否是退货申请单
     *@param materialQtyMap 各个分录的销售数量
     *@return
     */
    public ResultInfo getLiDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            return getController().getLiDiscountValue(getContext(), saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得赠包数量-User defined method
     *@param saleOrgUnitID 销售组织ID
     *@param customerID 客户ID
     *@param materialID 物料ID
     *@param noDSQty 折让前数量
     *@param basePrice 基本价格
     *@param date 日期
     *@param coefficient 换算系数
     *@param dsGridLogs 折让日志
     *@param seq 行号
     *@param saleOrderID 订单ID
     *@param validOrderEntryIDs 有效的订单ID
     *@param isSaleReturns 是否是退货申请单
     *@param materialQtyMap 分录销量明细
     *@return
     */
    public ResultInfo getZengBaoDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            return getController().getZengBaoDiscountValue(getContext(), saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得月折金额和月折表达式-User defined method
     *@param saleOrgUnitID 销售组织id
     *@param customerID 客户ID
     *@param materialID 物料ID
     *@param noDSQty 折让前数量
     *@param basePrice 基本价格
     *@param date 日期
     *@param coefficient 系数
     *@param dsGridLogs 折让日志
     *@param seq 行号
     *@param saleOrderID 订单ID
     *@param validOrderEntryIDs 有效的订单分录ID
     *@param isSaleReturns 是否是退货申请单
     *@param materialQtyMap 分录销量明细
     *@return
     */
    public ResultInfo getMonthDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            return getController().getMonthDiscountValue(getContext(), saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得年折 和 年折表达式-User defined method
     *@param saleOrgUnitID 销售组织ID
     *@param customerID 客户ID
     *@param materialID 物料ID
     *@param noDSQty 折让前数量
     *@param basePrice 基本价格
     *@param date 日期
     *@param coefficient 换算系数
     *@param dsGridLogs 折让日志
     *@param seq 行号
     *@param saleOrderID 订单ID
     *@param validOrderEntryIDs 有效的订单分录ID
     *@param isSaleReturns 是否是退货申请单
     *@param materialQtyMap 分录销量明细
     *@return
     */
    public ResultInfo getYearDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            return getController().getYearDiscountValue(getContext(), saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得物料对应价格政策的 价格，如果不存在价格政策，则取对应物料基本价格*单位系数的价格作为  政策价格-User defined method
     *@param companyID 公司id
     *@param customerID 客户ID
     *@param materialID 物料ID
     *@param bizDate 业务日期
     *@param orderQty 订单数量
     *@param unitID 计量单位ID
     *@return
     */
    public BigDecimal getMaterialPolicyPrice(String companyID, String customerID, String materialID, String bizDate, BigDecimal orderQty, String unitID) throws BOSException
    {
        try {
            return getController().getMaterialPolicyPrice(getContext(), companyID, customerID, materialID, bizDate, orderQty, unitID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *批量更新单据分录状态-User defined method
     *@param entryIDs 分录id
     *@param entryState 更新后的状态  1 启用  2  禁用
     */
    public void updateDSEntryState(List entryIDs, String entryState) throws BOSException
    {
        try {
            getController().updateDSEntryState(getContext(), entryIDs, entryState);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *判断公司是否启用折让处理-User defined method
     *@param saleOrgUnitID 销售组织id
     *@return
     */
    public boolean isEnableDiscount(String saleOrgUnitID) throws BOSException
    {
        try {
            return getController().isEnableDiscount(getContext(), saleOrgUnitID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *清除指定订单的折让计算日志-User defined method
     *@param orderID 订单id
     */
    public void removeOrderDsgridLogs(String orderID) throws BOSException
    {
        try {
            getController().removeOrderDsgridLogs(getContext(), orderID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得指定客户的上级客户ID-User defined method
     *@param customerID 客户ID
     *@return
     */
    public String getParentCustomer(String customerID) throws BOSException
    {
        try {
            return getController().getParentCustomer(getContext(), customerID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得分销折让数据-User defined method
     *@param saleOrgUnitID 销售组织ID
     *@param customerID 客户ID
     *@param materialID 物料ID
     *@param noDSQty 不含折扣数量
     *@param basePrice 基本价格
     *@param date 日期
     *@param coefficient 换算系数
     *@param dsGridLogs 折让日志
     *@param seq 行号
     *@param saleOrderID 订单ID
     *@param validOrderEntryIDs 有效的订单分录ID
     *@param isSaleReturns 是否是退货申请单
     *@param materialQtyMap 获得分录销量明细
     *@return
     */
    public ResultInfo getFenxiaoDiscountValue(String saleOrgUnitID, String customerID, String materialID, BigDecimal noDSQty, BigDecimal basePrice, String date, BigDecimal coefficient, List dsGridLogs, int seq, String saleOrderID, String validOrderEntryIDs, boolean isSaleReturns, Map materialQtyMap) throws BOSException
    {
        try {
            return getController().getFenxiaoDiscountValue(getContext(), saleOrgUnitID, customerID, materialID, noDSQty, basePrice, date, coefficient, dsGridLogs, seq, saleOrderID, validOrderEntryIDs, isSaleReturns, materialQtyMap);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得订单暂存的折让日志记录-User defined method
     *@param orderID 订单id
     *@return
     */
    public List getOrderDiscountGridLogs(String orderID) throws BOSException
    {
        try {
            return getController().getOrderDiscountGridLogs(getContext(), orderID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *删除指定的订单分录的销售折让日志信息-User defined method
     *@param saleOrderID 订单ID
     *@param validSaleOrderEntryID 有效订单分录ID
     */
    public void removeOrderEntryDsgridLogs(String saleOrderID, String validSaleOrderEntryID) throws BOSException
    {
        try {
            getController().removeOrderEntryDsgridLogs(getContext(), saleOrderID, validSaleOrderEntryID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *isDiscountUsed-User defined method
     *@param dsBillID 折让政策ID
     *@param dsEntryID 政策分录ID
     *@return
     */
    public boolean isDiscountUsed(String dsBillID, String dsEntryID) throws BOSException
    {
        try {
            return getController().isDiscountUsed(getContext(), dsBillID, dsEntryID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *是否校验客户应收余额-User defined method
     *@param companyID 公司ID
     *@return
     */
    public boolean isCheckCustomerBalance(String companyID) throws BOSException
    {
        try {
            return getController().isCheckCustomerBalance(getContext(), companyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *是否校验物料库存-User defined method
     *@param companyID 公司ID
     *@return
     */
    public boolean isCheckMaterialInventory(String companyID) throws BOSException
    {
        try {
            return getController().isCheckMaterialInventory(getContext(), companyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得指定时间段 指定类型的订单折让数据-User defined method
     *@param companyID 公司
     *@param beginTime 开始时间
     *@param entTime 结束时间
     *@param discountType 折让类别
     *@param periodInfo 期间
     *@return
     */
    public Map getDiscountInfos(String companyID, Date beginTime, Date entTime, String discountType, PeriodInfo periodInfo) throws BOSException
    {
        try {
            return getController().getDiscountInfos(getContext(), companyID, beginTime, entTime, discountType, periodInfo);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *添加由调整平台生成的折让记录单-User defined method
     *@param companyInfo 公司
     *@param discountType 折让类别
     *@param bizDate 记录单业务日期
     *@param adjustDSInfos 需要保存的调整信息
     *@param adjustType tiaozhengfangshi
     *@return
     */
    public ResultInfo addDiscountRecords(CompanyOrgUnitInfo companyInfo, String discountType, Date bizDate, List adjustDSInfos, String adjustType) throws BOSException
    {
        try {
            return getController().addDiscountRecords(getContext(), companyInfo, discountType, bizDate, adjustDSInfos, adjustType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *从销售订单生成折让记录单-User defined method
     *@param companyID 公司ID
     *@param discountTypes 需要生成结算单的  折让类型列表
     *@param customerList 客户列表
     *@param beginDate 开始时间
     *@param endDate 结束日期
     *@return
     */
    public boolean generateDiscountRecordbill(String companyID, List discountTypes, List customerList, Date beginDate, Date endDate) throws BOSException
    {
        try {
            return getController().generateDiscountRecordbill(getContext(), companyID, discountTypes, customerList, beginDate, endDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获取指定的 兑现信息-User defined method
     *@param companyID 公司ID
     *@param discountTypes 折让类型
     *@param beginDate 开始时间
     *@param endDate 结束时间
     *@param customers 客户
     *@param isNotReceiving isNotReceiving
     *@param isHaveReceiving 已生成
     *@return
     */
    public List getDiscountCashInfos(String companyID, List discountTypes, Date beginDate, Date endDate, List customers, boolean isNotReceiving, boolean isHaveReceiving) throws BOSException
    {
        try {
            return getController().getDiscountCashInfos(getContext(), companyID, discountTypes, beginDate, endDate, customers, isNotReceiving, isHaveReceiving);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *生成收款单-User defined method
     *@param companyID 公司id
     *@param receivRecords 需要保存的  记录单
     *@return
     */
    public boolean generateReceiveBills(String companyID, Map receivRecords) throws BOSException
    {
        try {
            return getController().generateReceiveBills(getContext(), companyID, receivRecords);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *判断单据是否已经存在了下游单据-User defined method
     *@param srcBillID 单据ID
     *@param SrcBosType SrcBosType
     *@return
     */
    public boolean isExistDestBill(String srcBillID, String SrcBosType) throws BOSException
    {
        try {
            return getController().isExistDestBill(getContext(), srcBillID, SrcBosType);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *判断对应折让政策的分录是否和其他政策有重复-User defined method
     *@param customerID 客户ID
     *@param materialID 物料ID
     *@param dsType 折让类别
     *@param dsNameType 政策类别
     *@param beginDate 开始时间
     *@param endDate 结束时间
     *@param dsInfoID 当前政策ID
     *@return
     */
    public boolean isExistDSInfos(String customerID, String materialID, String dsType, String dsNameType, String beginDate, String endDate, String dsInfoID) throws BOSException
    {
        try {
            return getController().isExistDSInfos(getContext(), customerID, materialID, dsType, dsNameType, beginDate, endDate, dsInfoID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *判断对应折让政策的分录是否和其他政策有重复-User defined method
     *@param discountSetID 政策ID
     *@return
     */
    public Object isExistDSInfos(String discountSetID) throws BOSException
    {
        try {
            return getController().isExistDSInfos(getContext(), discountSetID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得指定物料的 销售资料-User defined method
     *@param materialID materialID
     *@param companyID companyID
     *@return
     */
    public MaterialSalesInfo getMaterialSaleinfo(String materialID, String companyID) throws BOSException
    {
        try {
            return getController().getMaterialSaleinfo(getContext(), materialID, companyID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *getInventoryInfo-User defined method
     *@param matid 物料ID
     *@param ouid 组织ID
     *@return
     */
    public MaterialInventoryInfo getInventoryInfo(String matid, String ouid) throws BOSException
    {
        try {
            return getController().getInventoryInfo(getContext(), matid, ouid);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *获得客户在指定公司特定时间内某种物料分类的销量合计-User defined method
     *@param companyID 公司ID
     *@param customerID 客户ID
     *@param materialGroupLongNumber 物料分类长编码
     *@param materialID 物料ID
     *@param accumulateBeginDate 累计开始时间
     *@param accumulateEndDate 累计结束时间
     *@param billBizDate 单据业务日期
     *@return
     */
    public BigDecimal getCusMaterialGroupSaleBaseQty(String companyID, String customerID, String materialGroupLongNumber, String materialID, Date accumulateBeginDate, Date accumulateEndDate, Date billBizDate) throws BOSException
    {
        try {
            return getController().getCusMaterialGroupSaleBaseQty(getContext(), companyID, customerID, materialGroupLongNumber, materialID, accumulateBeginDate, accumulateEndDate, billBizDate);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
    /**
     *查询物料单包重-User defined method
     *@param saleOrgUnitID saleOrgUnitID
     *@param materialID materialID
     *@return
     */
    public BigDecimal getMaterialBagQty(String saleOrgUnitID, String materialID) throws BOSException
    {
        try {
            return getController().getMaterialBagQty(getContext(), saleOrgUnitID, materialID);
        }
        catch(RemoteException err) {
            throw new EJBRemoteException(err);
        }
    }
}