package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFractionOtherBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFractionOtherBillEntryInfo()
    {
        this("id");
    }
    protected AbstractFractionOtherBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.wages.FractionOtherBillInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.FractionOtherBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.FractionOtherBillInfo item)
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
     * Object:分录's 分数property 
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
     * Object:分录's 备注property 
     */
    public String getRemark()
    {
        return getString("Remark");
    }
    public void setRemark(String item)
    {
        setString("Remark", item);
    }
    /**
     * Object:分录's 分数工资property 
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
     * Object: 分录 's 岗位 property 
     */
    public com.kingdee.eas.custom.wages.BasicPostInfo getPersonPost()
    {
        return (com.kingdee.eas.custom.wages.BasicPostInfo)get("personPost");
    }
    public void setPersonPost(com.kingdee.eas.custom.wages.BasicPostInfo item)
    {
        put("personPost", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2B3DFC25");
    }
}