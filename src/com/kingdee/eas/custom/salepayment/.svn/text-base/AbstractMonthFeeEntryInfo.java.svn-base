package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMonthFeeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMonthFeeEntryInfo()
    {
        this("id");
    }
    protected AbstractMonthFeeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.salepayment.MonthFeeInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.MonthFeeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.MonthFeeInfo item)
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
    /**
     * Object:分录's 是否分摊生成property 
     */
    public boolean isIsShared()
    {
        return getBoolean("isShared");
    }
    public void setIsShared(boolean item)
    {
        setBoolean("isShared", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A1CF74B8");
    }
}