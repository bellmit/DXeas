package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHenhouseEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractHenhouseEntryInfo()
    {
        this("id");
    }
    protected AbstractHenhouseEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F4D2FFE9");
    }
}