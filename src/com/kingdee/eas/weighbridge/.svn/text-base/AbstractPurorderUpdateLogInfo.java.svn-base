package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPurorderUpdateLogInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractPurorderUpdateLogInfo()
    {
        this("id");
    }
    protected AbstractPurorderUpdateLogInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object:更新过磅重量日志's 采购订单IDproperty 
     */
    public String getBillID()
    {
        return getString("billID");
    }
    public void setBillID(String item)
    {
        setString("billID", item);
    }
    /**
     * Object:更新过磅重量日志's 原过磅重量property 
     */
    public java.math.BigDecimal getOldWeightQty()
    {
        return getBigDecimal("oldWeightQty");
    }
    public void setOldWeightQty(java.math.BigDecimal item)
    {
        setBigDecimal("oldWeightQty", item);
    }
    /**
     * Object:更新过磅重量日志's 原结算重量property 
     */
    public java.math.BigDecimal getOldSettleQty()
    {
        return getBigDecimal("oldSettleQty");
    }
    public void setOldSettleQty(java.math.BigDecimal item)
    {
        setBigDecimal("oldSettleQty", item);
    }
    /**
     * Object:更新过磅重量日志's 新过磅重量property 
     */
    public java.math.BigDecimal getNewWeightQty()
    {
        return getBigDecimal("newWeightQty");
    }
    public void setNewWeightQty(java.math.BigDecimal item)
    {
        setBigDecimal("newWeightQty", item);
    }
    /**
     * Object:更新过磅重量日志's 新结算重量property 
     */
    public java.math.BigDecimal getNewSettleQty()
    {
        return getBigDecimal("newSettleQty");
    }
    public void setNewSettleQty(java.math.BigDecimal item)
    {
        setBigDecimal("newSettleQty", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("958DC3DF");
    }
}