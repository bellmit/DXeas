package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWageOrganizationInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractWageOrganizationInfo()
    {
        this("id");
    }
    protected AbstractWageOrganizationInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 工资系统组织架构 's 组别 property 
     */
    public com.kingdee.eas.custom.wages.WageOrganizationTreeInfo getTreeid()
    {
        return (com.kingdee.eas.custom.wages.WageOrganizationTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.custom.wages.WageOrganizationTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:工资系统组织架构's 应出勤天数property 
     */
    public int getAttendanceDay()
    {
        return getInt("AttendanceDay");
    }
    public void setAttendanceDay(int item)
    {
        setInt("AttendanceDay", item);
    }
    /**
     * Object:工资系统组织架构's 温差补贴标准property 
     */
    public java.math.BigDecimal getTemAllowance()
    {
        return getBigDecimal("TemAllowance");
    }
    public void setTemAllowance(java.math.BigDecimal item)
    {
        setBigDecimal("TemAllowance", item);
    }
    /**
     * Object:工资系统组织架构's 夜班补贴标准property 
     */
    public java.math.BigDecimal getNightAllowance()
    {
        return getBigDecimal("NightAllowance");
    }
    public void setNightAllowance(java.math.BigDecimal item)
    {
        setBigDecimal("NightAllowance", item);
    }
    /**
     * Object:工资系统组织架构's 加班补贴（小时）标准property 
     */
    public java.math.BigDecimal getOverTimeH()
    {
        return getBigDecimal("OverTimeH");
    }
    public void setOverTimeH(java.math.BigDecimal item)
    {
        setBigDecimal("OverTimeH", item);
    }
    /**
     * Object:工资系统组织架构's 加班补贴（天）property 
     */
    public java.math.BigDecimal getOverTimeD()
    {
        return getBigDecimal("OverTimeD");
    }
    public void setOverTimeD(java.math.BigDecimal item)
    {
        setBigDecimal("OverTimeD", item);
    }
    /**
     * Object: 工资系统组织架构 's 班组长 property 
     */
    public com.kingdee.eas.basedata.person.PersonInfo getForemanname()
    {
        return (com.kingdee.eas.basedata.person.PersonInfo)get("Foremanname");
    }
    public void setForemanname(com.kingdee.eas.basedata.person.PersonInfo item)
    {
        put("Foremanname", item);
    }
    /**
     * Object:工资系统组织架构's 资料状态property 
     */
    public com.kingdee.eas.custom.wages.BasicStatus getBasestatus()
    {
        return com.kingdee.eas.custom.wages.BasicStatus.getEnum(getString("basestatus"));
    }
    public void setBasestatus(com.kingdee.eas.custom.wages.BasicStatus item)
    {
		if (item != null) {
        setString("basestatus", item.getValue());
		}
    }
    /**
     * Object:工资系统组织架构's 生活补助property 
     */
    public java.math.BigDecimal getLifeSubsidy()
    {
        return getBigDecimal("lifeSubsidy");
    }
    public void setLifeSubsidy(java.math.BigDecimal item)
    {
        setBigDecimal("lifeSubsidy", item);
    }
    /**
     * Object:工资系统组织架构's 全勤补助property 
     */
    public java.math.BigDecimal getAttendance()
    {
        return getBigDecimal("attendance");
    }
    public void setAttendance(java.math.BigDecimal item)
    {
        setBigDecimal("attendance", item);
    }
    /**
     * Object: 工资系统组织架构 's 公司 property 
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
     * Object:工资系统组织架构's 是否按天计算全勤property 
     */
    public boolean isOneDay()
    {
        return getBoolean("oneDay");
    }
    public void setOneDay(boolean item)
    {
        setBoolean("oneDay", item);
    }
    /**
     * Object:工资系统组织架构's 雇主责任险property 
     */
    public java.math.BigDecimal getEmployerInsur()
    {
        return getBigDecimal("EmployerInsur");
    }
    public void setEmployerInsur(java.math.BigDecimal item)
    {
        setBigDecimal("EmployerInsur", item);
    }
    /**
     * Object:工资系统组织架构's 五险property 
     */
    public java.math.BigDecimal getFiverisks()
    {
        return getBigDecimal("Fiverisks");
    }
    public void setFiverisks(java.math.BigDecimal item)
    {
        setBigDecimal("Fiverisks", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("41E4A283");
    }
}