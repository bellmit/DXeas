package com.kingdee.eas.custom.settlebill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarcassRateEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCarcassRateEntryInfo()
    {
        this("id");
    }
    protected AbstractCarcassRateEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��¼ 's null property 
     */
    public com.kingdee.eas.custom.settlebill.CarcassRateInfo getParent()
    {
        return (com.kingdee.eas.custom.settlebill.CarcassRateInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.settlebill.CarcassRateInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:��¼'s ƽ��ֻ��>=property 
     */
    public java.math.BigDecimal getAvgWgtCell()
    {
        return getBigDecimal("avgWgtCell");
    }
    public void setAvgWgtCell(java.math.BigDecimal item)
    {
        setBigDecimal("avgWgtCell", item);
    }
    /**
     * Object:��¼'s ƽ��ֻ��<property 
     */
    public java.math.BigDecimal getAvgWgtFloor()
    {
        return getBigDecimal("avgWgtFloor");
    }
    public void setAvgWgtFloor(java.math.BigDecimal item)
    {
        setBigDecimal("avgWgtFloor", item);
    }
    /**
     * Object:��¼'s ������property 
     */
    public java.math.BigDecimal getRate()
    {
        return getBigDecimal("rate");
    }
    public void setRate(java.math.BigDecimal item)
    {
        setBigDecimal("rate", item);
    }
    /**
     * Object:��¼'s ��עproperty 
     */
    public String getRemark()
    {
        return getString("remark");
    }
    public void setRemark(String item)
    {
        setString("remark", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CA3E2471");
    }
}