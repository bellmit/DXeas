package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDrugReceiveBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractDrugReceiveBillInfo()
    {
        this("id");
    }
    protected AbstractDrugReceiveBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillEntryCollection());
    }
    /**
     * Object: 药品处方单 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.DrugReceiveBillEntryCollection)get("entrys");
    }
    /**
     * Object:药品处方单's 是否生成凭证property 
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
     * Object:药品处方单's 单据状态property 
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
     * Object: 药品处方单 's 财务组织 property 
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
     * Object:药品处方单's 审核时间property 
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
     * Object: 药品处方单 's 库存组织 property 
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
     * Object:药品处方单's 初始化单据property 
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
     * Object:药品处方单's 是否生成领料出库property 
     */
    public boolean isIsHasMaterial()
    {
        return getBoolean("isHasMaterial");
    }
    public void setIsHasMaterial(boolean item)
    {
        setBoolean("isHasMaterial", item);
    }
    /**
     * Object:药品处方单's 是否生成调拨出库property 
     */
    public boolean isIsHasTrans()
    {
        return getBoolean("isHasTrans");
    }
    public void setIsHasTrans(boolean item)
    {
        setBoolean("isHasTrans", item);
    }
    /**
     * Object: 药品处方单 's 养殖户 property 
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
     * Object: 药品处方单 's 养殖场 property 
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
     * Object: 药品处方单 's 批次 property 
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
     * Object: 药品处方单 's 批次合同 property 
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
     * Object: 药品处方单 's 司机 property 
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
     * Object:药品处方单's 上苗日期property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object:药品处方单's 上苗数量property 
     */
    public java.math.BigDecimal getInQty()
    {
        return getBigDecimal("inQty");
    }
    public void setInQty(java.math.BigDecimal item)
    {
        setBigDecimal("inQty", item);
    }
    /**
     * Object:药品处方单's 总成本property 
     */
    public java.math.BigDecimal getTotalCost()
    {
        return getBigDecimal("totalCost");
    }
    public void setTotalCost(java.math.BigDecimal item)
    {
        setBigDecimal("totalCost", item);
    }
    /**
     * Object:药品处方单's 总金额property 
     */
    public java.math.BigDecimal getTotalAmt()
    {
        return getBigDecimal("totalAmt");
    }
    public void setTotalAmt(java.math.BigDecimal item)
    {
        setBigDecimal("totalAmt", item);
    }
    /**
     * Object:药品处方单's 凭证号property 
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
     * Object: 药品处方单 's 养殖政策 property 
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
     * Object: 药品处方单 's 品种 property 
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
     * Object: 药品处方单 's 业务员 property 
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
     * Object:药品处方单's 已开药单只金额property 
     */
    public java.math.BigDecimal getDrugedSingleAmt()
    {
        return getBigDecimal("drugedSingleAmt");
    }
    public void setDrugedSingleAmt(java.math.BigDecimal item)
    {
        setBigDecimal("drugedSingleAmt", item);
    }
    /**
     * Object:药品处方单's 由药品调整单生成property 
     */
    public boolean isIsFromTiaoYao()
    {
        return getBoolean("isFromTiaoYao");
    }
    public void setIsFromTiaoYao(boolean item)
    {
        setBoolean("isFromTiaoYao", item);
    }
    /**
     * Object:药品处方单's 业务类型property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.DrugBizType getBizType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.DrugBizType.getEnum(getString("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.carnivorous.feedbiz.DrugBizType item)
    {
		if (item != null) {
        setString("bizType", item.getValue());
		}
    }
    /**
     * Object:药品处方单's 养殖户电话property 
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
     * Object:药品处方单's 养殖场地址property 
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
     * Object:药品处方单's 已打印次数property 
     */
    public int getPrintTime()
    {
        return getInt("printTime");
    }
    public void setPrintTime(int item)
    {
        setInt("printTime", item);
    }
    /**
     * Object: 药品处方单 's 职业兽医师 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.VetInfo getVet()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.VetInfo)get("vet");
    }
    public void setVet(com.kingdee.eas.farm.carnivorous.basedata.VetInfo item)
    {
        put("vet", item);
    }
    /**
     * Object: 药品处方单 's 成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostcenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costcenter");
    }
    public void setCostcenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costcenter", item);
    }
    /**
     * Object:药品处方单's 已开药总金额property 
     */
    public java.math.BigDecimal getHasDrugAmount()
    {
        return getBigDecimal("hasDrugAmount");
    }
    public void setHasDrugAmount(java.math.BigDecimal item)
    {
        setBigDecimal("hasDrugAmount", item);
    }
    /**
     * Object:药品处方单's 最高开药金额property 
     */
    public java.math.BigDecimal getHignDrugAmount()
    {
        return getBigDecimal("hignDrugAmount");
    }
    public void setHignDrugAmount(java.math.BigDecimal item)
    {
        setBigDecimal("hignDrugAmount", item);
    }
    /**
     * Object:药品处方单's 已开药单只金额property 
     */
    public java.math.BigDecimal getHasOneDrug()
    {
        return getBigDecimal("hasOneDrug");
    }
    public void setHasOneDrug(java.math.BigDecimal item)
    {
        setBigDecimal("hasOneDrug", item);
    }
    /**
     * Object:药品处方单's 已开药总金额property 
     */
    public java.math.BigDecimal getSaveAmount()
    {
        return getBigDecimal("saveAmount");
    }
    public void setSaveAmount(java.math.BigDecimal item)
    {
        setBigDecimal("saveAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0E74B6E6");
    }
}