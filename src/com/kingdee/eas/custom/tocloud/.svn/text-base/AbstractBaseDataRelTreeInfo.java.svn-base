package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBaseDataRelTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBaseDataRelTreeInfo()
    {
        this("id");
    }
    protected AbstractBaseDataRelTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 基础资料映射组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.tocloud.BaseDataRelTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.tocloud.BaseDataRelTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.tocloud.BaseDataRelTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A5596903");
    }
}