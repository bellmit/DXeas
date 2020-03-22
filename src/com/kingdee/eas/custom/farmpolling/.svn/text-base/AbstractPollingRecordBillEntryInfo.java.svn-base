package com.kingdee.eas.custom.farmpolling;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractPollingRecordBillEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractPollingRecordBillEntryInfo()
    {
        this("id");
    }
    protected AbstractPollingRecordBillEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 签到分录 's 单据头 property 
     */
    public com.kingdee.eas.custom.farmpolling.PollingRecordBillInfo getParent()
    {
        return (com.kingdee.eas.custom.farmpolling.PollingRecordBillInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.custom.farmpolling.PollingRecordBillInfo item)
    {
        put("parent", item);
    }
    /**
     * Object:签到分录's 签到时间property 
     */
    public java.util.Date getSignTime()
    {
        return getDate("signTime");
    }
    public void setSignTime(java.util.Date item)
    {
        setDate("signTime", item);
    }
    /**
     * Object:签到分录's 签到地点property 
     */
    public String getSignLocation()
    {
        return getString("signLocation");
    }
    public void setSignLocation(String item)
    {
        setString("signLocation", item);
    }
    /**
     * Object:签到分录's 签到坐标property 
     */
    public String getSignXYZ()
    {
        return getString("signXYZ");
    }
    public void setSignXYZ(String item)
    {
        setString("signXYZ", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("F8A9115D");
    }
}