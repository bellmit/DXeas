package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFodderReceptionInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFodderReceptionInfo()
    {
        this("id");
    }
    protected AbstractFodderReceptionInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryCollection());
    }
    /**
     * Object: 饲料领用单 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.FodderReceptionEntryCollection)get("entrys");
    }
    /**
     * Object:饲料领用单's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object:饲料领用单's 单据状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object: 饲料领用单 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object:饲料领用单's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object: 饲料领用单 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object:饲料领用单's 初始化单据property 
     */
    public boolean isIsInit()
    {
        return getBoolean("isInit");
    }
    public void setIsInit(boolean item)
    {
        setBoolean("isInit", item);
    }
    /**
     * Object: 饲料领用单 's 司机 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverInfo getDriver()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverInfo)get("driver");
    }
    public void setDriver(com.kingdee.eas.farm.feemanager.basedata.DriverInfo item)
    {
        put("driver", item);
    }
    /**
     * Object:饲料领用单's 车牌号property 
     */
    public String getCarNo()
    {
        return getString("carNo");
    }
    public void setCarNo(String item)
    {
        setString("carNo", item);
    }
    /**
     * Object:饲料领用单's 联系方式property 
     */
    public String getLinkCell()
    {
        return getString("linkCell");
    }
    public void setLinkCell(String item)
    {
        setString("linkCell", item);
    }
    /**
     * Object: 饲料领用单 's 业务员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getBizPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("bizPerson");
    }
    public void setBizPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("bizPerson", item);
    }
    /**
     * Object: 饲料领用单 's 技术员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:饲料领用单's 业务类型property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType getBillType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType.getEnum(getString("billType"));
    }
    public void setBillType(com.kingdee.eas.farm.carnivorous.feedbiz.FodderBillType item)
    {
		if (item != null) {
        setString("billType", item.getValue());
		}
    }
    /**
     * Object:饲料领用单's 凭证号property 
     */
    public String getVoucherNum()
    {
        return getString("voucherNum");
    }
    public void setVoucherNum(String item)
    {
        setString("voucherNum", item);
    }
    /**
     * Object:饲料领用单's 是否生成领料出property 
     */
    public boolean isIsHasMaterialReq()
    {
        return getBoolean("isHasMaterialReq");
    }
    public void setIsHasMaterialReq(boolean item)
    {
        setBoolean("isHasMaterialReq", item);
    }
    /**
     * Object: 饲料领用单 's 退料公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getReturnCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("returnCompany");
    }
    public void setReturnCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("returnCompany", item);
    }
    /**
     * Object:饲料领用单's 来源类型property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.fodderSourceType getFodderSourceType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.fodderSourceType.getEnum(getString("fodderSourceType"));
    }
    public void setFodderSourceType(com.kingdee.eas.farm.carnivorous.feedbiz.fodderSourceType item)
    {
		if (item != null) {
        setString("fodderSourceType", item.getValue());
		}
    }
    /**
     * Object:饲料领用单's 是否生成销售订单property 
     */
    public boolean isIsHasSaleOrder()
    {
        return getBoolean("isHasSaleOrder");
    }
    public void setIsHasSaleOrder(boolean item)
    {
        setBoolean("isHasSaleOrder", item);
    }
    /**
     * Object:饲料领用单's 是否生成销售退货申请单property 
     */
    public boolean isIsHasSaleReturn()
    {
        return getBoolean("isHasSaleReturn");
    }
    public void setIsHasSaleReturn(boolean item)
    {
        setBoolean("isHasSaleReturn", item);
    }
    /**
     * Object: 饲料领用单 's 养殖户 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: 饲料领用单 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 饲料领用单 's 批次合同 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getBatchContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("batchContract");
    }
    public void setBatchContract(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("batchContract", item);
    }
    /**
     * Object: 饲料领用单 's 养殖批次 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getBatch()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("batch");
    }
    public void setBatch(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("batch", item);
    }
    /**
     * Object: 饲料领用单 's 结算政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo getSettlePolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo)get("settlePolicy");
    }
    public void setSettlePolicy(com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo item)
    {
        put("settlePolicy", item);
    }
    /**
     * Object:饲料领用单's 日龄property 
     */
    public int getWeekDay()
    {
        return getInt("weekDay");
    }
    public void setWeekDay(int item)
    {
        setInt("weekDay", item);
    }
    /**
     * Object:饲料领用单's 上苗日期property 
     */
    public java.util.Date getIndate()
    {
        return getDate("indate");
    }
    public void setIndate(java.util.Date item)
    {
        setDate("indate", item);
    }
    /**
     * Object:饲料领用单's 上苗数量property 
     */
    public java.math.BigDecimal getBatchQty()
    {
        return getBigDecimal("batchQty");
    }
    public void setBatchQty(java.math.BigDecimal item)
    {
        setBigDecimal("batchQty", item);
    }
    /**
     * Object: 饲料领用单 's 外购供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object: 饲料领用单 's 车辆 property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCar()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("car");
    }
    public void setCar(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("car", item);
    }
    /**
     * Object:饲料领用单's 是否提料property 
     */
    public boolean isIsTiLiao()
    {
        return getBoolean("isTiLiao");
    }
    public void setIsTiLiao(boolean item)
    {
        setBoolean("isTiLiao", item);
    }
    /**
     * Object:饲料领用单's 是否生成其他出库单property 
     */
    public boolean isIsOtherIssue()
    {
        return getBoolean("isOtherIssue");
    }
    public void setIsOtherIssue(boolean item)
    {
        setBoolean("isOtherIssue", item);
    }
    /**
     * Object:饲料领用单's 是否生成销售出库property 
     */
    public boolean isIsHasSaleIssue()
    {
        return getBoolean("isHasSaleIssue");
    }
    public void setIsHasSaleIssue(boolean item)
    {
        setBoolean("isHasSaleIssue", item);
    }
    /**
     * Object:饲料领用单's 由调料单生成property 
     */
    public boolean isIsFromTiaoLiao()
    {
        return getBoolean("isFromTiaoLiao");
    }
    public void setIsFromTiaoLiao(boolean item)
    {
        setBoolean("isFromTiaoLiao", item);
    }
    /**
     * Object:饲料领用单's 是否散装property 
     */
    public boolean isIsSanZhuang()
    {
        return getBoolean("isSanZhuang");
    }
    public void setIsSanZhuang(boolean item)
    {
        setBoolean("isSanZhuang", item);
    }
    /**
     * Object:饲料领用单's 养殖户电话property 
     */
    public String getFarmerPhone()
    {
        return getString("farmerPhone");
    }
    public void setFarmerPhone(String item)
    {
        setString("farmerPhone", item);
    }
    /**
     * Object:饲料领用单's 养殖场地址property 
     */
    public String getFarmAddress()
    {
        return getString("farmAddress");
    }
    public void setFarmAddress(String item)
    {
        setString("farmAddress", item);
    }
    /**
     * Object:饲料领用单's 是否过磅property 
     */
    public boolean isIsWeight()
    {
        return getBoolean("isWeight");
    }
    public void setIsWeight(boolean item)
    {
        setBoolean("isWeight", item);
    }
    /**
     * Object:饲料领用单's 已打印次数property 
     */
    public int getPrntTime()
    {
        return getInt("prntTime");
    }
    public void setPrntTime(int item)
    {
        setInt("prntTime", item);
    }
    /**
     * Object:饲料领用单's 料仓property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum getBunker()
    {
        return com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum.getEnum(getString("bunker"));
    }
    public void setBunker(com.kingdee.eas.farm.carnivorous.basedata.BunkerEnum item)
    {
		if (item != null) {
        setString("bunker", item.getValue());
		}
    }
    /**
     * Object:饲料领用单's 退料处理意见property 
     */
    public String getReturnOpinion()
    {
        return getString("returnOpinion");
    }
    public void setReturnOpinion(String item)
    {
        setString("returnOpinion", item);
    }
    /**
     * Object: 饲料领用单 's 成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenter");
    }
    public void setCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenter", item);
    }
    /**
     * Object: 饲料领用单 's 品种 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedDataInfo getBreedData()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedDataInfo)get("breedData");
    }
    public void setBreedData(com.kingdee.eas.farm.stocking.basedata.BreedDataInfo item)
    {
        put("breedData", item);
    }
    /**
     * Object:饲料领用单's 饲料里程数property 
     */
    public java.math.BigDecimal getFeedInstance()
    {
        return getBigDecimal("feedInstance");
    }
    public void setFeedInstance(java.math.BigDecimal item)
    {
        setBigDecimal("feedInstance", item);
    }
    /**
     * Object:饲料领用单's 前期肉仔鸡配合饲料标准用量：property 
     */
    public java.math.BigDecimal getEarlyStand()
    {
        return getBigDecimal("earlyStand");
    }
    public void setEarlyStand(java.math.BigDecimal item)
    {
        setBigDecimal("earlyStand", item);
    }
    /**
     * Object:饲料领用单's 前期肉仔鸡配合饲料已开票数量：property 
     */
    public java.math.BigDecimal getEarlyVou()
    {
        return getBigDecimal("earlyVou");
    }
    public void setEarlyVou(java.math.BigDecimal item)
    {
        setBigDecimal("earlyVou", item);
    }
    /**
     * Object:饲料领用单's 前期肉仔鸡配合饲料已审核数量：property 
     */
    public java.math.BigDecimal getEarlyAudit()
    {
        return getBigDecimal("earlyAudit");
    }
    public void setEarlyAudit(java.math.BigDecimal item)
    {
        setBigDecimal("earlyAudit", item);
    }
    /**
     * Object:饲料领用单's 前期肉仔鸡配合饲料未审核数量：property 
     */
    public java.math.BigDecimal getEarlyUnAudit()
    {
        return getBigDecimal("earlyUnAudit");
    }
    public void setEarlyUnAudit(java.math.BigDecimal item)
    {
        setBigDecimal("earlyUnAudit", item);
    }
    /**
     * Object:饲料领用单's 前期肉仔鸡配合饲料允许开票数量：property 
     */
    public java.math.BigDecimal getEarlyAllow()
    {
        return getBigDecimal("earlyAllow");
    }
    public void setEarlyAllow(java.math.BigDecimal item)
    {
        setBigDecimal("earlyAllow", item);
    }
    /**
     * Object:饲料领用单's 中期肉仔鸡配合饲料标准用量：property 
     */
    public java.math.BigDecimal getMidStand()
    {
        return getBigDecimal("midStand");
    }
    public void setMidStand(java.math.BigDecimal item)
    {
        setBigDecimal("midStand", item);
    }
    /**
     * Object:饲料领用单's 中期肉仔鸡配合饲料已开票数量：property 
     */
    public java.math.BigDecimal getMidVouch()
    {
        return getBigDecimal("midVouch");
    }
    public void setMidVouch(java.math.BigDecimal item)
    {
        setBigDecimal("midVouch", item);
    }
    /**
     * Object:饲料领用单's 中期肉仔鸡配合饲料已审核数量：property 
     */
    public java.math.BigDecimal getMidAudit()
    {
        return getBigDecimal("midAudit");
    }
    public void setMidAudit(java.math.BigDecimal item)
    {
        setBigDecimal("midAudit", item);
    }
    /**
     * Object:饲料领用单's 中期肉仔鸡配合饲料未审核数量：property 
     */
    public java.math.BigDecimal getMidUnAudit()
    {
        return getBigDecimal("midUnAudit");
    }
    public void setMidUnAudit(java.math.BigDecimal item)
    {
        setBigDecimal("midUnAudit", item);
    }
    /**
     * Object:饲料领用单's 中期肉仔鸡配合饲料允许开票数量：property 
     */
    public java.math.BigDecimal getMidAllow()
    {
        return getBigDecimal("midAllow");
    }
    public void setMidAllow(java.math.BigDecimal item)
    {
        setBigDecimal("midAllow", item);
    }
    /**
     * Object:饲料领用单's 后期肉仔鸡配合饲料标准用量：property 
     */
    public java.math.BigDecimal getLateStand()
    {
        return getBigDecimal("lateStand");
    }
    public void setLateStand(java.math.BigDecimal item)
    {
        setBigDecimal("lateStand", item);
    }
    /**
     * Object:饲料领用单's 后期肉仔鸡配合饲料已开票数量：property 
     */
    public java.math.BigDecimal getLateVoucher()
    {
        return getBigDecimal("lateVoucher");
    }
    public void setLateVoucher(java.math.BigDecimal item)
    {
        setBigDecimal("lateVoucher", item);
    }
    /**
     * Object:饲料领用单's 后期肉仔鸡配合饲料已审核数量：property 
     */
    public java.math.BigDecimal getLateAudit()
    {
        return getBigDecimal("lateAudit");
    }
    public void setLateAudit(java.math.BigDecimal item)
    {
        setBigDecimal("lateAudit", item);
    }
    /**
     * Object:饲料领用单's 后期肉仔鸡配合饲料未审核数量：property 
     */
    public java.math.BigDecimal getLateUnAudit()
    {
        return getBigDecimal("lateUnAudit");
    }
    public void setLateUnAudit(java.math.BigDecimal item)
    {
        setBigDecimal("lateUnAudit", item);
    }
    /**
     * Object:饲料领用单's 后期肉仔鸡配合饲料允许开票数量：property 
     */
    public java.math.BigDecimal getLateAllow()
    {
        return getBigDecimal("lateAllow");
    }
    public void setLateAllow(java.math.BigDecimal item)
    {
        setBigDecimal("lateAllow", item);
    }
    /**
     * Object:饲料领用单's 合同数量property 
     */
    public java.math.BigDecimal getContractQty()
    {
        return getBigDecimal("contractQty");
    }
    public void setContractQty(java.math.BigDecimal item)
    {
        setBigDecimal("contractQty", item);
    }
    /**
     * Object:饲料领用单's 是否进超药流程property 
     */
    public String getAllowProcess()
    {
        return getString("allowProcess");
    }
    public void setAllowProcess(String item)
    {
        setString("allowProcess", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("713C6B15");
    }
}