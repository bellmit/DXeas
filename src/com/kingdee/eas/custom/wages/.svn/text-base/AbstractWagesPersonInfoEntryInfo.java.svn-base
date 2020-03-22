package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWagesPersonInfoEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractWagesPersonInfoEntryInfo()
    {
        this("id");
    }
    protected AbstractWagesPersonInfoEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.WagesPersonInfoInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.WagesPersonInfoInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.WagesPersonInfoInfo item)
    {
        put("parent", item);
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
     * Object:分录's 入职时间property 
     */
    public java.util.Date getEnterdate()
    {
        return getDate("enterdate");
    }
    public void setEnterdate(java.util.Date item)
    {
        setDate("enterdate", item);
    }
    /**
     * Object:分录's 银行卡号property 
     */
    public String getBankcard()
    {
        return getString("bankcard");
    }
    public void setBankcard(String item)
    {
        setString("bankcard", item);
    }
    /**
     * Object:分录's 员工property 
     */
    public String getPerson()
    {
        return getString("person");
    }
    public void setPerson(String item)
    {
        setString("person", item);
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
     * Object:分录's 员工fidproperty 
     */
    public String getPersonid()
    {
        return getString("personid");
    }
    public void setPersonid(String item)
    {
        setString("personid", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B84190CC");
    }
}