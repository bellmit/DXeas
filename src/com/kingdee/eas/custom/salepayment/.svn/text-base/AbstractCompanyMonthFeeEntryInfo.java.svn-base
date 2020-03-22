package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCompanyMonthFeeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCompanyMonthFeeEntryInfo()
    {
        this("id");
    }
    protected AbstractCompanyMonthFeeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.salepayment.CompanyMonthFeeInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.CompanyMonthFeeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.CompanyMonthFeeInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 费用类型 property 
     */
    public com.kingdee.eas.custom.salepayment.FeeTypeInfo getFeeType()
    {
        return (com.kingdee.eas.custom.salepayment.FeeTypeInfo)get("feeType");
    }
    public void setFeeType(com.kingdee.eas.custom.salepayment.FeeTypeInfo item)
    {
        put("feeType", item);
    }
    /**
     * Object:分录's 金额property 
     */
    public java.math.BigDecimal getAmount()
    {
        return getBigDecimal("amount");
    }
    public void setAmount(java.math.BigDecimal item)
    {
        setBigDecimal("amount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A4150AA3");
    }
}