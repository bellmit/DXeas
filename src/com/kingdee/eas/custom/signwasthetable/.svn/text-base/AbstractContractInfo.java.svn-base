package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractContractInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractContractInfo()
    {
        this("id");
    }
    protected AbstractContractInfo(String pkField)
    {
        super(pkField);
        put("Payment", new com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection());
    }
    /**
     * Object:合同签呈's 是否生成凭证property 
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
     * Object:合同签呈's 审核时间property 
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
     * Object: 合同签呈 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getFIUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("FIUnit");
    }
    public void setFIUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("FIUnit", item);
    }
    /**
     * Object: 合同签呈 's 合同类别 property 
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
     * Object:合同签呈's 合同状态property 
     */
    public com.kingdee.eas.custom.signwasthetable.billStatus getContractStatus()
    {
        return com.kingdee.eas.custom.signwasthetable.billStatus.getEnum(getString("contractStatus"));
    }
    public void setContractStatus(com.kingdee.eas.custom.signwasthetable.billStatus item)
    {
		if (item != null) {
        setString("contractStatus", item.getValue());
		}
    }
    /**
     * Object:合同签呈's 保证金金额property 
     */
    public java.math.BigDecimal getBailAmount()
    {
        return getBigDecimal("bailAmount");
    }
    public void setBailAmount(java.math.BigDecimal item)
    {
        setBigDecimal("bailAmount", item);
    }
    /**
     * Object: 合同签呈 's 币别 property 
     */
    public com.kingdee.eas.basedata.assistant.CurrencyInfo getCurrency()
    {
        return (com.kingdee.eas.basedata.assistant.CurrencyInfo)get("currency");
    }
    public void setCurrency(com.kingdee.eas.basedata.assistant.CurrencyInfo item)
    {
        put("currency", item);
    }
    /**
     * Object:合同签呈's 汇率property 
     */
    public java.math.BigDecimal getExchangeRate()
    {
        return getBigDecimal("exchangeRate");
    }
    public void setExchangeRate(java.math.BigDecimal item)
    {
        setBigDecimal("exchangeRate", item);
    }
    /**
     * Object:合同签呈's 合同名称property 
     */
    public String getContractName()
    {
        return getString("contractName");
    }
    public void setContractName(String item)
    {
        setString("contractName", item);
    }
    /**
     * Object:合同签呈's 质保金比例property 
     */
    public java.math.BigDecimal getBailRate()
    {
        return getBigDecimal("bailRate");
    }
    public void setBailRate(java.math.BigDecimal item)
    {
        setBigDecimal("bailRate", item);
    }
    /**
     * Object:合同签呈's 版本property 
     */
    public String getVersion()
    {
        return getString("version");
    }
    public void setVersion(String item)
    {
        setString("version", item);
    }
    /**
     * Object:合同签呈's 本位币大写property 
     */
    public String getCapitalLocalCurrency()
    {
        return getString("CapitalLocalCurrency");
    }
    public void setCapitalLocalCurrency(String item)
    {
        setString("CapitalLocalCurrency", item);
    }
    /**
     * Object:合同签呈's 合同金额本位币property 
     */
    public java.math.BigDecimal getAmountLocalCurrency()
    {
        return getBigDecimal("AmountLocalCurrency");
    }
    public void setAmountLocalCurrency(java.math.BigDecimal item)
    {
        setBigDecimal("AmountLocalCurrency", item);
    }
    /**
     * Object:合同签呈's 合同金额原币property 
     */
    public java.math.BigDecimal getAmountOriCurrency()
    {
        return getBigDecimal("AmountOriCurrency");
    }
    public void setAmountOriCurrency(java.math.BigDecimal item)
    {
        setBigDecimal("AmountOriCurrency", item);
    }
    /**
     * Object:合同签呈's 原币大写property 
     */
    public String getCapitaloriCurrency()
    {
        return getString("CapitaloriCurrency");
    }
    public void setCapitaloriCurrency(String item)
    {
        setString("CapitaloriCurrency", item);
    }
    /**
     * Object: 合同签呈 's 责任部门 property 
     */
    public com.kingdee.eas.basedata.org.AdminOrgUnitInfo getAssureDept()
    {
        return (com.kingdee.eas.basedata.org.AdminOrgUnitInfo)get("assureDept");
    }
    public void setAssureDept(com.kingdee.eas.basedata.org.AdminOrgUnitInfo item)
    {
        put("assureDept", item);
    }
    /**
     * Object:合同签呈's 签订日期property 
     */
    public java.util.Date getSignDate()
    {
        return getDate("signDate");
    }
    public void setSignDate(java.util.Date item)
    {
        setDate("signDate", item);
    }
    /**
     * Object:合同签呈's 丙方property 
     */
    public String getPartyC()
    {
        return getString("partyC");
    }
    public void setPartyC(String item)
    {
        setString("partyC", item);
    }
    /**
     * Object: 合同签呈 's 乙方（供应商） property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getPartyB()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("partyB");
    }
    public void setPartyB(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("partyB", item);
    }
    /**
     * Object: 合同签呈 's 付款阶段 property 
     */
    public com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection getPayment()
    {
        return (com.kingdee.eas.custom.signwasthetable.ContractPaymentCollection)get("Payment");
    }
    /**
     * Object:合同签呈's 更改时间property 
     */
    public java.util.Date getChangeDate()
    {
        return getDate("changeDate");
    }
    public void setChangeDate(java.util.Date item)
    {
        setDate("changeDate", item);
    }
    /**
     * Object:合同签呈's 上一版本idproperty 
     */
    public String getPerVersionID()
    {
        return getString("perVersionID");
    }
    public void setPerVersionID(String item)
    {
        setString("perVersionID", item);
    }
    /**
     * Object:合同签呈's 是否历史版本property 
     */
    public int getIsHistory()
    {
        return getInt("isHistory");
    }
    public void setIsHistory(int item)
    {
        setInt("isHistory", item);
    }
    /**
     * Object:合同签呈's 分录条数property 
     */
    public int getPaymentRemove()
    {
        return getInt("paymentRemove");
    }
    public void setPaymentRemove(int item)
    {
        setInt("paymentRemove", item);
    }
    /**
     * Object:合同签呈's 最后一个阶段是否溢出property 
     */
    public int getIsLastOverflow()
    {
        return getInt("isLastOverflow");
    }
    public void setIsLastOverflow(int item)
    {
        setInt("isLastOverflow", item);
    }
    /**
     * Object:合同签呈's 分录数property 
     */
    public String getContractNum()
    {
        return getString("contractNum");
    }
    public void setContractNum(String item)
    {
        setString("contractNum", item);
    }
    /**
     * Object:合同签呈's 合同性质property 
     */
    public com.kingdee.eas.custom.signwasthetable.contractNature getContractNature()
    {
        return com.kingdee.eas.custom.signwasthetable.contractNature.getEnum(getString("contractNature"));
    }
    public void setContractNature(com.kingdee.eas.custom.signwasthetable.contractNature item)
    {
		if (item != null) {
        setString("contractNature", item.getValue());
		}
    }
    /**
     * Object: 合同签呈 's 责任人 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getAssurer()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("assurer");
    }
    public void setAssurer(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("assurer", item);
    }
    /**
     * Object: 合同签呈 's 甲方 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getPartyA()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("partyA");
    }
    public void setPartyA(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("partyA", item);
    }
    /**
     * Object:合同签呈's 是否初始化单据property 
     */
    public boolean isInitial()
    {
        return getBoolean("initial");
    }
    public void setInitial(boolean item)
    {
        setBoolean("initial", item);
    }
    /**
     * Object:合同签呈's 验收日期property 
     */
    public java.util.Date getCheckBeforeAcceptance()
    {
        return getDate("checkBeforeAcceptance");
    }
    public void setCheckBeforeAcceptance(java.util.Date item)
    {
        setDate("checkBeforeAcceptance", item);
    }
    /**
     * Object:合同签呈's 保证金天数property 
     */
    public int getBailAmtDays()
    {
        return getInt("bailAmtDays");
    }
    public void setBailAmtDays(int item)
    {
        setInt("bailAmtDays", item);
    }
    /**
     * Object:合同签呈's 备注property 
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
     * Object: 合同签呈 's 行政签呈 property 
     */
    public com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo getSignTable()
    {
        return (com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo)get("signTable");
    }
    public void setSignTable(com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo item)
    {
        put("signTable", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8C0AA21C");
    }
}