package com.kingdee.eas.custom.shr;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMyTestEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractMyTestEntryInfo()
    {
        this("id");
    }
    protected AbstractMyTestEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 第1个表体 's null property 
     */
    public com.kingdee.eas.custom.shr.MyTestInfo getParent()
    {
        return (com.kingdee.eas.custom.shr.MyTestInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.shr.MyTestInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8537081E");
    }
}