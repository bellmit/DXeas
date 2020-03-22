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
     * Object: ��ֳ��Ϣ��¼ 's null property 
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
     * Object:��ֳ��Ϣ��¼'s ��ʳʱ��property 
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
     * Object:��ֳ��Ϣ��¼'s ����ʱ����h��property 
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
     * Object:��ֳ��Ϣ��¼'s ����¶ȣ��棩property 
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
     * Object:��ֳ��Ϣ��¼'s ����¶ȣ��棩property 
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
     * Object:��ֳ��Ϣ��¼'s ���ʪ�ȣ�%��property 
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
     * Object:��ֳ��Ϣ��¼'s ���ʪ�ȣ�%��property 
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
     * Object:��ֳ��Ϣ��¼'s ������property 
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
     * Object:��ֳ��Ϣ��¼'s ��̭��property 
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
     * Object:��ֳ��Ϣ��¼'s ������property 
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
     * Object:��ֳ��Ϣ��¼'s �Ƿ���ȫ����property 
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
     * Object:��ֳ��Ϣ��¼'s ƽ��ֻ��property 
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
     * Object:��ֳ��Ϣ��¼'s ������property 
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
     * Object:��ֳ��Ϣ��¼'s ����ֵproperty 
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