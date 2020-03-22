package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingDailyEnviInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingDailyEnviInfo()
    {
        this("id");
    }
    protected AbstractStockingDailyEnviInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���ط�¼ 's null property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FF4F0945");
    }
}