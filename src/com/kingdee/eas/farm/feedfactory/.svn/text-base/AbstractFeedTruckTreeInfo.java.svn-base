package com.kingdee.eas.farm.feedfactory;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractFeedTruckTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractFeedTruckTreeInfo()
    {
        this("id");
    }
    protected AbstractFeedTruckTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 饲料车组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.feedfactory.FeedTruckTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.feedfactory.FeedTruckTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feedfactory.FeedTruckTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("1B4B79FD");
    }
}