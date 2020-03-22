package com.kingdee.eas.custom.independence;

import java.io.Serializable;

public class PermissionSettingTreeInfo extends AbstractPermissionSettingTreeInfo implements Serializable 
{
    public PermissionSettingTreeInfo()
    {
        super();
    }
    protected PermissionSettingTreeInfo(String pkField)
    {
        super(pkField);
    }
}