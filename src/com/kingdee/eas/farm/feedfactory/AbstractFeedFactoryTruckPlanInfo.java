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
     * Object: ���ϳ��ɳ��ƻ� 's �ɳ���ϸ��¼ property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanEntryCollection)get("entrys");
    }
    /**
     * Object:���ϳ��ɳ��ƻ�'s �Ƿ�����ƾ֤property 
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
     * Object: ���ϳ��ɳ��ƻ� 's Ҫ�������ϸ��¼ property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedFactoryTruckPlanAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object:���ϳ��ɳ��ƻ�'s ���ʱ��property 
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
     * Object:���ϳ��ɳ��ƻ�'s ״̬property 
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
     * Object:���ϳ��ɳ��ƻ�'s ��ʼ����ʱ��property 
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
     * Object:���ϳ��ɳ��ƻ�'s �緹��ʼʱ��property 
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
     * Object:���ϳ��ɳ��ƻ�'s �緹����ʱ��property 
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
     * Object:���ϳ��ɳ��ƻ�'s ��Ԥװ����property 
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
     * Object:���ϳ��ɳ��ƻ�'s �����ϳ�����property 
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
     * Object: ���ϳ��ɳ��ƻ� 's ���ϳ��ɳ���� property 
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