package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSettleAwardPolicyAwardEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractSettleAwardPolicyAwardEntryInfo()
    {
        this("id");
    }
    protected AbstractSettleAwardPolicyAwardEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 保底合同 's null property 
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
     * Object:保底合同's 单只重量上限property 
     */
    public java.math.BigDecimal getAvgWgtUpper()
    {
        return getBigDecimal("avgWgtUpper");
    }
    public void setAvgWgtUpper(java.math.BigDecimal item)
    {
        setBigDecimal("avgWgtUpper", item);
    }
    /**
     * Object:保底合同's 单只重量下限property 
     */
    public java.math.BigDecimal getAvgWgtLower()
    {
        return getBigDecimal("avgWgtLower");
    }
    public void setAvgWgtLower(java.math.BigDecimal item)
    {
        setBigDecimal("avgWgtLower", item);
    }
    /**
     * Object:保底合同's 奖惩金额property 
     */
    public java.math.BigDecimal getAwardAmt()
    {
        return getBigDecimal("awardAmt");
    }
    public void setAwardAmt(java.math.BigDecimal item)
    {
        setBigDecimal("awardAmt", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6997D5B6");
    }
}