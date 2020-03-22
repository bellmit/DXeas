package com.kingdee.eas.custom.taihe.weight;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassEntrysSInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCarcassEntrysSInfo()
    {
        this("id");
    }
    protected AbstractCarcassEntrysSInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 详细信息 's null property 
     */
    public com.kingdee.eas.custom.taihe.weight.CarcassInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.weight.CarcassInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.weight.CarcassInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:详细信息's 重量property 
     */
    public java.math.BigDecimal getDweight()
    {
        return getBigDecimal("Dweight");
    }
    public void setDweight(java.math.BigDecimal item)
    {
        setBigDecimal("Dweight", item);
    }
    /**
     * Object:详细信息's 详细时间property 
     */
    public java.util.Date getDtime()
    {
        return getDate("Dtime");
    }
    public void setDtime(java.util.Date item)
    {
        setDate("Dtime", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C3E8C076");
    }
}