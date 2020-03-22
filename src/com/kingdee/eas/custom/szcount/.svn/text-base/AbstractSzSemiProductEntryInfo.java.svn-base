package com.kingdee.eas.custom.szcount;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSzSemiProductEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSzSemiProductEntryInfo()
    {
        this("id");
    }
    protected AbstractSzSemiProductEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.szcount.SzSemiProductInfo getParent()
    {
        return (com.kingdee.eas.custom.szcount.SzSemiProductInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.szcount.SzSemiProductInfo item)
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
     * Object:分录's 基本数量property 
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
     * Object:分录's 成品分类property 
     */
    public String getFinishedProductType()
    {
        return getString("finishedProductType");
    }
    public void setFinishedProductType(String item)
    {
        setString("finishedProductType", item);
    }
    /**
     * Object:分录's 计量单位property 
     */
    public String getMeasureUnit()
    {
        return getString("measureUnit");
    }
    public void setMeasureUnit(String item)
    {
        setString("measureUnit", item);
    }
    /**
     * Object: 分录 's 仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getWareHouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("wareHouse");
    }
    public void setWareHouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("wareHouse", item);
    }
    /**
     * Object:分录's 计数数量property 
     */
    public String getCountNumber()
    {
        return getString("countNumber");
    }
    public void setCountNumber(String item)
    {
        setString("countNumber", item);
    }
    /**
     * Object: 分录 's 成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("CostObject");
    }
    public void setCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("CostObject", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("84568C83");
    }
}