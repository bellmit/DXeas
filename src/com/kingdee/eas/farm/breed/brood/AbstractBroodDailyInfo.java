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
     * Object: �����ձ� 's ��ι��Ϣ��¼ property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyEntryCollection)get("entrys");
    }
    /**
     * Object:�����ձ�'s �Ƿ�����ƾ֤property 
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
     * Object: �����ձ� 's ������Ϣ��¼ property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object:�����ձ�'s ״̬property 
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
     * Object:�����ձ�'s ����¶ȴ�property 
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
     * Object:�����ձ�'s ����¶ȵ�property 
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
     * Object:�����ձ�'s ����property 
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
     * Object:�����ձ�'s ���ʪ�ȣ�%����property 
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
     * Object:�����ձ�'s ���ʪ�ȣ�%����property 
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
     * Object:�����ձ�'s ���ʱ��property 
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
     * Object:�����ձ�'s ȼ������property 
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
     * Object:�����ձ�'s ��ֳ��־property 
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
     * Object:�����ձ�'s ����property 
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
     * Object:�����ձ�'s ����property 
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
     * Object: �����ձ� 's ��ֳ�� property 
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
     * Object: �����ձ� 's ���α��� property 
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
     * Object:�����ձ�'s ��������property 
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
     * Object:�����ձ�'s �õ���property 
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
     * Object: �����ձ� 's ������Ϣ property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object:�����ձ�'s ȼú���ģ�kg��property 
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
     * Object:�����ձ�'s �������ģ�L��property 
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
     * Object: �����ձ� 's Ҫ�ϼƻ� property 
     */
    public com.kingdee.eas.farm.breed.brood.BroodDailyFodderEntryCollection getFodderEntrys()
    {
        return (com.kingdee.eas.farm.breed.brood.BroodDailyFodderEntryCollection)get("FodderEntrys");
    }
    /**
     * Object:�����ձ�'s �����ʼ����property 
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
     * Object:�����ձ�'s ��������property 
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
     * Object:�����ձ�'s ��������property 
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
     * Object:�����ձ�'s ��������property 
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