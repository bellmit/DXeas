package com.kingdee.eas.custom.festival;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHappyHolidayTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractHappyHolidayTreeInfo()
    {
        this("id");
    }
    protected AbstractHappyHolidayTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 假日快乐组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.festival.HappyHolidayTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.festival.HappyHolidayTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.festival.HappyHolidayTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("87949721");
    }
}