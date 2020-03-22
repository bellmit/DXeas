package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;

public class DataBaseSettingInfo extends AbstractDataBaseSettingInfo implements Serializable 
{
    public DataBaseSettingInfo()
    {
        super();
    }
    protected DataBaseSettingInfo(String pkField)
    {
        super(pkField);
    }
}