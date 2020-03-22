package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractChickenDailyPriceInfo extends com.kingdee.eas.custom.wlhllicensemanager.WlhlDataBaseInfo implements Serializable 
{
    public AbstractChickenDailyPriceInfo()
    {
        this("id");
    }
    protected AbstractChickenDailyPriceInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 毛鸡价格 's 财务组织 property 
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
     * Object:毛鸡价格's 生效日期property 
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
     * Object:毛鸡价格's 失效日期property 
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
     * Object:毛鸡价格's 价格property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:毛鸡价格's 加价property 
     */
    public java.math.BigDecimal getAddPrice()
    {
        return getBigDecimal("addPrice");
    }
    public void setAddPrice(java.math.BigDecimal item)
    {
        setBigDecimal("addPrice", item);
    }
    /**
     * Object:毛鸡价格's 小鸡价格property 
     */
    public java.math.BigDecimal getSmallChickPrice()
    {
        return getBigDecimal("smallChickPrice");
    }
    public void setSmallChickPrice(java.math.BigDecimal item)
    {
        setBigDecimal("smallChickPrice", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("96BCA162");
    }
}