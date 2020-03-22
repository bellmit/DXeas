package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPersonTaxEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPersonTaxEntryInfo()
    {
        this("id");
    }
    protected AbstractPersonTaxEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 税率区间 's null property 
     */
    public com.kingdee.eas.custom.wages.PersonTaxInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.PersonTaxInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.PersonTaxInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:税率区间's 税额上限property 
     */
    public int getTaxUp()
    {
        return getInt("TaxUp");
    }
    public void setTaxUp(int item)
    {
        setInt("TaxUp", item);
    }
    /**
     * Object:税率区间's 税额下限property 
     */
    public int getTaxDown()
    {
        return getInt("TaxDown");
    }
    public void setTaxDown(int item)
    {
        setInt("TaxDown", item);
    }
    /**
     * Object:税率区间's 税率（%）property 
     */
    public java.math.BigDecimal getTaxRate()
    {
        return getBigDecimal("TaxRate");
    }
    public void setTaxRate(java.math.BigDecimal item)
    {
        setBigDecimal("TaxRate", item);
    }
    /**
     * Object:税率区间's 速算扣除数property 
     */
    public java.math.BigDecimal getQuickDeduction()
    {
        return getBigDecimal("QuickDeduction");
    }
    public void setQuickDeduction(java.math.BigDecimal item)
    {
        setBigDecimal("QuickDeduction", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("561EF404");
    }
}