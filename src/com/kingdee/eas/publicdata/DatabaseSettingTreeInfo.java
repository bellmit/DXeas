package com.kingdee.eas.publicdata;

import java.io.Serializable;

public class DatabaseSettingTreeInfo extends AbstractDatabaseSettingTreeInfo implements Serializable 
{
    public DatabaseSettingTreeInfo()
    {
        super();
    }
    protected DatabaseSettingTreeInfo(String pkField)
    {
        super(pkField);
    }
}