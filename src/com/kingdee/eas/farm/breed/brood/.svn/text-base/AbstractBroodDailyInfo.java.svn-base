package com.kingdee.eas.farm.breed.brood;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBroodDailyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBroodDailyInfo()
    {
        this("id");
    }
    protected AbstractBroodDailyInfo(String pkField)
    {
        super(pkField);
        put("AssEntrys", new com.kingdee.eas.farm.breed.brood.BroodDailyAssEntryCollection());
        put("ImmuneEntrys", new com.kingdee.eas.farm.breed.brood.BroodDailyImmuneEntryCollection());
        put("entrys", new com.kingdee.eas.farm.breed.brood.BroodDailyEntryCollection());
        put("FodderEntrys", new com.kingdee.eas.farm.breed.brood.BroodDailyFodderEntryCollection());
    }
    /**
     * Object: 育成日报 's 饲喂信息分录 property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyEntryCollection)get("entrys");
    }
    /**
     * Object:育成日报's 是否生成凭证property 
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
     * Object: 育成日报 's 其他信息分录 property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object:育成日报's 状态property 
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
     * Object:育成日报's 外界温度从property 
     */
    public java.math.BigDecimal getOutSideTFrom()
    {
        return getBigDecimal("outSideTFrom");
    }
    public void setOutSideTFrom(java.math.BigDecimal item)
    {
        setBigDecimal("outSideTFrom", item);
    }
    /**
     * Object:育成日报's 外界温度到property 
     */
    public java.math.BigDecimal getOutSideTTo()
    {
        return getBigDecimal("outSideTTo");
    }
    public void setOutSideTTo(java.math.BigDecimal item)
    {
        setBigDecimal("outSideTTo", item);
    }
    /**
     * Object:育成日报's 天气property 
     */
    public String getWeather()
    {
        return getString("weather");
    }
    public void setWeather(String item)
    {
        setString("weather", item);
    }
    /**
     * Object:育成日报's 外界湿度（%）从property 
     */
    public java.math.BigDecimal getOutHumidityFrom()
    {
        return getBigDecimal("outHumidityFrom");
    }
    public void setOutHumidityFrom(java.math.BigDecimal item)
    {
        setBigDecimal("outHumidityFrom", item);
    }
    /**
     * Object:育成日报's 外界湿度（%）到property 
     */
    public java.math.BigDecimal getOutHumidityTo()
    {
        return getBigDecimal("outHumidityTo");
    }
    public void setOutHumidityTo(java.math.BigDecimal item)
    {
        setBigDecimal("outHumidityTo", item);
    }
    /**
     * Object:育成日报's 审核时间property 
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
     * Object:育成日报's 燃料消耗property 
     */
    public java.math.BigDecimal getFuel()
    {
        return getBigDecimal("fuel");
    }
    public void setFuel(java.math.BigDecimal item)
    {
        setBigDecimal("fuel", item);
    }
    /**
     * Object:育成日报's 养殖日志property 
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
     * Object:育成日报's 周龄property 
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
     * Object:育成日报's 日龄property 
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
     * Object: 育成日报 's 养殖场 property 
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
     * Object: 育成日报 's 批次编码 property 
     */
    public com.kingdee.eas.farm.breed.BreedBatchInfo getBreedBatch()
    {
        return (com.kingdee.eas.farm.breed.BreedBatchInfo)get("breedBatch");
    }
    public void setBreedBatch(com.kingdee.eas.farm.breed.BreedBatchInfo item)
    {
        put("breedBatch", item);
    }
    /**
     * Object:育成日报's 批次名称property 
     */
    public String getCostObject()
    {
        return getString("costObject");
    }
    public void setCostObject(String item)
    {
        setString("costObject", item);
    }
    /**
     * Object:育成日报's 用电量property 
     */
    public java.math.BigDecimal getElectricityQty()
    {
        return getBigDecimal("electricityQty");
    }
    public void setElectricityQty(java.math.BigDecimal item)
    {
        setBigDecimal("electricityQty", item);
    }
    /**
     * Object: 育成日报 's 免疫信息 property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object:育成日报's 燃煤消耗（kg）property 
     */
    public java.math.BigDecimal getCoalFual()
    {
        return getBigDecimal("coalFual");
    }
    public void setCoalFual(java.math.BigDecimal item)
    {
        setBigDecimal("coalFual", item);
    }
    /**
     * Object:育成日报's 柴油消耗（L）property 
     */
    public java.math.BigDecimal getDieselFual()
    {
        return getBigDecimal("dieselFual");
    }
    public void setDieselFual(java.math.BigDecimal item)
    {
        setBigDecimal("dieselFual", item);
    }
    /**
     * Object: 育成日报 's 要料计划 property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyFodderEntryCollection getFodderEntrys()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyFodderEntryCollection)get("FodderEntrys");
    }
    /**
     * Object:育成日报's 当天初始人数property 
     */
    public int getInitPersonQty()
    {
        return getInt("initPersonQty");
    }
    public void setInitPersonQty(int item)
    {
        setInt("initPersonQty", item);
    }
    /**
     * Object:育成日报's 新增人数property 
     */
    public int getEntryPersonQty()
    {
        return getInt("entryPersonQty");
    }
    public void setEntryPersonQty(int item)
    {
        setInt("entryPersonQty", item);
    }
    /**
     * Object:育成日报's 减少人数property 
     */
    public int getLeavePersonQty()
    {
        return getInt("leavePersonQty");
    }
    public void setLeavePersonQty(int item)
    {
        setInt("leavePersonQty", item);
    }
    /**
     * Object:育成日报's 出勤人数property 
     */
    public int getAttendPersonQty()
    {
        return getInt("attendPersonQty");
    }
    public void setAttendPersonQty(int item)
    {
        setInt("attendPersonQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AD159A59");
    }
}