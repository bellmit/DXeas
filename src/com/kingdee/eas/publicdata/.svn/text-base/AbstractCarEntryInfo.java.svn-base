package com.kingdee.eas.publicdata;

import java.io.Serializable;
import com.kingdee.bos.dao.AbstractObjectValue;
import java.util.Locale;
import com.kingdee.util.TypeConversionUtils;
import com.kingdee.bos.util.BOSObjectType;


public class AbstractCarEntryInfo extends com.kingdee.eas.framework.CoreBillEntryBaseInfo implements Serializable 
{
    public AbstractCarEntryInfo()
    {
        this("id");
    }
    protected AbstractCarEntryInfo(String pkField)
    {
        super(pkField);
    }
    /**
     * Object: 分录 's null property 
     */
    public com.kingdee.eas.publicdata.CarInfo getParent()
    {
        return (com.kingdee.eas.publicdata.CarInfo)get("parent");
    }
    public void setParent(com.kingdee.eas.publicdata.CarInfo item)
    {
        put("parent", item);
    }
    /**
     * Object: 分录 's 司机 property 
     */
    public com.kingdee.eas.farm.feemanager.basedata.DriverInfo getDriver()
    {
        return (com.kingdee.eas.farm.feemanager.basedata.DriverInfo)get("driver");
    }
    public void setDriver(com.kingdee.eas.farm.feemanager.basedata.DriverInfo item)
    {
        put("driver", item);
    }
    /**
     * Object:分录's 年龄property 
     */
    public String getDriverAge()
    {
        return getString("driverAge");
    }
    public void setDriverAge(String item)
    {
        setString("driverAge", item);
    }
    /**
     * Object:分录's 司机身份证号码property 
     */
    public String getDriverID()
    {
        return getString("driverID");
    }
    public void setDriverID(String item)
    {
        setString("driverID", item);
    }
    /**
     * Object:分录's 司机籍贯property 
     */
    public String getDriverNative()
    {
        return getString("driverNative");
    }
    public void setDriverNative(String item)
    {
        setString("driverNative", item);
    }
    /**
     * Object:分录's 默认车辆property 
     */
    public boolean isIsDefault()
    {
        return getBoolean("isDefault");
    }
    public void setIsDefault(boolean item)
    {
        setBoolean("isDefault", item);
    }
    public BOSObjectType getBOSType()
    {
        return new BOSObjectType("AA4169E1");
    }
}