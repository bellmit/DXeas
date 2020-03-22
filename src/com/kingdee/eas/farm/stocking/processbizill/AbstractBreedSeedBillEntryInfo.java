package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBreedSeedBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBreedSeedBillEntryInfo()
    {
        this("id");
    }
    protected AbstractBreedSeedBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.BreedSeedBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 合同数量property 
     */
    public java.math.BigDecimal getReceiveQty()
    {
        return getBigDecimal("receiveQty");
    }
    public void setReceiveQty(java.math.BigDecimal item)
    {
        setBigDecimal("receiveQty", item);
    }
    /**
     * Object:分录's 领用单价property 
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
     * Object:分录's 基础单价property 
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
     * Object: 分录 's 种苗编码 property 
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
     * Object:分录's 种苗名称property 
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
     * Object:分录's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:分录's 另补数量property 
     */
    public java.math.BigDecimal getSupplementQty()
    {
        return getBigDecimal("supplementQty");
    }
    public void setSupplementQty(java.math.BigDecimal item)
    {
        setBigDecimal("supplementQty", item);
    }
    /**
     * Object:分录's 路损数量property 
     */
    public java.math.BigDecimal getLossQty()
    {
        return getBigDecimal("lossQty");
    }
    public void setLossQty(java.math.BigDecimal item)
    {
        setBigDecimal("lossQty", item);
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
     * Object:分录's 母禽数量property 
     */
    public java.math.BigDecimal getHenQty()
    {
        return getBigDecimal("henQty");
    }
    public void setHenQty(java.math.BigDecimal item)
    {
        setBigDecimal("henQty", item);
    }
    /**
     * Object:分录's 公禽数量property 
     */
    public java.math.BigDecimal getCockQty()
    {
        return getBigDecimal("cockQty");
    }
    public void setCockQty(java.math.BigDecimal item)
    {
        setBigDecimal("cockQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0676404B");
    }
}