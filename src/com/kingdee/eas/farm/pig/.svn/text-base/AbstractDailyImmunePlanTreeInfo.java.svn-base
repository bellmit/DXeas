package com.kingdee.eas.farm.pig;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDailyImmunePlanTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDailyImmunePlanTreeInfo()
    {
        this("id");
    }
    protected AbstractDailyImmunePlanTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 日常免疫计划组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.pig.DailyImmunePlanTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.pig.DailyImmunePlanTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.pig.DailyImmunePlanTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("3D91BC43");
    }
}