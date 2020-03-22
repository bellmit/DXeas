package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOverPayEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractOverPayEntryInfo()
    {
        this("id");
    }
    protected AbstractOverPayEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.signwasthetable.OverPayInfo getParent()
    {
        return (com.kingdee.eas.custom.signwasthetable.OverPayInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.signwasthetable.OverPayInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 阶段property 
     */
    public String getPhaseCoding()
    {
        return getString("phaseCoding");
    }
    public void setPhaseCoding(String item)
    {
        setString("phaseCoding", item);
    }
    /**
     * Object:分录's 超额比例property 
     */
    public java.math.BigDecimal getOverRate()
    {
        return getBigDecimal("overRate");
    }
    public void setOverRate(java.math.BigDecimal item)
    {
        setBigDecimal("overRate", item);
    }
    /**
     * Object:分录's 是否保证金字段property 
     */
    public boolean isIsBailAmt()
    {
        return getBoolean("isBailAmt");
    }
    public void setIsBailAmt(boolean item)
    {
        setBoolean("isBailAmt", item);
    }
    /**
     * Object:分录's 最大可付款金额property 
     */
    public java.math.BigDecimal getOverAmt()
    {
        return getBigDecimal("overAmt");
    }
    public void setOverAmt(java.math.BigDecimal item)
    {
        setBigDecimal("overAmt", item);
    }
    /**
     * Object:分录's 付款金额property 
     */
    public java.math.BigDecimal getPayAmount()
    {
        return getBigDecimal("payAmount");
    }
    public void setPayAmount(java.math.BigDecimal item)
    {
        setBigDecimal("payAmount", item);
    }
    /**
     * Object:分录's 已申请付款金额property 
     */
    public java.math.BigDecimal getRequiredPayAmount()
    {
        return getBigDecimal("requiredPayAmount");
    }
    public void setRequiredPayAmount(java.math.BigDecimal item)
    {
        setBigDecimal("requiredPayAmount", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6A2B19A8");
    }
}