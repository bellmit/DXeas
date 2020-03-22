package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractInsteadSeedPriceDataTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractInsteadSeedPriceDataTreeInfo()
    {
        this("id");
    }
    protected AbstractInsteadSeedPriceDataTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 苗价维护(代孵)组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.InsteadSeedPriceDataTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("0EDCE10F");
    }
}