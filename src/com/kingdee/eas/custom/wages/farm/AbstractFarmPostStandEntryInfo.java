package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFarmPostStandEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFarmPostStandEntryInfo()
    {
        this("id");
    }
    protected AbstractFarmPostStandEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ��λ��¼ 's null property 
     */
    public com.kingdee.eas.custom.wages.farm.FarmPostStandInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.farm.FarmPostStandInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.farm.FarmPostStandInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: ��λ��¼ 's ��λ property 
     */
    public com.kingdee.eas.basedata.org.PositionInfo getPosition()
    {
        return (com.kingdee.eas.basedata.org.PositionInfo)get("position");
    }
    public void setPosition(com.kingdee.eas.basedata.org.PositionInfo item)
    {
        put("position", item);
    }
    /**
     * Object:��λ��¼'s ��������property 
     */
    public String getPersonqty()
    {
        return getString("personqty");
    }
    public void setPersonqty(String item)
    {
        setString("personqty", item);
    }
    /**
     * Object:��λ��¼'s ����ϵ��property 
     */
    public java.math.BigDecimal getRateindex()
    {
        return getBigDecimal("rateindex");
    }
    public void setRateindex(java.math.BigDecimal item)
    {
        setBigDecimal("rateindex", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("86673E7C");
    }
}