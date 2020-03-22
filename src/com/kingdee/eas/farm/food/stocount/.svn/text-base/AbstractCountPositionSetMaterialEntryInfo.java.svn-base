package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCountPositionSetMaterialEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCountPositionSetMaterialEntryInfo()
    {
        this("id");
    }
    protected AbstractCountPositionSetMaterialEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 产品列表 's null property 
     */
    public com.kingdee.eas.farm.food.stocount.CountPositionSetInfo getParent()
    {
        return (com.kingdee.eas.farm.food.stocount.CountPositionSetInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.stocount.CountPositionSetInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 产品列表 's 产品 property 
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
     * Object: 产品列表 's 基本计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getBaseUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("baseUnit");
    }
    public void setBaseUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("baseUnit", item);
    }
    /**
     * Object:产品列表's 默认数量property 
     */
    public java.math.BigDecimal getDefaultQty()
    {
        return getBigDecimal("defaultQty");
    }
    public void setDefaultQty(java.math.BigDecimal item)
    {
        setBigDecimal("defaultQty", item);
    }
    /**
     * Object:产品列表's 规格型号property 
     */
    public String getMaterialtype()
    {
        return getString("materialtype");
    }
    public void setMaterialtype(String item)
    {
        setString("materialtype", item);
    }
    /**
     * Object: 产品列表 's 库存计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getInventoryUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("inventoryUnit");
    }
    public void setInventoryUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("inventoryUnit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B10A2024");
    }
}