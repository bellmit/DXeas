package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMonthBillFarmEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMonthBillFarmEntryInfo()
    {
        this("id");
    }
    protected AbstractMonthBillFarmEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.wages.farm.MonthBillFarmInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.farm.MonthBillFarmInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.farm.MonthBillFarmInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPerson()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("person");
    }
    public void setPerson(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("person", item);
    }
    /**
     * Object:��¼'s ��ְʱ��property 
     */
    public java.util.Date getTimeofentry()
    {
        return getDate("timeofentry");
    }
    public void setTimeofentry(java.util.Date item)
    {
        setDate("timeofentry", item);
    }
    /**
     * Object:��¼'s Ӧ��������property 
     */
    public java.math.BigDecimal getAttendanceday()
    {
        return getBigDecimal("attendanceday");
    }
    public void setAttendanceday(java.math.BigDecimal item)
    {
        setBigDecimal("attendanceday", item);
    }
    /**
     * Object:��¼'s ʵ�ʳ�������property 
     */
    public java.math.BigDecimal getActualattenday()
    {
        return getBigDecimal("actualattenday");
    }
    public void setActualattenday(java.math.BigDecimal item)
    {
        setBigDecimal("actualattenday", item);
    }
    /**
     * Object:��¼'s �¼�����property 
     */
    public java.math.BigDecimal getLeaveday()
    {
        return getBigDecimal("leaveday");
    }
    public void setLeaveday(java.math.BigDecimal item)
    {
        setBigDecimal("leaveday", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getAbsenteeismday()
    {
        return getBigDecimal("absenteeismday");
    }
    public void setAbsenteeismday(java.math.BigDecimal item)
    {
        setBigDecimal("absenteeismday", item);
    }
    /**
     * Object:��¼'s ���˹���property 
     */
    public java.math.BigDecimal getAssessmentwages()
    {
        return getBigDecimal("assessmentwages");
    }
    public void setAssessmentwages(java.math.BigDecimal item)
    {
        setBigDecimal("assessmentwages", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getBasicwages()
    {
        return getBigDecimal("basicwages");
    }
    public void setBasicwages(java.math.BigDecimal item)
    {
        setBigDecimal("basicwages", item);
    }
    /**
     * Object:��¼'s ���ڹ���property 
     */
    public java.math.BigDecimal getCheckworkwages()
    {
        return getBigDecimal("checkworkwages");
    }
    public void setCheckworkwages(java.math.BigDecimal item)
    {
        setBigDecimal("checkworkwages", item);
    }
    /**
     * Object:��¼'s �Ӱ๤��property 
     */
    public java.math.BigDecimal getOvertimeH()
    {
        return getBigDecimal("overtimeH");
    }
    public void setOvertimeH(java.math.BigDecimal item)
    {
        setBigDecimal("overtimeH", item);
    }
    /**
     * Object:��¼'s ҹ�ಹ��property 
     */
    public java.math.BigDecimal getNightwages()
    {
        return getBigDecimal("nightwages");
    }
    public void setNightwages(java.math.BigDecimal item)
    {
        setBigDecimal("nightwages", item);
    }
    /**
     * Object:��¼'s ��˾��������property 
     */
    public java.math.BigDecimal getSubsidywages()
    {
        return getBigDecimal("subsidywages");
    }
    public void setSubsidywages(java.math.BigDecimal item)
    {
        setBigDecimal("subsidywages", item);
    }
    /**
     * Object:��¼'s ��Ƹ����property 
     */
    public java.math.BigDecimal getRecruitwages()
    {
        return getBigDecimal("recruitwages");
    }
    public void setRecruitwages(java.math.BigDecimal item)
    {
        setBigDecimal("recruitwages", item);
    }
    /**
     * Object:��¼'s Ʒ�ؿۿ�property 
     */
    public java.math.BigDecimal getQualitydebit()
    {
        return getBigDecimal("qualitydebit");
    }
    public void setQualitydebit(java.math.BigDecimal item)
    {
        setBigDecimal("qualitydebit", item);
    }
    /**
     * Object:��¼'s ͨ������property 
     */
    public java.math.BigDecimal getNotificationwages()
    {
        return getBigDecimal("notificationwages");
    }
    public void setNotificationwages(java.math.BigDecimal item)
    {
        setBigDecimal("notificationwages", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getRepairmonth()
    {
        return getBigDecimal("repairmonth");
    }
    public void setRepairmonth(java.math.BigDecimal item)
    {
        setBigDecimal("repairmonth", item);
    }
    /**
     * Object:��¼'s Ӧ������property 
     */
    public java.math.BigDecimal getWagespay()
    {
        return getBigDecimal("wagespay");
    }
    public void setWagespay(java.math.BigDecimal item)
    {
        setBigDecimal("wagespay", item);
    }
    /**
     * Object:��¼'s �����籣property 
     */
    public java.math.BigDecimal getSocialsecurity()
    {
        return getBigDecimal("socialsecurity");
    }
    public void setSocialsecurity(java.math.BigDecimal item)
    {
        setBigDecimal("socialsecurity", item);
    }
    /**
     * Object:��¼'s Ӧ˰����property 
     */
    public java.math.BigDecimal getTaxableincome()
    {
        return getBigDecimal("taxableincome");
    }
    public void setTaxableincome(java.math.BigDecimal item)
    {
        setBigDecimal("taxableincome", item);
    }
    /**
     * Object:��¼'s ��������˰property 
     */
    public java.math.BigDecimal getWithholdincometax()
    {
        return getBigDecimal("Withholdincometax");
    }
    public void setWithholdincometax(java.math.BigDecimal item)
    {
        setBigDecimal("Withholdincometax", item);
    }
    /**
     * Object:��¼'s ʵ������property 
     */
    public java.math.BigDecimal getPayroll()
    {
        return getBigDecimal("Payroll");
    }
    public void setPayroll(java.math.BigDecimal item)
    {
        setBigDecimal("Payroll", item);
    }
    /**
     * Object:��¼'s ����������property 
     */
    public java.math.BigDecimal getAccidentinsurance()
    {
        return getBigDecimal("Accidentinsurance");
    }
    public void setAccidentinsurance(java.math.BigDecimal item)
    {
        setBigDecimal("Accidentinsurance", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public java.math.BigDecimal getDeductedloss()
    {
        return getBigDecimal("Deductedloss");
    }
    public void setDeductedloss(java.math.BigDecimal item)
    {
        setBigDecimal("Deductedloss", item);
    }
    /**
     * Object:��¼'s ����ְproperty 
     */
    public java.math.BigDecimal getNewEntry()
    {
        return getBigDecimal("newEntry");
    }
    public void setNewEntry(java.math.BigDecimal item)
    {
        setBigDecimal("newEntry", item);
    }
    /**
     * Object:��¼'s ��עproperty 
     */
    public String getRemarks()
    {
        return getString("Remarks");
    }
    public void setRemarks(String item)
    {
        setString("Remarks", item);
    }
    /**
     * Object:��¼'s �Ƿ�����property 
     */
    public boolean isIsSpeedfrom()
    {
        return getBoolean("isSpeedfrom");
    }
    public void setIsSpeedfrom(boolean item)
    {
        setBoolean("isSpeedfrom", item);
    }
    /**
     * Object:��¼'s �����˺�property 
     */
    public String getBanknumber()
    {
        return getString("banknumber");
    }
    public void setBanknumber(String item)
    {
        setString("banknumber", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public String getAccountopening()
    {
        return getString("Accountopening");
    }
    public void setAccountopening(String item)
    {
        setString("Accountopening", item);
    }
    /**
     * Object:��¼'s ͨ��property 
     */
    public boolean isCommute()
    {
        return getBoolean("Commute");
    }
    public void setCommute(boolean item)
    {
        setBoolean("Commute", item);
    }
    /**
     * Object:��¼'s ҹ��property 
     */
    public boolean isNightwork()
    {
        return getBoolean("nightwork");
    }
    public void setNightwork(boolean item)
    {
        setBoolean("nightwork", item);
    }
    /**
     * Object:��¼'s ���֤��property 
     */
    public String getPersonnumber()
    {
        return getString("personnumber");
    }
    public void setPersonnumber(String item)
    {
        setString("personnumber", item);
    }
    /**
     * Object:��¼'s ���۸�˰property 
     */
    public java.math.BigDecimal getPersontax()
    {
        return getBigDecimal("persontax");
    }
    public void setPersontax(java.math.BigDecimal item)
    {
        setBigDecimal("persontax", item);
    }
    /**
     * Object:��¼'s �������property 
     */
    public java.math.BigDecimal getAdjustAmount()
    {
        return getBigDecimal("adjustAmount");
    }
    public void setAdjustAmount(java.math.BigDecimal item)
    {
        setBigDecimal("adjustAmount", item);
    }
    /**
     * Object:��¼'s ������עproperty 
     */
    public String getAdjustRemarks()
    {
        return getString("adjustRemarks");
    }
    public void setAdjustRemarks(String item)
    {
        setString("adjustRemarks", item);
    }
    /**
     * Object:��¼'s ��λ����property 
     */
    public java.math.BigDecimal getPostwages()
    {
        return getBigDecimal("postwages");
    }
    public void setPostwages(java.math.BigDecimal item)
    {
        setBigDecimal("postwages", item);
    }
    /**
     * Object:��¼'s ���乤��property 
     */
    public java.math.BigDecimal getAgewages()
    {
        return getBigDecimal("agewages");
    }
    public void setAgewages(java.math.BigDecimal item)
    {
        setBigDecimal("agewages", item);
    }
    /**
     * Object:��¼'s ���ۺ����ȿ���property 
     */
    public java.math.BigDecimal getDailyevaluation()
    {
        return getBigDecimal("Dailyevaluation");
    }
    public void setDailyevaluation(java.math.BigDecimal item)
    {
        setBigDecimal("Dailyevaluation", item);
    }
    /**
     * Object:��¼'s ���ۺ����ȿ��˿۳�����property 
     */
    public java.math.BigDecimal getDailevadeduction()
    {
        return getBigDecimal("Dailevadeduction");
    }
    public void setDailevadeduction(java.math.BigDecimal item)
    {
        setBigDecimal("Dailevadeduction", item);
    }
    /**
     * Object:��¼'s ��ʱ����property 
     */
    public java.math.BigDecimal getTimewages()
    {
        return getBigDecimal("timewages");
    }
    public void setTimewages(java.math.BigDecimal item)
    {
        setBigDecimal("timewages", item);
    }
    /**
     * Object:��¼'s �Ƽ�����property 
     */
    public java.math.BigDecimal getJjgz()
    {
        return getBigDecimal("jjgz");
    }
    public void setJjgz(java.math.BigDecimal item)
    {
        setBigDecimal("jjgz", item);
    }
    /**
     * Object:��¼'s ���¹ʽ���property 
     */
    public java.math.BigDecimal getWsgjl()
    {
        return getBigDecimal("wsgjl");
    }
    public void setWsgjl(java.math.BigDecimal item)
    {
        setBigDecimal("wsgjl", item);
    }
    /**
     * Object: ��¼ 's ��λ property 
     */
    public com.kingdee.eas.basedata.org.PositionInfo getPosition()
    {
        return (com.kingdee.eas.basedata.org.PositionInfo)get("position");
    }
    public void setPosition(com.kingdee.eas.basedata.org.PositionInfo item)
    {
        put("position", item);
    }
    /**
     * Object:��¼'s �²���property 
     */
    public java.math.BigDecimal getMonthSubsidy()
    {
        return getBigDecimal("MonthSubsidy");
    }
    public void setMonthSubsidy(java.math.BigDecimal item)
    {
        setBigDecimal("MonthSubsidy", item);
    }
    /**
     * Object:��¼'s �ڼ��ղ���property 
     */
    public java.math.BigDecimal getHolidayallow()
    {
        return getBigDecimal("Holidayallow");
    }
    public void setHolidayallow(java.math.BigDecimal item)
    {
        setBigDecimal("Holidayallow", item);
    }
    /**
     * Object:��¼'s Ѻ��property 
     */
    public java.math.BigDecimal getYj()
    {
        return getBigDecimal("yj");
    }
    public void setYj(java.math.BigDecimal item)
    {
        setBigDecimal("yj", item);
    }
    /**
     * Object:��¼'s ���߲���property 
     */
    public java.math.BigDecimal getFybl()
    {
        return getBigDecimal("fybl");
    }
    public void setFybl(java.math.BigDecimal item)
    {
        setBigDecimal("fybl", item);
    }
    /**
     * Object:��¼'s ���ν���property 
     */
    public java.math.BigDecimal getBatchamount()
    {
        return getBigDecimal("batchamount");
    }
    public void setBatchamount(java.math.BigDecimal item)
    {
        setBigDecimal("batchamount", item);
    }
    /**
     * Object: ��¼ 's ���� property 
     */
    public com.kingdee.eas.custom.wages.farm.WagesFarmOrganInfo getCompany()
    {
        return (com.kingdee.eas.custom.wages.farm.WagesFarmOrganInfo)get("company");
    }
    public void setCompany(com.kingdee.eas.custom.wages.farm.WagesFarmOrganInfo item)
    {
        put("company", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A3E85C9F");
    }
}