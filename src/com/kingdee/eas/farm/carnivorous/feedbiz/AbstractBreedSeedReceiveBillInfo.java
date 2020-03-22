package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedSeedReceiveBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBreedSeedReceiveBillInfo()
    {
        this("id");
    }
    protected AbstractBreedSeedReceiveBillInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryCollection());
    }
    /**
     * Object: 雏苗领用单 's 分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BreedSeedReceiveBillEntryCollection)get("entrys");
    }
    /**
     * Object:雏苗领用单's 是否生成凭证property 
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
     * Object:雏苗领用单's 单据状态property 
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
     * Object: 雏苗领用单 's 财务组织 property 
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
     * Object:雏苗领用单's 审核时间property 
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
     * Object: 雏苗领用单 's 库存组织 property 
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
     * Object:雏苗领用单's 批次号property 
     */
    public String getStockingBatchNum()
    {
        return getString("stockingBatchNum");
    }
    public void setStockingBatchNum(String item)
    {
        setString("stockingBatchNum", item);
    }
    /**
     * Object: 雏苗领用单 's 品种 property 
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
     * Object:雏苗领用单's 数量property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:雏苗领用单's 母禽数量property 
     */
    public java.math.BigDecimal getFemaleQty()
    {
        return getBigDecimal("femaleQty");
    }
    public void setFemaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleQty", item);
    }
    /**
     * Object:雏苗领用单's 初始化单据property 
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
     * Object: 雏苗领用单 's 养殖户 property 
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
     * Object: 雏苗领用单 's 养殖场 property 
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
     * Object: 雏苗领用单 's 领用批次 property 
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
     * Object: 雏苗领用单 's 批次合同 property 
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
     * Object: 雏苗领用单 's 司机 property 
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
     * Object: 雏苗领用单 's 业务员 property 
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
     * Object: 雏苗领用单 's 采购员 property 
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
     * Object:雏苗领用单's 业务类型property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum getBizType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum.getEnum(getString("bizType"));
    }
    public void setBizType(com.kingdee.eas.farm.carnivorous.feedbiz.BizTypeEnum item)
    {
		if (item != null) {
        setString("bizType", item.getValue());
		}
    }
    /**
     * Object:雏苗领用单's 凭证号property 
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
     * Object:雏苗领用单's 是否生成领料出property 
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
     * Object:雏苗领用单's 是否生成销售出property 
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
     * Object:雏苗领用单's 雏苗来源类型property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.SeedSourceType getSeedSourceType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.SeedSourceType.getEnum(getString("seedSourceType"));
    }
    public void setSeedSourceType(com.kingdee.eas.farm.carnivorous.feedbiz.SeedSourceType item)
    {
		if (item != null) {
        setString("seedSourceType", item.getValue());
		}
    }
    /**
     * Object: 雏苗领用单 's 来源孵化场 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataInfo getSourceHatchArea()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataInfo)get("sourceHatchArea");
    }
    public void setSourceHatchArea(com.kingdee.eas.farm.hatch.HatchBaseDataInfo item)
    {
        put("sourceHatchArea", item);
    }
    /**
     * Object:雏苗领用单's 实际上苗日期property 
     */
    public java.util.Date getActualBizdate()
    {
        return getDate("actualBizdate");
    }
    public void setActualBizdate(java.util.Date item)
    {
        setDate("actualBizdate", item);
    }
    /**
     * Object: 雏苗领用单 's 养殖政策 property 
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
     * Object: 雏苗领用单 's 外购供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getPurSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("purSupplier");
    }
    public void setPurSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("purSupplier", item);
    }
    /**
     * Object:雏苗领用单's 是否生成其他出库单property 
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
     * Object:雏苗领用单's 养殖户电话property 
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
     * Object:雏苗领用单's 养殖场地址property 
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
     * Object:雏苗领用单's 已打印次数property 
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
     * Object:雏苗领用单's 雏苗来源property 
     */
    public String getSeedSource()
    {
        return getString("seedSource");
    }
    public void setSeedSource(String item)
    {
        setString("seedSource", item);
    }
    /**
     * Object: 雏苗领用单 's 成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costObject", item);
    }
    /**
     * Object:雏苗领用单's 是否注射油苗property 
     */
    public boolean isIsInsertImm()
    {
        return getBoolean("isInsertImm");
    }
    public void setIsInsertImm(boolean item)
    {
        setBoolean("isInsertImm", item);
    }
    /**
     * Object:雏苗领用单's 是否生产入负数property 
     */
    public boolean isIsManuIn()
    {
        return getBoolean("isManuIn");
    }
    public void setIsManuIn(boolean item)
    {
        setBoolean("isManuIn", item);
    }
    /**
     * Object:雏苗领用单's 是否其它入property 
     */
    public boolean isIsOtherIn()
    {
        return getBoolean("isOtherIn");
    }
    public void setIsOtherIn(boolean item)
    {
        setBoolean("isOtherIn", item);
    }
    /**
     * Object: 雏苗领用单 's 放雏员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getChickenPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("chickenPerson");
    }
    public void setChickenPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("chickenPerson", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("681AB2A9");
    }
}