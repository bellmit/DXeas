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
     * Object: ��ϸ��Ϣ 's null property 
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
     * Object:��ϸ��Ϣ's ë������property 
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
     * Object:��ϸ��Ϣ's ��ϸʱ��property 
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
     * Object:��ϸ��Ϣ's Ƥ������property 
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