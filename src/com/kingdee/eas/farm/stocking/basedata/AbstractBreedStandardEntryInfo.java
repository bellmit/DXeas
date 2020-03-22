package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedStandardEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedStandardEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedStandardEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 饲喂计划 's null property 
     */
    public com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.BreedStandardInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:饲喂计划's 周龄property 
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
     * Object: 饲喂计划 's 母禽料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getHenMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("henMaterial");
    }
    public void setHenMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("henMaterial", item);
    }
    /**
     * Object:饲喂计划's 日喂料量（g/只）property 
     */
    public java.math.BigDecimal getHenQtyPerday()
    {
        return getBigDecimal("henQtyPerday");
    }
    public void setHenQtyPerday(java.math.BigDecimal item)
    {
        setBigDecimal("henQtyPerday", item);
    }
    /**
     * Object: 饲喂计划 's 公禽料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getCockMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("cockMaterial");
    }
    public void setCockMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("cockMaterial", item);
    }
    /**
     * Object:饲喂计划's 日喂料量（g/只）property 
     */
    public java.math.BigDecimal getCockQtyPerday()
    {
        return getBigDecimal("cockQtyPerday");
    }
    public void setCockQtyPerday(java.math.BigDecimal item)
    {
        setBigDecimal("cockQtyPerday", item);
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
     * Object:饲喂计划's 公禽平均体重（g）property 
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
     * Object:饲喂计划's 周龄至property 
     */
    public int getEndWeek()
    {
        return getInt("endWeek");
    }
    public void setEndWeek(int item)
    {
        setInt("endWeek", item);
    }
    /**
     * Object:饲喂计划's 日龄至property 
     */
    public int getEndDays()
    {
        return getInt("endDays");
    }
    public void setEndDays(int item)
    {
        setInt("endDays", item);
    }
    /**
     * Object:饲喂计划's 母禽成活率%property 
     */
    public java.math.BigDecimal getFemaleLivability()
    {
        return getBigDecimal("femaleLivability");
    }
    public void setFemaleLivability(java.math.BigDecimal item)
    {
        setBigDecimal("femaleLivability", item);
    }
    /**
     * Object:饲喂计划's 母禽周累计死淘率%property 
     */
    public java.math.BigDecimal getFemaleTotalWeekDCRate()
    {
        return getBigDecimal("femaleTotalWeekDCRate");
    }
    public void setFemaleTotalWeekDCRate(java.math.BigDecimal item)
    {
        setBigDecimal("femaleTotalWeekDCRate", item);
    }
    /**
     * Object:饲喂计划's 母禽周平均死淘率%property 
     */
    public java.math.BigDecimal getFemalePerWeekDCRate()
    {
        return getBigDecimal("femalePerWeekDCRate");
    }
    public void setFemalePerWeekDCRate(java.math.BigDecimal item)
    {
        setBigDecimal("femalePerWeekDCRate", item);
    }
    /**
     * Object:饲喂计划's 公禽周平均死淘率%property 
     */
    public java.math.BigDecimal getPerWeekDCRate()
    {
        return getBigDecimal("perWeekDCRate");
    }
    public void setPerWeekDCRate(java.math.BigDecimal item)
    {
        setBigDecimal("perWeekDCRate", item);
    }
    /**
     * Object:饲喂计划's 公禽周累计死淘率%property 
     */
    public java.math.BigDecimal getTotalWeekDCRate()
    {
        return getBigDecimal("totalWeekDCRate");
    }
    public void setTotalWeekDCRate(java.math.BigDecimal item)
    {
        setBigDecimal("totalWeekDCRate", item);
    }
    /**
     * Object:饲喂计划's 公禽成活率%property 
     */
    public java.math.BigDecimal getLivability()
    {
        return getBigDecimal("livability");
    }
    public void setLivability(java.math.BigDecimal item)
    {
        setBigDecimal("livability", item);
    }
    /**
     * Object:饲喂计划's 母禽平均体重（g）property 
     */
    public java.math.BigDecimal getFemaleStandardWgt()
    {
        return getBigDecimal("femaleStandardWgt");
    }
    public void setFemaleStandardWgt(java.math.BigDecimal item)
    {
        setBigDecimal("femaleStandardWgt", item);
    }
    /**
     * Object:饲喂计划's 母鸡只累计耗料(千克)property 
     */
    public java.math.BigDecimal getFemaleTotalFeedCost()
    {
        return getBigDecimal("femaleTotalFeedCost");
    }
    public void setFemaleTotalFeedCost(java.math.BigDecimal item)
    {
        setBigDecimal("femaleTotalFeedCost", item);
    }
    /**
     * Object:饲喂计划's 入舍鸡周累计耗料(千克)property 
     */
    public java.math.BigDecimal getAllTotalFeedCost()
    {
        return getBigDecimal("allTotalFeedCost");
    }
    public void setAllTotalFeedCost(java.math.BigDecimal item)
    {
        setBigDecimal("allTotalFeedCost", item);
    }
    /**
     * Object:饲喂计划's 母鸡最小体重(kg)property 
     */
    public java.math.BigDecimal getFemaleWgtMin()
    {
        return getBigDecimal("FemaleWgtMin");
    }
    public void setFemaleWgtMin(java.math.BigDecimal item)
    {
        setBigDecimal("FemaleWgtMin", item);
    }
    /**
     * Object:饲喂计划's 母鸡最大体重(kg)property 
     */
    public java.math.BigDecimal getFemaleWgtMax()
    {
        return getBigDecimal("FemaleWgtMax");
    }
    public void setFemaleWgtMax(java.math.BigDecimal item)
    {
        setBigDecimal("FemaleWgtMax", item);
    }
    /**
     * Object:饲喂计划's 均匀度%property 
     */
    public java.math.BigDecimal getUniformRate()
    {
        return getBigDecimal("uniformRate");
    }
    public void setUniformRate(java.math.BigDecimal item)
    {
        setBigDecimal("uniformRate", item);
    }
    /**
     * Object:饲喂计划's 公鸡只累计耗料property 
     */
    public java.math.BigDecimal getTotalFeedCost()
    {
        return getBigDecimal("totalFeedCost");
    }
    public void setTotalFeedCost(java.math.BigDecimal item)
    {
        setBigDecimal("totalFeedCost", item);
    }
    /**
     * Object:饲喂计划's 母失重(g)property 
     */
    public java.math.BigDecimal getFemaleLossWeight()
    {
        return getBigDecimal("femaleLossWeight");
    }
    public void setFemaleLossWeight(java.math.BigDecimal item)
    {
        setBigDecimal("femaleLossWeight", item);
    }
    /**
     * Object:饲喂计划's 母失重率(%)property 
     */
    public java.math.BigDecimal getFemaleLossRate()
    {
        return getBigDecimal("femaleLossRate");
    }
    public void setFemaleLossRate(java.math.BigDecimal item)
    {
        setBigDecimal("femaleLossRate", item);
    }
    /**
     * Object:饲喂计划's 公失重property 
     */
    public java.math.BigDecimal getMaleLossWeight()
    {
        return getBigDecimal("maleLossWeight");
    }
    public void setMaleLossWeight(java.math.BigDecimal item)
    {
        setBigDecimal("maleLossWeight", item);
    }
    /**
     * Object:饲喂计划's 公失重率(%)property 
     */
    public java.math.BigDecimal getMaleLossRate()
    {
        return getBigDecimal("maleLossRate");
    }
    public void setMaleLossRate(java.math.BigDecimal item)
    {
        setBigDecimal("maleLossRate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4A2FA3B2");
    }
}