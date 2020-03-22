package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggRecycleEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractEggRecycleEntryInfo()
    {
        this("id");
    }
    protected AbstractEggRecycleEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.EggRecycleInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.EggRecycleInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.EggRecycleInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 蛋品编码 property 
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
     * Object:分录's 蛋品名称property 
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
     * Object:分录's 规格property 
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
     * Object: 分录 's 单位 property 
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
     * Object:分录's 数量property 
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
     * Object:分录's 受精率property 
     */
    public java.math.BigDecimal getErtilityRate()
    {
        return getBigDecimal("ertilityRate");
    }
    public void setErtilityRate(java.math.BigDecimal item)
    {
        setBigDecimal("ertilityRate", item);
    }
    /**
     * Object:分录's 基础价格property 
     */
    public java.math.BigDecimal getBasePrice()
    {
        return getBigDecimal("basePrice");
    }
    public void setBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("basePrice", item);
    }
    /**
     * Object:分录's 回收价格property 
     */
    public java.math.BigDecimal getReceivePrice()
    {
        return getBigDecimal("receivePrice");
    }
    public void setReceivePrice(java.math.BigDecimal item)
    {
        setBigDecimal("receivePrice", item);
    }
    /**
     * Object:分录's 回收金额property 
     */
    public java.math.BigDecimal getReceiveAmout()
    {
        return getBigDecimal("receiveAmout");
    }
    public void setReceiveAmout(java.math.BigDecimal item)
    {
        setBigDecimal("receiveAmout", item);
    }
    /**
     * Object: 分录 's 仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("warehouse");
    }
    public void setWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("warehouse", item);
    }
    /**
     * Object:分录's 重量property 
     */
    public java.math.BigDecimal getWeight()
    {
        return getBigDecimal("weight");
    }
    public void setWeight(java.math.BigDecimal item)
    {
        setBigDecimal("weight", item);
    }
    /**
     * Object:分录's 枚数property 
     */
    public java.math.BigDecimal getNumber()
    {
        return getBigDecimal("number");
    }
    public void setNumber(java.math.BigDecimal item)
    {
        setBigDecimal("number", item);
    }
    /**
     * Object:分录's 受精蛋数property 
     */
    public java.math.BigDecimal getErtilityQty()
    {
        return getBigDecimal("ertilityQty");
    }
    public void setErtilityQty(java.math.BigDecimal item)
    {
        setBigDecimal("ertilityQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0613343F");
    }
}