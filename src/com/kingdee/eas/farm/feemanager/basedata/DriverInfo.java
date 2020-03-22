package com.kingdee.eas.farm.feemanager.basedata;

import java.io.Serializable;

public class DriverInfo extends AbstractDriverInfo implements Serializable 
{
    public DriverInfo()
    {
        super();
    }
    protected DriverInfo(String pkField)
    {
        super(pkField);
    }
}