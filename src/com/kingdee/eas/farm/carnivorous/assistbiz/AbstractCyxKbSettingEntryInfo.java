package com.kingdee.eas.farm.carnivorous.assistbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCyxKbSettingEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCyxKbSettingEntryInfo()
    {
        this("id");
    }
    protected AbstractCyxKbSettingEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.assistbiz.CyxKbSettingInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.assistbiz.CyxKbSettingInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.assistbiz.CyxKbSettingInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ��ʼֵproperty 
     */
    public java.math.BigDecimal getMinValue()
    {
        return getBigDecimal("minValue");
    }
    public void setMinValue(java.math.BigDecimal item)
    {
        setBigDecimal("minValue", item);
    }
    /**
     * Object:��¼'s ��ֵֹproperty 
     */
    public java.math.BigDecimal getMaxValue()
    {
        return getBigDecimal("maxValue");
    }
    public void setMaxValue(java.math.BigDecimal item)
    {
        setBigDecimal("maxValue", item);
    }
    /**
     * Object:��¼'s �۲����property 
     */
    public java.math.BigDecimal getKbAmount()
    {
        return getBigDecimal("kbAmount");
    }
    public void setKbAmount(java.math.BigDecimal item)
    {
        setBigDecimal("kbAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EAB1758C");
    }
}