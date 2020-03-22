package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSeedBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSeedBillEntryInfo()
    {
        this("id");
    }
    protected AbstractSeedBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.SeedBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.SeedBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.SeedBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 领用仓库 property 
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
     * Object:分录's 确认数量property 
     */
    public java.math.BigDecimal getConfirmQty()
    {
        return getBigDecimal("confirmQty");
    }
    public void setConfirmQty(java.math.BigDecimal item)
    {
        setBigDecimal("confirmQty", item);
    }
    /**
     * Object: 分录 's 公禽苗编码 property 
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
     * Object:分录's 公禽苗名称property 
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
     * Object:分录's 公禽苗规格property 
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
     * Object: 分录 's 公禽苗单位 property 
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
     * Object:分录's 总领用数量property 
     */
    public java.math.BigDecimal getAllReceiveQty()
    {
        return getBigDecimal("allReceiveQty");
    }
    public void setAllReceiveQty(java.math.BigDecimal item)
    {
        setBigDecimal("allReceiveQty", item);
    }
    /**
     * Object: 分录 's 棚舍 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo getHouse()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo)get("house");
    }
    public void setHouse(com.kingdee.eas.farm.stocking.basedata.FarmHouseEntryInfo item)
    {
        put("house", item);
    }
    /**
     * Object:分录's 公禽苗数量property 
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
     * Object: 分录 's 母禽苗编码 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getFematerial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("fematerial");
    }
    public void setFematerial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("fematerial", item);
    }
    /**
     * Object:分录's 母禽苗名称property 
     */
    public String getFematerialName()
    {
        return getString("fematerialName");
    }
    public void setFematerialName(String item)
    {
        setString("fematerialName", item);
    }
    /**
     * Object:分录's 母禽苗规格property 
     */
    public String getFemodel()
    {
        return getString("femodel");
    }
    public void setFemodel(String item)
    {
        setString("femodel", item);
    }
    /**
     * Object: 分录 's 母禽苗单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getFeunit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("feunit");
    }
    public void setFeunit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("feunit", item);
    }
    /**
     * Object:分录's 母禽苗数量property 
     */
    public java.math.BigDecimal getFeqty()
    {
        return getBigDecimal("feqty");
    }
    public void setFeqty(java.math.BigDecimal item)
    {
        setBigDecimal("feqty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C0B191F5");
    }
}