package com.kingdee.eas.custom.signwasthetable;

import java.io.Serializable;

public class OverPayEntryInfo extends AbstractOverPayEntryInfo implements Serializable 
{
    public OverPayEntryInfo()
    {
        super();
    }
    protected OverPayEntryInfo(String pkField)
    {
        super(pkField);
    }
}