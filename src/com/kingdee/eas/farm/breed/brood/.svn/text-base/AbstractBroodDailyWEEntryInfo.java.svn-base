package com.kingdee.eas.farm.breed.brood;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBroodDailyWEEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBroodDailyWEEntryInfo()
    {
        this("id");
    }
    protected AbstractBroodDailyWEEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 水电信息 's null property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.brood.BroodDailyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:水电信息's 用电量property 
     */
    public java.math.BigDecimal getElectricityQuantity()
    {
        return getBigDecimal("electricityQuantity");
    }
    public void setElectricityQuantity(java.math.BigDecimal item)
    {
        setBigDecimal("electricityQuantity", item);
    }
    /**
     * Object:水电信息's 饮水量property 
     */
    public java.math.BigDecimal getWaterQuantity()
    {
        return getBigDecimal("waterQuantity");
    }
    public void setWaterQuantity(java.math.BigDecimal item)
    {
        setBigDecimal("waterQuantity", item);
    }
    /**
     * Object: 水电信息 's 鸡舍 property 
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
     * Object:水电信息's 鸡舍名称property 
     */
    public String getHenhouseName()
    {
        return getString("henhouseName");
    }
    public void setHenhouseName(String item)
    {
        setString("henhouseName", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("678E5DCB");
    }
}