package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSlaughterPlanInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractSlaughterPlanInfo()
    {
        this("id");
    }
    protected AbstractSlaughterPlanInfo(String pkField)
    {
        super(pkField);
        put("entrys", new com.kingdee.eas.farm.food.SlaughterPlanEntryCollection());
        put("EntryScheduling", new com.kingdee.eas.farm.food.SlaughterPlanEntrySchedulingCollection());
    }
    /**
     * Object: 屠宰计划 's 分录 property 
     */
    public com.kingdee.eas.farm.food.SlaughterPlanEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.food.SlaughterPlanEntryCollection)get("entrys");
    }
    /**
     * Object:屠宰计划's 是否生成凭证property 
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
     * Object:屠宰计划's 单据状态property 
     */
    public com.kingdee.eas.cm.common.BillBaseStatusEnum getBillStatus()
    {
        return com.kingdee.eas.cm.common.BillBaseStatusEnum.getEnum(getInt("billStatus"));
    }
    public void setBillStatus(com.kingdee.eas.cm.common.BillBaseStatusEnum item)
    {
		if (item != null) {
        setInt("billStatus", item.getValue());
		}
    }
    /**
     * Object:屠宰计划's 审核时间property 
     */
    public java.util.Date getAuditDate()
    {
        return getDate("auditDate");
    }
    public void setAuditDate(java.util.Date item)
    {
        setDate("auditDate", item);
    }
    /**
     * Object: 屠宰计划 's 食品厂 property 
     */
    public com.kingdee.eas.basedata.org.StorageOrgUnitInfo getStoOrg()
    {
        return (com.kingdee.eas.basedata.org.StorageOrgUnitInfo)get("stoOrg");
    }
    public void setStoOrg(com.kingdee.eas.basedata.org.StorageOrgUnitInfo item)
    {
        put("stoOrg", item);
    }
    /**
     * Object:屠宰计划's 标准屠宰日龄property 
     */
    public int getAgeInDays()
    {
        return getInt("ageInDays");
    }
    public void setAgeInDays(int item)
    {
        setInt("ageInDays", item);
    }
    /**
     * Object: 屠宰计划 's 宰杀期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:屠宰计划's 日龄从property 
     */
    public int getAgeOfDaysFrom()
    {
        return getInt("ageOfDaysFrom");
    }
    public void setAgeOfDaysFrom(int item)
    {
        setInt("ageOfDaysFrom", item);
    }
    /**
     * Object:屠宰计划's 日龄到property 
     */
    public int getAgeOfDaysTo()
    {
        return getInt("ageOfDaysTo");
    }
    public void setAgeOfDaysTo(int item)
    {
        setInt("ageOfDaysTo", item);
    }
    /**
     * Object:屠宰计划's 标准宰杀舍数property 
     */
    public int getSlaughterHenHouseQtyAveDay()
    {
        return getInt("slaughterHenHouseQtyAveDay");
    }
    public void setSlaughterHenHouseQtyAveDay(int item)
    {
        setInt("slaughterHenHouseQtyAveDay", item);
    }
    /**
     * Object: 屠宰计划 's 休班计划 property 
     */
    public com.kingdee.eas.farm.food.SlaughterPlanEntrySchedulingCollection getEntryScheduling()
    {
        return (com.kingdee.eas.farm.food.SlaughterPlanEntrySchedulingCollection)get("EntryScheduling");
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C95AD0D2");
    }
}