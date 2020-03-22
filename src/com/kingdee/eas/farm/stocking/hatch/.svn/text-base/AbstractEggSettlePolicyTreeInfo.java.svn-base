package com.kingdee.eas.farm.stocking.hatch;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggSettlePolicyTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractEggSettlePolicyTreeInfo()
    {
        this("id");
    }
    protected AbstractEggSettlePolicyTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 种蛋结算政策组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.hatch.EggSettlePolicyTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("8A7DA196");
    }
}