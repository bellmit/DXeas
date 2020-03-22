package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractParentEggDailyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractParentEggDailyEntryInfo()
    {
        this("id");
    }
    protected AbstractParentEggDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 饲喂信息分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.layegg.ParentEggDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:饲喂信息分录's 饮水量property 
     */
    public java.math.BigDecimal getWaterQty()
    {
        return getBigDecimal("waterQty");
    }
    public void setWaterQty(java.math.BigDecimal item)
    {
        setBigDecimal("waterQty", item);
    }
    /**
     * Object: 饲喂信息分录 's 禽舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenhouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henhouse");
    }
    public void setHenhouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henhouse", item);
    }
    /**
     * Object:饲喂信息分录's 禽舍名称property 
     */
    public String getHenhouseName()
    {
        return getString("henhouseName");
    }
    public void setHenhouseName(String item)
    {
        setString("henhouseName", item);
    }
    /**
     * Object:饲喂信息分录's 当天起始存栏量property 
     */
    public int getInitQty()
    {
        return getInt("initQty");
    }
    public void setInitQty(int item)
    {
        setInt("initQty", item);
    }
    /**
     * Object: 饲喂信息分录 's 饲料 property 
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
     * Object:饲喂信息分录's 标准耗料property 
     */
    public java.math.BigDecimal getStandardQty()
    {
        return getBigDecimal("standardQty");
    }
    public void setStandardQty(java.math.BigDecimal item)
    {
        setBigDecimal("standardQty", item);
    }
    /**
     * Object:饲喂信息分录's 实际耗料property 
     */
    public java.math.BigDecimal getActualQty()
    {
        return getBigDecimal("actualQty");
    }
    public void setActualQty(java.math.BigDecimal item)
    {
        setBigDecimal("actualQty", item);
    }
    /**
     * Object:饲喂信息分录's 计量单位property 
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
     * Object:饲喂信息分录's 死亡数量property 
     */
    public int getDeathQty()
    {
        return getInt("deathQty");
    }
    public void setDeathQty(int item)
    {
        setInt("deathQty", item);
    }
    /**
     * Object:饲喂信息分录's 淘汰数量property 
     */
    public int getDropQty()
    {
        return getInt("dropQty");
    }
    public void setDropQty(int item)
    {
        setInt("dropQty", item);
    }
    /**
     * Object:饲喂信息分录's 产蛋数property 
     */
    public int getEggQty()
    {
        return getInt("eggQty");
    }
    public void setEggQty(int item)
    {
        setInt("eggQty", item);
    }
    /**
     * Object:饲喂信息分录's 水表起始计数property 
     */
    public java.math.BigDecimal getWaterBegin()
    {
        return getBigDecimal("waterBegin");
    }
    public void setWaterBegin(java.math.BigDecimal item)
    {
        setBigDecimal("waterBegin", item);
    }
    /**
     * Object:饲喂信息分录's 水表截止计数property 
     */
    public java.math.BigDecimal getWaterEndQty()
    {
        return getBigDecimal("waterEndQty");
    }
    public void setWaterEndQty(java.math.BigDecimal item)
    {
        setBigDecimal("waterEndQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DB066D87");
    }
}