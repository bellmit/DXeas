package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleAwardPolicyEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettleAwardPolicyEntryInfo()
    {
        this("id");
    }
    protected AbstractSettleAwardPolicyEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 重量范围 's null property 
     */
    public com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.settle.SettleAwardPolicyInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:重量范围's 重量下限property 
     */
    public java.math.BigDecimal getFloor()
    {
        return getBigDecimal("floor");
    }
    public void setFloor(java.math.BigDecimal item)
    {
        setBigDecimal("floor", item);
    }
    /**
     * Object:重量范围's 重量上限property 
     */
    public java.math.BigDecimal getUp()
    {
        return getBigDecimal("up");
    }
    public void setUp(java.math.BigDecimal item)
    {
        setBigDecimal("up", item);
    }
    /**
     * Object:重量范围's 奖惩金额property 
     */
    public java.math.BigDecimal getAmt()
    {
        return getBigDecimal("amt");
    }
    public void setAmt(java.math.BigDecimal item)
    {
        setBigDecimal("amt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("138D0231");
    }
}