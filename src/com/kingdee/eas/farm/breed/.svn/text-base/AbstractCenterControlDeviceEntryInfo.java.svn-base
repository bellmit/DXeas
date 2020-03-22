package com.kingdee.eas.farm.breed;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCenterControlDeviceEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCenterControlDeviceEntryInfo()
    {
        this("id");
    }
    protected AbstractCenterControlDeviceEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 鸡舍终端机对应关系 's null property 
     */
    public com.kingdee.eas.farm.breed.CenterControlDeviceInfo getParent()
    {
        return (com.kingdee.eas.farm.breed.CenterControlDeviceInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.farm.breed.CenterControlDeviceInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 鸡舍终端机对应关系 's 鸡舍 property 
     */
    public com.kingdee.eas.farm.breed.HenhouseInfo getHenHouse()
    {
        return (com.kingdee.eas.farm.breed.HenhouseInfo)get("henHouse");
    }
    public void setHenHouse(com.kingdee.eas.farm.breed.HenhouseInfo item)
    {
        put("henHouse", item);
    }
    /**
     * Object:鸡舍终端机对应关系's 终端设备编码property 
     */
    public String getDeviceNum()
    {
        return getString("deviceNum");
    }
    public void setDeviceNum(String item)
    {
        setString("deviceNum", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F7AABEAE");
    }
}