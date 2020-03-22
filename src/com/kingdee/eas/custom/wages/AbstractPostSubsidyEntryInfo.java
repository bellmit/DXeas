package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPostSubsidyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPostSubsidyEntryInfo()
    {
        this("id");
    }
    protected AbstractPostSubsidyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 岗位补助分录 's null property 
     */
    public com.kingdee.eas.custom.wages.PostSubsidyInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.PostSubsidyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.PostSubsidyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 岗位补助分录 's 员工编码 property 
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
     * Object:岗位补助分录's 员工姓名property 
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
     * Object:岗位补助分录's 计提开始月份旧property 
     */
    public java.util.Date getStartMonth()
    {
        return getDate("startMonth");
    }
    public void setStartMonth(java.util.Date item)
    {
        setDate("startMonth", item);
    }
    /**
     * Object:岗位补助分录's 计提截至月份旧property 
     */
    public java.util.Date getEndMonth()
    {
        return getDate("endMonth");
    }
    public void setEndMonth(java.util.Date item)
    {
        setDate("endMonth", item);
    }
    /**
     * Object:岗位补助分录's 计提总月份property 
     */
    public int getAllMonth()
    {
        return getInt("allMonth");
    }
    public void setAllMonth(int item)
    {
        setInt("allMonth", item);
    }
    /**
     * Object:岗位补助分录's 已计提月份旧property 
     */
    public int getAlreadyMonth()
    {
        return getInt("AlreadyMonth");
    }
    public void setAlreadyMonth(int item)
    {
        setInt("AlreadyMonth", item);
    }
    /**
     * Object:岗位补助分录's 已计提金额property 
     */
    public java.math.BigDecimal getAlreadyMoney()
    {
        return getBigDecimal("AlreadyMoney");
    }
    public void setAlreadyMoney(java.math.BigDecimal item)
    {
        setBigDecimal("AlreadyMoney", item);
    }
    /**
     * Object:岗位补助分录's 计提总金额property 
     */
    public java.math.BigDecimal getAllMoney()
    {
        return getBigDecimal("allMoney");
    }
    public void setAllMoney(java.math.BigDecimal item)
    {
        setBigDecimal("allMoney", item);
    }
    /**
     * Object: 岗位补助分录 's 员工岗位 property 
     */
    public com.kingdee.eas.custom.wages.BasicPostInfo getPsersonpost()
    {
        return (com.kingdee.eas.custom.wages.BasicPostInfo)get("psersonpost");
    }
    public void setPsersonpost(com.kingdee.eas.custom.wages.BasicPostInfo item)
    {
        put("psersonpost", item);
    }
    /**
     * Object:岗位补助分录's 本月计提金额property 
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
     * Object:岗位补助分录's 开始计提月份property 
     */
    public String getStartMonthN()
    {
        return getString("startMonthN");
    }
    public void setStartMonthN(String item)
    {
        setString("startMonthN", item);
    }
    /**
     * Object:岗位补助分录's 截至计提月份property 
     */
    public String getEndMonthN()
    {
        return getString("endMonthN");
    }
    public void setEndMonthN(String item)
    {
        setString("endMonthN", item);
    }
    /**
     * Object:岗位补助分录's 已计提月份property 
     */
    public String getAlreadyMonthN()
    {
        return getString("AlreadyMonthN");
    }
    public void setAlreadyMonthN(String item)
    {
        setString("AlreadyMonthN", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("02A8784F");
    }
}