package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProdasseindexEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractProdasseindexEntryInfo()
    {
        this("id");
    }
    protected AbstractProdasseindexEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��λ��Ա 's null property 
     */
    public com.kingdee.eas.custom.wages.food.ProdasseindexInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.food.ProdasseindexInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.food.ProdasseindexInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��λ��Ա 's Ա�� property 
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
     * Object:��λ��Ա's �¿�����Ŀproperty 
     */
    public String getAssessmentproject()
    {
        return getString("Assessmentproject");
    }
    public void setAssessmentproject(String item)
    {
        setString("Assessmentproject", item);
    }
    /**
     * Object:��λ��Ա's ������ֵproperty 
     */
    public java.math.BigDecimal getAssesValue()
    {
        return getBigDecimal("AssesValue");
    }
    public void setAssesValue(java.math.BigDecimal item)
    {
        setBigDecimal("AssesValue", item);
    }
    /**
     * Object:��λ��Ա's ��꽱��property 
     */
    public java.math.BigDecimal getStandardAward()
    {
        return getBigDecimal("StandardAward");
    }
    public void setStandardAward(java.math.BigDecimal item)
    {
        setBigDecimal("StandardAward", item);
    }
    /**
     * Object:��λ��Ա's ���˵�λproperty 
     */
    public java.math.BigDecimal getAssesUnit()
    {
        return getBigDecimal("AssesUnit");
    }
    public void setAssesUnit(java.math.BigDecimal item)
    {
        setBigDecimal("AssesUnit", item);
    }
    /**
     * Object:��λ��Ա's ��λָ��property 
     */
    public java.math.BigDecimal getUnitindex()
    {
        return getBigDecimal("Unitindex");
    }
    public void setUnitindex(java.math.BigDecimal item)
    {
        setBigDecimal("Unitindex", item);
    }
    /**
     * Object:��λ��Ա's Ա������property 
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
     * Object:��λ��Ա's ����ָ��property 
     */
    public String getAssessRates()
    {
        return getString("AssessRates");
    }
    public void setAssessRates(String item)
    {
        setString("AssessRates", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("75FA9B5D");
    }
}