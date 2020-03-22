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
     * Object: ��¼ 's null property 
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
     * Object: ��¼ 's ˾�� property 
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
     * Object:��¼'s ����property 
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
     * Object:��¼'s ˾�����֤����property 
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
     * Object:��¼'s ˾������property 
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
     * Object:��¼'s Ĭ�ϳ���property 
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