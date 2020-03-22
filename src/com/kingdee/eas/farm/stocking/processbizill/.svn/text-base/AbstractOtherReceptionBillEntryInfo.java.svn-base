package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOtherReceptionBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractOtherReceptionBillEntryInfo()
    {
        this("id");
    }
    protected AbstractOtherReceptionBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.OtherReceptionBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.OtherReceptionBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.OtherReceptionBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 物料编码 property 
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
     * Object:分录's 物料名称property 
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
     * Object:分录's 领用数量property 
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
     * Object:分录's 领用价格property 
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
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AD12F4C7");
    }
}