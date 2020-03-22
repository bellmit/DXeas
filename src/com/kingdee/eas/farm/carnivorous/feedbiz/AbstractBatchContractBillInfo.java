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
     * Object:���κ�ͬ's �Ƿ�����ƾ֤property 
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
     * Object:���κ�ͬ's ����״̬property 
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
     * Object: ���κ�ͬ 's ������֯ property 
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
     * Object:���κ�ͬ's ���ʱ��property 
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
     * Object:���κ�ͬ's �Ƿ�ģ��property 
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
     * Object:���κ�ͬ's ���֤��property 
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
     * Object:���κ�ͬ's ��ͬ��ʼ����property 
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
     * Object: ���κ�ͬ 's ҵ��Ա property 
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
     * Object:���κ�ͬ's �ֻ���property 
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
     * Object:���κ�ͬ's ��ͬ����property 
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
     * Object:���κ�ͬ's ��ֳ����property 
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
     * Object:���κ�ͬ's Ԥ����������property 
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
     * Object:���κ�ͬ's ��������property 
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
     * Object: ���κ�ͬ 's ��֤�� property 
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
     * Object:���κ�ͬ's ��֤����property 
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
     * Object: ���κ�ͬ 's Ʒ�� property 
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
     * Object:���κ�ͬ's ��ͬ����property 
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
     * Object:���κ�ͬ's ��ʼ������property 
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
     * Object: ���κ�ͬ 's �տ property 
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
     * Object:���κ�ͬ's ��ͬ��������property 
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
     * Object: ���κ�ͬ 's �����������õ� property 
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
     * Object:���κ�ͬ's ʵ����������property 
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
     * Object:���κ�ͬ's ʵ�ʹ�������property 
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
     * Object:���κ�ͬ's ʵ��ĸ������property 
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
     * Object: ���κ�ͬ 's �տ���ϸ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillReceiveBillEntryCollection getReceiveBillEntry()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillReceiveBillEntryCollection)get("ReceiveBillEntry");
    }
    /**
     * Object: ���κ�ͬ 's ��ֳ�� property 
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
     * Object: ���κ�ͬ 's ��ֳ�� property 
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
     * Object: ���κ�ͬ 's �������� property 
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
     * Object: ���κ�ͬ 's ������ͬ property 
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
     * Object: ���κ�ͬ 's �ɹ�Ա property 
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
     * Object:���κ�ͬ's ��ͬ����property 
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
     * Object:���κ�ͬ's Ԥ�ƻ�������property 
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
     * Object:���κ�ͬ's ƫ������property 
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
     * Object:���κ�ͬ's ���տ�ʼ����property 
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
     * Object:���κ�ͬ's ������ֹ����property 
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
     * Object:���κ�ͬ's ��ι��ʽproperty 
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
     * Object:���κ�ͬ's �������ռ۸�property 
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
     * Object: ���κ�ͬ 's �������� property 
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
     * Object:���κ�ͬ's �ֽ�֤����property 
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
     * Object:���κ�ͬ's ���֤����property 
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
     * Object:���κ�ͬ's ֻ��֤����property 
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
     * Object:���κ�ͬ's ��֤����property 
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
     * Object:���κ�ͬ's ֻ��֤���ֽ�property 
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
     * Object:���κ�ͬ's ����property 
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
     * Object:���κ�ͬ's ��עproperty 
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
     * Object: ���κ�ͬ 's Ͷ������ property 
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
     * Object: ���κ�ͬ 's ��֤������ property 
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
     * Object:���κ�ͬ's ���ñ�֤��property 
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
     * Object:���κ�ͬ's Ӧ�ñ�׼��֤��property 
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
     * Object:���κ�ͬ's Ӧ����ͱ�֤��property 
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
     * Object:���κ�ͬ's ʵ���ñ�֤��property 
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
     * Object: ���κ�ͬ 's ������ͬ property 
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
     * Object:���κ�ͬ's �ѽ�����֤��property 
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
     * Object:���κ�ͬ's ��֤���ܶ�property 
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
     * Object:���κ�ͬ's ռ�ñ�֤��property 
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
     * Object:���κ�ͬ's ��ֳģʽproperty 
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
     * Object: ���κ�ͬ 's �������� property 
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
     * Object:���κ�ͬ's ʵ�ʵ�ֻ��֤��property 
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
     * Object:���κ�ͬ's ��ֳ����ַproperty 
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
     * Object:���κ�ͬ's ����۸�property 
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
     * Object:���κ�ͬ's ����ȫ���ս���property 
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
     * Object: ���κ�ͬ 's ������ property 
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
     * Object:���κ�ͬ's ��������property 
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
     * Object:���κ�ͬ's ����property 
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
     * Object: ���κ�ͬ 's ���׵� property 
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
     * Object:���κ�ͬ's ������ʼ����property 
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
     * Object:���κ�ͬ's ������������property 
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
     * Object:���κ�ͬ's �������property 
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
     * Object: ���κ�ͬ 's �ɱ����� property 
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
     * Object: ���κ�ͬ 's ����Ͷ������ property 
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
     * Object: ���κ�ͬ 's �����۸�������� property 
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
     * Object:���κ�ͬ's �Ƿ���ȡ��֤��property 
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
     * Object: ���κ�ͬ 's ���� property 
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
     * Object: ���κ�ͬ 's �ɱ����� property 
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