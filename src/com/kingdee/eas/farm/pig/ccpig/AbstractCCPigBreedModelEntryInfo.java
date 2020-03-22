package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCCPigBreedModelEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCCPigBreedModelEntryInfo()
    {
        this("id");
    }
    protected AbstractCCPigBreedModelEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 饲喂计划 's null property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.ccpig.CCPigBreedModelInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 饲喂计划 's 饲料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("material");
    }
    public void setMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("material", item);
    }
    /**
     * Object:饲喂计划's 日喂料量（g/头）property 
     */
    public java.math.BigDecimal getQtyPerday()
    {
        return getBigDecimal("qtyPerday");
    }
    public void setQtyPerday(java.math.BigDecimal item)
    {
        setBigDecimal("qtyPerday", item);
    }
    /**
     * Object:饲喂计划's 标准饮水量property 
     */
    public java.math.BigDecimal getWaterQty()
    {
        return getBigDecimal("waterQty");
    }
    public void setWaterQty(java.math.BigDecimal item)
    {
        setBigDecimal("waterQty", item);
    }
    /**
     * Object:饲喂计划's 采食时长property 
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
     * Object:饲喂计划's 光照时长（h）property 
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
     * Object:饲喂计划's 最高温度（℃）property 
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
     * Object:饲喂计划's 最低温度（℃）property 
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
     * Object:饲喂计划's 最低湿度（%）property 
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
     * Object:饲喂计划's 最高湿度（%）property 
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
     * Object:饲喂计划's 日龄property 
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
     * Object:饲喂计划's 标准只重（kg）property 
     */
    public java.math.BigDecimal getStandardWeight()
    {
        return getBigDecimal("standardWeight");
    }
    public void setStandardWeight(java.math.BigDecimal item)
    {
        setBigDecimal("standardWeight", item);
    }
    /**
     * Object:饲喂计划's 增重（g）property 
     */
    public java.math.BigDecimal getDynamiting()
    {
        return getBigDecimal("dynamiting");
    }
    public void setDynamiting(java.math.BigDecimal item)
    {
        setBigDecimal("dynamiting", item);
    }
    /**
     * Object:饲喂计划's 日标准死淘率（%）property 
     */
    public java.math.BigDecimal getDailyDCRate()
    {
        return getBigDecimal("dailyDCRate");
    }
    public void setDailyDCRate(java.math.BigDecimal item)
    {
        setBigDecimal("dailyDCRate", item);
    }
    /**
     * Object:饲喂计划's 备注property 
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
     * Object:饲喂计划's 注意事项property 
     */
    public String getAttentions()
    {
        return getString("attentions");
    }
    public void setAttentions(String item)
    {
        setString("attentions", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("38FC290F");
    }
}