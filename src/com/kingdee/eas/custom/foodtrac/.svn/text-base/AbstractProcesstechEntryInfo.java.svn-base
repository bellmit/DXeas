package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractProcesstechEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractProcesstechEntryInfo()
    {
        this("id");
    }
    protected AbstractProcesstechEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.foodtrac.ProcesstechInfo getParent()
    {
        return (com.kingdee.eas.custom.foodtrac.ProcesstechInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.foodtrac.ProcesstechInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("066338B2");
    }
}