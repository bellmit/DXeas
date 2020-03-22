package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTAttendanceRecordsEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTAttendanceRecordsEntryInfo()
    {
        this("id");
    }
    protected AbstractTAttendanceRecordsEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.food.TAttendanceRecordsInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.food.TAttendanceRecordsInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.food.TAttendanceRecordsInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 员工 property 
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
     * Object:分录's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:分录's 应出勤天数property 
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
     * Object:分录's 实际出勤天数property 
     */
    public java.math.BigDecimal getActualattendance()
    {
        return getBigDecimal("actualattendance");
    }
    public void setActualattendance(java.math.BigDecimal item)
    {
        setBigDecimal("actualattendance", item);
    }
    /**
     * Object:分录's 迟到、早退时数property 
     */
    public java.math.BigDecimal getLate()
    {
        return getBigDecimal("Late");
    }
    public void setLate(java.math.BigDecimal item)
    {
        setBigDecimal("Late", item);
    }
    /**
     * Object:分录's 事假天数property 
     */
    public String getPrivite()
    {
        return getString("privite");
    }
    public void setPrivite(String item)
    {
        setString("privite", item);
    }
    /**
     * Object:分录's 病假天数property 
     */
    public java.math.BigDecimal getSickleave()
    {
        return getBigDecimal("sickleave");
    }
    public void setSickleave(java.math.BigDecimal item)
    {
        setBigDecimal("sickleave", item);
    }
    /**
     * Object:分录's 未签到、签退次数property 
     */
    public java.math.BigDecimal getNosign()
    {
        return getBigDecimal("nosign");
    }
    public void setNosign(java.math.BigDecimal item)
    {
        setBigDecimal("nosign", item);
    }
    /**
     * Object:分录's 违反制度处罚金额property 
     */
    public java.math.BigDecimal getViolation()
    {
        return getBigDecimal("violation");
    }
    public void setViolation(java.math.BigDecimal item)
    {
        setBigDecimal("violation", item);
    }
    /**
     * Object:分录's 出差天数property 
     */
    public java.math.BigDecimal getBusinesstravel()
    {
        return getBigDecimal("businesstravel");
    }
    public void setBusinesstravel(java.math.BigDecimal item)
    {
        setBigDecimal("businesstravel", item);
    }
    /**
     * Object:分录's 员工编码property 
     */
    public String getPersonnumber()
    {
        return getString("personnumber");
    }
    public void setPersonnumber(String item)
    {
        setString("personnumber", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6C627B2B");
    }
}