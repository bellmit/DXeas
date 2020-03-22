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
     * Object: ��ι�ƻ� 's null property 
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
     * Object: ��ι�ƻ� 's ���� property 
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
     * Object:��ι�ƻ�'s ��ι������g/ͷ��property 
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
     * Object:��ι�ƻ�'s ��׼��ˮ��property 
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
     * Object:��ι�ƻ�'s ��ʳʱ��property 
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
     * Object:��ι�ƻ�'s ����ʱ����h��property 
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
     * Object:��ι�ƻ�'s ����¶ȣ��棩property 
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
     * Object:��ι�ƻ�'s ����¶ȣ��棩property 
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
     * Object:��ι�ƻ�'s ���ʪ�ȣ�%��property 
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
     * Object:��ι�ƻ�'s ���ʪ�ȣ�%��property 
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
     * Object:��ι�ƻ�'s ����property 
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
     * Object:��ι�ƻ�'s ��׼ֻ�أ�kg��property 
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
     * Object:��ι�ƻ�'s ���أ�g��property 
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
     * Object:��ι�ƻ�'s �ձ�׼�����ʣ�%��property 
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
     * Object:��ι�ƻ�'s ��עproperty 
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
     * Object:��ι�ƻ�'s ע������property 
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