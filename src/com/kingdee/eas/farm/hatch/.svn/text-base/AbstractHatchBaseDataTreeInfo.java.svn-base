package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchBaseDataTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractHatchBaseDataTreeInfo()
    {
        this("id");
    }
    protected AbstractHatchBaseDataTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 孵化基础资料组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.hatch.HatchBaseDataTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.HatchBaseDataTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.HatchBaseDataTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0E62A46B");
    }
}