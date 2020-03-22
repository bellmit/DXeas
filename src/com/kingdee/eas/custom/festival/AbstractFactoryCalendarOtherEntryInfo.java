package com.kingdee.eas.custom.festival;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFactoryCalendarOtherEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFactoryCalendarOtherEntryInfo()
    {
        this("id");
    }
    protected AbstractFactoryCalendarOtherEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 其它资料分录 's null property 
     */
    public com.kingdee.eas.custom.festival.FactoryCalendarInfo getParent()
    {
        return (com.kingdee.eas.custom.festival.FactoryCalendarInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.festival.FactoryCalendarInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("23DED21F");
    }
}