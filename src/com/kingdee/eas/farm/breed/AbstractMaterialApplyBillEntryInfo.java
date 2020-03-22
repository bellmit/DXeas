package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMaterialApplyBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMaterialApplyBillEntryInfo()
    {
        this("id");
    }
    protected AbstractMaterialApplyBillEntryInfo(String pkField)
    {
        super(pkField);
        put("HenhouseEntry", new com.kingdee.eas.farm.breed.MaterialApplyBillEntryHenhouseEntryCollection());
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.MaterialApplyBillInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.MaterialApplyBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.MaterialApplyBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
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
     * Object:分录's 计量单位property 
     */
    public String getUnit()
    {
        return getString("unit");
    }
    public void setUnit(String item)
    {
        setString("unit", item);
    }
    /**
     * Object:分录's 申请数量property 
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
     * Object:分录's 开始使用日期property 
     */
    public java.util.Date getUseDate()
    {
        return getDate("useDate");
    }
    public void setUseDate(java.util.Date item)
    {
        setDate("useDate", item);
    }
    /**
     * Object: 分录 's 鸡舍明细 property 
     */
    public com.kingdee.eas.farm.breed.MaterialApplyBillEntryHenhouseEntryCollection getHenhouseEntry()
    {
        return (com.kingdee.eas.farm.breed.MaterialApplyBillEntryHenhouseEntryCollection)get("HenhouseEntry");
    }
    /**
     * Object:分录's 使用天数property 
     */
    public int getUseDays()
    {
        return getInt("useDays");
    }
    public void setUseDays(int item)
    {
        setInt("useDays", item);
    }
    /**
     * Object:分录's 残留天数property 
     */
    public int getResidueDays()
    {
        return getInt("residueDays");
    }
    public void setResidueDays(int item)
    {
        setInt("residueDays", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("034EB3BE");
    }
}