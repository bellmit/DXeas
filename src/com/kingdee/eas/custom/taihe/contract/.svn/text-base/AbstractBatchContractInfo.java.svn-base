package com.kingdee.eas.custom.taihe.contract;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchContractInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractBatchContractInfo()
    {
        this("id");
    }
    protected AbstractBatchContractInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.taihe.contract.BatchContractEntryCollection());
        put("AllotEntry", new com.kingdee.eas.custom.taihe.contract.BatchContractAllotEntryCollection());
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
     * Object:批次合同's 是否连养合同property 
     */
    public boolean isIsSuccessive()
    {
        return getBoolean("isSuccessive");
    }
    public void setIsSuccessive(boolean item)
    {
        setBoolean("isSuccessive", item);
    }
    /**
     * Object: 批次合同 's 合同类型 property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractTypeInfo getContractType()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractTypeInfo)get("contractType");
    }
    public void setContractType(com.kingdee.eas.custom.signwasthetable.ContractTypeInfo item)
    {
        put("contractType", item);
    }
    /**
     * Object:批次合同's 签订开始日期property 
     */
    public java.util.Date getBeginDate()
    {
        return getDate("beginDate");
    }
    public void setBeginDate(java.util.Date item)
    {
        setDate("beginDate", item);
    }
    /**
     * Object:批次合同's 终止日期property 
     */
    public java.util.Date getEndDate()
    {
        return getDate("endDate");
    }
    public void setEndDate(java.util.Date item)
    {
        setDate("endDate", item);
    }
    /**
     * Object:批次合同's 连养批数property 
     */
    public java.math.BigDecimal getSuccessiveQty()
    {
        return getBigDecimal("successiveQty");
    }
    public void setSuccessiveQty(java.math.BigDecimal item)
    {
        setBigDecimal("successiveQty", item);
    }
    /**
     * Object:批次合同's 供应商联系方式property 
     */
    public String getPartyBCell()
    {
        return getString("partyBCell");
    }
    public void setPartyBCell(String item)
    {
        setString("partyBCell", item);
    }
    /**
     * Object:批次合同's 供应商地址property 
     */
    public String getPartyBAddress()
    {
        return getString("partyBAddress");
    }
    public void setPartyBAddress(String item)
    {
        setString("partyBAddress", item);
    }
    /**
     * Object:批次合同's 供应商身份证号property 
     */
    public String getPartyBID()
    {
        return getString("partyBID");
    }
    public void setPartyBID(String item)
    {
        setString("partyBID", item);
    }
    /**
     * Object:批次合同's 供应商收款银行property 
     */
    public String getPartyBBank()
    {
        return getString("partyBBank");
    }
    public void setPartyBBank(String item)
    {
        setString("partyBBank", item);
    }
    /**
     * Object:批次合同's 供应商收款账号property 
     */
    public String getPartyBAccount()
    {
        return getString("partyBAccount");
    }
    public void setPartyBAccount(String item)
    {
        setString("partyBAccount", item);
    }
    /**
     * Object: 批次合同 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:批次合同's 养殖场规模property 
     */
    public java.math.BigDecimal getCapacity()
    {
        return getBigDecimal("capacity");
    }
    public void setCapacity(java.math.BigDecimal item)
    {
        setBigDecimal("capacity", item);
    }
    /**
     * Object:批次合同's 饲喂类别property 
     */
    public com.kingdee.eas.custom.taihe.contract.FeedType getFeedType()
    {
        return com.kingdee.eas.custom.taihe.contract.FeedType.getEnum(getString("feedType"));
    }
    public void setFeedType(com.kingdee.eas.custom.taihe.contract.FeedType item)
    {
		if (item != null) {
        setString("feedType", item.getValue());
		}
    }
    /**
     * Object:批次合同's 上苗日期property 
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
     * Object:批次合同's 上苗数量property 
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
     * Object:批次合同's 标准出栏天数property 
     */
    public int getOutDaysStd()
    {
        return getInt("outDaysStd");
    }
    public void setOutDaysStd(int item)
    {
        setInt("outDaysStd", item);
    }
    /**
     * Object:批次合同's 偏离天数property 
     */
    public int getDiffDays()
    {
        return getInt("diffDays");
    }
    public void setDiffDays(int item)
    {
        setInt("diffDays", item);
    }
    /**
     * Object:批次合同's 回收开始日期property 
     */
    public java.util.Date getRecycleBeginDate()
    {
        return getDate("recycleBeginDate");
    }
    public void setRecycleBeginDate(java.util.Date item)
    {
        setDate("recycleBeginDate", item);
    }
    /**
     * Object:批次合同's 回收截止日期property 
     */
    public java.util.Date getRecycleEndDate()
    {
        return getDate("recycleEndDate");
    }
    public void setRecycleEndDate(java.util.Date item)
    {
        setDate("recycleEndDate", item);
    }
    /**
     * Object:批次合同's 政策保底价property 
     */
    public java.math.BigDecimal getPolicySafePrice()
    {
        return getBigDecimal("policySafePrice");
    }
    public void setPolicySafePrice(java.math.BigDecimal item)
    {
        setBigDecimal("policySafePrice", item);
    }
    /**
     * Object:批次合同's 合同保底价property 
     */
    public java.math.BigDecimal getContractSafePrice()
    {
        return getBigDecimal("contractSafePrice");
    }
    public void setContractSafePrice(java.math.BigDecimal item)
    {
        setBigDecimal("contractSafePrice", item);
    }
    /**
     * Object:批次合同's 当日苗价property 
     */
    public java.math.BigDecimal getCurrentDaysPrice()
    {
        return getBigDecimal("currentDaysPrice");
    }
    public void setCurrentDaysPrice(java.math.BigDecimal item)
    {
        setBigDecimal("currentDaysPrice", item);
    }
    /**
     * Object:批次合同's 合同签订价property 
     */
    public java.math.BigDecimal getContractCellPrice()
    {
        return getBigDecimal("contractCellPrice");
    }
    public void setContractCellPrice(java.math.BigDecimal item)
    {
        setBigDecimal("contractCellPrice", item);
    }
    /**
     * Object:批次合同's 政策单只保证金property 
     */
    public java.math.BigDecimal getPolicyProAmt()
    {
        return getBigDecimal("policyProAmt");
    }
    public void setPolicyProAmt(java.math.BigDecimal item)
    {
        setBigDecimal("policyProAmt", item);
    }
    /**
     * Object:批次合同's 合同单只保证金property 
     */
    public java.math.BigDecimal getContractProAmt()
    {
        return getBigDecimal("contractProAmt");
    }
    public void setContractProAmt(java.math.BigDecimal item)
    {
        setBigDecimal("contractProAmt", item);
    }
    /**
     * Object:批次合同's 应收保证金总额property 
     */
    public java.math.BigDecimal getReceiveAmt()
    {
        return getBigDecimal("receiveAmt");
    }
    public void setReceiveAmt(java.math.BigDecimal item)
    {
        setBigDecimal("receiveAmt", item);
    }
    /**
     * Object:批次合同's 实收保证金总额property 
     */
    public java.math.BigDecimal getActualAmt()
    {
        return getBigDecimal("actualAmt");
    }
    public void setActualAmt(java.math.BigDecimal item)
    {
        setBigDecimal("actualAmt", item);
    }
    /**
     * Object: 批次合同 's 保证金分录 property 
     */
    public com.kingdee.eas.custom.taihe.contract.BatchContractEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.taihe.contract.BatchContractEntryCollection)get("Entry");
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
     * Object: 批次合同 's 公司 property 
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
     * Object:批次合同's 基础价格property 
     */
    public java.math.BigDecimal getBasePrice()
    {
        return getBigDecimal("basePrice");
    }
    public void setBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("basePrice", item);
    }
    /**
     * Object: 批次合同 's 供应商 property 
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
     * Object: 批次合同 's 连养合同 property 
     */
    public com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo getSuccessiveContract()
    {
        return (com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo)get("successiveContract");
    }
    public void setSuccessiveContract(com.kingdee.eas.custom.taihe.contract.SuccessiveContractInfo item)
    {
        put("successiveContract", item);
    }
    /**
     * Object: 批次合同 's 原料员 property 
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
     * Object: 批次合同 's 结算政策 property 
     */
    public com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo getSettlePolicy()
    {
        return (com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo)get("settlePolicy");
    }
    public void setSettlePolicy(com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo item)
    {
        put("settlePolicy", item);
    }
    /**
     * Object:批次合同's 扣嗉系数property 
     */
    public java.math.BigDecimal getChickenSzCoeff()
    {
        return getBigDecimal("chickenSzCoeff");
    }
    public void setChickenSzCoeff(java.math.BigDecimal item)
    {
        setBigDecimal("chickenSzCoeff", item);
    }
    /**
     * Object:批次合同's 保值价格property 
     */
    public java.math.BigDecimal getHedgingPrice()
    {
        return getBigDecimal("hedgingPrice");
    }
    public void setHedgingPrice(java.math.BigDecimal item)
    {
        setBigDecimal("hedgingPrice", item);
    }
    /**
     * Object:批次合同's 固定系数property 
     */
    public java.math.BigDecimal getFixedCoeff()
    {
        return getBigDecimal("fixedCoeff");
    }
    public void setFixedCoeff(java.math.BigDecimal item)
    {
        setBigDecimal("fixedCoeff", item);
    }
    /**
     * Object:批次合同's 分享系数property 
     */
    public java.math.BigDecimal getShareCoeff()
    {
        return getBigDecimal("shareCoeff");
    }
    public void setShareCoeff(java.math.BigDecimal item)
    {
        setBigDecimal("shareCoeff", item);
    }
    /**
     * Object: 批次合同 's 奖惩政策 property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo getAwardPolicy()
    {
        return (com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo)get("awardPolicy");
    }
    public void setAwardPolicy(com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo item)
    {
        put("awardPolicy", item);
    }
    /**
     * Object:批次合同's 养殖场场长property 
     */
    public String getFarmer()
    {
        return getString("farmer");
    }
    public void setFarmer(String item)
    {
        setString("farmer", item);
    }
    /**
     * Object:批次合同's 场长联系方式property 
     */
    public String getHeaderCell()
    {
        return getString("headerCell");
    }
    public void setHeaderCell(String item)
    {
        setString("headerCell", item);
    }
    /**
     * Object: 批次合同 's 分配记录 property 
     */
    public com.kingdee.eas.custom.taihe.contract.BatchContractAllotEntryCollection getAllotEntry()
    {
        return (com.kingdee.eas.custom.taihe.contract.BatchContractAllotEntryCollection)get("AllotEntry");
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
     * Object:批次合同's 是否关闭property 
     */
    public boolean isWhetherClose()
    {
        return getBoolean("whetherClose");
    }
    public void setWhetherClose(boolean item)
    {
        setBoolean("whetherClose", item);
    }
    /**
     * Object:批次合同's 是否初始化property 
     */
    public boolean isInitialization()
    {
        return getBoolean("initialization");
    }
    public void setInitialization(boolean item)
    {
        setBoolean("initialization", item);
    }
    /**
     * Object:批次合同's 初始累计回收数量property 
     */
    public java.math.BigDecimal getInitialCumulativeQty()
    {
        return getBigDecimal("initialCumulativeQty");
    }
    public void setInitialCumulativeQty(java.math.BigDecimal item)
    {
        setBigDecimal("initialCumulativeQty", item);
    }
    /**
     * Object:批次合同's 已回收数量property 
     */
    public java.math.BigDecimal getRecoveredQty()
    {
        return getBigDecimal("recoveredQty");
    }
    public void setRecoveredQty(java.math.BigDecimal item)
    {
        setBigDecimal("recoveredQty", item);
    }
    /**
     * Object:批次合同's 未回收数量property 
     */
    public java.math.BigDecimal getNonRecoveryQty()
    {
        return getBigDecimal("nonRecoveryQty");
    }
    public void setNonRecoveryQty(java.math.BigDecimal item)
    {
        setBigDecimal("nonRecoveryQty", item);
    }
    /**
     * Object:批次合同's 回收率property 
     */
    public String getRecoveryRate()
    {
        return getString("recoveryRate");
    }
    public void setRecoveryRate(String item)
    {
        setString("recoveryRate", item);
    }
    /**
     * Object:批次合同's 原料经理property 
     */
    public String getMManager()
    {
        return getString("mManager");
    }
    public void setMManager(String item)
    {
        setString("mManager", item);
    }
    /**
     * Object:批次合同's 建厂时间property 
     */
    public java.util.Date getBuildDate()
    {
        return getDate("buildDate");
    }
    public void setBuildDate(java.util.Date item)
    {
        setDate("buildDate", item);
    }
    /**
     * Object:批次合同's 是否禁养区property 
     */
    public boolean isProhibitArea()
    {
        return getBoolean("prohibitArea");
    }
    public void setProhibitArea(boolean item)
    {
        setBoolean("prohibitArea", item);
    }
    /**
     * Object:批次合同's 重复批次property 
     */
    public boolean isWhetherRepeat()
    {
        return getBoolean("whetherRepeat");
    }
    public void setWhetherRepeat(boolean item)
    {
        setBoolean("whetherRepeat", item);
    }
    /**
     * Object:批次合同's 优质鸡加价property 
     */
    public java.math.BigDecimal getYzjincrease()
    {
        return getBigDecimal("yzjincrease");
    }
    public void setYzjincrease(java.math.BigDecimal item)
    {
        setBigDecimal("yzjincrease", item);
    }
    /**
     * Object:批次合同's 鸡苗来源property 
     */
    public String getChickenSource()
    {
        return getString("chickenSource");
    }
    public void setChickenSource(String item)
    {
        setString("chickenSource", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8193F8D0");
    }
}