package com.kingdee.eas.spray;

import java.io.Serializable;

public class DeviceDataTreeInfo extends AbstractDeviceDataTreeInfo implements Serializable 
{
    public DeviceDataTreeInfo()
    {
        super();
    }
    protected DeviceDataTreeInfo(String pkField)
    {
        super(pkField);
    }
}