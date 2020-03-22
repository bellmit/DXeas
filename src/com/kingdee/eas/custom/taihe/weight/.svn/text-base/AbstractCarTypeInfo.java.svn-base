package com.kingdee.eas.custom.taihe.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarTypeInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractCarTypeInfo()
    {
        this("id");
    }
    protected AbstractCarTypeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:车辆类型's 保底吨位property 
     */
    public java.math.BigDecimal getLowTon()
    {
        return getBigDecimal("lowTon");
    }
    public void setLowTon(java.math.BigDecimal item)
    {
        setBigDecimal("lowTon", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2AFECA38");
    }
}