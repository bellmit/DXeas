package com.kingdee.eas.spray;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDeviceDataTreeInfo extends com.kingdee.eas.framework.TreeBaseInfo implements Serializable 
{
    public AbstractDeviceDataTreeInfo()
    {
        this("id");
    }
    protected AbstractDeviceDataTreeInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 设备资料组别 's 父节点 property 
     */
    public com.kingdee.eas.spray.DeviceDataTreeInfo getParent()
    {
        return (com.kingdee.eas.spray.DeviceDataTreeInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.spray.DeviceDataTreeInfo item)
    {
        put("parent", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("6CCB1591");
    }
}