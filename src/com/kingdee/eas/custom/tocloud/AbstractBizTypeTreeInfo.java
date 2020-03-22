package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractBizTypeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractBizTypeTreeInfo()
    {
        this("id");
    }
    protected AbstractBizTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 业务类型组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.tocloud.BizTypeTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.tocloud.BizTypeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.tocloud.BizTypeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("D467A772");
    }
}