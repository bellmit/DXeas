package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSaleProfitCalculateResultMonthEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSaleProfitCalculateResultMonthEntryInfo()
    {
        this("id");
    }
    protected AbstractSaleProfitCalculateResultMonthEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 月损益明细 's null property 
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
     * Object: 月损益明细 's 月毛利明细 property 
     */
    public com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo getMonthGrossProfit()
    {
        return (com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo)get("monthGrossProfit");
    }
    public void setMonthGrossProfit(com.kingdee.eas.custom.salepayment.GrossProfitInfoInfo item)
    {
        put("monthGrossProfit", item);
    }
    /**
     * Object:月损益明细's 月property 
     */
    public int getMonth()
    {
        return getInt("month");
    }
    public void setMonth(int item)
    {
        setInt("month", item);
    }
    /**
     * Object:月损益明细's 月毛利property 
     */
    public java.math.BigDecimal getGrossProfit()
    {
        return getBigDecimal("grossProfit");
    }
    public void setGrossProfit(java.math.BigDecimal item)
    {
        setBigDecimal("grossProfit", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0129B6B6");
    }
}