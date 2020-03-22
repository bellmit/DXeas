package com.kingdee.eas.farm.breed.brood;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBroodDailyAssEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBroodDailyAssEntryInfo()
    {
        this("id");
    }
    protected AbstractBroodDailyAssEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 其他信息分录 's null property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.brood.BroodDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:其他信息分录's 采食时长property 
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
     * Object:其他信息分录's 光照时长（h）property 
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
     * Object:其他信息分录's 最高温度（℃）property 
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
     * Object:其他信息分录's 最低温度（℃）property 
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
     * Object:其他信息分录's 最高湿度（%）property 
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
     * Object:其他信息分录's 最低湿度（%）property 
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
     * Object: 其他信息分录 's 鸡舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenhouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henhouse");
    }
    public void setHenhouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henhouse", item);
    }
    /**
     * Object:其他信息分录's 鸡舍名称property 
     */
    public String getHenhouseName()
    {
        return getString("henhouseName");
    }
    public void setHenhouseName(String item)
    {
        setString("henhouseName", item);
    }
    /**
     * Object:其他信息分录's 死亡数property 
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
     * Object:其他信息分录's 淘汰数property 
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
     * Object:其他信息分录's 存栏量property 
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
     * Object:其他信息分录's 是否完全出栏property 
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
     * Object:其他信息分录's 出栏量property 
     */
    public int getMarketQty()
    {
        return getInt("marketQty");
    }
    public void setMarketQty(int item)
    {
        setInt("marketQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6A7C9BEA");
    }
}