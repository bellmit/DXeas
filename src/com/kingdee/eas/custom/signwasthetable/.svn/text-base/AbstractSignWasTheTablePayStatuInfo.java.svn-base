package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSignWasTheTablePayStatuInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSignWasTheTablePayStatuInfo()
    {
        this("id");
    }
    protected AbstractSignWasTheTablePayStatuInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 付款执行情况 's null property 
     */
    public com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo getParent()
    {
        return (com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.signwasthetable.SignWasTheTableInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:付款执行情况's 付款金额property 
     */
    public java.math.BigDecimal getPayAmt()
    {
        return getBigDecimal("payAmt");
    }
    public void setPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("payAmt", item);
    }
    /**
     * Object:付款执行情况's 已申请付款金额property 
     */
    public java.math.BigDecimal getReqPayAmt()
    {
        return getBigDecimal("reqPayAmt");
    }
    public void setReqPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("reqPayAmt", item);
    }
    /**
     * Object:付款执行情况's 已付款金额property 
     */
    public java.math.BigDecimal getPayedAmt()
    {
        return getBigDecimal("payedAmt");
    }
    public void setPayedAmt(java.math.BigDecimal item)
    {
        setBigDecimal("payedAmt", item);
    }
    /**
     * Object:付款执行情况's 未申请付款金额property 
     */
    public java.math.BigDecimal getUnReqPayAmt()
    {
        return getBigDecimal("unReqPayAmt");
    }
    public void setUnReqPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("unReqPayAmt", item);
    }
    /**
     * Object:付款执行情况's 未付款金额property 
     */
    public java.math.BigDecimal getUnPayedAmt()
    {
        return getBigDecimal("unPayedAmt");
    }
    public void setUnPayedAmt(java.math.BigDecimal item)
    {
        setBigDecimal("unPayedAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("23CED398");
    }
}