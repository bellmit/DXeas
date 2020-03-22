package com.kingdee.eas.custom.salepayment;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLongTimeArAmountEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLongTimeArAmountEntryInfo()
    {
        this("id");
    }
    protected AbstractLongTimeArAmountEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.salepayment.LongTimeArAmountInfo getParent()
    {
        return (com.kingdee.eas.custom.salepayment.LongTimeArAmountInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.salepayment.LongTimeArAmountInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 客户 property 
     */
    public com.kingdee.eas.basedata.master.cssp.CustomerInfo getCustomer()
    {
        return (com.kingdee.eas.basedata.master.cssp.CustomerInfo)get("customer");
    }
    public void setCustomer(com.kingdee.eas.basedata.master.cssp.CustomerInfo item)
    {
        put("customer", item);
    }
    /**
     * Object:分录's 备注property 
     */
    public String getDescription()
    {
        return getString("description");
    }
    public void setDescription(String item)
    {
        setString("description", item);
    }
    /**
     * Object:分录's 长期应收款property 
     */
    public java.math.BigDecimal getArAmount()
    {
        return getBigDecimal("arAmount");
    }
    public void setArAmount(java.math.BigDecimal item)
    {
        setBigDecimal("arAmount", item);
    }
    /**
     * Object:分录's 考核金额property 
     */
    public java.math.BigDecimal getKhAmount()
    {
        return getBigDecimal("khAmount");
    }
    public void setKhAmount(java.math.BigDecimal item)
    {
        setBigDecimal("khAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("70A9A6AC");
    }
}