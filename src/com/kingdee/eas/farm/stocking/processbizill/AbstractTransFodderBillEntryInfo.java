package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTransFodderBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTransFodderBillEntryInfo()
    {
        this("id");
    }
    protected AbstractTransFodderBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.TransFodderBillInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.TransFodderBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.TransFodderBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 饲料编码 property 
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
     * Object:分录's 饲料名称property 
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
     * Object: 分录 's 目标养殖户 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getOrderFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("orderFarmer");
    }
    public void setOrderFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("orderFarmer", item);
    }
    /**
     * Object: 分录 's 目标养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getOrderFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("orderFarm");
    }
    public void setOrderFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("orderFarm", item);
    }
    /**
     * Object: 分录 's 目标批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getOrderStockingBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("orderStockingBatch");
    }
    public void setOrderStockingBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("orderStockingBatch", item);
    }
    /**
     * Object:分录's 转料数量property 
     */
    public java.math.BigDecimal getTransQty()
    {
        return getBigDecimal("transQty");
    }
    public void setTransQty(java.math.BigDecimal item)
    {
        setBigDecimal("transQty", item);
    }
    /**
     * Object: 分录 's 目标仓库 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getOrderWarehouse()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("orderWarehouse");
    }
    public void setOrderWarehouse(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("orderWarehouse", item);
    }
    /**
     * Object:分录's 目标领用价格property 
     */
    public java.math.BigDecimal getOrderReceivePrice()
    {
        return getBigDecimal("orderReceivePrice");
    }
    public void setOrderReceivePrice(java.math.BigDecimal item)
    {
        setBigDecimal("orderReceivePrice", item);
    }
    /**
     * Object:分录's 转出金额property 
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
    /**
     * Object:分录's 目标领用金额property 
     */
    public java.math.BigDecimal getOrderAmount()
    {
        return getBigDecimal("orderAmount");
    }
    public void setOrderAmount(java.math.BigDecimal item)
    {
        setBigDecimal("orderAmount", item);
    }
    /**
     * Object:分录's 目标基础价格property 
     */
    public java.math.BigDecimal getOrderBasePrice()
    {
        return getBigDecimal("orderBasePrice");
    }
    public void setOrderBasePrice(java.math.BigDecimal item)
    {
        setBigDecimal("orderBasePrice", item);
    }
    /**
     * Object: 分录 's 计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("unit");
    }
    public void setUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("unit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4A9502F2");
    }
}