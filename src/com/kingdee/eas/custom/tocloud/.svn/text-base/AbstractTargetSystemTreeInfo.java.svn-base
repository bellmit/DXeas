package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractTargetSystemTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractTargetSystemTreeInfo()
    {
        this("id");
    }
    protected AbstractTargetSystemTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 目标系统组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.tocloud.TargetSystemTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.tocloud.TargetSystemTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.tocloud.TargetSystemTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C3F52BF7");
    }
}