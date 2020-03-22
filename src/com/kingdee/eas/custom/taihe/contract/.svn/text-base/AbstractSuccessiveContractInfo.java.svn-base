package com.kingdee.eas.custom.taihe.contract;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSuccessiveContractInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractSuccessiveContractInfo()
    {
        this("id");
    }
    protected AbstractSuccessiveContractInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:连养合同's 是否生成凭证property 
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
     * Object:连养合同's 初始化单据property 
     */
    public boolean isIsInitBill()
    {
        return getBoolean("isInitBill");
    }
    public void setIsInitBill(boolean item)
    {
        setBoolean("isInitBill", item);
    }
    /**
     * Object: 连养合同 's 合同类型 property 
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
     * Object:连养合同's 合同开始日期property 
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
     * Object:连养合同's 合同终止日期property 
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
     * Object:连养合同's 连养批数property 
     */
    public int getSuccessiveQty()
    {
        return getInt("successiveQty");
    }
    public void setSuccessiveQty(int item)
    {
        setInt("successiveQty", item);
    }
    /**
     * Object:连养合同's 联系方式property 
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
     * Object:连养合同's 供应商地址property 
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
     * Object:连养合同's 供应商身份证号码property 
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
     * Object:连养合同's 供应商收款银行property 
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
     * Object:连养合同's 供应商银行账号property 
     */
    public String getPartyBBankNo()
    {
        return getString("partyBBankNo");
    }
    public void setPartyBBankNo(String item)
    {
        setString("partyBBankNo", item);
    }
    /**
     * Object: 连养合同 's 养殖场 property 
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
     * Object:连养合同's 养殖场场长property 
     */
    public String getHeader()
    {
        return getString("header");
    }
    public void setHeader(String item)
    {
        setString("header", item);
    }
    /**
     * Object:连养合同's 养殖规模property 
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
     * Object:连养合同's 预计出栏天数property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    /**
     * Object:连养合同's 偏离天数property 
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
     * Object:连养合同's 间隔天数property 
     */
    public int getIntervalDays()
    {
        return getInt("intervalDays");
    }
    public void setIntervalDays(int item)
    {
        setInt("intervalDays", item);
    }
    /**
     * Object:连养合同's 关闭状态property 
     */
    public com.kingdee.eas.custom.taihe.contract.CloseStatus getCloseStatus()
    {
        return com.kingdee.eas.custom.taihe.contract.CloseStatus.getEnum(getString("closeStatus"));
    }
    public void setCloseStatus(com.kingdee.eas.custom.taihe.contract.CloseStatus item)
    {
		if (item != null) {
        setString("closeStatus", item.getValue());
		}
    }
    /**
     * Object:连养合同's 关闭时间property 
     */
    public java.util.Date getCloseTime()
    {
        return getDate("closeTime");
    }
    public void setCloseTime(java.util.Date item)
    {
        setDate("closeTime", item);
    }
    /**
     * Object:连养合同's 备注property 
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
     * Object: 连养合同 's 公司 property 
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
     * Object: 连养合同 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("Supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("Supplier", item);
    }
    /**
     * Object:连养合同's 上苗日期property 
     */
    public java.util.Date getUpSeedingDate()
    {
        return getDate("upSeedingDate");
    }
    public void setUpSeedingDate(java.util.Date item)
    {
        setDate("upSeedingDate", item);
    }
    /**
     * Object:连养合同's 上苗数量property 
     */
    public java.math.BigDecimal getUpSeedingQty()
    {
        return getBigDecimal("upSeedingQty");
    }
    public void setUpSeedingQty(java.math.BigDecimal item)
    {
        setBigDecimal("upSeedingQty", item);
    }
    /**
     * Object: 连养合同 's 原料员 property 
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
     * Object:连养合同's 已连养批数property 
     */
    public int getHasSuccessiveQty()
    {
        return getInt("hasSuccessiveQty");
    }
    public void setHasSuccessiveQty(int item)
    {
        setInt("hasSuccessiveQty", item);
    }
    /**
     * Object:连养合同's 饲喂类别property 
     */
    public com.kingdee.eas.custom.taihe.contract.FeedType getFeedingType()
    {
        return com.kingdee.eas.custom.taihe.contract.FeedType.getEnum(getString("feedingType"));
    }
    public void setFeedingType(com.kingdee.eas.custom.taihe.contract.FeedType item)
    {
		if (item != null) {
        setString("feedingType", item.getValue());
		}
    }
    /**
     * Object: 连养合同 's 保证金政策 property 
     */
    public com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo getSecurityDeposit()
    {
        return (com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo)get("securityDeposit");
    }
    public void setSecurityDeposit(com.kingdee.eas.custom.taihe.contract.AssureAmtPolicyInfo item)
    {
        put("securityDeposit", item);
    }
    /**
     * Object:连养合同's 单只保证金property 
     */
    public java.math.BigDecimal getSingleSecurityDeposit()
    {
        return getBigDecimal("singleSecurityDeposit");
    }
    public void setSingleSecurityDeposit(java.math.BigDecimal item)
    {
        setBigDecimal("singleSecurityDeposit", item);
    }
    /**
     * Object:连养合同's 政策保底价property 
     */
    public java.math.BigDecimal getPolicyMinimum()
    {
        return getBigDecimal("policyMinimum");
    }
    public void setPolicyMinimum(java.math.BigDecimal item)
    {
        setBigDecimal("policyMinimum", item);
    }
    /**
     * Object:连养合同's 合同保底价property 
     */
    public java.math.BigDecimal getContractMinimum()
    {
        return getBigDecimal("contractMinimum");
    }
    public void setContractMinimum(java.math.BigDecimal item)
    {
        setBigDecimal("contractMinimum", item);
    }
    /**
     * Object:连养合同's 应交保证金property 
     */
    public java.math.BigDecimal getShouldSecurityDeposit()
    {
        return getBigDecimal("shouldSecurityDeposit");
    }
    public void setShouldSecurityDeposit(java.math.BigDecimal item)
    {
        setBigDecimal("shouldSecurityDeposit", item);
    }
    /**
     * Object:连养合同's 场长联系方式property 
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
     * Object: 连养合同 's 结算政策 property 
     */
    public com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo getStatementPolicy()
    {
        return (com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo)get("statementPolicy");
    }
    public void setStatementPolicy(com.kingdee.eas.custom.taihe.settle.TaiHeSettlePolicyInfo item)
    {
        put("statementPolicy", item);
    }
    /**
     * Object:连养合同's 初始化已养批数property 
     */
    public int getInitBatchQty()
    {
        return getInt("initBatchQty");
    }
    public void setInitBatchQty(int item)
    {
        setInt("initBatchQty", item);
    }
    /**
     * Object:连养合同's 养殖场地址property 
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
     * Object:连养合同's 优质鸡加价property 
     */
    public java.math.BigDecimal getYzjincrease()
    {
        return getBigDecimal("yzjincrease");
    }
    public void setYzjincrease(java.math.BigDecimal item)
    {
        setBigDecimal("yzjincrease", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6C7F3E43");
    }
}