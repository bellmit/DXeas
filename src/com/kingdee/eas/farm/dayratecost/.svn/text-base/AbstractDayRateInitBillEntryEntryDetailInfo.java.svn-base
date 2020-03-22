package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayRateInitBillEntryEntryDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDayRateInitBillEntryEntryDetailInfo()
    {
        this("id");
    }
    protected AbstractDayRateInitBillEntryEntryDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 成本明细 's null property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryInfo getParent1()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryInfo)get("parent1");
    }
    public void setParent1(com.kingdee.eas.farm.dayratecost.DayRateInitBillEntryInfo item)
    {
        put("parent1", item);
    }
    /**
     * Object:成本明细's 金额property 
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
     * Object:成本明细's 项目名称property 
     */
    public String getItemName()
    {
        return getString("itemName");
    }
    public void setItemName(String item)
    {
        setString("itemName", item);
    }
    /**
     * Object:成本明细's 项目idproperty 
     */
    public String getItemID()
    {
        return getString("itemID");
    }
    public void setItemID(String item)
    {
        setString("itemID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6802679F");
    }
}