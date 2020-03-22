package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOilPriceTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractOilPriceTreeInfo()
    {
        this("id");
    }
    protected AbstractOilPriceTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 柴油价格维护 's 父节点 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.OilPriceTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.OilPriceTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feemanager.basedata.OilPriceTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("9FE66081");
    }
}