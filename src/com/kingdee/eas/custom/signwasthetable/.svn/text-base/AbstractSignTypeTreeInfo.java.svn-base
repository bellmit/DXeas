package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractSignTypeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractSignTypeTreeInfo()
    {
        this("id");
    }
    protected AbstractSignTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 签呈类别组别 's 父节点 property 
     */
    public com.kingdee.eas.custom.signwasthetable.SignTypeTreeInfo getParent()
    {
        return (com.kingdee.eas.custom.signwasthetable.SignTypeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.signwasthetable.SignTypeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("184B7ADF");
    }
}