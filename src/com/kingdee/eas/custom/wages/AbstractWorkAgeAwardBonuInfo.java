package com.kingdee.eas.custom.wages;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWorkAgeAwardBonuInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractWorkAgeAwardBonuInfo()
    {
        this("id");
    }
    protected AbstractWorkAgeAwardBonuInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: �����׼ 's null property 
     */
    public com.kingdee.eas.custom.wages.WorkAgeAwardInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.WorkAgeAwardInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.WorkAgeAwardInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:�����׼'s ִ�б�׼(Ԫ/��)property 
     */
    public java.math.BigDecimal getStandard()
    {
        return getBigDecimal("standard");
    }
    public void setStandard(java.math.BigDecimal item)
    {
        setBigDecimal("standard", item);
    }
    /**
     * Object:�����׼'s �����·�С��property 
     */
    public java.math.BigDecimal getWorkX()
    {
        return getBigDecimal("workX");
    }
    public void setWorkX(java.math.BigDecimal item)
    {
        setBigDecimal("workX", item);
    }
    /**
     * Object:�����׼'s �����·ݴ���property 
     */
    public java.math.BigDecimal getWorkD()
    {
        return getBigDecimal("workD");
    }
    public void setWorkD(java.math.BigDecimal item)
    {
        setBigDecimal("workD", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("26F85E4B");
    }
}