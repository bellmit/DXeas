package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSocialwelfareEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSocialwelfareEntryInfo()
    {
        this("id");
    }
    protected AbstractSocialwelfareEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.SocialwelfareInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.SocialwelfareInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.SocialwelfareInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 员工编码 property 
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
     * Object:分录's 员工姓名property 
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
     * Object:分录's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("Amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("Amount", item);
    }
    /**
     * Object: 分录 's 补贴种类 property 
     */
    public com.kingdee.eas.custom.wages.WelfarecategoryInfo getSubsidy()
    {
        return (com.kingdee.eas.custom.wages.WelfarecategoryInfo)get("subsidy");
    }
    public void setSubsidy(com.kingdee.eas.custom.wages.WelfarecategoryInfo item)
    {
        put("subsidy", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("49FA113B");
    }
}