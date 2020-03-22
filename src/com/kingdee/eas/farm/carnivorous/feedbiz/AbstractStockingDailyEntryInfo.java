package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingDailyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStockingDailyEntryInfo()
    {
        this("id");
    }
    protected AbstractStockingDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��ι��Ϣ��¼ 's ����ͷ property 
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
     * Object: ��ι��Ϣ��¼ 's ���� property 
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
     * Object:��ι��Ϣ��¼'s ��������property 
     */
    public String getMaterialName()
    {
        return getString("materialName");
    }
    public void setMaterialName(String item)
    {
        setString("materialName", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ��ι������kg��property 
     */
    public java.math.BigDecimal getDailyQtyAll()
    {
        return getBigDecimal("dailyQtyAll");
    }
    public void setDailyQtyAll(java.math.BigDecimal item)
    {
        setBigDecimal("dailyQtyAll", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ��ˮ��property 
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
     * Object:��ι��Ϣ��¼'s ���Ƿ�ʽproperty 
     */
    public String getLimitFeedType()
    {
        return getString("limitFeedType");
    }
    public void setLimitFeedType(String item)
    {
        setString("limitFeedType", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ���property 
     */
    public String getMaterialModel()
    {
        return getString("materialModel");
    }
    public void setMaterialModel(String item)
    {
        setString("materialModel", item);
    }
    /**
     * Object: ��ι��Ϣ��¼ 's ��λ property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ������property 
     */
    public java.math.BigDecimal getUnitQty()
    {
        return getBigDecimal("unitQty");
    }
    public void setUnitQty(java.math.BigDecimal item)
    {
        setBigDecimal("unitQty", item);
    }
    /**
     * Object:��ι��Ϣ��¼'s ����property 
     */
    public java.math.BigDecimal getBagQty()
    {
        return getBigDecimal("bagQty");
    }
    public void setBagQty(java.math.BigDecimal item)
    {
        setBigDecimal("bagQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("EA921969");
    }
}