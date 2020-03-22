package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggDailyFodderEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLayEggDailyFodderEntryInfo()
    {
        this("id");
    }
    protected AbstractLayEggDailyFodderEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 要料计划 's null property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.layegg.LayEggDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 要料计划 's 料塔 property 
     */
    public com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo getFodderTower()
    {
        return (com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo)get("fodderTower");
    }
    public void setFodderTower(com.kingdee.eas.basedata.scm.im.inv.WarehouseInfo item)
    {
        put("fodderTower", item);
    }
    /**
     * Object: 要料计划 's 饲料 property 
     */
    public com.kingdee.eas.basedata.master.material.MaterialInfo getFodderMaterial()
    {
        return (com.kingdee.eas.basedata.master.material.MaterialInfo)get("fodderMaterial");
    }
    public void setFodderMaterial(com.kingdee.eas.basedata.master.material.MaterialInfo item)
    {
        put("fodderMaterial", item);
    }
    /**
     * Object:要料计划's 饲料名称property 
     */
    public String getFodderMaterialName()
    {
        return getString("fodderMaterialName");
    }
    public void setFodderMaterialName(String item)
    {
        setString("fodderMaterialName", item);
    }
    /**
     * Object:要料计划's 规格property 
     */
    public String getFodderMaterialModel()
    {
        return getString("fodderMaterialModel");
    }
    public void setFodderMaterialModel(String item)
    {
        setString("fodderMaterialModel", item);
    }
    /**
     * Object:要料计划's 要料日期property 
     */
    public java.util.Date getFodderDate()
    {
        return getDate("fodderDate");
    }
    public void setFodderDate(java.util.Date item)
    {
        setDate("fodderDate", item);
    }
    /**
     * Object:要料计划's 数量(公斤)property 
     */
    public java.math.BigDecimal getFodderQty()
    {
        return getBigDecimal("fodderQty");
    }
    public void setFodderQty(java.math.BigDecimal item)
    {
        setBigDecimal("fodderQty", item);
    }
    /**
     * Object:要料计划's 备注property 
     */
    public String getFodderDesc()
    {
        return getString("fodderDesc");
    }
    public void setFodderDesc(String item)
    {
        setString("fodderDesc", item);
    }
    /**
     * Object:要料计划's 料塔名称property 
     */
    public String getFodderTowerName()
    {
        return getString("fodderTowerName");
    }
    public void setFodderTowerName(String item)
    {
        setString("fodderTowerName", item);
    }
    /**
     * Object:要料计划's 当前剩余库存(公斤)property 
     */
    public java.math.BigDecimal getTowerInventory()
    {
        return getBigDecimal("towerInventory");
    }
    public void setTowerInventory(java.math.BigDecimal item)
    {
        setBigDecimal("towerInventory", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0CD5E371");
    }
}