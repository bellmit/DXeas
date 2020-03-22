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
     * Object: ���ط�¼ 's null property 
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
     * Object: ���ط�¼ 's ���� property 
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
     * Object:���ط�¼'s ��ʳʱ��property 
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
     * Object:���ط�¼'s ����ʱ��property 
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
     * Object:���ط�¼'s ����¶�property 
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
     * Object:���ط�¼'s ����¶�property 
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
     * Object:���ط�¼'s ���ʪ��property 
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
     * Object:���ط�¼'s ���ʪ��property 
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
     * Object:���ط�¼'s ����ǿ��property 
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
     * Object:���ط�¼'s ��עproperty 
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
     * Object:���ط�¼'s ҹ��ʱ��property 
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