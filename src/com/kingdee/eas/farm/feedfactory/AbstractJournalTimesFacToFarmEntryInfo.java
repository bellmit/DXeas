package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractJournalTimesFacToFarmEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractJournalTimesFacToFarmEntryInfo()
    {
        this("id");
    }
    protected AbstractJournalTimesFacToFarmEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 饲料厂与养殖场间车程 's null property 
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
     * Object: 饲料厂与养殖场间车程 's 养殖场 property 
     */
    public com.kingdee.eas.farm.breed.BreedStoorgSetInfo getFarm()
    {
        return (com.kingdee.eas.farm.breed.BreedStoorgSetInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.breed.BreedStoorgSetInfo item)
    {
        put("farm", item);
    }
    /**
     * Object:饲料厂与养殖场间车程's 地址property 
     */
    public String getAffress()
    {
        return getString("affress");
    }
    public void setAffress(String item)
    {
        setString("affress", item);
    }
    /**
     * Object:饲料厂与养殖场间车程's 重车时间（分钟）property 
     */
    public int getLoadTimes()
    {
        return getInt("loadTimes");
    }
    public void setLoadTimes(int item)
    {
        setInt("loadTimes", item);
    }
    /**
     * Object:饲料厂与养殖场间车程's 空车时间（分钟）property 
     */
    public int getUnloadTimes()
    {
        return getInt("unloadTimes");
    }
    public void setUnloadTimes(int item)
    {
        setInt("unloadTimes", item);
    }
    /**
     * Object:饲料厂与养殖场间车程's 路程(km)property 
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
        return new BOSObjectType("4BE2A50A");
    }
}