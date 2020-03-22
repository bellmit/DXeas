package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSzCountPositionSetMaterialEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSzCountPositionSetMaterialEntryInfo()
    {
        this("id");
    }
    protected AbstractSzCountPositionSetMaterialEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 产品列表 's null property 
     */
    public com.kingdee.eas.custom.szcount.SzCountPositionSetInfo getParent()
    {
        return (com.kingdee.eas.custom.szcount.SzCountPositionSetInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.szcount.SzCountPositionSetInfo item)
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
     * Object:产品列表's 基本计量单位property 
     */
    public String getBaseUnit()
    {
        return getString("baseUnit");
    }
    public void setBaseUnit(String item)
    {
        setString("baseUnit", item);
    }
    /**
     * Object:产品列表's 库存计量单位property 
     */
    public String getInventoryUnit()
    {
        return getString("inventoryUnit");
    }
    public void setInventoryUnit(String item)
    {
        setString("inventoryUnit", item);
    }
    /**
     * Object:产品列表's 产品编码property 
     */
    public String getMaterialNum()
    {
        return getString("materialNum");
    }
    public void setMaterialNum(String item)
    {
        setString("materialNum", item);
    }
    /**
     * Object:产品列表's 是否参与计数property 
     */
    public boolean isIsCount()
    {
        return getBoolean("isCount");
    }
    public void setIsCount(boolean item)
    {
        setBoolean("isCount", item);
    }
    /**
     * Object:产品列表's 类别property 
     */
    public String getMaterialGroup()
    {
        return getString("materialGroup");
    }
    public void setMaterialGroup(String item)
    {
        setString("materialGroup", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4E23C5CF");
    }
}