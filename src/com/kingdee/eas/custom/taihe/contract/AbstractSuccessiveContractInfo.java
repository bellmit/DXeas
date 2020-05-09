package com.kingdee.eas.custom.taihe.contract;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSuccessiveContractInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
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
     * Object:连养合同's 乙方地址property 
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
     * Object:连养合同's 乙方身份证号码property 
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
     * Object:连养合同's 乙方收款银行property 
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
     * Object:连养合同's 乙方银行账号property 
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
     * Object:连养合同's 单据状态property 
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
     * Object:连养合同's 审核时间property 
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
    public com.kingdee.eas.bdm.bdapply.SupplierReqInfo getSupplier()
    {
        return (com.kingdee.eas.bdm.bdapply.SupplierReqInfo)get("Supplier");
    }
    public void setSupplier(com.kingdee.eas.bdm.bdapply.SupplierReqInfo item)
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
     * Object: 连养合同 's 养殖户 property 
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
     * Object: 连养合同 's 养殖场 property 
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
     * Object: 连养合同 's 结算政策 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo getSettlePolicy()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo)get("settlePolicy");
    }
    public void setSettlePolicy(com.kingdee.eas.farm.carnivorous.basedata.SettlePolicyInfo item)
    {
        put("settlePolicy", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6C7F3E43");
    }
}