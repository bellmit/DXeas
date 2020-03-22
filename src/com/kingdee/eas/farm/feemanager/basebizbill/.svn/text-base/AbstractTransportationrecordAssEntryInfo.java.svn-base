package com.kingdee.eas.farm.feemanager.basebizbill;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTransportationrecordAssEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractTransportationrecordAssEntryInfo()
    {
        this("id");
    }
    protected AbstractTransportationrecordAssEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 结算信息 's null property 
     */
    public com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo getParent()
    {
        return (com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feemanager.basebizbill.TransportationrecordInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:结算信息's 结算项目property 
     */
    public String getSettle()
    {
        return getString("settle");
    }
    public void setSettle(String item)
    {
        setString("settle", item);
    }
    /**
     * Object:结算信息's 结算金额property 
     */
    public java.math.BigDecimal getPrice()
    {
        return getBigDecimal("price");
    }
    public void setPrice(java.math.BigDecimal item)
    {
        setBigDecimal("price", item);
    }
    /**
     * Object:结算信息's 计算公式property 
     */
    public String getFormula()
    {
        return getString("formula");
    }
    public void setFormula(String item)
    {
        setString("formula", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("E0A331F4");
    }
}