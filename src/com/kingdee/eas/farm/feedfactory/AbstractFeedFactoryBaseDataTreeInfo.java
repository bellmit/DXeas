package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedFactoryBaseDataTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractFeedFactoryBaseDataTreeInfo()
    {
        this("id");
    }
    protected AbstractFeedFactoryBaseDataTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 饲料厂基础设置组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feedfactory.FeedFactoryBaseDataTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A868A7E3");
    }
}