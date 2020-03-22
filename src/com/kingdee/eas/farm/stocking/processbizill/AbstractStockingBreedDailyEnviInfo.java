package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBreedDailyEnviInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingBreedDailyEnviInfo()
    {
        this("id");
    }
    protected AbstractStockingBreedDailyEnviInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 环控分录 's null property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 环控分录 's 栋舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object:环控分录's 采食时长property 
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
     * Object:环控分录's 光照时长property 
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
     * Object:环控分录's 最高温度property 
     */
    public java.math.BigDecimal getHighTemp()
    {
        return getBigDecimal("highTemp");
    }
    public void setHighTemp(java.math.BigDecimal item)
    {
        setBigDecimal("highTemp", item);
    }
    /**
     * Object:环控分录's 最低温度property 
     */
    public java.math.BigDecimal getLowTemp()
    {
        return getBigDecimal("lowTemp");
    }
    public void setLowTemp(java.math.BigDecimal item)
    {
        setBigDecimal("lowTemp", item);
    }
    /**
     * Object:环控分录's 最高湿度property 
     */
    public java.math.BigDecimal getHighHumidity()
    {
        return getBigDecimal("highHumidity");
    }
    public void setHighHumidity(java.math.BigDecimal item)
    {
        setBigDecimal("highHumidity", item);
    }
    /**
     * Object:环控分录's 最低湿度property 
     */
    public java.math.BigDecimal getLowHumidity()
    {
        return getBigDecimal("lowHumidity");
    }
    public void setLowHumidity(java.math.BigDecimal item)
    {
        setBigDecimal("lowHumidity", item);
    }
    /**
     * Object:环控分录's 光照强度property 
     */
    public java.math.BigDecimal getLightIntensity()
    {
        return getBigDecimal("lightIntensity");
    }
    public void setLightIntensity(java.math.BigDecimal item)
    {
        setBigDecimal("lightIntensity", item);
    }
    /**
     * Object:环控分录's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:环控分录's 夜饲时间property 
     */
    public String getNightFeedTime()
    {
        return getString("nightFeedTime");
    }
    public void setNightFeedTime(String item)
    {
        setString("nightFeedTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8A0B1592");
    }
}