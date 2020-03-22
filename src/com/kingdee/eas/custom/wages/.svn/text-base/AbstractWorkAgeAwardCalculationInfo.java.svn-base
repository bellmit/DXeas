package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkAgeAwardCalculationInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractWorkAgeAwardCalculationInfo()
    {
        this("id");
    }
    protected AbstractWorkAgeAwardCalculationInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 计算方法 's null property 
     */
    public com.kingdee.eas.custom.wages.WorkAgeAwardInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.WorkAgeAwardInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.WorkAgeAwardInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:计算方法's 出勤天数>=property 
     */
    public java.math.BigDecimal getDaysD()
    {
        return getBigDecimal("daysD");
    }
    public void setDaysD(java.math.BigDecimal item)
    {
        setBigDecimal("daysD", item);
    }
    /**
     * Object:计算方法's 出勤天数<=property 
     */
    public java.math.BigDecimal getDaysX()
    {
        return getBigDecimal("daysX");
    }
    public void setDaysX(java.math.BigDecimal item)
    {
        setBigDecimal("daysX", item);
    }
    /**
     * Object:计算方法's 工龄奖计算方法(工龄奖*N%)property 
     */
    public java.math.BigDecimal getPercentage()
    {
        return getBigDecimal("percentage");
    }
    public void setPercentage(java.math.BigDecimal item)
    {
        setBigDecimal("percentage", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5D0E3772");
    }
}