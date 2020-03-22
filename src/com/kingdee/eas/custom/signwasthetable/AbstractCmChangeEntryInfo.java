package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCmChangeEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCmChangeEntryInfo()
    {
        this("id");
    }
    protected AbstractCmChangeEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.signwasthetable.CmChangeInfo getParent()
    {
        return (com.kingdee.eas.custom.signwasthetable.CmChangeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.signwasthetable.CmChangeInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:分录's 合同金额原币property 
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
     * Object:分录's 版本号property 
     */
    public String getVersionNum()
    {
        return getString("VersionNum");
    }
    public void setVersionNum(String item)
    {
        setString("VersionNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("B1B7ED0E");
    }
}