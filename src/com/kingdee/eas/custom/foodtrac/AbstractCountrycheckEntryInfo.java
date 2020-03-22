package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCountrycheckEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCountrycheckEntryInfo()
    {
        this("id");
    }
    protected AbstractCountrycheckEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.foodtrac.CountrycheckInfo getParent()
    {
        return (com.kingdee.eas.custom.foodtrac.CountrycheckInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.foodtrac.CountrycheckInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D175BE3B");
    }
}