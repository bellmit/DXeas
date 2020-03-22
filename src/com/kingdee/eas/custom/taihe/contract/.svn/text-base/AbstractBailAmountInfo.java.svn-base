package com.kingdee.eas.custom.taihe.contract;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBailAmountInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlBillBaseInfo implements Serializable 
{
    public AbstractBailAmountInfo()
    {
        this("id");
    }
    protected AbstractBailAmountInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:保证金's 是否生成凭证property 
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
     * Object:保证金's 缴款时间property 
     */
    public java.util.Date getPayTime()
    {
        return getDate("payTime");
    }
    public void setPayTime(java.util.Date item)
    {
        setDate("payTime", item);
    }
    /**
     * Object:保证金's 缴费金额property 
     */
    public java.math.BigDecimal getPayAmount()
    {
        return getBigDecimal("payAmount");
    }
    public void setPayAmount(java.math.BigDecimal item)
    {
        setBigDecimal("payAmount", item);
    }
    /**
     * Object: 保证金 's 供应商 property 
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
     * Object:保证金's 审批意见property 
     */
    public String getAuditOpinion()
    {
        return getString("auditOpinion");
    }
    public void setAuditOpinion(String item)
    {
        setString("auditOpinion", item);
    }
    /**
     * Object:保证金's 缴款方式property 
     */
    public com.kingdee.eas.custom.taihe.contract.PaymentType getPayType()
    {
        return com.kingdee.eas.custom.taihe.contract.PaymentType.getEnum(getString("payType"));
    }
    public void setPayType(com.kingdee.eas.custom.taihe.contract.PaymentType item)
    {
		if (item != null) {
        setString("payType", item.getValue());
		}
    }
    /**
     * Object:保证金's 期初保证金property 
     */
    public java.math.BigDecimal getBeginMoney()
    {
        return getBigDecimal("beginMoney");
    }
    public void setBeginMoney(java.math.BigDecimal item)
    {
        setBigDecimal("beginMoney", item);
    }
    /**
     * Object:保证金's 单据类型property 
     */
    public com.kingdee.eas.custom.taihe.contract.client.moneyType getMoneyTypes()
    {
        return com.kingdee.eas.custom.taihe.contract.client.moneyType.getEnum(getString("moneyTypes"));
    }
    public void setMoneyTypes(com.kingdee.eas.custom.taihe.contract.client.moneyType item)
    {
		if (item != null) {
        setString("moneyTypes", item.getValue());
		}
    }
    /**
     * Object:保证金's 是否初始化单据property 
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
     * Object: 保证金 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("694FB4B6");
    }
}