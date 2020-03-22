package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTransportDailyOilEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTransportDailyOilEntryInfo()
    {
        this("id");
    }
    protected AbstractTransportDailyOilEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 加油明细 's null property 
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
     * Object:加油明细's 当时里程(Km)property 
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
     * Object:加油明细's 加油金额property 
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
     * Object:加油明细's 加油数(L)property 
     */
    public java.math.BigDecimal getQty()
    {
        return getBigDecimal("qty");
    }
    public void setQty(java.math.BigDecimal item)
    {
        setBigDecimal("qty", item);
    }
    /**
     * Object: 加油明细 's 车辆 property 
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
     * Object:加油明细's 当时价格property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:加油明细's 尿素溶液消耗量property 
     */
    public java.math.BigDecimal getUrea()
    {
        return getBigDecimal("urea");
    }
    public void setUrea(java.math.BigDecimal item)
    {
        setBigDecimal("urea", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D4085B7A");
    }
}