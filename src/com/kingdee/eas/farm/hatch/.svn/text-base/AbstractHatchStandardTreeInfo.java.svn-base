package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchStandardTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractHatchStandardTreeInfo()
    {
        this("id");
    }
    protected AbstractHatchStandardTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 孵化规范组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.hatch.HatchStandardTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.HatchStandardTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.HatchStandardTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("A04C080D");
    }
}