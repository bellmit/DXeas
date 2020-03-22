package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAttendanceDockingEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAttendanceDockingEntryInfo()
    {
        this("id");
    }
    protected AbstractAttendanceDockingEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 考勤对接分录 's null property 
     */
    public com.kingdee.eas.custom.wages.AttendanceDockingInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.AttendanceDockingInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.AttendanceDockingInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 考勤对接分录 's EAS职员 property 
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
     * Object:考勤对接分录's 员工编码property 
     */
    public String getPersonNum()
    {
        return getString("personNum");
    }
    public void setPersonNum(String item)
    {
        setString("personNum", item);
    }
    /**
     * Object:考勤对接分录's 员工姓名property 
     */
    public String getPersonName()
    {
        return getString("personName");
    }
    public void setPersonName(String item)
    {
        setString("personName", item);
    }
    /**
     * Object:考勤对接分录's 打卡时间property 
     */
    public java.util.Date getPunchCardTime()
    {
        return getDate("punchCardTime");
    }
    public void setPunchCardTime(java.util.Date item)
    {
        setDate("punchCardTime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("22FAA474");
    }
}