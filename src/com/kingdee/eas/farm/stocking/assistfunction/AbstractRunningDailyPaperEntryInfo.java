package com.kingdee.eas.farm.stocking.assistfunction;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractRunningDailyPaperEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractRunningDailyPaperEntryInfo()
    {
        this("id");
    }
    protected AbstractRunningDailyPaperEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's ����ͷ property 
     */
    public com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.assistfunction.RunningDailyPaperInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s �Ϸ����ɱ�(��Ʒ)property 
     */
    public java.math.BigDecimal getCcEggCost()
    {
        return getBigDecimal("ccEggCost");
    }
    public void setCcEggCost(java.math.BigDecimal item)
    {
        setBigDecimal("ccEggCost", item);
    }
    /**
     * Object:��¼'s �Ϸ����ɱ�(���)property 
     */
    public java.math.BigDecimal getParentEggCost()
    {
        return getBigDecimal("parentEggCost");
    }
    public void setParentEggCost(java.math.BigDecimal item)
    {
        setBigDecimal("parentEggCost", item);
    }
    /**
     * Object:��¼'s ��������property 
     */
    public java.math.BigDecimal getHatchFee()
    {
        return getBigDecimal("hatchFee");
    }
    public void setHatchFee(java.math.BigDecimal item)
    {
        setBigDecimal("hatchFee", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getHatchAgentFee()
    {
        return getBigDecimal("hatchAgentFee");
    }
    public void setHatchAgentFee(java.math.BigDecimal item)
    {
        setBigDecimal("hatchAgentFee", item);
    }
    /**
     * Object:��¼'s ����property 
     */
    public java.util.Date getBizDate()
    {
        return getDate("bizDate");
    }
    public void setBizDate(java.util.Date item)
    {
        setDate("bizDate", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0BFCB64B");
    }
}