package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedFactoryTruckPlanInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractFeedFactoryTruckPlanInfo()
    {
        this("id");
    }
    protected AbstractFeedFactoryTruckPlanInfo(String pkField)
    {
        super(pkField);
        put("AssEntrys", new com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanAssEntryCollection());
        put("entrys", new com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanEntryCollection());
        put("TruckEntrys", new com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanTruckEntryCollection());
    }
    /**
     * Object: 饲料厂派车计划 's 派车明细分录 property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanEntryCollection)get("entrys");
    }
    /**
     * Object:饲料厂派车计划's 是否生成凭证property 
     */
    public boolean isFivouchered()
    {
        return getBoolean("Fivouchered");
    }
    public void setFivouchered(boolean item)
    {
        setBoolean("Fivouchered", item);
    }
    /**
     * Object: 饲料厂派车计划 's 要料情况明细分录 property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object:饲料厂派车计划's 审核时间property 
     */
    public java.util.Date getAuditTime()
    {
        return getDate("auditTime");
    }
    public void setAuditTime(java.util.Date item)
    {
        setDate("auditTime", item);
    }
    /**
     * Object:饲料厂派车计划's 状态property 
     */
    public com.kingdee.eas.scm.common.BillBaseStatusEnum getBaseStatus()
    {
        return com.kingdee.eas.scm.common.BillBaseStatusEnum.getEnum(getInt("baseStatus"));
    }
    public void setBaseStatus(com.kingdee.eas.scm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("baseStatus", item.getValue());
		}
    }
    /**
     * Object:饲料厂派车计划's 开始打料时间property 
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
     * Object:饲料厂派车计划's 午饭开始时间property 
     */
    public java.sql.Time getLunchBeginTime()
    {
        return getTime("lunchBeginTime");
    }
    public void setLunchBeginTime(java.sql.Time item)
    {
        setTime("lunchBeginTime", item);
    }
    /**
     * Object:饲料厂派车计划's 午饭结束时间property 
     */
    public java.sql.Time getLunchEndTime()
    {
        return getTime("lunchEndTime");
    }
    public void setLunchEndTime(java.sql.Time item)
    {
        setTime("lunchEndTime", item);
    }
    /**
     * Object:饲料厂派车计划's 已预装车数property 
     */
    public int getPrepackedTruckCount()
    {
        return getInt("prepackedTruckCount");
    }
    public void setPrepackedTruckCount(int item)
    {
        setInt("prepackedTruckCount", item);
    }
    /**
     * Object:饲料厂派车计划's 按饲料车排序property 
     */
    public boolean isOrderByTruck()
    {
        return getBoolean("orderByTruck");
    }
    public void setOrderByTruck(boolean item)
    {
        setBoolean("orderByTruck", item);
    }
    /**
     * Object: 饲料厂派车计划 's 饲料车派车情况 property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanTruckEntryCollection getTruckEntrys()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanTruckEntryCollection)get("TruckEntrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F34F04DE");
    }
}