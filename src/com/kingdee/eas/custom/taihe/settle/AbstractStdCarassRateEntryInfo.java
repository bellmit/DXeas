package com.kingdee.eas.custom.taihe.settle;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractStdCarassRateEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractStdCarassRateEntryInfo()
    {
        this("id");
    }
    protected AbstractStdCarassRateEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��׼��¼ 's null property 
     */
    public com.kingdee.eas.custom.taihe.settle.StdCarassRateInfo getParent()
    {
        return (com.kingdee.eas.custom.taihe.settle.StdCarassRateInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.taihe.settle.StdCarassRateInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��׼��¼'s ƽ��ֻ������property 
     */
    public java.math.BigDecimal getTop()
    {
        return getBigDecimal("top");
    }
    public void setTop(java.math.BigDecimal item)
    {
        setBigDecimal("top", item);
    }
    /**
     * Object:��׼��¼'s ƽ��ֻ������property 
     */
    public java.math.BigDecimal getLow()
    {
        return getBigDecimal("low");
    }
    public void setLow(java.math.BigDecimal item)
    {
        setBigDecimal("low", item);
    }
    /**
     * Object:��׼��¼'s ���ɱ�׼property 
     */
    public java.math.BigDecimal getRate()
    {
        return getBigDecimal("rate");
    }
    public void setRate(java.math.BigDecimal item)
    {
        setBigDecimal("rate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("67D067A5");
    }
}