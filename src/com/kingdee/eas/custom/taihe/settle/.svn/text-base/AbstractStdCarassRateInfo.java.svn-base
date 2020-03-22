package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStdCarassRateInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractStdCarassRateInfo()
    {
        this("id");
    }
    protected AbstractStdCarassRateInfo(String pkField)
    {
        super(pkField);
        put("Entry", new com.kingdee.eas.custom.taihe.settle.StdCarassRateEntryCollection());
    }
    /**
     * Object: 标准出成率 's 财务组织 property 
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
     * Object:标准出成率's 生效日期property 
     */
    public java.util.Date getEffectDate()
    {
        return getDate("effectDate");
    }
    public void setEffectDate(java.util.Date item)
    {
        setDate("effectDate", item);
    }
    /**
     * Object:标准出成率's 失效日期property 
     */
    public java.util.Date getUnEffectDate()
    {
        return getDate("unEffectDate");
    }
    public void setUnEffectDate(java.util.Date item)
    {
        setDate("unEffectDate", item);
    }
    /**
     * Object:标准出成率's 标准出成率property 
     */
    public java.math.BigDecimal getStdCarcassRate()
    {
        return getBigDecimal("stdCarcassRate");
    }
    public void setStdCarcassRate(java.math.BigDecimal item)
    {
        setBigDecimal("stdCarcassRate", item);
    }
    /**
     * Object:标准出成率's 收购类型property 
     */
    public com.kingdee.eas.custom.taihe.weight.PurchaseType getAcquisitionType()
    {
        return com.kingdee.eas.custom.taihe.weight.PurchaseType.getEnum(getString("acquisitionType"));
    }
    public void setAcquisitionType(com.kingdee.eas.custom.taihe.weight.PurchaseType item)
    {
		if (item != null) {
        setString("acquisitionType", item.getValue());
		}
    }
    /**
     * Object:标准出成率's 是否棚前property 
     */
    public boolean isHouseBefore()
    {
        return getBoolean("houseBefore");
    }
    public void setHouseBefore(boolean item)
    {
        setBoolean("houseBefore", item);
    }
    /**
     * Object: 标准出成率 's 标准分录 property 
     */
    public com.kingdee.eas.custom.taihe.settle.StdCarassRateEntryCollection getEntry()
    {
        return (com.kingdee.eas.custom.taihe.settle.StdCarassRateEntryCollection)get("Entry");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BC1A28CD");
    }
}