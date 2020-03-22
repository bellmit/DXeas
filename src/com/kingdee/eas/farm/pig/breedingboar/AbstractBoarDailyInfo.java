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
     * Object: �ֹ�����ֳ�ձ� 's ��ι��¼ property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyEntryCollection)get("entrys");
    }
    /**
     * Object:�ֹ�����ֳ�ձ�'s �Ƿ�����ƾ֤property 
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
     * Object: �ֹ�����ֳ�ձ� 's ���߷�¼ property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object:�ֹ�����ֳ�ձ�'s ���ʱ��property 
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
     * Object:�ֹ�����ֳ�ձ�'s ״̬property 
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
     * Object: �ֹ�����ֳ�ձ� 's ���ط�¼ property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyEnviConEntryCollection getEnviConEntry()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyEnviConEntryCollection)get("EnviConEntry");
    }
    /**
     * Object:�ֹ�����ֳ�ձ�'s ��ֳ��־ property 
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
     * Object: �ֹ�����ֳ�ձ� 's ������¼ property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyDCEntryCollection getDCEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyDCEntryCollection)get("DCEntrys");
    }
    /**
     * Object:�ֹ�����ֳ�ձ�'s ����¶ȴ�(��)property 
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
     * Object:�ֹ�����ֳ�ձ�'s ����¶ȵ�(��)property 
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
     * Object:�ֹ�����ֳ�ձ�'s ���ʪ�ȴ�(%)property 
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
     * Object:�ֹ�����ֳ�ձ�'s ���ʪ�ȵ�(%)property 
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
     * Object:�ֹ�����ֳ�ձ�'s ����property 
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
     * Object: �ֹ�����ֳ�ձ� 's ���α�� property 
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
     * Object: �ֹ�����ֳ�ձ� 's ������� property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyLiveStockEntryCollection getLiveStockEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyLiveStockEntryCollection)get("LiveStockEntrys");
    }
    /**
     * Object: �ֹ�����ֳ�ձ� 's ��ֳ�� property 
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
     * Object: �ֹ�����ֳ�ձ� 's ��̭��¼ property 
     */
    public com.kingdee.eas.farm.pig.breedingboar.BoarDailyCullEntryCollection getCullEntrys()
    {
        return (com.kingdee.eas.farm.pig.breedingboar.BoarDailyCullEntryCollection)get("CullEntrys");
    }
    /**
     * Object:�ֹ�����ֳ�ձ�'s ע������property 
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