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
     * Object: 岗位人员 's null property 
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
     * Object: 岗位人员 's 员工 property 
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
     * Object:岗位人员's 月考核项目property 
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
     * Object:岗位人员's 考核数值property 
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
     * Object:岗位人员's 达标奖励property 
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
     * Object:岗位人员's 考核单位property 
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
     * Object:岗位人员's 单位指标property 
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
     * Object:岗位人员's 员工编码property 
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
     * Object:岗位人员's 考核指标property 
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