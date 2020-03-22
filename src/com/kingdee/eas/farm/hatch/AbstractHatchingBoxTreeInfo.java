package com.kingdee.eas.farm.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractHatchingBoxTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractHatchingBoxTreeInfo()
    {
        this("id");
    }
    protected AbstractHatchingBoxTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 出雏箱组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.hatch.HatchingBoxTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.hatch.HatchingBoxTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.hatch.HatchingBoxTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9863EE39");
    }
}