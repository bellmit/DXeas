package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQuitWagesBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractQuitWagesBillEntryInfo()
    {
        this("id");
    }
    protected AbstractQuitWagesBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��ְ���ʷ�¼ 's null property 
     */
    public com.kingdee.eas.custom.wages.QuitWagesBillInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.QuitWagesBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.QuitWagesBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��ְ���ʷ�¼'s ��������>=property 
     */
    public int getAttendanceDD()
    {
        return getInt("attendanceDD");
    }
    public void setAttendanceDD(int item)
    {
        setInt("attendanceDD", item);
    }
    /**
     * Object:��ְ���ʷ�¼'s ��������<=property 
     */
    public int getAttendanceDX()
    {
        return getInt("AttendanceDX");
    }
    public void setAttendanceDX(int item)
    {
        setInt("AttendanceDX", item);
    }
    /**
     * Object:��ְ���ʷ�¼'s Ӧ�۹���property 
     */
    public java.math.BigDecimal getDeductibleWages()
    {
        return getBigDecimal("deductibleWages");
    }
    public void setDeductibleWages(java.math.BigDecimal item)
    {
        setBigDecimal("deductibleWages", item);
    }
    /**
     * Object:��ְ���ʷ�¼'s �չ���property 
     */
    public java.math.BigDecimal getDayWages()
    {
        return getBigDecimal("dayWages");
    }
    public void setDayWages(java.math.BigDecimal item)
    {
        setBigDecimal("dayWages", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1F3D32D7");
    }
}