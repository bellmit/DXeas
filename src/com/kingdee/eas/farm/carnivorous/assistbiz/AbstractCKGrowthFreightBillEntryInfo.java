package com.kingdee.eas.farm.carnivorous.assistbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCKGrowthFreightBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCKGrowthFreightBillEntryInfo()
    {
        this("id");
    }
    protected AbstractCKGrowthFreightBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.assistbiz.CKGrowthFreightBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 里程起始值property 
     */
    public java.math.BigDecimal getMileageFrom()
    {
        return getBigDecimal("mileageFrom");
    }
    public void setMileageFrom(java.math.BigDecimal item)
    {
        setBigDecimal("mileageFrom", item);
    }
    /**
     * Object:分录's 里程终止值property 
     */
    public java.math.BigDecimal getMileageTo()
    {
        return getBigDecimal("mileageTo");
    }
    public void setMileageTo(java.math.BigDecimal item)
    {
        setBigDecimal("mileageTo", item);
    }
    /**
     * Object:分录's 增幅运费property 
     */
    public java.math.BigDecimal getGrowthFreight()
    {
        return getBigDecimal("growthFreight");
    }
    public void setGrowthFreight(java.math.BigDecimal item)
    {
        setBigDecimal("growthFreight", item);
    }
    /**
     * Object:分录's 标准出肉率(%)property 
     */
    public java.math.BigDecimal getFmRateStd()
    {
        return getBigDecimal("fmRateStd");
    }
    public void setFmRateStd(java.math.BigDecimal item)
    {
        setBigDecimal("fmRateStd", item);
    }
    /**
     * Object:分录's 最高出肉率(%)property 
     */
    public java.math.BigDecimal getMaxFmRate()
    {
        return getBigDecimal("maxFmRate");
    }
    public void setMaxFmRate(java.math.BigDecimal item)
    {
        setBigDecimal("maxFmRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AEDF8AA6");
    }
}