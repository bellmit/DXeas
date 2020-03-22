package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarketPolicyInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractMarketPolicyInfo()
    {
        this("id");
    }
    protected AbstractMarketPolicyInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 市场结算政策 's 公司 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompanyOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("companyOrgUnit");
    }
    public void setCompanyOrgUnit(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("companyOrgUnit", item);
    }
    /**
     * Object:市场结算政策's 单据状态property 
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
     * Object: 市场结算政策 's 审核人 property 
     */
    public com.kingdee.eas.base.permission.UserInfo getAuditor()
    {
        return (com.kingdee.eas.base.permission.UserInfo)get("auditor");
    }
    public void setAuditor(com.kingdee.eas.base.permission.UserInfo item)
    {
        put("auditor", item);
    }
    /**
     * Object:市场结算政策's 审核时间property 
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
     * Object:市场结算政策's 出成率property 
     */
    public java.math.BigDecimal getYieldRate()
    {
        return getBigDecimal("yieldRate");
    }
    public void setYieldRate(java.math.BigDecimal item)
    {
        setBigDecimal("yieldRate", item);
    }
    /**
     * Object:市场结算政策's 市场价property 
     */
    public java.math.BigDecimal getContractPrice()
    {
        return getBigDecimal("contractPrice");
    }
    public void setContractPrice(java.math.BigDecimal item)
    {
        setBigDecimal("contractPrice", item);
    }
    /**
     * Object:市场结算政策's 市场类型property 
     */
    public com.kingdee.eas.farm.carnivorous.recyclebiz.MarketType getMarketType()
    {
        return com.kingdee.eas.farm.carnivorous.recyclebiz.MarketType.getEnum(getString("marketType"));
    }
    public void setMarketType(com.kingdee.eas.farm.carnivorous.recyclebiz.MarketType item)
    {
		if (item != null) {
        setString("marketType", item.getValue());
		}
    }
    /**
     * Object:市场结算政策's 市场毛鸡价格(元/只)property 
     */
    public java.math.BigDecimal getMarketChicOrice()
    {
        return getBigDecimal("marketChicOrice");
    }
    public void setMarketChicOrice(java.math.BigDecimal item)
    {
        setBigDecimal("marketChicOrice", item);
    }
    /**
     * Object:市场结算政策's 市场小鸡价格(元/只)property 
     */
    public java.math.BigDecimal getMarketSmartPrice()
    {
        return getBigDecimal("marketSmartPrice");
    }
    public void setMarketSmartPrice(java.math.BigDecimal item)
    {
        setBigDecimal("marketSmartPrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("837DB730");
    }
}