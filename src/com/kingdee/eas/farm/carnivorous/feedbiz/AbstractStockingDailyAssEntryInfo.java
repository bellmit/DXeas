package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingDailyAssEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingDailyAssEntryInfo()
    {
        this("id");
    }
    protected AbstractStockingDailyAssEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖信息分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:养殖信息分录's 采食时长property 
     */
    public java.math.BigDecimal getBreedTime()
    {
        return getBigDecimal("breedTime");
    }
    public void setBreedTime(java.math.BigDecimal item)
    {
        setBigDecimal("breedTime", item);
    }
    /**
     * Object:养殖信息分录's 光照时长（h）property 
     */
    public java.math.BigDecimal getLightingTime()
    {
        return getBigDecimal("lightingTime");
    }
    public void setLightingTime(java.math.BigDecimal item)
    {
        setBigDecimal("lightingTime", item);
    }
    /**
     * Object:养殖信息分录's 最高温度（℃）property 
     */
    public java.math.BigDecimal getTemperatureTo()
    {
        return getBigDecimal("temperatureTo");
    }
    public void setTemperatureTo(java.math.BigDecimal item)
    {
        setBigDecimal("temperatureTo", item);
    }
    /**
     * Object:养殖信息分录's 最低温度（℃）property 
     */
    public java.math.BigDecimal getTemperatureFrom()
    {
        return getBigDecimal("temperatureFrom");
    }
    public void setTemperatureFrom(java.math.BigDecimal item)
    {
        setBigDecimal("temperatureFrom", item);
    }
    /**
     * Object:养殖信息分录's 最高湿度（%）property 
     */
    public java.math.BigDecimal getHumidityTo()
    {
        return getBigDecimal("humidityTo");
    }
    public void setHumidityTo(java.math.BigDecimal item)
    {
        setBigDecimal("humidityTo", item);
    }
    /**
     * Object:养殖信息分录's 最低湿度（%）property 
     */
    public java.math.BigDecimal getHumidityFrom()
    {
        return getBigDecimal("humidityFrom");
    }
    public void setHumidityFrom(java.math.BigDecimal item)
    {
        setBigDecimal("humidityFrom", item);
    }
    /**
     * Object:养殖信息分录's 死亡数property 
     */
    public int getDeathQty()
    {
        return getInt("deathQty");
    }
    public void setDeathQty(int item)
    {
        setInt("deathQty", item);
    }
    /**
     * Object:养殖信息分录's 淘汰数property 
     */
    public int getCullQty()
    {
        return getInt("cullQty");
    }
    public void setCullQty(int item)
    {
        setInt("cullQty", item);
    }
    /**
     * Object:养殖信息分录's 存栏量property 
     */
    public int getBreekingStock()
    {
        return getInt("breekingStock");
    }
    public void setBreekingStock(int item)
    {
        setInt("breekingStock", item);
    }
    /**
     * Object:养殖信息分录's 是否完全出栏property 
     */
    public boolean isIsMarketed()
    {
        return getBoolean("isMarketed");
    }
    public void setIsMarketed(boolean item)
    {
        setBoolean("isMarketed", item);
    }
    /**
     * Object:养殖信息分录's 平均只重property 
     */
    public java.math.BigDecimal getAvgWeight()
    {
        return getBigDecimal("avgWeight");
    }
    public void setAvgWeight(java.math.BigDecimal item)
    {
        setBigDecimal("avgWeight", item);
    }
    /**
     * Object:养殖信息分录's 出栏量property 
     */
    public int getMarkedQty()
    {
        return getInt("markedQty");
    }
    public void setMarkedQty(int item)
    {
        setInt("markedQty", item);
    }
    /**
     * Object:养殖信息分录's 调整值property 
     */
    public int getAdjustQty()
    {
        return getInt("adjustQty");
    }
    public void setAdjustQty(int item)
    {
        setInt("adjustQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A4833E1A");
    }
}