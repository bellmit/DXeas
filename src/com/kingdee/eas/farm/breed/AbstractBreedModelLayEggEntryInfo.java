package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedModelLayEggEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedModelLayEggEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedModelLayEggEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 产蛋规范 's null property 
     */
    public com.kingdee.eas.farm.breed.BreedModelInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.BreedModelInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.BreedModelInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:产蛋规范's 周龄property 
     */
    public int getWeek()
    {
        return getInt("week");
    }
    public void setWeek(int item)
    {
        setInt("week", item);
    }
    /**
     * Object:产蛋规范's 日龄property 
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
     * Object:产蛋规范's 产蛋率（%）property 
     */
    public java.math.BigDecimal getEggRate()
    {
        return getBigDecimal("eggRate");
    }
    public void setEggRate(java.math.BigDecimal item)
    {
        setBigDecimal("eggRate", item);
    }
    /**
     * Object:产蛋规范's 合格率（%）property 
     */
    public java.math.BigDecimal getUpEggRate()
    {
        return getBigDecimal("upEggRate");
    }
    public void setUpEggRate(java.math.BigDecimal item)
    {
        setBigDecimal("upEggRate", item);
    }
    /**
     * Object:产蛋规范's 畸形率(%)property 
     */
    public java.math.BigDecimal getFreakRate()
    {
        return getBigDecimal("freakRate");
    }
    public void setFreakRate(java.math.BigDecimal item)
    {
        setBigDecimal("freakRate", item);
    }
    /**
     * Object:产蛋规范's 双黄率(%)property 
     */
    public java.math.BigDecimal getDoubleYolkRate()
    {
        return getBigDecimal("doubleYolkRate");
    }
    public void setDoubleYolkRate(java.math.BigDecimal item)
    {
        setBigDecimal("doubleYolkRate", item);
    }
    /**
     * Object:产蛋规范's 破损率(%)property 
     */
    public java.math.BigDecimal getBrokenRate()
    {
        return getBigDecimal("brokenRate");
    }
    public void setBrokenRate(java.math.BigDecimal item)
    {
        setBigDecimal("brokenRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4FB0AEC2");
    }
}