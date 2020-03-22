package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractAttendanceBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractAttendanceBillEntryInfo()
    {
        this("id");
    }
    protected AbstractAttendanceBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 考勤明细 's null property 
     */
    public com.kingdee.eas.custom.wages.AttendanceBillInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.AttendanceBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.AttendanceBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 考勤明细 's 员工编码 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getPersonNum()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("personNum");
    }
    public void setPersonNum(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("personNum", item);
    }
    /**
     * Object:考勤明细's 员工名称property 
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
     * Object: 考勤明细 's 员工岗位 property 
     */
    public com.kingdee.eas.custom.wages.BasicPostInfo getPersonPost()
    {
        return (com.kingdee.eas.custom.wages.BasicPostInfo)get("personPost");
    }
    public void setPersonPost(com.kingdee.eas.custom.wages.BasicPostInfo item)
    {
        put("personPost", item);
    }
    /**
     * Object:考勤明细's 工资类型property 
     */
    public com.kingdee.eas.custom.wages.wagesType getWagesType()
    {
        return com.kingdee.eas.custom.wages.wagesType.getEnum(getString("wagesType"));
    }
    public void setWagesType(com.kingdee.eas.custom.wages.wagesType item)
    {
		if (item != null) {
        setString("wagesType", item.getValue());
		}
    }
    /**
     * Object:考勤明细's 员工系数property 
     */
    public java.math.BigDecimal getPersonRatio()
    {
        return getBigDecimal("personRatio");
    }
    public void setPersonRatio(java.math.BigDecimal item)
    {
        setBigDecimal("personRatio", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5965AABA");
    }
}