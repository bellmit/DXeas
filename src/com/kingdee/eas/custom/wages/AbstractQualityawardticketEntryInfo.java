package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractQualityawardticketEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractQualityawardticketEntryInfo()
    {
        this("id");
    }
    protected AbstractQualityawardticketEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.QualityawardticketInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.QualityawardticketInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.QualityawardticketInfo item)
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
     * Object:分录's 奖罚金额property 
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
     * Object:分录's 奖罚是由property 
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
     * Object: 分录 's 奖罚事由 property 
     */
    public com.kingdee.eas.custom.wages.AdjustCauseInfo getAdjustCause()
    {
        return (com.kingdee.eas.custom.wages.AdjustCauseInfo)get("AdjustCause");
    }
    public void setAdjustCause(com.kingdee.eas.custom.wages.AdjustCauseInfo item)
    {
        put("AdjustCause", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5E728C40");
    }
}