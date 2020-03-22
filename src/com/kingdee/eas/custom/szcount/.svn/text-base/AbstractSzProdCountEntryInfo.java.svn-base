package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSzProdCountEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSzProdCountEntryInfo()
    {
        this("id");
    }
    protected AbstractSzProdCountEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.szcount.SzProdCountInfo getParent()
    {
        return (com.kingdee.eas.custom.szcount.SzProdCountInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.szcount.SzProdCountInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 物料 property 
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
     * Object:分录's 规格型号property 
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
     * Object:分录's 基本计量单位property 
     */
    public String getMbaseunit()
    {
        return getString("mbaseunit");
    }
    public void setMbaseunit(String item)
    {
        setString("mbaseunit", item);
    }
    /**
     * Object:分录's 生产日期property 
     */
    public java.util.Date getProductDate()
    {
        return getDate("productDate");
    }
    public void setProductDate(java.util.Date item)
    {
        setDate("productDate", item);
    }
    /**
     * Object:分录's 基本数量property 
     */
    public java.math.BigDecimal getMnumber()
    {
        return getBigDecimal("mnumber");
    }
    public void setMnumber(java.math.BigDecimal item)
    {
        setBigDecimal("mnumber", item);
    }
    /**
     * Object:分录's 批次property 
     */
    public String getBatch()
    {
        return getString("batch");
    }
    public void setBatch(String item)
    {
        setString("batch", item);
    }
    /**
     * Object:分录's 仓库号property 
     */
    public String getWarehouse()
    {
        return getString("warehouse");
    }
    public void setWarehouse(String item)
    {
        setString("warehouse", item);
    }
    /**
     * Object:分录's 物料编码property 
     */
    public String getMaterialnumber()
    {
        return getString("materialnumber");
    }
    public void setMaterialnumber(String item)
    {
        setString("materialnumber", item);
    }
    /**
     * Object: 分录 's 仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWarehouseF7()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("warehouseF7");
    }
    public void setWarehouseF7(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("warehouseF7", item);
    }
    /**
     * Object:分录's 规格单位property 
     */
    public java.math.BigDecimal getTypenumber()
    {
        return getBigDecimal("typenumber");
    }
    public void setTypenumber(java.math.BigDecimal item)
    {
        setBigDecimal("typenumber", item);
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
     * Object: 分录 's 成本对象名称 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostobject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("costobject");
    }
    public void setCostobject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("costobject", item);
    }
    /**
     * Object:分录's 成本对象编码property 
     */
    public String getCostobjectnumber()
    {
        return getString("costobjectnumber");
    }
    public void setCostobjectnumber(String item)
    {
        setString("costobjectnumber", item);
    }
    /**
     * Object: 分录 's 库存计量单位 property 
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
        return new BOSObjectType("DD72510C");
    }
}