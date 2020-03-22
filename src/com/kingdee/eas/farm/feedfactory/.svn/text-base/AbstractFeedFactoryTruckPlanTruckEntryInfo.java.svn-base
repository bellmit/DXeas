package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedFactoryTruckPlanTruckEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFeedFactoryTruckPlanTruckEntryInfo()
    {
        this("id");
    }
    protected AbstractFeedFactoryTruckPlanTruckEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 饲料车派车情况 's null property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo getParent()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 饲料车派车情况 's 车号 property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedTruckInfo getTruck()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedTruckInfo)get("truck");
    }
    public void setTruck(com.kingdee.eas.farm.feedfactory.FeedTruckInfo item)
    {
        put("truck", item);
    }
    /**
     * Object:饲料车派车情况's 总车次property 
     */
    public int getAllCount()
    {
        return getInt("allCount");
    }
    public void setAllCount(int item)
    {
        setInt("allCount", item);
    }
    /**
     * Object:饲料车派车情况's 预计午饭地点property 
     */
    public String getLunchPlace()
    {
        return getString("lunchPlace");
    }
    public void setLunchPlace(String item)
    {
        setString("lunchPlace", item);
    }
    /**
     * Object:饲料车派车情况's 出车时间property 
     */
    public java.sql.Time getBeginTime()
    {
        return getTime("beginTime");
    }
    public void setBeginTime(java.sql.Time item)
    {
        setTime("beginTime", item);
    }
    /**
     * Object:饲料车派车情况's 收车时间property 
     */
    public java.sql.Time getEndTime()
    {
        return getTime("endTime");
    }
    public void setEndTime(java.sql.Time item)
    {
        setTime("endTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E5C8A2D1");
    }
}