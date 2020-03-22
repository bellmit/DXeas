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
     * Object: ��¼ 's ����ͷ property 
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
     * Object:��¼'s �������property 
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
     * Object:��¼'s ԭ��property 
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
     * Object:��¼'s ��������property 
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