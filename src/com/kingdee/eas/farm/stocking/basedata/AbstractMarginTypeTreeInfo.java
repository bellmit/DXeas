package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractMarginTypeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractMarginTypeTreeInfo()
    {
        this("id");
    }
    protected AbstractMarginTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 保证金类型组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.MarginTypeTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.MarginTypeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.MarginTypeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F0A7FF57");
    }
}