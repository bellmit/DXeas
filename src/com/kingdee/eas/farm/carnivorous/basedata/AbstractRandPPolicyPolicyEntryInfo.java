package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRandPPolicyPolicyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractRandPPolicyPolicyEntryInfo()
    {
        this("id");
    }
    protected AbstractRandPPolicyPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 政策分录 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.basedata.RandPPolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:政策分录's 下限property 
     */
    public java.math.BigDecimal getFloor()
    {
        return getBigDecimal("floor");
    }
    public void setFloor(java.math.BigDecimal item)
    {
        setBigDecimal("floor", item);
    }
    /**
     * Object:政策分录's 上限property 
     */
    public java.math.BigDecimal getUpper()
    {
        return getBigDecimal("upper");
    }
    public void setUpper(java.math.BigDecimal item)
    {
        setBigDecimal("upper", item);
    }
    /**
     * Object:政策分录's 增减值property 
     */
    public java.math.BigDecimal getDiff()
    {
        return getBigDecimal("diff");
    }
    public void setDiff(java.math.BigDecimal item)
    {
        setBigDecimal("diff", item);
    }
    /**
     * Object:政策分录's 实际价格property 
     */
    public java.math.BigDecimal getCalValue()
    {
        return getBigDecimal("calValue");
    }
    public void setCalValue(java.math.BigDecimal item)
    {
        setBigDecimal("calValue", item);
    }
    /**
     * Object:政策分录's 变动系数property 
     */
    public java.math.BigDecimal getDiffCoeff()
    {
        return getBigDecimal("diffCoeff");
    }
    public void setDiffCoeff(java.math.BigDecimal item)
    {
        setBigDecimal("diffCoeff", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8F1DB465");
    }
}