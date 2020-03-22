package com.kingdee.eas.message;

import java.io.Serializable;

public class BaseSettingTreeInfo extends AbstractBaseSettingTreeInfo implements Serializable 
{
    public BaseSettingTreeInfo()
    {
        super();
    }
    protected BaseSettingTreeInfo(String pkField)
    {
        super(pkField);
    }
}