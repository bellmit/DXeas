package com.kingdee.eas.spray;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractDeviceDataInfo extends com.kingdee.eas.framework.DataBaseInfo implements Serializable 
{
    public AbstractDeviceDataInfo()
    {
        this("id");
    }
    protected AbstractDeviceDataInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 喷涂设备资料 's 组别 property 
     */
    public com.kingdee.eas.spray.DeviceDataTreeInfo getTreeid()
    {
        return (com.kingdee.eas.spray.DeviceDataTreeInfo)get("treeid");
    }
    public void setTreeid(com.kingdee.eas.spray.DeviceDataTreeInfo item)
    {
        put("treeid", item);
    }
    /**
     * Object:喷涂设备资料's 规格型号property 
     */
    public String getModel()
    {
        return getString("model");
    }
    public void setModel(String item)
    {
        setString("model", item);
    }
    /**
     * Object:喷涂设备资料's 容量property 
     */
    public java.math.BigDecimal getCapacity()
    {
        return getBigDecimal("capacity");
    }
    public void setCapacity(java.math.BigDecimal item)
    {
        setBigDecimal("capacity", item);
    }
    /**
     * Object:喷涂设备资料's 喷涂速度property 
     */
    public java.math.BigDecimal getSpraySpeed()
    {
        return getBigDecimal("spraySpeed");
    }
    public void setSpraySpeed(java.math.BigDecimal item)
    {
        setBigDecimal("spraySpeed", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("95310F53");
    }
}