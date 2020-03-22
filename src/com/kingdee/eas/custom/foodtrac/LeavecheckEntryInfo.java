package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;

public class LeavecheckEntryInfo extends AbstractLeavecheckEntryInfo implements Serializable 
{
    public LeavecheckEntryInfo()
    {
        super();
    }
    protected LeavecheckEntryInfo(String pkField)
    {
        super(pkField);
    }
}