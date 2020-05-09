package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmPollingBillInventoryEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmPollingBillInventoryEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmPollingBillInventoryEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 库存分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.feedbiz.FarmPollingBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 库存分录 's 物料编码 property 
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
     * Object:库存分录's 物料名称property 
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
     * Object:库存分录's 规格property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object: 库存分录 's 计量单位 property 
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
     * Object:库存分录's 包数property 
     */
    public java.math.BigDecimal getBagQty()
    {
        return getBigDecimal("bagQty");
    }
    public void setBagQty(java.math.BigDecimal item)
    {
        setBigDecimal("bagQty", item);
    }
    /**
     * Object:库存分录's 单包重property 
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
     * Object:库存分录's 数量property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object:库存分录's 当日使用包数property 
     */
    public java.math.BigDecimal getDailyUsgBags()
    {
        return getBigDecimal("dailyUsgBags");
    }
    public void setDailyUsgBags(java.math.BigDecimal item)
    {
        setBigDecimal("dailyUsgBags", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("583A8606");
    }
}