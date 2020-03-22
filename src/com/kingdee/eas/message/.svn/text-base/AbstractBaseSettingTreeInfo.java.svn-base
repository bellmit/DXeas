package com.kingdee.eas.message;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBaseSettingTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBaseSettingTreeInfo()
    {
        this("id");
    }
    protected AbstractBaseSettingTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 基础设置组别 's 父节点 property 
     */
    public com.kingdee.eas.message.BaseSettingTreeInfo getParent()
    {
        return (com.kingdee.eas.message.BaseSettingTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.message.BaseSettingTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DF91A5C4");
    }
}