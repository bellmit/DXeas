package com.kingdee.eas.custom.festival;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFactoryCalendarAssEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractFactoryCalendarAssEntryInfo()
    {
        this("id");
    }
    protected AbstractFactoryCalendarAssEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: ¸¨Öú×ÊÁÏ·ÖÂ¼ 's null property 
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
        return new BOSObjectType("95B8688E");
    }
}