package com.kingdee.eas.custom.dx.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarSendBillEntrysSInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCarSendBillEntrysSInfo()
    {
        this("id");
    }
    protected AbstractCarSendBillEntrysSInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 详细信息 's null property 
     */
    public com.kingdee.eas.custom.dx.weight.CarSendBillInfo getParent()
    {
        return (com.kingdee.eas.custom.dx.weight.CarSendBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.dx.weight.CarSendBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:详细信息's 毛重重量property 
     */
    public java.math.BigDecimal getDweight()
    {
        return getBigDecimal("Dweight");
    }
    public void setDweight(java.math.BigDecimal item)
    {
        setBigDecimal("Dweight", item);
    }
    /**
     * Object:详细信息's 详细时间property 
     */
    public java.util.Date getDtime()
    {
        return getDate("Dtime");
    }
    public void setDtime(java.util.Date item)
    {
        setDate("Dtime", item);
    }
    /**
     * Object:详细信息's 皮重重量property 
     */
    public java.math.BigDecimal getPweight()
    {
        return getBigDecimal("Pweight");
    }
    public void setPweight(java.math.BigDecimal item)
    {
        setBigDecimal("Pweight", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F3395E70");
    }
}