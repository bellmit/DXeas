package com.kingdee.eas.publicdata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCardRelationTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCardRelationTreeInfo()
    {
        this("id");
    }
    protected AbstractCardRelationTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 磁卡关系维护组别 's 父节点 property 
     */
    public com.kingdee.eas.publicdata.CardRelationTreeInfo getParent()
    {
        return (com.kingdee.eas.publicdata.CardRelationTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.publicdata.CardRelationTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("73EAB4CD");
    }
}