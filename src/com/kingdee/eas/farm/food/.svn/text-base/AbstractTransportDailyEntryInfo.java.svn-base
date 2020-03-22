package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTransportDailyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTransportDailyEntryInfo()
    {
        this("id");
    }
    protected AbstractTransportDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 运输明细 's null property 
     */
    public com.kingdee.eas.farm.food.TransportDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.food.TransportDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.TransportDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 运输明细 's 车辆 property 
     */
    public com.kingdee.eas.publicdata.CarInfo getCar()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("car");
    }
    public void setCar(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("car", item);
    }
    /**
     * Object:运输明细's 运输次数property 
     */
    public int getCount()
    {
        return getInt("count");
    }
    public void setCount(int item)
    {
        setInt("count", item);
    }
    /**
     * Object: 运输明细 's 路线 property 
     */
    public com.kingdee.eas.delivery.basedata.DeliveryLineInfo getDeliveryLine()
    {
        return (com.kingdee.eas.delivery.basedata.DeliveryLineInfo)get("DeliveryLine");
    }
    public void setDeliveryLine(com.kingdee.eas.delivery.basedata.DeliveryLineInfo item)
    {
        put("DeliveryLine", item);
    }
    /**
     * Object:运输明细's 出发地property 
     */
    public String getBeginStation()
    {
        return getString("beginStation");
    }
    public void setBeginStation(String item)
    {
        setString("beginStation", item);
    }
    /**
     * Object:运输明细's 目的地property 
     */
    public String getEndStation()
    {
        return getString("endStation");
    }
    public void setEndStation(String item)
    {
        setString("endStation", item);
    }
    /**
     * Object:运输明细's 里程property 
     */
    public java.math.BigDecimal getMileage()
    {
        return getBigDecimal("mileage");
    }
    public void setMileage(java.math.BigDecimal item)
    {
        setBigDecimal("mileage", item);
    }
    /**
     * Object:运输明细's 起始表盘数property 
     */
    public java.math.BigDecimal getStartMileage()
    {
        return getBigDecimal("startMileage");
    }
    public void setStartMileage(java.math.BigDecimal item)
    {
        setBigDecimal("startMileage", item);
    }
    /**
     * Object:运输明细's 结束表盘数property 
     */
    public java.math.BigDecimal getEndMileage()
    {
        return getBigDecimal("endMileage");
    }
    public void setEndMileage(java.math.BigDecimal item)
    {
        setBigDecimal("endMileage", item);
    }
    /**
     * Object:运输明细's 今日里程property 
     */
    public java.math.BigDecimal getTodayMileage()
    {
        return getBigDecimal("todayMileage");
    }
    public void setTodayMileage(java.math.BigDecimal item)
    {
        setBigDecimal("todayMileage", item);
    }
    /**
     * Object:运输明细's 每次平均里程property 
     */
    public java.math.BigDecimal getAvgMileage()
    {
        return getBigDecimal("avgMileage");
    }
    public void setAvgMileage(java.math.BigDecimal item)
    {
        setBigDecimal("avgMileage", item);
    }
    /**
     * Object:运输明细's 理论今日油耗(L)property 
     */
    public java.math.BigDecimal getTodayMPG()
    {
        return getBigDecimal("todayMPG");
    }
    public void setTodayMPG(java.math.BigDecimal item)
    {
        setBigDecimal("todayMPG", item);
    }
    /**
     * Object:运输明细's 理论平均油耗(L/Km)property 
     */
    public java.math.BigDecimal getAvgMPG()
    {
        return getBigDecimal("avgMPG");
    }
    public void setAvgMPG(java.math.BigDecimal item)
    {
        setBigDecimal("avgMPG", item);
    }
    /**
     * Object:运输明细's 违章次数property 
     */
    public int getViolationTimes()
    {
        return getInt("violationTimes");
    }
    public void setViolationTimes(int item)
    {
        setInt("violationTimes", item);
    }
    /**
     * Object:运输明细's 晚点时间(小时)property 
     */
    public java.math.BigDecimal getLateLong()
    {
        return getBigDecimal("lateLong");
    }
    public void setLateLong(java.math.BigDecimal item)
    {
        setBigDecimal("lateLong", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("90C054F8");
    }
}