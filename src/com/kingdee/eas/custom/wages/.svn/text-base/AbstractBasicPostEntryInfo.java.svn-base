package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBasicPostEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBasicPostEntryInfo()
    {
        this("id");
    }
    protected AbstractBasicPostEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.custom.wages.BasicPostInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.BasicPostInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.BasicPostInfo item)
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
     * Object:分录's 分值property 
     */
    public java.math.BigDecimal getScore()
    {
        return getBigDecimal("score");
    }
    public void setScore(java.math.BigDecimal item)
    {
        setBigDecimal("score", item);
    }
    /**
     * Object:分录's 银行卡号property 
     */
    public String getBankcar()
    {
        return getString("bankcar");
    }
    public void setBankcar(String item)
    {
        setString("bankcar", item);
    }
    /**
     * Object:分录's 身份证号property 
     */
    public String getIdcard()
    {
        return getString("idcard");
    }
    public void setIdcard(String item)
    {
        setString("idcard", item);
    }
    /**
     * Object:分录's 手机号property 
     */
    public String getPhonenumber()
    {
        return getString("phonenumber");
    }
    public void setPhonenumber(String item)
    {
        setString("phonenumber", item);
    }
    /**
     * Object:分录's 是否离职property 
     */
    public boolean isIsQuit()
    {
        return getBoolean("isQuit");
    }
    public void setIsQuit(boolean item)
    {
        setBoolean("isQuit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("4B5AB12C");
    }
}