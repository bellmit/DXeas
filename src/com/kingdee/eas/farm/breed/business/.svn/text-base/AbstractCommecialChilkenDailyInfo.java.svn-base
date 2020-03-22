package com.kingdee.eas.farm.breed.business;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCommecialChilkenDailyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractCommecialChilkenDailyInfo()
    {
        this("id");
    }
    protected AbstractCommecialChilkenDailyInfo(String pkField)
    {
        super(pkField);
        put("AssEntrys", new com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryCollection());
        put("FodderPlanEntrys", new com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFodderPlanEntryCollection());
        put("ImmuneEntrys", new com.kingdee.eas.farm.breed.business.CommecialChilkenDailyImmuneEntryCollection());
        put("entrys", new com.kingdee.eas.farm.breed.business.CommecialChilkenDailyEntryCollection());
    }
    /**
     * Object: 商品鸡日报 's 饲喂信息分录 property 
     */
    public com.kingdee.eas.farm.breed.business.CommecialChilkenDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CommecialChilkenDailyEntryCollection)get("entrys");
    }
    /**
     * Object:商品鸡日报's 是否生成凭证property 
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
     * Object: 商品鸡日报 's 其他信息分录 property 
     */
    public com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object:商品鸡日报's 状态property 
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
     * Object:商品鸡日报's 外界温度从property 
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
     * Object:商品鸡日报's 外界温度到property 
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
     * Object:商品鸡日报's 天气property 
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
     * Object:商品鸡日报's 外界湿度（%）从property 
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
     * Object:商品鸡日报's 外界湿度（%）到property 
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
     * Object:商品鸡日报's 审核时间property 
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
     * Object:商品鸡日报's 燃料消耗property 
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
     * Object:商品鸡日报's 养殖日志property 
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
     * Object:商品鸡日报's 用电量property 
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
     * Object:商品鸡日报's 日龄property 
     */
    public int getDays()
    {
        return getInt("days");
    }
    public void setDays(int item)
    {
        setInt("days", item);
    }
    /**
     * Object:商品鸡日报's 燃煤消耗（kg）property 
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
     * Object:商品鸡日报's 柴油消耗（L）property 
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
     * Object: 商品鸡日报 's 免疫信息 property 
     */
    public com.kingdee.eas.farm.breed.business.CommecialChilkenDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CommecialChilkenDailyImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object: 商品鸡日报 's 饲料要料计划 property 
     */
    public com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFodderPlanEntryCollection getFodderPlanEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFodderPlanEntryCollection)get("FodderPlanEntrys");
    }
    /**
     * Object:商品鸡日报's 当天初始人数property 
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
     * Object:商品鸡日报's 离职人数property 
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
     * Object:商品鸡日报's 新增人数property 
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
     * Object:商品鸡日报's 出勤人数property 
     */
    public int getAttendPersonQty()
    {
        return getInt("attendPersonQty");
    }
    public void setAttendPersonQty(int item)
    {
        setInt("attendPersonQty", item);
    }
    /**
     * Object:商品鸡日报's 空栏期property 
     */
    public boolean isIsHenhouseEmpty()
    {
        return getBoolean("isHenhouseEmpty");
    }
    public void setIsHenhouseEmpty(boolean item)
    {
        setBoolean("isHenhouseEmpty", item);
    }
    /**
     * Object: 商品鸡日报 's 养殖批次 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getBreedBatch()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("breedBatch");
    }
    public void setBreedBatch(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("breedBatch", item);
    }
    /**
     * Object: 商品鸡日报 's 财务组织 property 
     */
    public com.kingdee.eas.basedata.org.CompanyOrgUnitInfo getCompany()
    {
        return (com.kingdee.eas.basedata.org.CompanyOrgUnitInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.basedata.org.CompanyOrgUnitInfo item)
    {
        put("company", item);
    }
    /**
     * Object: 商品鸡日报 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 商品鸡日报 's 养殖户 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo getFarmer()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.carnivorous.basedata.FarmerInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object:商品鸡日报's 周龄property 
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
     * Object:商品鸡日报's 日龄property 
     */
    public int getDay()
    {
        return getInt("day");
    }
    public void setDay(int item)
    {
        setInt("day", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8506D469");
    }
}