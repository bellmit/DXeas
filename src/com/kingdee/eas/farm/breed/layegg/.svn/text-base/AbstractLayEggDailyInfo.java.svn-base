package com.kingdee.eas.farm.breed.layegg;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLayEggDailyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractLayEggDailyInfo()
    {
        this("id");
    }
    protected AbstractLayEggDailyInfo(String pkField)
    {
        super(pkField);
        put("TransHenhouseEntrys", new com.kingdee.eas.farm.breed.layegg.LayEggDailyTransHenhouseEntryCollection());
        put("AssEntrys", new com.kingdee.eas.farm.breed.layegg.LayEggDailyAssEntryCollection());
        put("ImmuneEntrys", new com.kingdee.eas.farm.breed.layegg.LayEggDailyImmuneEntryCollection());
        put("Conveyor", new com.kingdee.eas.farm.breed.layegg.LayEggDailyConveyorCollection());
        put("LayEggEntrys", new com.kingdee.eas.farm.breed.layegg.LayEggDailyLayEggEntryCollection());
        put("entrys", new com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryCollection());
        put("FodderEntrys", new com.kingdee.eas.farm.breed.layegg.LayEggDailyFodderEntryCollection());
        put("CullDeathEntrys", new com.kingdee.eas.farm.breed.layegg.LayEggDailyCullDeathEntryCollection());
    }
    /**
     * Object: 产蛋日报 's 饲喂信息分录 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyEntryCollection)get("entrys");
    }
    /**
     * Object:产蛋日报's 是否生成凭证property 
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
     * Object: 产蛋日报 's 其他信息分录 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object:产蛋日报's 状态property 
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
     * Object:产蛋日报's 外界温度从property 
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
     * Object:产蛋日报's 外界温度到property 
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
     * Object:产蛋日报's 天气property 
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
     * Object:产蛋日报's 外界湿度（%）从property 
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
     * Object:产蛋日报's 外界湿度（%）到property 
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
     * Object:产蛋日报's 审核时间property 
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
     * Object:产蛋日报's 燃料消耗property 
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
     * Object:产蛋日报's 养殖日志property 
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
     * Object: 产蛋日报 's 产蛋信息 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyLayEggEntryCollection getLayEggEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyLayEggEntryCollection)get("LayEggEntrys");
    }
    /**
     * Object: 产蛋日报 's 传送带信息 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyConveyorCollection getConveyor()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyConveyorCollection)get("Conveyor");
    }
    /**
     * Object: 产蛋日报 's 死淘信息 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyCullDeathEntryCollection getCullDeathEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyCullDeathEntryCollection)get("CullDeathEntrys");
    }
    /**
     * Object:产蛋日报's 用电量property 
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
     * Object:产蛋日报's 周龄property 
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
     * Object:产蛋日报's 日龄property 
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
     * Object:产蛋日报's 调拨合格蛋数property 
     */
    public int getQualifiedQty()
    {
        return getInt("qualifiedQty");
    }
    public void setQualifiedQty(int item)
    {
        setInt("qualifiedQty", item);
    }
    /**
     * Object:产蛋日报's 调拨畸形蛋数property 
     */
    public int getCommodityQty()
    {
        return getInt("commodityQty");
    }
    public void setCommodityQty(int item)
    {
        setInt("commodityQty", item);
    }
    /**
     * Object:产蛋日报's 调拨双黄蛋数property 
     */
    public int getDoubleYolkQty()
    {
        return getInt("doubleYolkQty");
    }
    public void setDoubleYolkQty(int item)
    {
        setInt("doubleYolkQty", item);
    }
    /**
     * Object: 产蛋日报 's 免疫信息 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object:产蛋日报's 燃煤消耗（kg）property 
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
     * Object:产蛋日报's 柴油消耗（L）property 
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
     * Object:产蛋日报's 是否定群property 
     */
    public boolean isIsFixed()
    {
        return getBoolean("isFixed");
    }
    public void setIsFixed(boolean item)
    {
        setBoolean("isFixed", item);
    }
    /**
     * Object: 产蛋日报 's 要料计划 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyFodderEntryCollection getFodderEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyFodderEntryCollection)get("FodderEntrys");
    }
    /**
     * Object:产蛋日报's 产蛋property 
     */
    public boolean isHadFixed()
    {
        return getBoolean("hadFixed");
    }
    public void setHadFixed(boolean item)
    {
        setBoolean("hadFixed", item);
    }
    /**
     * Object: 产蛋日报 's 转栏信息 property 
     */
    public com.kingdee.eas.farm.breed.layegg.LayEggDailyTransHenhouseEntryCollection getTransHenhouseEntrys()
    {
        return (com.kingdee.eas.farm.breed.layegg.LayEggDailyTransHenhouseEntryCollection)get("TransHenhouseEntrys");
    }
    /**
     * Object: 产蛋日报 's 养殖批次 property 
     */
    public com.kingdee.eas.farm.breed.ParentBreedBatchInfo getParentBatch()
    {
        return (com.kingdee.eas.farm.breed.ParentBreedBatchInfo)get("parentBatch");
    }
    public void setParentBatch(com.kingdee.eas.farm.breed.ParentBreedBatchInfo item)
    {
        put("parentBatch", item);
    }
    /**
     * Object:产蛋日报's 转育成期property 
     */
    public boolean isIsTransBrood()
    {
        return getBoolean("isTransBrood");
    }
    public void setIsTransBrood(boolean item)
    {
        setBoolean("isTransBrood", item);
    }
    /**
     * Object: 产蛋日报 's 育成成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getBroodCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("broodCostObject");
    }
    public void setBroodCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("broodCostObject", item);
    }
    /**
     * Object: 产蛋日报 's 养殖场 property 
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
     * Object: 产蛋日报 's 养殖场库存组织 property 
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
     * Object: 产蛋日报 's 育雏成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getBabyCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("babyCostObject");
    }
    public void setBabyCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("babyCostObject", item);
    }
    /**
     * Object: 产蛋日报 's 种蛋成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getEggCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("eggCostObject");
    }
    public void setEggCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("eggCostObject", item);
    }
    /**
     * Object:产蛋日报's 育成property 
     */
    public boolean isHadBrood()
    {
        return getBoolean("hadBrood");
    }
    public void setHadBrood(boolean item)
    {
        setBoolean("hadBrood", item);
    }
    /**
     * Object:产蛋日报's 总日龄property 
     */
    public int getSumDay()
    {
        return getInt("sumDay");
    }
    public void setSumDay(int item)
    {
        setInt("sumDay", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2472242B");
    }
}