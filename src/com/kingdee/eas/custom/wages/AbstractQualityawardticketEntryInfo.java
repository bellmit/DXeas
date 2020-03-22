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
     * Object: ��¼ 's ����ͷ property 
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
     * Object: ��¼ 's Ա�� property 
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
     * Object:��¼'s Ա������property 
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
     * Object:��¼'s �������property 
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
     * Object:��¼'s ��������property 
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
     * Object: ��¼ 's �������� property 
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