package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWageFoodOrganTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractWageFoodOrganTreeInfo()
    {
        this("id");
    }
    protected AbstractWageFoodOrganTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 后勤组织架构组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.wages.food.WageFoodOrganTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.wages.food.WageFoodOrganTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.wages.food.WageFoodOrganTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("03027587");
    }
}