package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSeniorityBonusEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSeniorityBonusEntryInfo()
    {
        this("id");
    }
    protected AbstractSeniorityBonusEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ���佱��¼ 's null property 
     */
    public com.kingdee.eas.custom.wages.SeniorityBonusInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.SeniorityBonusInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.SeniorityBonusInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ���佱��¼ 's Ա������ property 
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
     * Object:���佱��¼'s Ա������property 
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
     * Object:���佱��¼'s ���佱property 
     */
    public java.math.BigDecimal getMoneys()
    {
        return getBigDecimal("moneys");
    }
    public void setMoneys(java.math.BigDecimal item)
    {
        setBigDecimal("moneys", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A8735DA9");
    }
}