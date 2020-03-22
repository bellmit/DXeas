package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractLeavecheckEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractLeavecheckEntryInfo()
    {
        this("id");
    }
    protected AbstractLeavecheckEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.foodtrac.LeavecheckInfo getParent()
    {
        return (com.kingdee.eas.custom.foodtrac.LeavecheckInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.foodtrac.LeavecheckInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("5E42BADC");
    }
}