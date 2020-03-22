package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class HRwagesEntryInfo extends AbstractHRwagesEntryInfo implements Serializable 
{
    public HRwagesEntryInfo()
    {
        super();
    }
    protected HRwagesEntryInfo(String pkField)
    {
        super(pkField);
    }
}