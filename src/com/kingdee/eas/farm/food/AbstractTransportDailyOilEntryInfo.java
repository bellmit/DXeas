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
     * Object: ������ϸ 's null property 
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
     * Object:������ϸ's ��ʱ���(Km)property 
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
     * Object:������ϸ's ���ͽ��property 
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
     * Object:������ϸ's ������(L)property 
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
     * Object: ������ϸ 's ���� property 
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
     * Object:������ϸ's ��ʱ�۸�property 
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
     * Object:������ϸ's ������Һ������property 
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