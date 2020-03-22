package com.kingdee.eas.message;

import java.io.Serializable;

public class BaseSettingInfo extends AbstractBaseSettingInfo implements Serializable 
{
    public BaseSettingInfo()
    {
        super();
    }
    protected BaseSettingInfo(String pkField)
    {
        super(pkField);
    }
}