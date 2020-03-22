package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDayrateFeeItemTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDayrateFeeItemTreeInfo()
    {
        this("id");
    }
    protected AbstractDayrateFeeItemTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 费用项目组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.dayratecost.DayrateFeeItemTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.dayratecost.DayrateFeeItemTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.dayratecost.DayrateFeeItemTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("CAD34D00");
    }
}