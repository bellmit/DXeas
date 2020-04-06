package com.kingdee.eas.farm.carnivorous.recyclebiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKSettleBillInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCKSettleBillInfo()
    {
        this("id");
    }
    protected AbstractCKSettleBillInfo(String pkField)
    {
        super(pkField);
        put("SeedEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedEntryCollection());
        put("SlaughterEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSlaughterEntryCollection());
        put("QCEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillQCEntryCollection());
        put("SaleEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSaleEntryCollection());
        put("TempPolicyEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillTempPolicyEntryCollection());
        put("entrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillEntryCollection());
        put("SeedSourceEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedSourceEntryCollection());
        put("PreHouseEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillPreHouseEntryCollection());
        put("OtherEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillOtherEntryCollection());
        put("FodderEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFodderEntryCollection());
        put("ViewReqEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillViewReqEntryCollection());
        put("DrugEntrys", new com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillDrugEntryCollection());
    }
    /**
     * Object: 结算单 's 毛鸡回收 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillEntryCollection)get("entrys");
    }
    /**
     * Object:结算单's 是否生成凭证property 
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
     * Object: 结算单 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFICompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FICompany");
    }
    public void setFICompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FICompany", item);
    }
    /**
     * Object: 结算单 's 库存组织 property 
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
     * Object:结算单's 单据状态property 
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
     * Object: 结算单 's 养殖户 property 
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
     * Object: 结算单 's 养殖场 property 
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
     * Object: 结算单 's 批次合同 property 
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
     * Object: 结算单 's 养殖批次 property 
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
     * Object: 结算单 's 养殖品种 property 
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
     * Object:结算单's 连养起始日期property 
     */
    public java.util.Date getCFBeginDate()
    {
        return getDate("cFBeginDate");
    }
    public void setCFBeginDate(java.util.Date item)
    {
        setDate("cFBeginDate", item);
    }
    /**
     * Object:结算单's 连养终止日期property 
     */
    public java.util.Date getCFEndDate()
    {
        return getDate("cFEndDate");
    }
    public void setCFEndDate(java.util.Date item)
    {
        setDate("cFEndDate", item);
    }
    /**
     * Object: 结算单 's 连养政策 property 
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
     * Object:结算单's 已连养批数property 
     */
    public int getConFeededNum()
    {
        return getInt("conFeededNum");
    }
    public void setConFeededNum(int item)
    {
        setInt("conFeededNum", item);
    }
    /**
     * Object: 结算单 's 开户银行 property 
     */
    public com.kingdee.eas.fm.be.BEBankInfo getBEBank()
    {
        return (com.kingdee.eas.fm.be.BEBankInfo)get("bEBank");
    }
    public void setBEBank(com.kingdee.eas.fm.be.BEBankInfo item)
    {
        put("bEBank", item);
    }
    /**
     * Object:结算单's 银行账号property 
     */
    public String getBankNum()
    {
        return getString("bankNum");
    }
    public void setBankNum(String item)
    {
        setString("bankNum", item);
    }
    /**
     * Object:结算单's 开户地址property 
     */
    public String getBEBankAddress()
    {
        return getString("bEBankAddress");
    }
    public void setBEBankAddress(String item)
    {
        setString("bEBankAddress", item);
    }
    /**
     * Object: 结算单 's 业务员 property 
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
     * Object:结算单's 上苗日期property 
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
     * Object:结算单's 上苗数量property 
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
     * Object:结算单's 上苗金额property 
     */
    public java.math.BigDecimal getBatchAmt()
    {
        return getBigDecimal("batchAmt");
    }
    public void setBatchAmt(java.math.BigDecimal item)
    {
        setBigDecimal("batchAmt", item);
    }
    /**
     * Object:结算单's 耗料重量property 
     */
    public java.math.BigDecimal getFeedWgt()
    {
        return getBigDecimal("feedWgt");
    }
    public void setFeedWgt(java.math.BigDecimal item)
    {
        setBigDecimal("feedWgt", item);
    }
    /**
     * Object:结算单's 耗料袋数property 
     */
    public int getFeedQty()
    {
        return getInt("feedQty");
    }
    public void setFeedQty(int item)
    {
        setInt("feedQty", item);
    }
    /**
     * Object:结算单's 耗料金额property 
     */
    public java.math.BigDecimal getFeedAmt()
    {
        return getBigDecimal("feedAmt");
    }
    public void setFeedAmt(java.math.BigDecimal item)
    {
        setBigDecimal("feedAmt", item);
    }
    /**
     * Object:结算单's 用药金额property 
     */
    public java.math.BigDecimal getDrugAmt()
    {
        return getBigDecimal("drugAmt");
    }
    public void setDrugAmt(java.math.BigDecimal item)
    {
        setBigDecimal("drugAmt", item);
    }
    /**
     * Object:结算单's 回收日期property 
     */
    public java.util.Date getRecDate()
    {
        return getDate("recDate");
    }
    public void setRecDate(java.util.Date item)
    {
        setDate("recDate", item);
    }
    /**
     * Object:结算单's 回收只数property 
     */
    public int getRecQty()
    {
        return getInt("recQty");
    }
    public void setRecQty(int item)
    {
        setInt("recQty", item);
    }
    /**
     * Object:结算单's 棚前重量property 
     */
    public java.math.BigDecimal getPreHouseWgt()
    {
        return getBigDecimal("preHouseWgt");
    }
    public void setPreHouseWgt(java.math.BigDecimal item)
    {
        setBigDecimal("preHouseWgt", item);
    }
    /**
     * Object:结算单's 品质扣重property 
     */
    public java.math.BigDecimal getPunishWgt()
    {
        return getBigDecimal("punishWgt");
    }
    public void setPunishWgt(java.math.BigDecimal item)
    {
        setBigDecimal("punishWgt", item);
    }
    /**
     * Object:结算单's 结算重量property 
     */
    public java.math.BigDecimal getSettleWgt()
    {
        return getBigDecimal("settleWgt");
    }
    public void setSettleWgt(java.math.BigDecimal item)
    {
        setBigDecimal("settleWgt", item);
    }
    /**
     * Object:结算单's 料肉比property 
     */
    public java.math.BigDecimal getMeatRate()
    {
        return getBigDecimal("meatRate");
    }
    public void setMeatRate(java.math.BigDecimal item)
    {
        setBigDecimal("meatRate", item);
    }
    /**
     * Object:结算单's 成活率property 
     */
    public java.math.BigDecimal getSurvivalRate()
    {
        return getBigDecimal("survivalRate");
    }
    public void setSurvivalRate(java.math.BigDecimal item)
    {
        setBigDecimal("survivalRate", item);
    }
    /**
     * Object:结算单's 毛鸡均重property 
     */
    public java.math.BigDecimal getChickenAveWgt()
    {
        return getBigDecimal("chickenAveWgt");
    }
    public void setChickenAveWgt(java.math.BigDecimal item)
    {
        setBigDecimal("chickenAveWgt", item);
    }
    /**
     * Object:结算单's 饲养天数property 
     */
    public int getFeedDays()
    {
        return getInt("feedDays");
    }
    public void setFeedDays(int item)
    {
        setInt("feedDays", item);
    }
    /**
     * Object:结算单's 苗料药总金额property 
     */
    public java.math.BigDecimal getMlyAllAmt()
    {
        return getBigDecimal("mlyAllAmt");
    }
    public void setMlyAllAmt(java.math.BigDecimal item)
    {
        setBigDecimal("mlyAllAmt", item);
    }
    /**
     * Object:结算单's 回收金额property 
     */
    public java.math.BigDecimal getRecAmt()
    {
        return getBigDecimal("recAmt");
    }
    public void setRecAmt(java.math.BigDecimal item)
    {
        setBigDecimal("recAmt", item);
    }
    /**
     * Object:结算单's 扣补金额property 
     */
    public java.math.BigDecimal getPunishAmt()
    {
        return getBigDecimal("punishAmt");
    }
    public void setPunishAmt(java.math.BigDecimal item)
    {
        setBigDecimal("punishAmt", item);
    }
    /**
     * Object:结算单's 扣保证金property 
     */
    public java.math.BigDecimal getMarginAmt()
    {
        return getBigDecimal("marginAmt");
    }
    public void setMarginAmt(java.math.BigDecimal item)
    {
        setBigDecimal("marginAmt", item);
    }
    /**
     * Object:结算单's 扣预付款property 
     */
    public java.math.BigDecimal getAdPayAmount()
    {
        return getBigDecimal("adPayAmount");
    }
    public void setAdPayAmount(java.math.BigDecimal item)
    {
        setBigDecimal("adPayAmount", item);
    }
    /**
     * Object:结算单's 代养费property 
     */
    public java.math.BigDecimal getDyFee()
    {
        return getBigDecimal("dyFee");
    }
    public void setDyFee(java.math.BigDecimal item)
    {
        setBigDecimal("dyFee", item);
    }
    /**
     * Object:结算单's 只代养费property 
     */
    public java.math.BigDecimal getSingleDyFee()
    {
        return getBigDecimal("singleDyFee");
    }
    public void setSingleDyFee(java.math.BigDecimal item)
    {
        setBigDecimal("singleDyFee", item);
    }
    /**
     * Object:结算单's 是否生成付款单property 
     */
    public boolean isIsHasPaymentBill()
    {
        return getBoolean("isHasPaymentBill");
    }
    public void setIsHasPaymentBill(boolean item)
    {
        setBoolean("isHasPaymentBill", item);
    }
    /**
     * Object:结算单's 是否扣保证金property 
     */
    public boolean isIsKouBZJ()
    {
        return getBoolean("isKouBZJ");
    }
    public void setIsKouBZJ(boolean item)
    {
        setBoolean("isKouBZJ", item);
    }
    /**
     * Object:结算单's 料肉比扣罚金额property 
     */
    public java.math.BigDecimal getMRatePAmt()
    {
        return getBigDecimal("mRatePAmt");
    }
    public void setMRatePAmt(java.math.BigDecimal item)
    {
        setBigDecimal("mRatePAmt", item);
    }
    /**
     * Object:结算单's 实际料肉比property 
     */
    public java.math.BigDecimal getActualMRate()
    {
        return getBigDecimal("actualMRate");
    }
    public void setActualMRate(java.math.BigDecimal item)
    {
        setBigDecimal("actualMRate", item);
    }
    /**
     * Object:结算单's 标准料肉比property 
     */
    public java.math.BigDecimal getStandardMRate()
    {
        return getBigDecimal("standardMRate");
    }
    public void setStandardMRate(java.math.BigDecimal item)
    {
        setBigDecimal("standardMRate", item);
    }
    /**
     * Object:结算单's 药品不足扣罚金额property 
     */
    public java.math.BigDecimal getDrugLackPAmt()
    {
        return getBigDecimal("drugLackPAmt");
    }
    public void setDrugLackPAmt(java.math.BigDecimal item)
    {
        setBigDecimal("drugLackPAmt", item);
    }
    /**
     * Object:结算单's 实际单只用药property 
     */
    public java.math.BigDecimal getSingleActualDrug()
    {
        return getBigDecimal("singleActualDrug");
    }
    public void setSingleActualDrug(java.math.BigDecimal item)
    {
        setBigDecimal("singleActualDrug", item);
    }
    /**
     * Object:结算单's 标准单只用药property 
     */
    public java.math.BigDecimal getSingleStandardDrug()
    {
        return getBigDecimal("singleStandardDrug");
    }
    public void setSingleStandardDrug(java.math.BigDecimal item)
    {
        setBigDecimal("singleStandardDrug", item);
    }
    /**
     * Object:结算单's 保证金占用费property 
     */
    public java.math.BigDecimal getMarginOccupyFee()
    {
        return getBigDecimal("marginOccupyFee");
    }
    public void setMarginOccupyFee(java.math.BigDecimal item)
    {
        setBigDecimal("marginOccupyFee", item);
    }
    /**
     * Object:结算单's 本批占用保证金property 
     */
    public java.math.BigDecimal getBatchOccupyMargin()
    {
        return getBigDecimal("batchOccupyMargin");
    }
    public void setBatchOccupyMargin(java.math.BigDecimal item)
    {
        setBigDecimal("batchOccupyMargin", item);
    }
    /**
     * Object:结算单's 标准保证金property 
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
     * Object:结算单's 单只保证金property 
     */
    public java.math.BigDecimal getSingleMargin()
    {
        return getBigDecimal("singleMargin");
    }
    public void setSingleMargin(java.math.BigDecimal item)
    {
        setBigDecimal("singleMargin", item);
    }
    /**
     * Object:结算单's 连养批次补贴property 
     */
    public java.math.BigDecimal getConFeedSubsidies()
    {
        return getBigDecimal("conFeedSubsidies");
    }
    public void setConFeedSubsidies(java.math.BigDecimal item)
    {
        setBigDecimal("conFeedSubsidies", item);
    }
    /**
     * Object: 结算单 's 扣补连养政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo getKbConFeedPolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo)get("kbConFeedPolicy");
    }
    public void setKbConFeedPolicy(com.kingdee.eas.farm.carnivorous.basedata.ConFeedPolicyInfo item)
    {
        put("kbConFeedPolicy", item);
    }
    /**
     * Object:结算单's 合同内鸡重量property 
     */
    public java.math.BigDecimal getContractCKWgt()
    {
        return getBigDecimal("contractCKWgt");
    }
    public void setContractCKWgt(java.math.BigDecimal item)
    {
        setBigDecimal("contractCKWgt", item);
    }
    /**
     * Object:结算单's 运费差价补款property 
     */
    public java.math.BigDecimal getFreightDiffSubsidies()
    {
        return getBigDecimal("freightDiffSubsidies");
    }
    public void setFreightDiffSubsidies(java.math.BigDecimal item)
    {
        setBigDecimal("freightDiffSubsidies", item);
    }
    /**
     * Object:结算单's 拉料重量property 
     */
    public java.math.BigDecimal getLFeedWgt()
    {
        return getBigDecimal("lFeedWgt");
    }
    public void setLFeedWgt(java.math.BigDecimal item)
    {
        setBigDecimal("lFeedWgt", item);
    }
    /**
     * Object:结算单's 运费单价property 
     */
    public java.math.BigDecimal getFreightPrice()
    {
        return getBigDecimal("freightPrice");
    }
    public void setFreightPrice(java.math.BigDecimal item)
    {
        setBigDecimal("freightPrice", item);
    }
    /**
     * Object:结算单's 运费补贴标准property 
     */
    public java.math.BigDecimal getFreightSubsidiesStd()
    {
        return getBigDecimal("freightSubsidiesStd");
    }
    public void setFreightSubsidiesStd(java.math.BigDecimal item)
    {
        setBigDecimal("freightSubsidiesStd", item);
    }
    /**
     * Object:结算单's 扣保证金(正数)property 
     */
    public java.math.BigDecimal getDeductMargin()
    {
        return getBigDecimal("deductMargin");
    }
    public void setDeductMargin(java.math.BigDecimal item)
    {
        setBigDecimal("deductMargin", item);
    }
    /**
     * Object:结算单's 保证金总额property 
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
     * Object:结算单's 占用保证金property 
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
     * Object:结算单's 可用保证金property 
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
     * Object:结算单's 扣预付款(正数)property 
     */
    public java.math.BigDecimal getDeductAdPayAmt()
    {
        return getBigDecimal("deductAdPayAmt");
    }
    public void setDeductAdPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("deductAdPayAmt", item);
    }
    /**
     * Object:结算单's 资金占用月利率(%)property 
     */
    public java.math.BigDecimal getLoanRate()
    {
        return getBigDecimal("loanRate");
    }
    public void setLoanRate(java.math.BigDecimal item)
    {
        setBigDecimal("loanRate", item);
    }
    /**
     * Object:结算单's 扣预付款占用费property 
     */
    public java.math.BigDecimal getKYFKOccupyFee()
    {
        return getBigDecimal("kYFKOccupyFee");
    }
    public void setKYFKOccupyFee(java.math.BigDecimal item)
    {
        setBigDecimal("kYFKOccupyFee", item);
    }
    /**
     * Object: 结算单 's 品质扣款 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillQCEntryCollection getQCEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillQCEntryCollection)get("QCEntrys");
    }
    /**
     * Object: 结算单 's 客诉补款 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillViewReqEntryCollection getViewReqEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillViewReqEntryCollection)get("ViewReqEntrys");
    }
    /**
     * Object: 结算单 's 其他扣补 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillOtherEntryCollection getOtherEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillOtherEntryCollection)get("OtherEntrys");
    }
    /**
     * Object:结算单's 审核日期property 
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
     * Object: 结算单 's 领苗单 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedEntryCollection getSeedEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedEntryCollection)get("SeedEntrys");
    }
    /**
     * Object: 结算单 's 领料单 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFodderEntryCollection getFodderEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillFodderEntryCollection)get("FodderEntrys");
    }
    /**
     * Object: 结算单 's 领药单 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillDrugEntryCollection getDrugEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillDrugEntryCollection)get("DrugEntrys");
    }
    /**
     * Object: 结算单 's 屠宰单 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSlaughterEntryCollection getSlaughterEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSlaughterEntryCollection)get("SlaughterEntrys");
    }
    /**
     * Object: 结算单 's 销售信息 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSaleEntryCollection getSaleEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSaleEntryCollection)get("SaleEntrys");
    }
    /**
     * Object:结算单's 只用药property 
     */
    public java.math.BigDecimal getSingleDrugAmt()
    {
        return getBigDecimal("singleDrugAmt");
    }
    public void setSingleDrugAmt(java.math.BigDecimal item)
    {
        setBigDecimal("singleDrugAmt", item);
    }
    /**
     * Object:结算单's 只耗料(kg/只)property 
     */
    public java.math.BigDecimal getSingleFeedWgt()
    {
        return getBigDecimal("singleFeedWgt");
    }
    public void setSingleFeedWgt(java.math.BigDecimal item)
    {
        setBigDecimal("singleFeedWgt", item);
    }
    /**
     * Object:结算单's 欧指property 
     */
    public java.math.BigDecimal getOValue()
    {
        return getBigDecimal("oValue");
    }
    public void setOValue(java.math.BigDecimal item)
    {
        setBigDecimal("oValue", item);
    }
    /**
     * Object: 结算单 's 连养合同 property 
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
     * Object: 结算单 's 棚前过磅 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillPreHouseEntryCollection getPreHouseEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillPreHouseEntryCollection)get("PreHouseEntrys");
    }
    /**
     * Object:结算单's 料肉比扣罚标准property 
     */
    public java.math.BigDecimal getFmRatePunishStd()
    {
        return getBigDecimal("fmRatePunishStd");
    }
    public void setFmRatePunishStd(java.math.BigDecimal item)
    {
        setBigDecimal("fmRatePunishStd", item);
    }
    /**
     * Object:结算单's 代养费账务余额property 
     */
    public java.math.BigDecimal getDyfBalance()
    {
        return getBigDecimal("dyfBalance");
    }
    public void setDyfBalance(java.math.BigDecimal item)
    {
        setBigDecimal("dyfBalance", item);
    }
    /**
     * Object:结算单's 扣补项目金额property 
     */
    public java.math.BigDecimal getKbItemAmt()
    {
        return getBigDecimal("kbItemAmt");
    }
    public void setKbItemAmt(java.math.BigDecimal item)
    {
        setBigDecimal("kbItemAmt", item);
    }
    /**
     * Object:结算单's 品质扣款property 
     */
    public java.math.BigDecimal getQCItemAmt()
    {
        return getBigDecimal("QCItemAmt");
    }
    public void setQCItemAmt(java.math.BigDecimal item)
    {
        setBigDecimal("QCItemAmt", item);
    }
    /**
     * Object:结算单's 政策搭雏比例property 
     */
    public java.math.BigDecimal getViewItemAmt()
    {
        return getBigDecimal("viewItemAmt");
    }
    public void setViewItemAmt(java.math.BigDecimal item)
    {
        setBigDecimal("viewItemAmt", item);
    }
    /**
     * Object:结算单's 其他扣补property 
     */
    public java.math.BigDecimal getOtherItemAmt()
    {
        return getBigDecimal("otherItemAmt");
    }
    public void setOtherItemAmt(java.math.BigDecimal item)
    {
        setBigDecimal("otherItemAmt", item);
    }
    /**
     * Object:结算单's 临时政策扣补property 
     */
    public java.math.BigDecimal getTempItemAmt()
    {
        return getBigDecimal("tempItemAmt");
    }
    public void setTempItemAmt(java.math.BigDecimal item)
    {
        setBigDecimal("tempItemAmt", item);
    }
    /**
     * Object:结算单's 资金占用天数property 
     */
    public int getMoneyOccupyDays()
    {
        return getInt("moneyOccupyDays");
    }
    public void setMoneyOccupyDays(int item)
    {
        setInt("moneyOccupyDays", item);
    }
    /**
     * Object:结算单's 连养补贴政策单价property 
     */
    public java.math.BigDecimal getConFeedPolicySub()
    {
        return getBigDecimal("conFeedPolicySub");
    }
    public void setConFeedPolicySub(java.math.BigDecimal item)
    {
        setBigDecimal("conFeedPolicySub", item);
    }
    /**
     * Object:结算单's 还赊欠款property 
     */
    public java.math.BigDecimal getPayOweMonery()
    {
        return getBigDecimal("payOweMonery");
    }
    public void setPayOweMonery(java.math.BigDecimal item)
    {
        setBigDecimal("payOweMonery", item);
    }
    /**
     * Object:结算单's 外卖扣补款property 
     */
    public java.math.BigDecimal getOutSaleKbAmt()
    {
        return getBigDecimal("outSaleKbAmt");
    }
    public void setOutSaleKbAmt(java.math.BigDecimal item)
    {
        setBigDecimal("outSaleKbAmt", item);
    }
    /**
     * Object:结算单's 实际支付property 
     */
    public java.math.BigDecimal getActualPayAmt()
    {
        return getBigDecimal("actualPayAmt");
    }
    public void setActualPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("actualPayAmt", item);
    }
    /**
     * Object:结算单's 还赊欠款property 
     */
    public java.math.BigDecimal getPayOweMoneryB()
    {
        return getBigDecimal("payOweMoneryB");
    }
    public void setPayOweMoneryB(java.math.BigDecimal item)
    {
        setBigDecimal("payOweMoneryB", item);
    }
    /**
     * Object:结算单's 雏苗成本property 
     */
    public java.math.BigDecimal getSeedCost()
    {
        return getBigDecimal("SeedCost");
    }
    public void setSeedCost(java.math.BigDecimal item)
    {
        setBigDecimal("SeedCost", item);
    }
    /**
     * Object:结算单's 饲料成本property 
     */
    public java.math.BigDecimal getFodderCost()
    {
        return getBigDecimal("fodderCost");
    }
    public void setFodderCost(java.math.BigDecimal item)
    {
        setBigDecimal("fodderCost", item);
    }
    /**
     * Object:结算单's 药品成本property 
     */
    public java.math.BigDecimal getDrugCost()
    {
        return getBigDecimal("drugCost");
    }
    public void setDrugCost(java.math.BigDecimal item)
    {
        setBigDecimal("drugCost", item);
    }
    /**
     * Object:结算单's 分摊费用property 
     */
    public java.math.BigDecimal getAllocateAmt()
    {
        return getBigDecimal("allocateAmt");
    }
    public void setAllocateAmt(java.math.BigDecimal item)
    {
        setBigDecimal("allocateAmt", item);
    }
    /**
     * Object:结算单's 单位成本property 
     */
    public java.math.BigDecimal getUnitCost()
    {
        return getBigDecimal("unitCost");
    }
    public void setUnitCost(java.math.BigDecimal item)
    {
        setBigDecimal("unitCost", item);
    }
    /**
     * Object:结算单's 总成本property 
     */
    public java.math.BigDecimal getAllCost()
    {
        return getBigDecimal("allCost");
    }
    public void setAllCost(java.math.BigDecimal item)
    {
        setBigDecimal("allCost", item);
    }
    /**
     * Object:结算单's 本批已解锁保证金property 
     */
    public java.math.BigDecimal getUnLockedMargin()
    {
        return getBigDecimal("unLockedMargin");
    }
    public void setUnLockedMargin(java.math.BigDecimal item)
    {
        setBigDecimal("unLockedMargin", item);
    }
    /**
     * Object:结算单's 回收净重property 
     */
    public java.math.BigDecimal getRecSuttle()
    {
        return getBigDecimal("recSuttle");
    }
    public void setRecSuttle(java.math.BigDecimal item)
    {
        setBigDecimal("recSuttle", item);
    }
    /**
     * Object: 结算单 's 雏苗来源 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedSourceEntryCollection getSeedSourceEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillSeedSourceEntryCollection)get("SeedSourceEntrys");
    }
    /**
     * Object:结算单's 预付款余额property 
     */
    public java.math.BigDecimal getAdPayBalance()
    {
        return getBigDecimal("adPayBalance");
    }
    public void setAdPayBalance(java.math.BigDecimal item)
    {
        setBigDecimal("adPayBalance", item);
    }
    /**
     * Object: 结算单 's 临时政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillTempPolicyEntryCollection getTempPolicyEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.recyclebiz.CKSettleBillTempPolicyEntryCollection)get("TempPolicyEntrys");
    }
    /**
     * Object:结算单's 打印次数property 
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
     * Object: 结算单 's 结算政策 property 
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
     * Object:结算单's 品质扣款明细property 
     */
    public String getQCKbDetail()
    {
        return getString("QCKbDetail");
    }
    public void setQCKbDetail(String item)
    {
        setString("QCKbDetail", item);
    }
    /**
     * Object:结算单's 其他扣补明细property 
     */
    public String getOtherKbDetail()
    {
        return getString("otherKbDetail");
    }
    public void setOtherKbDetail(String item)
    {
        setString("otherKbDetail", item);
    }
    /**
     * Object:结算单's 养殖模式property 
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
     * Object:结算单's 外卖扣补款property 
     */
    public java.math.BigDecimal getOutSaleKbAmt2()
    {
        return getBigDecimal("outSaleKbAmt2");
    }
    public void setOutSaleKbAmt2(java.math.BigDecimal item)
    {
        setBigDecimal("outSaleKbAmt2", item);
    }
    /**
     * Object:结算单's 扣油苗费用property 
     */
    public java.math.BigDecimal getImmuneCost()
    {
        return getBigDecimal("immuneCost");
    }
    public void setImmuneCost(java.math.BigDecimal item)
    {
        setBigDecimal("immuneCost", item);
    }
    /**
     * Object:结算单's 油苗费用(元/只)property 
     */
    public java.math.BigDecimal getImmuneCostOne()
    {
        return getBigDecimal("immuneCostOne");
    }
    public void setImmuneCostOne(java.math.BigDecimal item)
    {
        setBigDecimal("immuneCostOne", item);
    }
    /**
     * Object:结算单's 清舍费property 
     */
    public java.math.BigDecimal getCleanHouse()
    {
        return getBigDecimal("cleanHouse");
    }
    public void setCleanHouse(java.math.BigDecimal item)
    {
        setBigDecimal("cleanHouse", item);
    }
    /**
     * Object:结算单's 清舍费(元/只)property 
     */
    public java.math.BigDecimal getCleanHouseOne()
    {
        return getBigDecimal("cleanHouseOne");
    }
    public void setCleanHouseOne(java.math.BigDecimal item)
    {
        setBigDecimal("cleanHouseOne", item);
    }
    /**
     * Object:结算单's 预留风险押金property 
     */
    public java.math.BigDecimal getReserveRiskCost()
    {
        return getBigDecimal("reserveRiskCost");
    }
    public void setReserveRiskCost(java.math.BigDecimal item)
    {
        setBigDecimal("reserveRiskCost", item);
    }
    /**
     * Object:结算单's 实际用料property 
     */
    public java.math.BigDecimal getActualFoder()
    {
        return getBigDecimal("actualFoder");
    }
    public void setActualFoder(java.math.BigDecimal item)
    {
        setBigDecimal("actualFoder", item);
    }
    /**
     * Object:结算单's 标准用料property 
     */
    public java.math.BigDecimal getStandFodder()
    {
        return getBigDecimal("standFodder");
    }
    public void setStandFodder(java.math.BigDecimal item)
    {
        setBigDecimal("standFodder", item);
    }
    /**
     * Object:结算单's 单只保证金property 
     */
    public java.math.BigDecimal getOneMrgin()
    {
        return getBigDecimal("oneMrgin");
    }
    public void setOneMrgin(java.math.BigDecimal item)
    {
        setBigDecimal("oneMrgin", item);
    }
    /**
     * Object:结算单's 保证金留取金额property 
     */
    public java.math.BigDecimal getMarginGAmount()
    {
        return getBigDecimal("marginGAmount");
    }
    public void setMarginGAmount(java.math.BigDecimal item)
    {
        setBigDecimal("marginGAmount", item);
    }
    /**
     * Object:结算单's 鸡雏让利金额property 
     */
    public java.math.BigDecimal getChickenRetunAmt()
    {
        return getBigDecimal("chickenRetunAmt");
    }
    public void setChickenRetunAmt(java.math.BigDecimal item)
    {
        setBigDecimal("chickenRetunAmt", item);
    }
    /**
     * Object:结算单's 笼养借款property 
     */
    public java.math.BigDecimal getLongBorrowAmount()
    {
        return getBigDecimal("longBorrowAmount");
    }
    public void setLongBorrowAmount(java.math.BigDecimal item)
    {
        setBigDecimal("longBorrowAmount", item);
    }
    /**
     * Object:结算单's 笼养借款还款金额property 
     */
    public java.math.BigDecimal getLongBorrowReturn()
    {
        return getBigDecimal("longBorrowReturn");
    }
    public void setLongBorrowReturn(java.math.BigDecimal item)
    {
        setBigDecimal("longBorrowReturn", item);
    }
    /**
     * Object:结算单's 保证金利息property 
     */
    public java.math.BigDecimal getMarginProfit()
    {
        return getBigDecimal("marginProfit");
    }
    public void setMarginProfit(java.math.BigDecimal item)
    {
        setBigDecimal("marginProfit", item);
    }
    /**
     * Object:结算单's 上批余额property 
     */
    public java.math.BigDecimal getBeforeBatchAmount()
    {
        return getBigDecimal("beforeBatchAmount");
    }
    public void setBeforeBatchAmount(java.math.BigDecimal item)
    {
        setBigDecimal("beforeBatchAmount", item);
    }
    /**
     * Object:结算单's 借款利息property 
     */
    public java.math.BigDecimal getBorrowAmiunt()
    {
        return getBigDecimal("borrowAmiunt");
    }
    public void setBorrowAmiunt(java.math.BigDecimal item)
    {
        setBigDecimal("borrowAmiunt", item);
    }
    /**
     * Object:结算单's 特批借款利息property 
     */
    public java.math.BigDecimal getSpecialBorrowinst()
    {
        return getBigDecimal("specialBorrowinst");
    }
    public void setSpecialBorrowinst(java.math.BigDecimal item)
    {
        setBigDecimal("specialBorrowinst", item);
    }
    /**
     * Object:结算单's 运费property 
     */
    public java.math.BigDecimal getTranCost()
    {
        return getBigDecimal("tranCost");
    }
    public void setTranCost(java.math.BigDecimal item)
    {
        setBigDecimal("tranCost", item);
    }
    /**
     * Object:结算单's 断档费property 
     */
    public java.math.BigDecimal getBrokenCost()
    {
        return getBigDecimal("brokenCost");
    }
    public void setBrokenCost(java.math.BigDecimal item)
    {
        setBigDecimal("brokenCost", item);
    }
    /**
     * Object:结算单's 煤款property 
     */
    public java.math.BigDecimal getCoalCost()
    {
        return getBigDecimal("coalCost");
    }
    public void setCoalCost(java.math.BigDecimal item)
    {
        setBigDecimal("coalCost", item);
    }
    /**
     * Object:结算单's 身份证号property 
     */
    public String getIdCodeCode()
    {
        return getString("idCodeCode");
    }
    public void setIdCodeCode(String item)
    {
        setString("idCodeCode", item);
    }
    /**
     * Object:结算单's 养殖场地址property 
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
     * Object:结算单's 不计算料肉比扣罚property 
     */
    public boolean isNoCalFodderPunish()
    {
        return getBoolean("noCalFodderPunish");
    }
    public void setNoCalFodderPunish(boolean item)
    {
        setBoolean("noCalFodderPunish", item);
    }
    /**
     * Object:结算单's 不计算药品不足扣罚property 
     */
    public boolean isNoCalDrupPunish()
    {
        return getBoolean("noCalDrupPunish");
    }
    public void setNoCalDrupPunish(boolean item)
    {
        setBoolean("noCalDrupPunish", item);
    }
    /**
     * Object:结算单's 设备借款还款金额property 
     */
    public java.math.BigDecimal getEquipmentReAmt()
    {
        return getBigDecimal("equipmentReAmt");
    }
    public void setEquipmentReAmt(java.math.BigDecimal item)
    {
        setBigDecimal("equipmentReAmt", item);
    }
    /**
     * Object:结算单's 特批借款还款金额property 
     */
    public java.math.BigDecimal getSpecialPermitAmt()
    {
        return getBigDecimal("specialPermitAmt");
    }
    public void setSpecialPermitAmt(java.math.BigDecimal item)
    {
        setBigDecimal("specialPermitAmt", item);
    }
    /**
     * Object:结算单's 抓鸡费property 
     */
    public java.math.BigDecimal getGetChickCost()
    {
        return getBigDecimal("getChickCost");
    }
    public void setGetChickCost(java.math.BigDecimal item)
    {
        setBigDecimal("getChickCost", item);
    }
    /**
     * Object:结算单's 清舍防疫费property 
     */
    public java.math.BigDecimal getCleanHouseCost()
    {
        return getBigDecimal("cleanHouseCost");
    }
    public void setCleanHouseCost(java.math.BigDecimal item)
    {
        setBigDecimal("cleanHouseCost", item);
    }
    /**
     * Object:结算单's 雏源property 
     */
    public String getChickenSource()
    {
        return getString("chickenSource");
    }
    public void setChickenSource(String item)
    {
        setString("chickenSource", item);
    }
    /**
     * Object: 结算单 's 会计期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:结算单's 代养费property 
     */
    public java.math.BigDecimal getDaiyFee()
    {
        return getBigDecimal("daiyFee");
    }
    public void setDaiyFee(java.math.BigDecimal item)
    {
        setBigDecimal("daiyFee", item);
    }
    /**
     * Object:结算单's 公司利润property 
     */
    public java.math.BigDecimal getCompanyProfit()
    {
        return getBigDecimal("companyProfit");
    }
    public void setCompanyProfit(java.math.BigDecimal item)
    {
        setBigDecimal("companyProfit", item);
    }
    /**
     * Object:结算单's 消毒清料塔费property 
     */
    public java.math.BigDecimal getCleanTowerCost()
    {
        return getBigDecimal("cleanTowerCost");
    }
    public void setCleanTowerCost(java.math.BigDecimal item)
    {
        setBigDecimal("cleanTowerCost", item);
    }
    /**
     * Object:结算单's 现账面累计余额property 
     */
    public java.math.BigDecimal getNowAccountBac()
    {
        return getBigDecimal("nowAccountBac");
    }
    public void setNowAccountBac(java.math.BigDecimal item)
    {
        setBigDecimal("nowAccountBac", item);
    }
    /**
     * Object:结算单's 资产占用费property 
     */
    public java.math.BigDecimal getAssetsOccupy()
    {
        return getBigDecimal("assetsOccupy");
    }
    public void setAssetsOccupy(java.math.BigDecimal item)
    {
        setBigDecimal("assetsOccupy", item);
    }
    /**
     * Object: 结算单 's 成本中心 property 
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
     * Object:结算单's 是否普通鸡A鸡property 
     */
    public boolean isIsOrdinary()
    {
        return getBoolean("isOrdinary");
    }
    public void setIsOrdinary(boolean item)
    {
        setBoolean("isOrdinary", item);
    }
    /**
     * Object:结算单's 用药数量property 
     */
    public java.math.BigDecimal getDrugQty()
    {
        return getBigDecimal("drugQty");
    }
    public void setDrugQty(java.math.BigDecimal item)
    {
        setBigDecimal("drugQty", item);
    }
    /**
     * Object:结算单's 亏损还款property 
     */
    public java.math.BigDecimal getNoPfoRetAmt()
    {
        return getBigDecimal("noPfoRetAmt");
    }
    public void setNoPfoRetAmt(java.math.BigDecimal item)
    {
        setBigDecimal("noPfoRetAmt", item);
    }
    /**
     * Object:结算单's 养户毛利property 
     */
    public java.math.BigDecimal getFarmeronlyPro()
    {
        return getBigDecimal("farmeronlyPro");
    }
    public void setFarmeronlyPro(java.math.BigDecimal item)
    {
        setBigDecimal("farmeronlyPro", item);
    }
    /**
     * Object:结算单's 只养户毛利property 
     */
    public java.math.BigDecimal getFarmerOnlyProOne()
    {
        return getBigDecimal("farmerOnlyProOne");
    }
    public void setFarmerOnlyProOne(java.math.BigDecimal item)
    {
        setBigDecimal("farmerOnlyProOne", item);
    }
    /**
     * Object:结算单's 副产品成本property 
     */
    public java.math.BigDecimal getOtherMatCost()
    {
        return getBigDecimal("otherMatCost");
    }
    public void setOtherMatCost(java.math.BigDecimal item)
    {
        setBigDecimal("otherMatCost", item);
    }
    /**
     * Object:结算单's 实际支付凭证property 
     */
    public boolean isActualVoucher()
    {
        return getBoolean("actualVoucher");
    }
    public void setActualVoucher(boolean item)
    {
        setBoolean("actualVoucher", item);
    }
    /**
     * Object:结算单's 预留风险押金凭证property 
     */
    public boolean isPreVoucher()
    {
        return getBoolean("preVoucher");
    }
    public void setPreVoucher(boolean item)
    {
        setBoolean("preVoucher", item);
    }
    /**
     * Object:结算单's 运费凭证property 
     */
    public boolean isTransVoucher()
    {
        return getBoolean("transVoucher");
    }
    public void setTransVoucher(boolean item)
    {
        setBoolean("transVoucher", item);
    }
    /**
     * Object:结算单's 已付风险押金property 
     */
    public boolean isHasPay()
    {
        return getBoolean("hasPay");
    }
    public void setHasPay(boolean item)
    {
        setBoolean("hasPay", item);
    }
    /**
     * Object:结算单's 利润分成property 
     */
    public java.math.BigDecimal getProDiv()
    {
        return getBigDecimal("proDiv");
    }
    public void setProDiv(java.math.BigDecimal item)
    {
        setBigDecimal("proDiv", item);
    }
    /**
     * Object:结算单's 公司运费property 
     */
    public java.math.BigDecimal getCompanyTC()
    {
        return getBigDecimal("companyTC");
    }
    public void setCompanyTC(java.math.BigDecimal item)
    {
        setBigDecimal("companyTC", item);
    }
    /**
     * Object:结算单's 司机运费property 
     */
    public java.math.BigDecimal getDiverCt()
    {
        return getBigDecimal("diverCt");
    }
    public void setDiverCt(java.math.BigDecimal item)
    {
        setBigDecimal("diverCt", item);
    }
    /**
     * Object:结算单's 实际饲养天数property 
     */
    public int getActfeedDays()
    {
        return getInt("actfeedDays");
    }
    public void setActfeedDays(int item)
    {
        setInt("actfeedDays", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2A2E0777");
    }
}