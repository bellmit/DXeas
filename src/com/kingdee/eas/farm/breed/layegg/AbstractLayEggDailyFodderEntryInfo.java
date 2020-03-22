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
     * Object: Ҫ�ϼƻ� 's null property 
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
     * Object: Ҫ�ϼƻ� 's ���� property 
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
     * Object: Ҫ�ϼƻ� 's ���� property 
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
     * Object:Ҫ�ϼƻ�'s ��������property 
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
     * Object:Ҫ�ϼƻ�'s ���property 
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
     * Object:Ҫ�ϼƻ�'s Ҫ������property 
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
     * Object:Ҫ�ϼƻ�'s ����(����)property 
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
     * Object:Ҫ�ϼƻ�'s ��עproperty 
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
     * Object:Ҫ�ϼƻ�'s ��������property 
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
     * Object:Ҫ�ϼƻ�'s ��ǰʣ����(����)property 
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