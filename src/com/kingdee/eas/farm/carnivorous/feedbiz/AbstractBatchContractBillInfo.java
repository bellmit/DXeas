package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchContractBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBatchContractBillInfo()
    {
        this("id");
    }
    protected AbstractBatchContractBillInfo(String pkField)
    {
        super(pkField);
        put("ReceiveBillEntry", new com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillReceiveBillEntryCollection());
    }
    /**
     * Object:批次合同's 是否生成凭证property 
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
     * Object:批次合同's 单据状态property 
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
     * Object: 批次合同 's 财务组织 property 
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
     * Object:批次合同's 审核时间property 
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
     * Object:批次合同's 是否模板property 
     */
    public boolean isIsTemplate()
    {
        return getBoolean("isTemplate");
    }
    public void setIsTemplate(boolean item)
    {
        setBoolean("isTemplate", item);
    }
    /**
     * Object:批次合同's 身份证号property 
     */
    public String getIdentity()
    {
        return getString("identity");
    }
    public void setIdentity(String item)
    {
        setString("identity", item);
    }
    /**
     * Object:批次合同's 合同开始日期property 
     */
    public java.util.Date getContractDate()
    {
        return getDate("contractDate");
    }
    public void setContractDate(java.util.Date item)
    {
        setDate("contractDate", item);
    }
    /**
     * Object: 批次合同 's 业务员 property 
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
     * Object:批次合同's 手机号property 
     */
    public String getMobileTel()
    {
        return getString("mobileTel");
    }
    public void setMobileTel(String item)
    {
        setString("mobileTel", item);
    }
    /**
     * Object:批次合同's 合同内容property 
     */
    public String getContractContext()
    {
        return getString("contractContext");
    }
    public void setContractContext(String item)
    {
        setString("contractContext", item);
    }
    /**
     * Object:批次合同's 养殖类型property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingTypeEnum getBreedType()
    {
        return com.kingdee.eas.farm.stocking.basedata.StockingTypeEnum.getEnum(getInt("breedType"));
    }
    public void setBreedType(com.kingdee.eas.farm.stocking.basedata.StockingTypeEnum item)
    {
		if (item != null) {
        setInt("breedType", item.getValue());
		}
    }
    /**
     * Object:批次合同's 预计上苗日期property 
     */
    public java.util.Date getBreedDate()
    {
        return getDate("breedDate");
    }
    public void setBreedDate(java.util.Date item)
    {
        setDate("breedDate", item);
    }
    /**
     * Object:批次合同's 公禽数量property 
     */
    public java.math.BigDecimal getBreedQty()
    {
        return getBigDecimal("breedQty");
    }
    public void setBreedQty(java.math.BigDecimal item)
    {
        setBigDecimal("breedQty", item);
    }
    /**
     * Object: 批次合同 's 保证金 property 
     */
    public com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo getMarginBill()
    {
        return (com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo)get("MarginBill");
    }
    public void setMarginBill(com.kingdee.eas.farm.stocking.basebizbill.MarginBillInfo item)
    {
        put("MarginBill", item);
    }
    /**
     * Object:批次合同's 保证金金额property 
     */
    public java.math.BigDecimal getMarginBillAmount()
    {
        return getBigDecimal("MarginBillAmount");
    }
    public void setMarginBillAmount(java.math.BigDecimal item)
    {
        setBigDecimal("MarginBillAmount", item);
    }
    /**
     * Object: 批次合同 's 品种 property 
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
     * Object:批次合同's 合同数量property 
     */
    public java.math.BigDecimal getFemaleBreedQty()
    {
        return getBigDecimal("femaleBreedQty");
    }
    public void setFemaleBreedQty(java.math.BigDecimal item)
    {
        setBigDecimal("femaleBreedQty", item);
    }
    /**
     * Object:批次合同's 初始化单据property 
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
     * Object: 批次合同 's 收款单 property 
     */
    public com.kingdee.eas.fi.cas.ReceivingBillInfo getReceiveBill()
    {
        return (com.kingdee.eas.fi.cas.ReceivingBillInfo)get("receiveBill");
    }
    public void setReceiveBill(com.kingdee.eas.fi.cas.ReceivingBillInfo item)
    {
        put("receiveBill", item);
    }
    /**
     * Object:批次合同's 合同结束日期property 
     */
    public java.util.Date getContractEndDate()
    {
        return getDate("contractEndDate");
    }
    public void setContractEndDate(java.util.Date item)
    {
        setDate("contractEndDate", item);
    }
    /**
     * Object: 批次合同 's 初次种苗领用单 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo getFirstBreedBillSeel()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo)get("firstBreedBillSeel");
    }
    public void setFirstBreedBillSeel(com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo item)
    {
        put("firstBreedBillSeel", item);
    }
    /**
     * Object:批次合同's 实际上苗日期property 
     */
    public java.util.Date getActualBreedDate()
    {
        return getDate("actualBreedDate");
    }
    public void setActualBreedDate(java.util.Date item)
    {
        setDate("actualBreedDate", item);
    }
    /**
     * Object:批次合同's 实际公禽数量property 
     */
    public java.math.BigDecimal getActualbreedQty()
    {
        return getBigDecimal("actualbreedQty");
    }
    public void setActualbreedQty(java.math.BigDecimal item)
    {
        setBigDecimal("actualbreedQty", item);
    }
    /**
     * Object:批次合同's 实际母禽数量property 
     */
    public java.math.BigDecimal getActualFemaleQty()
    {
        return getBigDecimal("actualFemaleQty");
    }
    public void setActualFemaleQty(java.math.BigDecimal item)
    {
        setBigDecimal("actualFemaleQty", item);
    }
    /**
     * Object: 批次合同 's 收款明细 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillReceiveBillEntryCollection getReceiveBillEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillReceiveBillEntryCollection)get("ReceiveBillEntry");
    }
    /**
     * Object: 批次合同 's 养殖户 property 
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
     * Object: 批次合同 's 养殖场 property 
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
     * Object: 批次合同 's 结算政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo getSettlementPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo)get("settlementPolicy");
    }
    public void setSettlementPolicy(com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo item)
    {
        put("settlementPolicy", item);
    }
    /**
     * Object: 批次合同 's 连养合同 property 
     */
    public com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo getSucContract()
    {
        return (com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo)get("sucContract");
    }
    public void setSucContract(com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo item)
    {
        put("sucContract", item);
    }
    /**
     * Object: 批次合同 's 采购员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPurchasePerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("purchasePerson");
    }
    public void setPurchasePerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("purchasePerson", item);
    }
    /**
     * Object:批次合同's 合同类型property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.ContractType getContractType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.ContractType.getEnum(getString("contractType"));
    }
    public void setContractType(com.kingdee.eas.farm.carnivorous.feedbiz.ContractType item)
    {
		if (item != null) {
        setString("contractType", item.getValue());
		}
    }
    /**
     * Object:批次合同's 预计回收日期property 
     */
    public java.util.Date getPreditRecDate()
    {
        return getDate("preditRecDate");
    }
    public void setPreditRecDate(java.util.Date item)
    {
        setDate("preditRecDate", item);
    }
    /**
     * Object:批次合同's 偏离天数property 
     */
    public int getDiffDay()
    {
        return getInt("diffDay");
    }
    public void setDiffDay(int item)
    {
        setInt("diffDay", item);
    }
    /**
     * Object:批次合同's 回收开始日期property 
     */
    public java.util.Date getRecyBeginDate()
    {
        return getDate("recyBeginDate");
    }
    public void setRecyBeginDate(java.util.Date item)
    {
        setDate("recyBeginDate", item);
    }
    /**
     * Object:批次合同's 回收终止日期property 
     */
    public java.util.Date getRecyEndDate()
    {
        return getDate("recyEndDate");
    }
    public void setRecyEndDate(java.util.Date item)
    {
        setDate("recyEndDate", item);
    }
    /**
     * Object:批次合同's 饲喂方式property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.FeedType getFeedType()
    {
        return com.kingdee.eas.farm.carnivorous.feedbiz.FeedType.getEnum(getString("feedType"));
    }
    public void setFeedType(com.kingdee.eas.farm.carnivorous.feedbiz.FeedType item)
    {
		if (item != null) {
        setString("feedType", item.getValue());
		}
    }
    /**
     * Object:批次合同's 基础回收价格property 
     */
    public java.math.BigDecimal getBaseRecPrice()
    {
        return getBigDecimal("baseRecPrice");
    }
    public void setBaseRecPrice(java.math.BigDecimal item)
    {
        setBigDecimal("baseRecPrice", item);
    }
    /**
     * Object: 批次合同 's 上苗批次 property 
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
     * Object:批次合同's 现金保证金金额property 
     */
    public java.math.BigDecimal getMarginAmtInCash()
    {
        return getBigDecimal("marginAmtInCash");
    }
    public void setMarginAmtInCash(java.math.BigDecimal item)
    {
        setBigDecimal("marginAmtInCash", item);
    }
    /**
     * Object:批次合同's 贷款保证金金额property 
     */
    public java.math.BigDecimal getMarginAmtLoan()
    {
        return getBigDecimal("marginAmtLoan");
    }
    public void setMarginAmtLoan(java.math.BigDecimal item)
    {
        setBigDecimal("marginAmtLoan", item);
    }
    /**
     * Object:批次合同's 只保证金金额property 
     */
    public java.math.BigDecimal getMarginPrice()
    {
        return getBigDecimal("marginPrice");
    }
    public void setMarginPrice(java.math.BigDecimal item)
    {
        setBigDecimal("marginPrice", item);
    }
    /**
     * Object:批次合同's 保证金补贴property 
     */
    public java.math.BigDecimal getMarginSubsidy()
    {
        return getBigDecimal("marginSubsidy");
    }
    public void setMarginSubsidy(java.math.BigDecimal item)
    {
        setBigDecimal("marginSubsidy", item);
    }
    /**
     * Object:批次合同's 只保证金（现金）property 
     */
    public java.math.BigDecimal getCashMarginPrice()
    {
        return getBigDecimal("cashMarginPrice");
    }
    public void setCashMarginPrice(java.math.BigDecimal item)
    {
        setBigDecimal("cashMarginPrice", item);
    }
    /**
     * Object:批次合同's 其他property 
     */
    public String getOther()
    {
        return getString("other");
    }
    public void setOther(String item)
    {
        setString("other", item);
    }
    /**
     * Object:批次合同's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object: 批次合同 's 投入政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyInfo getInvestPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyInfo)get("investPolicy");
    }
    public void setInvestPolicy(com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyInfo item)
    {
        put("investPolicy", item);
    }
    /**
     * Object: 批次合同 's 保证金政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyInfo getMarginPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyInfo)get("marginPolicy");
    }
    public void setMarginPolicy(com.kingdee.eas.farm.carnivorous.basedata.MarginPolicyInfo item)
    {
        put("marginPolicy", item);
    }
    /**
     * Object:批次合同's 可用保证金property 
     */
    public java.math.BigDecimal getEnableMargin()
    {
        return getBigDecimal("enableMargin");
    }
    public void setEnableMargin(java.math.BigDecimal item)
    {
        setBigDecimal("enableMargin", item);
    }
    /**
     * Object:批次合同's 应用标准保证金property 
     */
    public java.math.BigDecimal getStandardMargin()
    {
        return getBigDecimal("standardMargin");
    }
    public void setStandardMargin(java.math.BigDecimal item)
    {
        setBigDecimal("standardMargin", item);
    }
    /**
     * Object:批次合同's 应用最低保证金property 
     */
    public java.math.BigDecimal getMinMargin()
    {
        return getBigDecimal("minMargin");
    }
    public void setMinMargin(java.math.BigDecimal item)
    {
        setBigDecimal("minMargin", item);
    }
    /**
     * Object:批次合同's 实际用保证金property 
     */
    public java.math.BigDecimal getUsedMargin()
    {
        return getBigDecimal("usedMargin");
    }
    public void setUsedMargin(java.math.BigDecimal item)
    {
        setBigDecimal("usedMargin", item);
    }
    /**
     * Object: 批次合同 's 连养合同 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo getConFeedContract()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo)get("conFeedContract");
    }
    public void setConFeedContract(com.kingdee.eas.farm.carnivorous.feedbiz.ConFeedContractInfo item)
    {
        put("conFeedContract", item);
    }
    /**
     * Object:批次合同's 已解锁保证金property 
     */
    public java.math.BigDecimal getUnlockMargin()
    {
        return getBigDecimal("unlockMargin");
    }
    public void setUnlockMargin(java.math.BigDecimal item)
    {
        setBigDecimal("unlockMargin", item);
    }
    /**
     * Object:批次合同's 保证金总额property 
     */
    public java.math.BigDecimal getTotalMargin()
    {
        return getBigDecimal("totalMargin");
    }
    public void setTotalMargin(java.math.BigDecimal item)
    {
        setBigDecimal("totalMargin", item);
    }
    /**
     * Object:批次合同's 占用保证金property 
     */
    public java.math.BigDecimal getOccupyMargin()
    {
        return getBigDecimal("occupyMargin");
    }
    public void setOccupyMargin(java.math.BigDecimal item)
    {
        setBigDecimal("occupyMargin", item);
    }
    /**
     * Object:批次合同's 养殖模式property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmsType getFarmsType()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmsType.getEnum(getString("farmsType"));
    }
    public void setFarmsType(com.kingdee.eas.farm.stocking.basedata.FarmsType item)
    {
		if (item != null) {
        setString("farmsType", item.getValue());
		}
    }
    /**
     * Object: 批次合同 's 连养政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo getConFeedPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo)get("conFeedPolicy");
    }
    public void setConFeedPolicy(com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo item)
    {
        put("conFeedPolicy", item);
    }
    /**
     * Object:批次合同's 实际单只保证金property 
     */
    public java.math.BigDecimal getActualSingleMargin()
    {
        return getBigDecimal("actualSingleMargin");
    }
    public void setActualSingleMargin(java.math.BigDecimal item)
    {
        setBigDecimal("actualSingleMargin", item);
    }
    /**
     * Object:批次合同's 养殖场地址property 
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
     * Object:批次合同's 雏苗价格property 
     */
    public java.math.BigDecimal getBreedPrice()
    {
        return getBigDecimal("breedPrice");
    }
    public void setBreedPrice(java.math.BigDecimal item)
    {
        setBigDecimal("breedPrice", item);
    }
    /**
     * Object:批次合同's 已完全回收结算property 
     */
    public boolean isIsRecSettled()
    {
        return getBoolean("isRecSettled");
    }
    public void setIsRecSettled(boolean item)
    {
        setBoolean("isRecSettled", item);
    }
    /**
     * Object: 批次合同 's 担保书 property 
     */
    public com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo getGuaranty()
    {
        return (com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo)get("guaranty");
    }
    public void setGuaranty(com.kingdee.eas.farm.carnivorous.basebiz.FarmerGuaranteeBillInfo item)
    {
        put("guaranty", item);
    }
    /**
     * Object:批次合同's 补贴单价property 
     */
    public java.math.BigDecimal getSubsidyPrice()
    {
        return getBigDecimal("subsidyPrice");
    }
    public void setSubsidyPrice(java.math.BigDecimal item)
    {
        setBigDecimal("subsidyPrice", item);
    }
    /**
     * Object:批次合同's 养大鸡property 
     */
    public boolean isIsFeedBig()
    {
        return getBoolean("isFeedBig");
    }
    public void setIsFeedBig(boolean item)
    {
        setBoolean("isFeedBig", item);
    }
    /**
     * Object: 批次合同 's 屠宰点 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo getSlaughterPoint()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo)get("slaughterPoint");
    }
    public void setSlaughterPoint(com.kingdee.eas.farm.carnivorous.basedata.FreightCalPointInfo item)
    {
        put("slaughterPoint", item);
    }
    /**
     * Object:批次合同's 担保开始日期property 
     */
    public java.util.Date getGuaranteeBeginDate()
    {
        return getDate("guaranteeBeginDate");
    }
    public void setGuaranteeBeginDate(java.util.Date item)
    {
        setDate("guaranteeBeginDate", item);
    }
    /**
     * Object:批次合同's 担保结束日期property 
     */
    public java.util.Date getGuaranteeEndDate()
    {
        return getDate("guaranteeEndDate");
    }
    public void setGuaranteeEndDate(java.util.Date item)
    {
        setDate("guaranteeEndDate", item);
    }
    /**
     * Object:批次合同's 饲料里程property 
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
     * Object: 批次合同 's 成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costObject", item);
    }
    /**
     * Object: 批次合同 's 鸡雏投入政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo getPutPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo)get("putPolicy");
    }
    public void setPutPolicy(com.kingdee.eas.farm.carnivorous.basedata.InvestmentPolicyChickenInfo item)
    {
        put("putPolicy", item);
    }
    /**
     * Object: 批次合同 's 基础价格调整政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo getBasePriceAdjust()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo)get("basePriceAdjust");
    }
    public void setBasePriceAdjust(com.kingdee.eas.farm.carnivorous.basedata.BasePriceAdjustPolicyInfo item)
    {
        put("basePriceAdjust", item);
    }
    /**
     * Object:批次合同's 是否留取保证金property 
     */
    public boolean isIsSetMargin()
    {
        return getBoolean("isSetMargin");
    }
    public void setIsSetMargin(boolean item)
    {
        setBoolean("isSetMargin", item);
    }
    /**
     * Object: 批次合同 's 棚舍 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.carnivorous.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object: 批次合同 's 成本中心 property 
     */
    public com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo getCostCenter()
    {
        return (com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo)get("costCenter");
    }
    public void setCostCenter(com.kingdee.eas.basedata.org.CostCenterOrgUnitInfo item)
    {
        put("costCenter", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F66F7EAF");
    }
}