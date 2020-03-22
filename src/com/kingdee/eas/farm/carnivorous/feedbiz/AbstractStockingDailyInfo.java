package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingDailyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractStockingDailyInfo()
    {
        this("id");
    }
    protected AbstractStockingDailyInfo(String pkField)
    {
        super(pkField);
        put("AssEntrys", new com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyAssEntryCollection());
        put("ImmuneEntrys", new com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyImmuneEntryCollection());
        put("entrys", new com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEntryCollection());
        put("Envi", new com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEnviCollection());
    }
    /**
     * Object: 养殖日报 's 饲喂信息分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEntryCollection)get("entrys");
    }
    /**
     * Object:养殖日报's 是否生成凭证property 
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
     * Object: 养殖日报 's 养殖信息分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object:养殖日报's 状态property 
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
     * Object:养殖日报's 外界温度从property 
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
     * Object:养殖日报's 外界温度到property 
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
     * Object:养殖日报's 天气property 
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
     * Object:养殖日报's 外界湿度（%）从property 
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
     * Object:养殖日报's 外界湿度（%）到property 
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
     * Object:养殖日报's 审核时间property 
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
     * Object:养殖日报's 燃料消耗property 
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
     * Object:养殖日报's 周龄property 
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
     * Object:养殖日报's 日龄property 
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
     * Object:养殖日报's 用电量property 
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
     * Object: 养殖日报 's 免疫信息 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object:养殖日报's 燃煤消耗（kg）property 
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
     * Object:养殖日报's 柴油消耗（L）property 
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
     * Object: 养殖日报 's 财务组织 property 
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
     * Object:养殖日报's 转移公鸭数量property 
     */
    public java.math.BigDecimal getTransInQty()
    {
        return getBigDecimal("transInQty");
    }
    public void setTransInQty(java.math.BigDecimal item)
    {
        setBigDecimal("transInQty", item);
    }
    /**
     * Object:养殖日报's 初始化单据property 
     */
    public boolean isIsInit()
    {
        return getBoolean("isInit");
    }
    public void setIsInit(boolean item)
    {
        setBoolean("isInit", item);
    }
    /**
     * Object: 养殖日报 's 环控分录 property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEnviCollection getEnvi()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEnviCollection)get("Envi");
    }
    /**
     * Object: 养殖日报 's 养殖户 property 
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
     * Object: 养殖日报 's 批次 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.BatchInfo getBatch()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.BatchInfo)get("batch");
    }
    public void setBatch(com.kingdee.eas.farm.carnivorous.basedata.BatchInfo item)
    {
        put("batch", item);
    }
    /**
     * Object: 养殖日报 's 养殖场 property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.carnivorous.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CA396C89");
    }
}