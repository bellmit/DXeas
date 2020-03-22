package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonTaxInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPersonTaxInfo()
    {
        this("id");
    }
    protected AbstractPersonTaxInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.wages.PersonTaxEntryCollection());
    }
    /**
     * Object:个税标准配置's 生效日期property 
     */
    public java.util.Date getBizdate()
    {
        return getDate("bizdate");
    }
    public void setBizdate(java.util.Date item)
    {
        setDate("bizdate", item);
    }
    /**
     * Object: 个税标准配置 's 公司 property 
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
     * Object:个税标准配置's 单据状态property 
     */
    public com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.custom.wlhllicensemanager.UsedStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:个税标准配置's 起征标准property 
     */
    public java.math.BigDecimal getTaxstandard()
    {
        return getBigDecimal("taxstandard");
    }
    public void setTaxstandard(java.math.BigDecimal item)
    {
        setBigDecimal("taxstandard", item);
    }
    /**
     * Object: 个税标准配置 's 税率区间 property 
     */
    public com.kingdee.eas.custom.wages.PersonTaxEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.wages.PersonTaxEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B7AF1D0E");
    }
}