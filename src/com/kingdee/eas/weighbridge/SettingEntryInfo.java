package com.kingdee.eas.weighbridge;

import java.io.Serializable;

public class SettingEntryInfo extends AbstractSettingEntryInfo implements Serializable 
{
    public SettingEntryInfo()
    {
        super();
    }
    protected SettingEntryInfo(String pkField)
    {
        super(pkField);
    }
}