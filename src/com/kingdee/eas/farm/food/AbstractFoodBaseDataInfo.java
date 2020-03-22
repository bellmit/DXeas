package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFoodBaseDataInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractFoodBaseDataInfo()
    {
        this("id");
    }
    protected AbstractFoodBaseDataInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:食品厂基础设置's 挂鸡时间（分钟/车）property 
     */
    public java.math.BigDecimal getHitchTime()
    {
        return getBigDecimal("hitchTime");
    }
    public void setHitchTime(java.math.BigDecimal item)
    {
        setBigDecimal("hitchTime", item);
    }
    /**
     * Object:食品厂基础设置's 抓鸡时间（分钟/车）property 
     */
    public java.math.BigDecimal getCatchTime()
    {
        return getBigDecimal("catchTime");
    }
    public void setCatchTime(java.math.BigDecimal item)
    {
        setBigDecimal("catchTime", item);
    }
    /**
     * Object:食品厂基础设置's 单筐只数property 
     */
    public java.math.BigDecimal getUnitQty()
    {
        return getBigDecimal("unitQty");
    }
    public void setUnitQty(java.math.BigDecimal item)
    {
        setBigDecimal("unitQty", item);
    }
    /**
     * Object: 食品厂基础设置 's 库存组织 property 
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
     * Object:食品厂基础设置's 每次派车数property 
     */
    public int getEveryCarCount()
    {
        return getInt("everyCarCount");
    }
    public void setEveryCarCount(int item)
    {
        setInt("everyCarCount", item);
    }
    /**
     * Object:食品厂基础设置's 每车筐数property 
     */
    public int getBasketQty()
    {
        return getInt("basketQty");
    }
    public void setBasketQty(int item)
    {
        setInt("basketQty", item);
    }
    /**
     * Object:食品厂基础设置's 毛鸡车装卸时间(分钟)property 
     */
    public java.math.BigDecimal getCarHandlingTime()
    {
        return getBigDecimal("carHandlingTime");
    }
    public void setCarHandlingTime(java.math.BigDecimal item)
    {
        setBigDecimal("carHandlingTime", item);
    }
    /**
     * Object:食品厂基础设置's 过磅时间（分钟/车）property 
     */
    public java.math.BigDecimal getWeghtTimeCost()
    {
        return getBigDecimal("weghtTimeCost");
    }
    public void setWeghtTimeCost(java.math.BigDecimal item)
    {
        setBigDecimal("weghtTimeCost", item);
    }
    /**
     * Object:食品厂基础设置's 开始挂鸡时间property 
     */
    public java.sql.Time getBeginHitchTime()
    {
        return getTime("beginHitchTime");
    }
    public void setBeginHitchTime(java.sql.Time item)
    {
        setTime("beginHitchTime", item);
    }
    /**
     * Object:食品厂基础设置's 抓鸡设备转运时间property 
     */
    public java.math.BigDecimal getTransDeviceTime()
    {
        return getBigDecimal("transDeviceTime");
    }
    public void setTransDeviceTime(java.math.BigDecimal item)
    {
        setBigDecimal("transDeviceTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D0187A43");
    }
}