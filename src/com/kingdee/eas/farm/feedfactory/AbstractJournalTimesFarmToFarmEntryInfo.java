package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractJournalTimesFarmToFarmEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractJournalTimesFarmToFarmEntryInfo()
    {
        this("id");
    }
    protected AbstractJournalTimesFarmToFarmEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 养殖场间车程设置 's null property 
     */
    public com.kingdee.eas.farm.feedfactory.JournalTimesInfo getParent()
    {
        return (com.kingdee.eas.farm.feedfactory.JournalTimesInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feedfactory.JournalTimesInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 养殖场间车程设置 's 起始场 property 
     */
    public com.kingdee.eas.farm.breed.BreedStoorgSetInfo getStartFarm()
    {
        return (com.kingdee.eas.farm.breed.BreedStoorgSetInfo)get("startFarm");
    }
    public void setStartFarm(com.kingdee.eas.farm.breed.BreedStoorgSetInfo item)
    {
        put("startFarm", item);
    }
    /**
     * Object:养殖场间车程设置's 地址property 
     */
    public String getStartFarmAddress()
    {
        return getString("startFarmAddress");
    }
    public void setStartFarmAddress(String item)
    {
        setString("startFarmAddress", item);
    }
    /**
     * Object: 养殖场间车程设置 's 终点场 property 
     */
    public com.kingdee.eas.farm.breed.BreedStoorgSetInfo getEndFarm()
    {
        return (com.kingdee.eas.farm.breed.BreedStoorgSetInfo)get("endFarm");
    }
    public void setEndFarm(com.kingdee.eas.farm.breed.BreedStoorgSetInfo item)
    {
        put("endFarm", item);
    }
    /**
     * Object:养殖场间车程设置's 地址property 
     */
    public String getEndFarmAddress()
    {
        return getString("endFarmAddress");
    }
    public void setEndFarmAddress(String item)
    {
        setString("endFarmAddress", item);
    }
    /**
     * Object:养殖场间车程设置's 耗时（分钟）property 
     */
    public int getTimes()
    {
        return getInt("times");
    }
    public void setTimes(int item)
    {
        setInt("times", item);
    }
    /**
     * Object:养殖场间车程设置's 路程(km)property 
     */
    public java.math.BigDecimal getDistance()
    {
        return getBigDecimal("distance");
    }
    public void setDistance(java.math.BigDecimal item)
    {
        setBigDecimal("distance", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("176DA21A");
    }
}