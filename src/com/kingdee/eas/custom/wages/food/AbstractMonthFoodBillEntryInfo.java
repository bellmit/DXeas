package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMonthFoodBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMonthFoodBillEntryInfo()
    {
        this("id");
    }
    protected AbstractMonthFoodBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.custom.wages.food.MonthFoodBillInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.food.MonthFoodBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.food.MonthFoodBillInfo item)
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
     * Object:��¼'s ����property 
     */
    public java.math.BigDecimal getFullworkwages()
    {
        return getBigDecimal("fullworkwages");
    }
    public void setFullworkwages(java.math.BigDecimal item)
    {
        setBigDecimal("fullworkwages", item);
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s �Ӱ��׼property 
     */
    public java.math.BigDecimal getOvertimeD()
    {
        return getBigDecimal("overtimeD");
    }
    public void setOvertimeD(java.math.BigDecimal item)
    {
        setBigDecimal("overtimeD", item);
    }
    /**
     * Object:��¼'s ��λ����property 
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
     * Object:��¼'s ��������property 
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
     * Object:��¼'s ����֤����property 
     */
    public java.math.BigDecimal getJgzbx()
    {
        return getBigDecimal("jgzbx");
    }
    public void setJgzbx(java.math.BigDecimal item)
    {
        setBigDecimal("jgzbx", item);
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
     * Object:��¼'s ������ʧproperty 
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
     * Object:��¼'s ���¼Ʒ�����property 
     */
    public java.math.BigDecimal getByjfkh()
    {
        return getBigDecimal("byjfkh");
    }
    public void setByjfkh(java.math.BigDecimal item)
    {
        setBigDecimal("byjfkh", item);
    }
    /**
     * Object:��¼'s �ڼ��ղ���property 
     */
    public java.math.BigDecimal getJjrbz()
    {
        return getBigDecimal("jjrbz");
    }
    public void setJjrbz(java.math.BigDecimal item)
    {
        setBigDecimal("jjrbz", item);
    }
    /**
     * Object:��¼'s ��λ����property 
     */
    public java.math.BigDecimal getPostSalary()
    {
        return getBigDecimal("PostSalary");
    }
    public void setPostSalary(java.math.BigDecimal item)
    {
        setBigDecimal("PostSalary", item);
    }
    /**
     * Object:��¼'s ��λ����property 
     */
    public java.math.BigDecimal getPostattendance()
    {
        return getBigDecimal("Postattendance");
    }
    public void setPostattendance(java.math.BigDecimal item)
    {
        setBigDecimal("Postattendance", item);
    }
    /**
     * Object:��¼'s �۳�������ʵ��property 
     */
    public java.math.BigDecimal getDeAccident()
    {
        return getBigDecimal("deAccident");
    }
    public void setDeAccident(java.math.BigDecimal item)
    {
        setBigDecimal("deAccident", item);
    }
    /**
     * Object:��¼'s ��������֤ʵ��property 
     */
    public java.math.BigDecimal getBhjkzsf()
    {
        return getBigDecimal("bhjkzsf");
    }
    public void setBhjkzsf(java.math.BigDecimal item)
    {
        setBigDecimal("bhjkzsf", item);
    }
    /**
     * Object:��¼'s �ν�property 
     */
    public java.math.BigDecimal getAwards()
    {
        return getBigDecimal("Awards");
    }
    public void setAwards(java.math.BigDecimal item)
    {
        setBigDecimal("Awards", item);
    }
    /**
     * Object:��¼'s �Ӱ๤��property 
     */
    public java.math.BigDecimal getOverdayamount()
    {
        return getBigDecimal("overdayamount");
    }
    public void setOverdayamount(java.math.BigDecimal item)
    {
        setBigDecimal("overdayamount", item);
    }
    /**
     * Object:��¼'s ���ڱ���property 
     */
    public java.math.BigDecimal getAttendanceratio()
    {
        return getBigDecimal("Attendanceratio");
    }
    public void setAttendanceratio(java.math.BigDecimal item)
    {
        setBigDecimal("Attendanceratio", item);
    }
    /**
     * Object:��¼'s �Ӱ�����property 
     */
    public java.math.BigDecimal getOverday()
    {
        return getBigDecimal("overday");
    }
    public void setOverday(java.math.BigDecimal item)
    {
        setBigDecimal("overday", item);
    }
    /**
     * Object: ��¼ 's ��λ property 
     */
    public com.kingdee.eas.custom.wages.food.BasicPostFoodInfo getPost()
    {
        return (com.kingdee.eas.custom.wages.food.BasicPostFoodInfo)get("post");
    }
    public void setPost(com.kingdee.eas.custom.wages.food.BasicPostFoodInfo item)
    {
        put("post", item);
    }
    /**
     * Object: ��¼ 's �������� property 
     */
    public com.kingdee.eas.custom.wages.food.WageFoodOrganInfo getFromgroup()
    {
        return (com.kingdee.eas.custom.wages.food.WageFoodOrganInfo)get("fromgroup");
    }
    public void setFromgroup(com.kingdee.eas.custom.wages.food.WageFoodOrganInfo item)
    {
        put("fromgroup", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getBasicattendance()
    {
        return getBigDecimal("basicattendance");
    }
    public void setBasicattendance(java.math.BigDecimal item)
    {
        setBigDecimal("basicattendance", item);
    }
    /**
     * Object:��¼'s ���ڹ���property 
     */
    public java.math.BigDecimal getFullwages()
    {
        return getBigDecimal("fullwages");
    }
    public void setFullwages(java.math.BigDecimal item)
    {
        setBigDecimal("fullwages", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getStandardAward()
    {
        return getBigDecimal("StandardAward");
    }
    public void setStandardAward(java.math.BigDecimal item)
    {
        setBigDecimal("StandardAward", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("08A1F3CF");
    }
}