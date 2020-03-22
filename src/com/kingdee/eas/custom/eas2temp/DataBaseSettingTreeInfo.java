package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;

public class DataBaseSettingTreeInfo extends AbstractDataBaseSettingTreeInfo implements Serializable 
{
    public DataBaseSettingTreeInfo()
    {
        super();
    }
    protected DataBaseSettingTreeInfo(String pkField)
    {
        super(pkField);
    }
}