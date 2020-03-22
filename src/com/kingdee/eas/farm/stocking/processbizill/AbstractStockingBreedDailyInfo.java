package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStockingBreedDailyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractStockingBreedDailyInfo()
    {
        this("id");
    }
    protected AbstractStockingBreedDailyInfo(String pkField)
    {
        super(pkField);
        put("TransEntry", new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyTransEntryCollection());
        put("AssEntrys", new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryCollection());
        put("ImmuneEntrys", new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryCollection());
        put("MatUserEntry", new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryCollection());
        put("entrys", new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryCollection());
        put("SendEggEntry", new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailySendEggEntryCollection());
        put("Envi", new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEnviCollection());
        put("DrugEntrys", new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyDrugEntryCollection());
        put("EggEntry", new com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryCollection());
    }
    /**
     * Object: 养殖日报 's 饲喂信息分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEntryCollection)get("entrys");
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
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyAssEntryCollection)get("AssEntrys");
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
     * Object:养殖日报's 养殖日志property 
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
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyImmuneEntryCollection)get("ImmuneEntrys");
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
     * Object: 养殖日报 's 养殖户 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmersInfo getFarmer()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmersInfo)get("farmer");
    }
    public void setFarmer(com.kingdee.eas.farm.stocking.basedata.FarmersInfo item)
    {
        put("farmer", item);
    }
    /**
     * Object: 养殖日报 's 养殖场 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.stocking.basedata.FarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.stocking.basedata.FarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 养殖日报 's 批次 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo getStockingBatch()
    {
        return (com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo)get("stockingBatch");
    }
    public void setStockingBatch(com.kingdee.eas.farm.stocking.basedata.StockingBatchInfo item)
    {
        put("stockingBatch", item);
    }
    /**
     * Object: 养殖日报 's 产蛋分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryCollection getEggEntry()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEggEntryCollection)get("EggEntry");
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
     * Object: 养殖日报 's 转栏分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyTransEntryCollection getTransEntry()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyTransEntryCollection)get("TransEntry");
    }
    /**
     * Object: 养殖日报 's 环控分录 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEnviCollection getEnvi()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyEnviCollection)get("Envi");
    }
    /**
     * Object:养殖日报's 定群property 
     */
    public boolean isIsMature()
    {
        return getBoolean("isMature");
    }
    public void setIsMature(boolean item)
    {
        setBoolean("isMature", item);
    }
    /**
     * Object:养殖日报's 当前阶段property 
     */
    public com.kingdee.eas.farm.stocking.basedata.FarmStageEnum getNowBreedStage()
    {
        return com.kingdee.eas.farm.stocking.basedata.FarmStageEnum.getEnum(getInt("nowBreedStage"));
    }
    public void setNowBreedStage(com.kingdee.eas.farm.stocking.basedata.FarmStageEnum item)
    {
		if (item != null) {
        setInt("nowBreedStage", item.getValue());
		}
    }
    /**
     * Object: 养殖日报 's 蛋品报送 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailySendEggEntryCollection getSendEggEntry()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailySendEggEntryCollection)get("SendEggEntry");
    }
    /**
     * Object:养殖日报's 转育成property 
     */
    public boolean isIsBreed()
    {
        return getBoolean("isBreed");
    }
    public void setIsBreed(boolean item)
    {
        setBoolean("isBreed", item);
    }
    /**
     * Object: 养殖日报 's 技术员 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getBizPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("bizPerson");
    }
    public void setBizPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("bizPerson", item);
    }
    /**
     * Object:养殖日报's 总日龄property 
     */
    public String getSumWeekDay()
    {
        return getString("sumWeekDay");
    }
    public void setSumWeekDay(String item)
    {
        setString("sumWeekDay", item);
    }
    /**
     * Object: 养殖日报 's 物料领用 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryCollection getMatUserEntry()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyMatUserEntryCollection)get("MatUserEntry");
    }
    /**
     * Object: 养殖日报 's 当前成本对象 property 
     */
    public com.kingdee.eas.basedata.assistant.CostObjectInfo getCurrentCostObject()
    {
        return (com.kingdee.eas.basedata.assistant.CostObjectInfo)get("currentCostObject");
    }
    public void setCurrentCostObject(com.kingdee.eas.basedata.assistant.CostObjectInfo item)
    {
        put("currentCostObject", item);
    }
    /**
     * Object:养殖日报's 转预产property 
     */
    public boolean isPreEgg()
    {
        return getBoolean("preEgg");
    }
    public void setPreEgg(boolean item)
    {
        setBoolean("preEgg", item);
    }
    /**
     * Object:养殖日报's 是否调整property 
     */
    public boolean isIsAdjust()
    {
        return getBoolean("isAdjust");
    }
    public void setIsAdjust(boolean item)
    {
        setBoolean("isAdjust", item);
    }
    /**
     * Object: 养殖日报 's 用药信息 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyDrugEntryCollection getDrugEntrys()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.StockingBreedDailyDrugEntryCollection)get("DrugEntrys");
    }
    /**
     * Object:养殖日报's 公禽料出库property 
     */
    public boolean isMaleOut()
    {
        return getBoolean("maleOut");
    }
    public void setMaleOut(boolean item)
    {
        setBoolean("maleOut", item);
    }
    /**
     * Object:养殖日报's 母禽料出库property 
     */
    public boolean isFemaleOut()
    {
        return getBoolean("femaleOut");
    }
    public void setFemaleOut(boolean item)
    {
        setBoolean("femaleOut", item);
    }
    /**
     * Object:养殖日报's 用药出库property 
     */
    public boolean isDrugOut()
    {
        return getBoolean("drugOut");
    }
    public void setDrugOut(boolean item)
    {
        setBoolean("drugOut", item);
    }
    /**
     * Object:养殖日报's 免疫出库property 
     */
    public boolean isImmuneOut()
    {
        return getBoolean("immuneOut");
    }
    public void setImmuneOut(boolean item)
    {
        setBoolean("immuneOut", item);
    }
    /**
     * Object:养殖日报's 物料出库property 
     */
    public boolean isMaterialOut()
    {
        return getBoolean("materialOut");
    }
    public void setMaterialOut(boolean item)
    {
        setBoolean("materialOut", item);
    }
    /**
     * Object:养殖日报's 合格蛋出库property 
     */
    public boolean isQualityEggOut()
    {
        return getBoolean("qualityEggOut");
    }
    public void setQualityEggOut(boolean item)
    {
        setBoolean("qualityEggOut", item);
    }
    /**
     * Object:养殖日报's 非合格蛋入库property 
     */
    public boolean isUnQualityEggOut()
    {
        return getBoolean("unQualityEggOut");
    }
    public void setUnQualityEggOut(boolean item)
    {
        setBoolean("unQualityEggOut", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2859A756");
    }
}