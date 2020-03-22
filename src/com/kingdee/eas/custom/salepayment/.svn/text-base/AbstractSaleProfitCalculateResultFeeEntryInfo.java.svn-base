package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleProfitCalculateResultFeeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSaleProfitCalculateResultFeeEntryInfo()
    {
        this("id");
    }
    protected AbstractSaleProfitCalculateResultFeeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 费用分录 's null property 
     */
    public com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.SaleProfitCalculateResultInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 费用分录 's 费用类型 property 
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
     * Object:费用分录's 金额property 
     */
    public java.math.BigDecimal getFeeAmount()
    {
        return getBigDecimal("feeAmount");
    }
    public void setFeeAmount(java.math.BigDecimal item)
    {
        setBigDecimal("feeAmount", item);
    }
    /**
     * Object:费用分录's 是否分摊生成property 
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
        return new BOSObjectType("ACF1EA70");
    }
}