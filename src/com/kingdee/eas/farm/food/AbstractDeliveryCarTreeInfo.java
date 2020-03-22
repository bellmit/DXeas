package com.kingdee.eas.farm.food;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDeliveryCarTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDeliveryCarTreeInfo()
    {
        this("id");
    }
    protected AbstractDeliveryCarTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 送货车辆组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.food.DeliveryCarTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.food.DeliveryCarTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.food.DeliveryCarTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("88F0B914");
    }
}