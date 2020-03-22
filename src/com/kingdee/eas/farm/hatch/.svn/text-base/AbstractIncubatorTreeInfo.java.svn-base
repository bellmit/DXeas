package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractIncubatorTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractIncubatorTreeInfo()
    {
        this("id");
    }
    protected AbstractIncubatorTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 孵化箱组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.hatch.IncubatorTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.IncubatorTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.IncubatorTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("C0742AB1");
    }
}