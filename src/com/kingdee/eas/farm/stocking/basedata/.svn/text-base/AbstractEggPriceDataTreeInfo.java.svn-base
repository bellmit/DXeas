package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractEggPriceDataTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractEggPriceDataTreeInfo()
    {
        this("id");
    }
    protected AbstractEggPriceDataTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 种蛋价格维护组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.stocking.basedata.EggPriceDataTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.stocking.basedata.EggPriceDataTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.stocking.basedata.EggPriceDataTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F201801D");
    }
}