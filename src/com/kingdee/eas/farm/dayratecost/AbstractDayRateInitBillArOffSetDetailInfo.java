package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayRateInitBillArOffSetDetailInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractDayRateInitBillArOffSetDetailInfo()
    {
        this("id");
    }
    protected AbstractDayRateInitBillArOffSetDetailInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 应收冲减明细 's null property 
     */
    public com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo getParent()
    {
        return (com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.dayratecost.DayRateInitBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:应收冲减明细's 业务日期property 
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
     * Object:应收冲减明细's 业务期间property 
     */
    public java.math.BigDecimal getPeriod()
    {
        return getBigDecimal("period");
    }
    public void setPeriod(java.math.BigDecimal item)
    {
        setBigDecimal("period", item);
    }
    /**
     * Object:应收冲减明细's 冲减单据idproperty 
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
        return new BOSObjectType("6F9B8D03");
    }
}