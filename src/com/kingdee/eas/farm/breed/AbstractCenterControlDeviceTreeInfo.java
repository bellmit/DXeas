package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCenterControlDeviceTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractCenterControlDeviceTreeInfo()
    {
        this("id");
    }
    protected AbstractCenterControlDeviceTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 中控设备组别 's 父节点 property 
     */
    public com.kingdee.eas.farm.breed.CenterControlDeviceTreeInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.CenterControlDeviceTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.CenterControlDeviceTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("7BA105E2");
    }
}