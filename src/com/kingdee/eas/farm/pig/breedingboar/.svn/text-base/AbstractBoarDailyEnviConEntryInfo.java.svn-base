package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBoarDailyEnviConEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBoarDailyEnviConEntryInfo()
    {
        this("id");
    }
    protected AbstractBoarDailyEnviConEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 环控分录 's null property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.breedingboar.BoarDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:环控分录's 采食时长(h)property 
     */
    public java.math.BigDecimal getBreedTimes()
    {
        return getBigDecimal("breedTimes");
    }
    public void setBreedTimes(java.math.BigDecimal item)
    {
        setBigDecimal("breedTimes", item);
    }
    /**
     * Object:环控分录's 光照时长(h)property 
     */
    public java.math.BigDecimal getLightingTimes()
    {
        return getBigDecimal("lightingTimes");
    }
    public void setLightingTimes(java.math.BigDecimal item)
    {
        setBigDecimal("lightingTimes", item);
    }
    /**
     * Object:环控分录's 最低温度(℃)property 
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
     * Object:环控分录's 最高温度(℃)property 
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
     * Object:环控分录's 最低湿度(%)property 
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
     * Object:环控分录's 最高湿度(%)property 
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
     * Object: 环控分录 's 猪舍 property 
     */
    public com.kingdee.eas.farm.pig.PigHouseInfo getPigHouse()
    {
        return (com.kingdee.eas.farm.pig.PigHouseInfo)get("pigHouse");
    }
    public void setPigHouse(com.kingdee.eas.farm.pig.PigHouseInfo item)
    {
        put("pigHouse", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("BCE9942B");
    }
}