package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBaseDataTypeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBaseDataTypeTreeInfo()
    {
        this("id");
    }
    protected AbstractBaseDataTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 基础资料类型组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.tocloud.BaseDataTypeTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.tocloud.BaseDataTypeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.tocloud.BaseDataTypeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("FF48324C");
    }
}