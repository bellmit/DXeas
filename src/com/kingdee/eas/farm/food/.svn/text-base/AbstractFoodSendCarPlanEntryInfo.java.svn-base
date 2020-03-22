package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFoodSendCarPlanEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFoodSendCarPlanEntryInfo()
    {
        this("id");
    }
    protected AbstractFoodSendCarPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.food.FoodSendCarPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.food.FoodSendCarPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.FoodSendCarPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 车辆序号property 
     */
    public String getCarNo()
    {
        return getString("carNo");
    }
    public void setCarNo(String item)
    {
        setString("carNo", item);
    }
    /**
     * Object:分录's 出车时间property 
     */
    public java.sql.Time getStartTime()
    {
        return getTime("startTime");
    }
    public void setStartTime(java.sql.Time item)
    {
        setTime("startTime", item);
    }
    /**
     * Object:分录's 到鸡场时间property 
     */
    public java.sql.Time getReachTime()
    {
        return getTime("reachTime");
    }
    public void setReachTime(java.sql.Time item)
    {
        setTime("reachTime", item);
    }
    /**
     * Object:分录's 出鸡场时间property 
     */
    public java.sql.Time getOutTime()
    {
        return getTime("outTime");
    }
    public void setOutTime(java.sql.Time item)
    {
        setTime("outTime", item);
    }
    /**
     * Object:分录's 到食品厂时间property 
     */
    public java.sql.Time getBackTime()
    {
        return getTime("backTime");
    }
    public void setBackTime(java.sql.Time item)
    {
        setTime("backTime", item);
    }
    /**
     * Object:分录's 再次出发时间property 
     */
    public java.sql.Time getReStartTime()
    {
        return getTime("reStartTime");
    }
    public void setReStartTime(java.sql.Time item)
    {
        setTime("reStartTime", item);
    }
    /**
     * Object:分录's 存放毛鸡车数property 
     */
    public java.math.BigDecimal getCarCount()
    {
        return getBigDecimal("carCount");
    }
    public void setCarCount(java.math.BigDecimal item)
    {
        setBigDecimal("carCount", item);
    }
    /**
     * Object: 分录 's 商品鸡场 property 
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
     * Object:分录's 开始抓鸡时间property 
     */
    public java.sql.Time getBeginCatchTime()
    {
        return getTime("beginCatchTime");
    }
    public void setBeginCatchTime(java.sql.Time item)
    {
        setTime("beginCatchTime", item);
    }
    /**
     * Object:分录's 挂鸡时间property 
     */
    public java.sql.Time getHitchTime()
    {
        return getTime("hitchTime");
    }
    public void setHitchTime(java.sql.Time item)
    {
        setTime("hitchTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("824D9D25");
    }
}