package com.kingdee.eas.publicdata;

import java.io.Serializable;

public class CardSettingEntryInfo extends AbstractCardSettingEntryInfo implements Serializable 
{
    public CardSettingEntryInfo()
    {
        super();
    }
    protected CardSettingEntryInfo(String pkField)
    {
        super(pkField);
    }
}