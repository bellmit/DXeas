package com.kingdee.eas.custom.stockprice;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRealTimeInventoryEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractRealTimeInventoryEntryInfo()
    {
        this("id");
    }
    protected AbstractRealTimeInventoryEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.stockprice.RealTimeInventoryInfo getParent()
    {
        return (com.kingdee.eas.custom.stockprice.RealTimeInventoryInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.stockprice.RealTimeInventoryInfo item)
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
     * Object:分录's 物料编码property 
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
     * Object:分录's 规格型号property 
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
     * Object:分录's 批次property 
     */
    public String getFlot()
    {
        return getString("flot");
    }
    public void setFlot(String item)
    {
        setString("flot", item);
    }
    /**
     * Object: 分录 's 库存组织 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStorageOrgUnit()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("storageOrgUnit");
    }
    public void setStorageOrgUnit(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("storageOrgUnit", item);
    }
    /**
     * Object: 分录 's 库位 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.LocationInfo getLocation()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.LocationInfo)get("location");
    }
    public void setLocation(com.kingdee.eas.basedata.scm.im.inv.LocationInfo item)
    {
        put("location", item);
    }
    /**
     * Object: 分录 's 存放仓库 property 
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
     * Object: 分录 's 基本计量单位 property 
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
     * Object:分录's 数量property 
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
     * Object: 分录 's 供应商 property 
     */
    public com.kingdee.eas.basedata.master.cssp.SupplierInfo getSupplier()
    {
        return (com.kingdee.eas.basedata.master.cssp.SupplierInfo)get("supplier");
    }
    public void setSupplier(com.kingdee.eas.basedata.master.cssp.SupplierInfo item)
    {
        put("supplier", item);
    }
    /**
     * Object: 分录 's 客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object: 分录 's 库存类型 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.StoreTypeInfo getStoreType()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.StoreTypeInfo)get("storeType");
    }
    public void setStoreType(com.kingdee.eas.basedata.scm.im.inv.StoreTypeInfo item)
    {
        put("storeType", item);
    }
    /**
     * Object: 分录 's 库存状态 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.StoreStateInfo getStoreState()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.StoreStateInfo)get("storeState");
    }
    public void setStoreState(com.kingdee.eas.basedata.scm.im.inv.StoreStateInfo item)
    {
        put("storeState", item);
    }
    /**
     * Object:分录's 生产日期property 
     */
    public java.util.Date getProductionDate()
    {
        return getDate("productionDate");
    }
    public void setProductionDate(java.util.Date item)
    {
        setDate("productionDate", item);
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
    /**
     * Object:分录's 基本数量property 
     */
    public java.math.BigDecimal getBaseQty()
    {
        return getBigDecimal("baseQty");
    }
    public void setBaseQty(java.math.BigDecimal item)
    {
        setBigDecimal("baseQty", item);
    }
    /**
     * Object:分录's 到期日期property 
     */
    public java.util.Date getExp()
    {
        return getDate("exp");
    }
    public void setExp(java.util.Date item)
    {
        setDate("exp", item);
    }
    /**
     * Object:分录's 可用数量property 
     */
    public java.math.BigDecimal getAvailableQty()
    {
        return getBigDecimal("availableQty");
    }
    public void setAvailableQty(java.math.BigDecimal item)
    {
        setBigDecimal("availableQty", item);
    }
    /**
     * Object:分录's 可用基本数量property 
     */
    public java.math.BigDecimal getAvailableBaseQty()
    {
        return getBigDecimal("availableBaseQty");
    }
    public void setAvailableBaseQty(java.math.BigDecimal item)
    {
        setBigDecimal("availableBaseQty", item);
    }
    /**
     * Object: 分录 's 辅助计量单位 property 
     */
    public com.kingdee.eas.basedata.assistant.MeasureUnitInfo getAssistUnit()
    {
        return (com.kingdee.eas.basedata.assistant.MeasureUnitInfo)get("assistUnit");
    }
    public void setAssistUnit(com.kingdee.eas.basedata.assistant.MeasureUnitInfo item)
    {
        put("assistUnit", item);
    }
    /**
     * Object:分录's 辅助数量property 
     */
    public java.math.BigDecimal getAssistQty()
    {
        return getBigDecimal("assistQty");
    }
    public void setAssistQty(java.math.BigDecimal item)
    {
        setBigDecimal("assistQty", item);
    }
    /**
     * Object:分录's 可用辅助数量property 
     */
    public java.math.BigDecimal getAvailableAssistQty()
    {
        return getBigDecimal("availableAssistQty");
    }
    public void setAvailableAssistQty(java.math.BigDecimal item)
    {
        setBigDecimal("availableAssistQty", item);
    }
    /**
     * Object: 分录 's 跟踪号 property 
     */
    public com.kingdee.eas.mm.basedata.TrackNumberInfo getTrackNumber()
    {
        return (com.kingdee.eas.mm.basedata.TrackNumberInfo)get("trackNumber");
    }
    public void setTrackNumber(com.kingdee.eas.mm.basedata.TrackNumberInfo item)
    {
        put("trackNumber", item);
    }
    /**
     * Object:分录's 预留数量property 
     */
    public java.math.BigDecimal getReservedQty()
    {
        return getBigDecimal("reservedQty");
    }
    public void setReservedQty(java.math.BigDecimal item)
    {
        setBigDecimal("reservedQty", item);
    }
    /**
     * Object:分录's 预留基本数量property 
     */
    public java.math.BigDecimal getReservedBaseQty()
    {
        return getBigDecimal("reservedBaseQty");
    }
    public void setReservedBaseQty(java.math.BigDecimal item)
    {
        setBigDecimal("reservedBaseQty", item);
    }
    /**
     * Object:分录's 预留可用数量property 
     */
    public java.math.BigDecimal getReservedAvaliableQty()
    {
        return getBigDecimal("reservedAvaliableQty");
    }
    public void setReservedAvaliableQty(java.math.BigDecimal item)
    {
        setBigDecimal("reservedAvaliableQty", item);
    }
    /**
     * Object: 分录 's 项目号 property 
     */
    public com.kingdee.eas.mm.project.ProjectInfo getProject()
    {
        return (com.kingdee.eas.mm.project.ProjectInfo)get("project");
    }
    public void setProject(com.kingdee.eas.mm.project.ProjectInfo item)
    {
        put("project", item);
    }
    /**
     * Object: 分录 's 辅助属性 property 
     */
    public com.kingdee.eas.basedata.master.material.AsstAttrValueInfo getAssistProperty()
    {
        return (com.kingdee.eas.basedata.master.material.AsstAttrValueInfo)get("assistProperty");
    }
    public void setAssistProperty(com.kingdee.eas.basedata.master.material.AsstAttrValueInfo item)
    {
        put("assistProperty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6EAC3B51");
    }
}