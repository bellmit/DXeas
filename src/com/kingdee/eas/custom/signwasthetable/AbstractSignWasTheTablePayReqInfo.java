package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSignWasTheTablePayReqInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSignWasTheTablePayReqInfo()
    {
        this("id");
    }
    protected AbstractSignWasTheTablePayReqInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 付款申请 's null property 
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
     * Object:付款申请's 付款条件property 
     */
    public String getPayCondition()
    {
        return getString("payCondition");
    }
    public void setPayCondition(String item)
    {
        setString("payCondition", item);
    }
    /**
     * Object:付款申请's 未申请付款金额property 
     */
    public java.math.BigDecimal getUnreqPayAmt()
    {
        return getBigDecimal("unreqPayAmt");
    }
    public void setUnreqPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("unreqPayAmt", item);
    }
    /**
     * Object:付款申请's 已申请付款金额property 
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
     * Object:付款申请's 已付款金额property 
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
     * Object:付款申请's 未付款金额property 
     */
    public java.math.BigDecimal getUnpayedAmt()
    {
        return getBigDecimal("unpayedAmt");
    }
    public void setUnpayedAmt(java.math.BigDecimal item)
    {
        setBigDecimal("unpayedAmt", item);
    }
    /**
     * Object:付款申请's 备注property 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    /**
     * Object:付款申请's 付款比率property 
     */
    public java.math.BigDecimal getPayRate()
    {
        return getBigDecimal("payRate");
    }
    public void setPayRate(java.math.BigDecimal item)
    {
        setBigDecimal("payRate", item);
    }
    /**
     * Object:付款申请's 付款金额property 
     */
    public java.math.BigDecimal getPayAmt()
    {
        return getBigDecimal("payAmt");
    }
    public void setPayAmt(java.math.BigDecimal item)
    {
        setBigDecimal("payAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3E1B1955");
    }
}