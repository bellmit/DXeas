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
     * Object: ��ֳ�ձ� 's ��ι��Ϣ��¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEntryCollection)get("entrys");
    }
    /**
     * Object:��ֳ�ձ�'s �Ƿ�����ƾ֤property 
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
     * Object: ��ֳ�ձ� 's ��ֳ��Ϣ��¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object:��ֳ�ձ�'s ״̬property 
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
     * Object:��ֳ�ձ�'s ����¶ȴ�property 
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
     * Object:��ֳ�ձ�'s ����¶ȵ�property 
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
     * Object:��ֳ�ձ�'s ����property 
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
     * Object:��ֳ�ձ�'s ���ʪ�ȣ�%����property 
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
     * Object:��ֳ�ձ�'s ���ʪ�ȣ�%����property 
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
     * Object:��ֳ�ձ�'s ���ʱ��property 
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
     * Object:��ֳ�ձ�'s ȼ������property 
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
     * Object:��ֳ�ձ�'s ����property 
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
     * Object:��ֳ�ձ�'s ����property 
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
     * Object:��ֳ�ձ�'s �õ���property 
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
     * Object: ��ֳ�ձ� 's ������Ϣ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object:��ֳ�ձ�'s ȼú���ģ�kg��property 
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
     * Object:��ֳ�ձ�'s �������ģ�L��property 
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
     * Object: ��ֳ�ձ� 's ������֯ property 
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
     * Object:��ֳ�ձ�'s ת�ƹ�Ѽ����property 
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
     * Object:��ֳ�ձ�'s ��ʼ������property 
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
     * Object: ��ֳ�ձ� 's ���ط�¼ property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEnviCollection getEnvi()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.StockingDailyEnviCollection)get("Envi");
    }
    /**
     * Object: ��ֳ�ձ� 's ��ֳ�� property 
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
     * Object: ��ֳ�ձ� 's ���� property 
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
     * Object: ��ֳ�ձ� 's ��ֳ�� property 
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