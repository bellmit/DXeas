package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBoarDailyInfo extends com.kingdee.eas.framework.CoreBillBaseInfo implements Serializable 
{
    public AbstractBoarDailyInfo()
    {
        this("id");
    }
    protected AbstractBoarDailyInfo(String pkField)
    {
        super(pkField);
        put("LiveStockEntrys", new com.kingdee.eas.farm.pig.breedingboar.BoarDailyLiveStockEntryCollection());
        put("DCEntrys", new com.kingdee.eas.farm.pig.breedingboar.BoarDailyDCEntryCollection());
        put("ImmuneEntrys", new com.kingdee.eas.farm.pig.breedingboar.BoarDailyImmuneEntryCollection());
        put("entrys", new com.kingdee.eas.farm.pig.breedingboar.BoarDailyEntryCollection());
        put("EnviConEntry", new com.kingdee.eas.farm.pig.breedingboar.BoarDailyEnviConEntryCollection());
        put("CullEntrys", new com.kingdee.eas.farm.pig.breedingboar.BoarDailyCullEntryCollection());
    }
    /**
     * Object: 种公猪养殖日报 's 饲喂分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyEntryCollection)get("entrys");
    }
    /**
     * Object:种公猪养殖日报's 是否生成凭证property 
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
     * Object: 种公猪养殖日报 's 免疫分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object:种公猪养殖日报's 审核时间property 
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
     * Object:种公猪养殖日报's 状态property 
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
     * Object: 种公猪养殖日报 's 环控分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyEnviConEntryCollection getEnviConEntry()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyEnviConEntryCollection)get("EnviConEntry");
    }
    /**
     * Object:种公猪养殖日报's 养殖日志 property 
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
     * Object: 种公猪养殖日报 's 死亡记录 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyDCEntryCollection getDCEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyDCEntryCollection)get("DCEntrys");
    }
    /**
     * Object:种公猪养殖日报's 外界温度从(℃)property 
     */
    public java.math.BigDecimal getOutTemperatureFrom()
    {
        return getBigDecimal("outTemperatureFrom");
    }
    public void setOutTemperatureFrom(java.math.BigDecimal item)
    {
        setBigDecimal("outTemperatureFrom", item);
    }
    /**
     * Object:种公猪养殖日报's 外界温度到(℃)property 
     */
    public java.math.BigDecimal getOutTemperatureTo()
    {
        return getBigDecimal("outTemperatureTo");
    }
    public void setOutTemperatureTo(java.math.BigDecimal item)
    {
        setBigDecimal("outTemperatureTo", item);
    }
    /**
     * Object:种公猪养殖日报's 外界湿度从(%)property 
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
     * Object:种公猪养殖日报's 外界湿度到(%)property 
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
     * Object:种公猪养殖日报's 天气property 
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
     * Object: 种公猪养殖日报 's 批次编号 property 
     */
    public com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo getPigBatch()
    {
        return (com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo)get("pigBatch");
    }
    public void setPigBatch(com.kingdee.eas.farm.pig.ccpig.CCPigBatchInfo item)
    {
        put("pigBatch", item);
    }
    /**
     * Object: 种公猪养殖日报 's 存栏情况 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyLiveStockEntryCollection getLiveStockEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyLiveStockEntryCollection)get("LiveStockEntrys");
    }
    /**
     * Object: 种公猪养殖日报 's 养殖场 property 
     */
    public com.kingdee.eas.farm.pig.PigFarmInfo getFarm()
    {
        return (com.kingdee.eas.farm.pig.PigFarmInfo)get("farm");
    }
    public void setFarm(com.kingdee.eas.farm.pig.PigFarmInfo item)
    {
        put("farm", item);
    }
    /**
     * Object: 种公猪养殖日报 's 淘汰分录 property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyCullEntryCollection getCullEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyCullEntryCollection)get("CullEntrys");
    }
    /**
     * Object:种公猪养殖日报's 注意事项property 
     */
    public String getWarn()
    {
        return getString("warn");
    }
    public void setWarn(String item)
    {
        setString("warn", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("66D2D13F");
    }
}