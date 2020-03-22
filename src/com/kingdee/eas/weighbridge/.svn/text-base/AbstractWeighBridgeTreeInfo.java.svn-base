package com.kingdee.eas.weighbridge;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractWeighBridgeTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractWeighBridgeTreeInfo()
    {
        this("id");
    }
    protected AbstractWeighBridgeTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 磅秤组别 's 父节点 property 
     */
    public com.kingdee.eas.weighbridge.WeighBridgeTreeInfo getParent()
    {
        return (com.kingdee.eas.weighbridge.WeighBridgeTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.weighbridge.WeighBridgeTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("DEC58428");
    }
}