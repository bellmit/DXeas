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
     * Object: ��Ʒ���ձ� 's ��ι��Ϣ��¼ property 
     */
    public com.kingdee.eas.farm.breed.business.CommecialChilkenDailyEntryCollection getEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CommecialChilkenDailyEntryCollection)get("entrys");
    }
    /**
     * Object:��Ʒ���ձ�'s �Ƿ�����ƾ֤property 
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
     * Object: ��Ʒ���ձ� 's ������Ϣ��¼ property 
     */
    public com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryCollection getAssEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CommecialChilkenDailyAssEntryCollection)get("AssEntrys");
    }
    /**
     * Object:��Ʒ���ձ�'s ״̬property 
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
     * Object:��Ʒ���ձ�'s ����¶ȴ�property 
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
     * Object:��Ʒ���ձ�'s ����¶ȵ�property 
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
     * Object:��Ʒ���ձ�'s ����property 
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
     * Object:��Ʒ���ձ�'s ���ʪ�ȣ�%����property 
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
     * Object:��Ʒ���ձ�'s ���ʪ�ȣ�%����property 
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
     * Object:��Ʒ���ձ�'s ���ʱ��property 
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
     * Object:��Ʒ���ձ�'s ȼ������property 
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
     * Object:��Ʒ���ձ�'s ��ֳ��־property 
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
     * Object:��Ʒ���ձ�'s �õ���property 
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
     * Object:��Ʒ���ձ�'s ����property 
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
     * Object:��Ʒ���ձ�'s ȼú���ģ�kg��property 
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
     * Object:��Ʒ���ձ�'s �������ģ�L��property 
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
     * Object: ��Ʒ���ձ� 's ������Ϣ property 
     */
    public com.kingdee.eas.farm.breed.business.CommecialChilkenDailyImmuneEntryCollection getImmuneEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CommecialChilkenDailyImmuneEntryCollection)get("ImmuneEntrys");
    }
    /**
     * Object: ��Ʒ���ձ� 's ����Ҫ�ϼƻ� property 
     */
    public com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFodderPlanEntryCollection getFodderPlanEntrys()
    {
        return (com.kingdee.eas.farm.breed.business.CommecialChilkenDailyFodderPlanEntryCollection)get("FodderPlanEntrys");
    }
    /**
     * Object:��Ʒ���ձ�'s �����ʼ����property 
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
     * Object:��Ʒ���ձ�'s ��ְ����property 
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
     * Object:��Ʒ���ձ�'s ��������property 
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
     * Object:��Ʒ���ձ�'s ��������property 
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
     * Object:��Ʒ���ձ�'s ������property 
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
     * Object: ��Ʒ���ձ� 's ��ֳ���� property 
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
     * Object: ��Ʒ���ձ� 's ������֯ property 
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
     * Object: ��Ʒ���ձ� 's ��ֳ�� property 
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
     * Object: ��Ʒ���ձ� 's ��ֳ�� property 
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
     * Object:��Ʒ���ձ�'s ����property 
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
     * Object:��Ʒ���ձ�'s ����property 
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