package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCompAssessmentEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCompAssessmentEntryInfo()
    {
        this("id");
    }
    protected AbstractCompAssessmentEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 考核标准 's null property 
     */
    public com.kingdee.eas.custom.wages.food.CompAssessmentInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.food.CompAssessmentInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.food.CompAssessmentInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:考核标准's 指标上限property 
     */
    public java.math.BigDecimal getUplimit()
    {
        return getBigDecimal("uplimit");
    }
    public void setUplimit(java.math.BigDecimal item)
    {
        setBigDecimal("uplimit", item);
    }
    /**
     * Object:考核标准's 指标下限property 
     */
    public java.math.BigDecimal getDownlimit()
    {
        return getBigDecimal("downlimit");
    }
    public void setDownlimit(java.math.BigDecimal item)
    {
        setBigDecimal("downlimit", item);
    }
    /**
     * Object:考核标准's 绩效比例property 
     */
    public java.math.BigDecimal getPerforratio()
    {
        return getBigDecimal("perforratio");
    }
    public void setPerforratio(java.math.BigDecimal item)
    {
        setBigDecimal("perforratio", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("49C8AB7F");
    }
}