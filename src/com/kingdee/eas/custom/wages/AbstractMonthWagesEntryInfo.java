package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMonthWagesEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMonthWagesEntryInfo()
    {
        this("id");
    }
    protected AbstractMonthWagesEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 工资计算单分录 's null property 
     */
    public com.kingdee.eas.custom.wages.MonthWagesInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.MonthWagesInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.MonthWagesInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 工资计算单分录 's 员工编码 property 
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
     * Object:工资计算单分录's 员工姓名property 
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
     * Object: 工资计算单分录 's 员工岗位 property 
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
     * Object:工资计算单分录's 分数工资property 
     */
    public java.math.BigDecimal getFractionWages()
    {
        return getBigDecimal("fractionWages");
    }
    public void setFractionWages(java.math.BigDecimal item)
    {
        setBigDecimal("fractionWages", item);
    }
    /**
     * Object:工资计算单分录's 计件工资property 
     */
    public java.math.BigDecimal getBythejobWages()
    {
        return getBigDecimal("bythejobWages");
    }
    public void setBythejobWages(java.math.BigDecimal item)
    {
        setBigDecimal("bythejobWages", item);
    }
    /**
     * Object:工资计算单分录's 工龄奖property 
     */
    public java.math.BigDecimal getSeniorityWages()
    {
        return getBigDecimal("seniorityWages");
    }
    public void setSeniorityWages(java.math.BigDecimal item)
    {
        setBigDecimal("seniorityWages", item);
    }
    /**
     * Object:工资计算单分录's 奖罚工资property 
     */
    public java.math.BigDecimal getSanctionWages()
    {
        return getBigDecimal("sanctionWages");
    }
    public void setSanctionWages(java.math.BigDecimal item)
    {
        setBigDecimal("sanctionWages", item);
    }
    /**
     * Object:工资计算单分录's 全勤补助property 
     */
    public java.math.BigDecimal getAttendanceWages()
    {
        return getBigDecimal("attendanceWages");
    }
    public void setAttendanceWages(java.math.BigDecimal item)
    {
        setBigDecimal("attendanceWages", item);
    }
    /**
     * Object:工资计算单分录's 生活补助property 
     */
    public java.math.BigDecimal getLifeWages()
    {
        return getBigDecimal("lifeWages");
    }
    public void setLifeWages(java.math.BigDecimal item)
    {
        setBigDecimal("lifeWages", item);
    }
    /**
     * Object:工资计算单分录's 岗位补助property 
     */
    public java.math.BigDecimal getPostWages()
    {
        return getBigDecimal("postWages");
    }
    public void setPostWages(java.math.BigDecimal item)
    {
        setBigDecimal("postWages", item);
    }
    /**
     * Object:工资计算单分录's 介绍费property 
     */
    public java.math.BigDecimal getIntroduceWages()
    {
        return getBigDecimal("introduceWages");
    }
    public void setIntroduceWages(java.math.BigDecimal item)
    {
        setBigDecimal("introduceWages", item);
    }
    /**
     * Object:工资计算单分录's 调整工资property 
     */
    public java.math.BigDecimal getAdjustmentWages()
    {
        return getBigDecimal("adjustmentWages");
    }
    public void setAdjustmentWages(java.math.BigDecimal item)
    {
        setBigDecimal("adjustmentWages", item);
    }
    /**
     * Object:工资计算单分录's 总工资property 
     */
    public java.math.BigDecimal getAllWags()
    {
        return getBigDecimal("allWags");
    }
    public void setAllWags(java.math.BigDecimal item)
    {
        setBigDecimal("allWags", item);
    }
    /**
     * Object:工资计算单分录's 当月分数property 
     */
    public java.math.BigDecimal getFractionQty()
    {
        return getBigDecimal("fractionQty");
    }
    public void setFractionQty(java.math.BigDecimal item)
    {
        setBigDecimal("fractionQty", item);
    }
    /**
     * Object:工资计算单分录's 基本工资property 
     */
    public java.math.BigDecimal getBasicWages()
    {
        return getBigDecimal("basicWages");
    }
    public void setBasicWages(java.math.BigDecimal item)
    {
        setBigDecimal("basicWages", item);
    }
    /**
     * Object:工资计算单分录's 银行卡号property 
     */
    public String getBankCard()
    {
        return getString("BankCard");
    }
    public void setBankCard(String item)
    {
        setString("BankCard", item);
    }
    /**
     * Object:工资计算单分录's 身份证号property 
     */
    public String getIDCard()
    {
        return getString("IDCard");
    }
    public void setIDCard(String item)
    {
        setString("IDCard", item);
    }
    /**
     * Object:工资计算单分录's 手机号码property 
     */
    public String getPhoneNumber()
    {
        return getString("PhoneNumber");
    }
    public void setPhoneNumber(String item)
    {
        setString("PhoneNumber", item);
    }
    /**
     * Object:工资计算单分录's 出勤天数property 
     */
    public java.math.BigDecimal getWorkDay()
    {
        return getBigDecimal("workDay");
    }
    public void setWorkDay(java.math.BigDecimal item)
    {
        setBigDecimal("workDay", item);
    }
    /**
     * Object: 工资计算单分录 's 所属班组 property 
     */
    public com.kingdee.eas.custom.wages.WageOrganizationInfo getTheGroup()
    {
        return (com.kingdee.eas.custom.wages.WageOrganizationInfo)get("theGroup");
    }
    public void setTheGroup(com.kingdee.eas.custom.wages.WageOrganizationInfo item)
    {
        put("theGroup", item);
    }
    /**
     * Object:工资计算单分录's 员工入职时间property 
     */
    public java.util.Date getInDate()
    {
        return getDate("inDate");
    }
    public void setInDate(java.util.Date item)
    {
        setDate("inDate", item);
    }
    /**
     * Object:工资计算单分录's 雇主责任险property 
     */
    public java.math.BigDecimal getEmployerInsurance()
    {
        return getBigDecimal("EmployerInsurance");
    }
    public void setEmployerInsurance(java.math.BigDecimal item)
    {
        setBigDecimal("EmployerInsurance", item);
    }
    /**
     * Object:工资计算单分录's 个人所得税property 
     */
    public java.math.BigDecimal getPersonTax()
    {
        return getBigDecimal("PersonTax");
    }
    public void setPersonTax(java.math.BigDecimal item)
    {
        setBigDecimal("PersonTax", item);
    }
    /**
     * Object:工资计算单分录's 实发工资property 
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
     * Object:工资计算单分录's 福利费property 
     */
    public java.math.BigDecimal getWelfare()
    {
        return getBigDecimal("Welfare");
    }
    public void setWelfare(java.math.BigDecimal item)
    {
        setBigDecimal("Welfare", item);
    }
    /**
     * Object: 工资计算单分录 's 用工性质 property 
     */
    public com.kingdee.eas.hr.base.EmployeePropertInfo getWorknature()
    {
        return (com.kingdee.eas.hr.base.EmployeePropertInfo)get("worknature");
    }
    public void setWorknature(com.kingdee.eas.hr.base.EmployeePropertInfo item)
    {
        put("worknature", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D1876C7F");
    }
}