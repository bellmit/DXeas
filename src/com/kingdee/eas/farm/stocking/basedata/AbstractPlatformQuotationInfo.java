package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPlatformQuotationInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPlatformQuotationInfo()
    {
        this("id");
    }
    protected AbstractPlatformQuotationInfo(String pkField)
    {
        super(pkField);
        put("PriceEntrys", new com.kingdee.eas.farm.stocking.basedata.PlatformQuotationPriceEntryCollection());
    }
    /**
     * Object:平台报价's 日期property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    /**
     * Object: 平台报价 's 报价分录 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.PlatformQuotationPriceEntryCollection getPriceEntrys()
    {
        return (com.kingdee.eas.farm.stocking.basedata.PlatformQuotationPriceEntryCollection)get("PriceEntrys");
    }
    /**
     * Object:平台报价's 基本状态property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.farm.stocking.basedata.FarmBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object: 平台报价 's 财务组织 property 
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
        return new BOSObjectType("EECE0F28");
    }
}