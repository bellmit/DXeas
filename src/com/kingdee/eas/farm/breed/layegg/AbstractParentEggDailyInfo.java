package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractParentEggDailyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractParentEggDailyInfo()
    {
        this("id");
    }
    protected AbstractParentEggDailyInfo(String pkField)
    {
        super(pkField);
        put("ImmuneEntrys", new com.kingdee.eas.farm.breed.layegg.ParentEggDailyImmuneEntryCollection());
        put("entrys", new com.kingdee.eas.farm.breed.layegg.ParentEggDailyEntryCollection());
        put("TransEntrys", new com.kingdee.eas.farm.breed.layegg.ParentEggDailyTransEntryCollection());
        put("FodderEntrys", new com.kingdee.eas.farm.breed.layegg.ParentEggDailyFodderEntryCollection());
    }
    /**
     * Object: �����ձ� 's ��ι��Ϣ��¼ property 
     */
    public com.kingdee.eas.farm.breed.layegg.ParentEggDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.ParentEggDailyEntryCollection)get("entrys");
    }
    /**
     * Object:�����ձ�'s �Ƿ�����ƾ֤property 
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
     * Object:�����ձ�'s ״̬property 
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
     * Object:�����ձ�'s ���ʱ��property 
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
     * Object:�����ձ�'s ��ֳ��־property 
     */
    public String getBreedLog()
    {
        return getString("breedLog");
    }
    public void setBreedLog(String item)
    {
        setString("breedLog", item);
    }
    /**
     * Object:�����ձ�'s ����property 
     */
    public int getWeek()
    {
        return getInt("week");
    }
    public void setWeek(int item)
    {
        setInt("week", item);
    }
    /**
     * Object:�����ձ�'s ����property 
     */
    public int getWeekDay()
    {
        return getInt("weekDay");
    }
    public void setWeekDay(int item)
    {
        setInt("weekDay", item);
    }
    /**
     * Object: �����ձ� 's ������Ϣ property 
     */
    public com.kingdee.eas.farm.breed.layegg.ParentEggDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.ParentEggDailyImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object: �����ձ� 's Ҫ�ϼƻ� property 
     */
    public com.kingdee.eas.farm.breed.layegg.ParentEggDailyFodderEntryCollection getFodderEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.ParentEggDailyFodderEntryCollection)get("FodderEntrys");
    }
    /**
     * Object: �����ձ� 's ��ֳ�� property 
     */
    public com.kingdee.eas.farm.breed.BreedStoorgSetInfo getFeedFarm()
    {
        return (com.kingdee.eas.farm.breed.BreedStoorgSetInfo)get("feedFarm");
    }
    public void setFeedFarm(com.kingdee.eas.farm.breed.BreedStoorgSetInfo item)
    {
        put("feedFarm", item);
    }
    /**
     * Object: �����ձ� 's ��ֳ���� property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchInfo getBatch()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchInfo)get("batch");
    }
    public void setBatch(com.kingdee.eas.farm.breed.ParentBreedBatchInfo item)
    {
        put("batch", item);
    }
    /**
     * Object: �����ձ� 's ת����ϸ property 
     */
    public com.kingdee.eas.farm.breed.layegg.ParentEggDailyTransEntryCollection getTransEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.ParentEggDailyTransEntryCollection)get("TransEntrys");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("020C7DAB");
    }
}