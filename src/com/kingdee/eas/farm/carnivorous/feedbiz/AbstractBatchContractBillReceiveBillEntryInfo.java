package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBatchContractBillReceiveBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractBatchContractBillReceiveBillEntryInfo()
    {
        this("id");
    }
    protected AbstractBatchContractBillReceiveBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 收款明细 's null property 
     */
    public com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo getParent()
    {
        return (com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.carnivorous.feedbiz.BatchContractBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 收款明细 's 收款单编码 property 
     */
    public com.kingdee.eas.fi.cas.ReceivingBillInfo getReceiveBill()
    {
        return (com.kingdee.eas.fi.cas.ReceivingBillInfo)get("receiveBill");
    }
    public void setReceiveBill(com.kingdee.eas.fi.cas.ReceivingBillInfo item)
    {
        put("receiveBill", item);
    }
    /**
     * Object:收款明细's 收款金额property 
     */
    public java.math.BigDecimal getReceiveAmount()
    {
        return getBigDecimal("receiveAmount");
    }
    public void setReceiveAmount(java.math.BigDecimal item)
    {
        setBigDecimal("receiveAmount", item);
    }
    /**
     * Object:收款明细's 业务日期property 
     */
    public java.util.Date getReceiveBizDate()
    {
        return getDate("receiveBizDate");
    }
    public void setReceiveBizDate(java.util.Date item)
    {
        setDate("receiveBizDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("2B4021D7");
    }
}