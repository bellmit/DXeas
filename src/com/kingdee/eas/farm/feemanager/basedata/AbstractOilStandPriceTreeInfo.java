package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractOilStandPriceTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractOilStandPriceTreeInfo()
    {
        this("id");
    }
    protected AbstractOilStandPriceTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 柴油标准价格维护组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.OilStandPriceTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.OilStandPriceTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.feemanager.basedata.OilStandPriceTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("48A7F197");
    }
}