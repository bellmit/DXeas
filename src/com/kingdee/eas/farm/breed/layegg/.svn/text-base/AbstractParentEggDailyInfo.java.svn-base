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
     * Object: 种禽日报 's 饲喂信息分录 property 
     */
    public com.kingdee.eas.farm.breed.layegg.ParentEggDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.ParentEggDailyEntryCollection)get("entrys");
    }
    /**
     * Object:种禽日报's 是否生成凭证property 
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
     * Object:种禽日报's 状态property 
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
     * Object:种禽日报's 审核时间property 
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
     * Object:种禽日报's 养殖日志property 
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
     * Object:种禽日报's 周龄property 
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
     * Object:种禽日报's 日龄property 
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
     * Object: 种禽日报 's 免疫信息 property 
     */
    public com.kingdee.eas.farm.breed.layegg.ParentEggDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.ParentEggDailyImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object: 种禽日报 's 要料计划 property 
     */
    public com.kingdee.eas.farm.breed.layegg.ParentEggDailyFodderEntryCollection getFodderEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.ParentEggDailyFodderEntryCollection)get("FodderEntrys");
    }
    /**
     * Object: 种禽日报 's 养殖场 property 
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
     * Object: 种禽日报 's 养殖批次 property 
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
     * Object: 种禽日报 's 转栏明细 property 
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