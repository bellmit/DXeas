package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayRateCostDetailArOffSetDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDayRateCostDetailArOffSetDetailInfo()
    {
        this("id");
    }
    protected AbstractDayRateCostDetailArOffSetDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 应收冲减明细 's null property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo getParent()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.dayratecost.DayRateCostDetailInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:应收冲减明细's 发生日期property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    /**
     * Object: 应收冲减明细 's 发生期间 property 
     */
    public com.kingdee.eas.basedata.assistant.PeriodInfo getPeriod()
    {
        return (com.kingdee.eas.basedata.assistant.PeriodInfo)get("period");
    }
    public void setPeriod(com.kingdee.eas.basedata.assistant.PeriodInfo item)
    {
        put("period", item);
    }
    /**
     * Object:应收冲减明细's 冲减金额property 
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
     * Object:应收冲减明细's 单据idproperty 
     */
    public String getBillID()
    {
        return getString("billID");
    }
    public void setBillID(String item)
    {
        setString("billID", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3727744A");
    }
}