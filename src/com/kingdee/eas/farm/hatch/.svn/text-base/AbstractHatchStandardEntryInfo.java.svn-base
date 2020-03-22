package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchStandardEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHatchStandardEntryInfo()
    {
        this("id");
    }
    protected AbstractHatchStandardEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 标准健母率 's null property 
     */
    public com.kingdee.eas.farm.hatch.HatchStandardInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.HatchStandardInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.HatchStandardInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:标准健母率's 周龄property 
     */
    public int getWeek()
    {
        return getInt("week");
    }
    public void setWeek(int item)
    {
        setInt("week", item);
    }
    /**
     * Object:标准健母率's 标准健母率(%)property 
     */
    public java.math.BigDecimal getRate()
    {
        return getBigDecimal("rate");
    }
    public void setRate(java.math.BigDecimal item)
    {
        setBigDecimal("rate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("686001E3");
    }
}