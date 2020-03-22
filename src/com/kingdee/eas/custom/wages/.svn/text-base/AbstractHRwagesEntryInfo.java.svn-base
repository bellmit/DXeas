package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHRwagesEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHRwagesEntryInfo()
    {
        this("id");
    }
    protected AbstractHRwagesEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.HRwagesInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.HRwagesInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.HRwagesInfo item)
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
    /**
     * Object:分录's 招聘奖励property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
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
     * Object:分录's 健康证报销property 
     */
    public java.math.BigDecimal getHealthCar()
    {
        return getBigDecimal("healthCar");
    }
    public void setHealthCar(java.math.BigDecimal item)
    {
        setBigDecimal("healthCar", item);
    }
    /**
     * Object:分录's 是否通勤property 
     */
    public boolean isIsCommute()
    {
        return getBoolean("IsCommute");
    }
    public void setIsCommute(boolean item)
    {
        setBoolean("IsCommute", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A9767B59");
    }
}