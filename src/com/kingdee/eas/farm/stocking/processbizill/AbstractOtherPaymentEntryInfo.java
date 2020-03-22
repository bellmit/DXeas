package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOtherPaymentEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractOtherPaymentEntryInfo()
    {
        this("id");
    }
    protected AbstractOtherPaymentEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.stocking.processbizill.OtherPaymentInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.processbizill.OtherPaymentInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.processbizill.OtherPaymentInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 发生金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    /**
     * Object:分录's 原因property 
     */
    public String getReason()
    {
        return getString("reason");
    }
    public void setReason(String item)
    {
        setString("reason", item);
    }
    /**
     * Object:分录's 发生日期property 
     */
    public java.util.Date getOccurDate()
    {
        return getDate("occurDate");
    }
    public void setOccurDate(java.util.Date item)
    {
        setDate("occurDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2E935077");
    }
}