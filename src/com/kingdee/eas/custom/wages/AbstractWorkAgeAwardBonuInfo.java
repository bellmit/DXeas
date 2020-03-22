package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkAgeAwardBonuInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractWorkAgeAwardBonuInfo()
    {
        this("id");
    }
    protected AbstractWorkAgeAwardBonuInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 奖金标准 's null property 
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
     * Object:奖金标准's 执行标准(元/月)property 
     */
    public java.math.BigDecimal getStandard()
    {
        return getBigDecimal("standard");
    }
    public void setStandard(java.math.BigDecimal item)
    {
        setBigDecimal("standard", item);
    }
    /**
     * Object:奖金标准's 工龄月份小于property 
     */
    public java.math.BigDecimal getWorkX()
    {
        return getBigDecimal("workX");
    }
    public void setWorkX(java.math.BigDecimal item)
    {
        setBigDecimal("workX", item);
    }
    /**
     * Object:奖金标准's 工龄月份大于property 
     */
    public java.math.BigDecimal getWorkD()
    {
        return getBigDecimal("workD");
    }
    public void setWorkD(java.math.BigDecimal item)
    {
        setBigDecimal("workD", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("26F85E4B");
    }
}