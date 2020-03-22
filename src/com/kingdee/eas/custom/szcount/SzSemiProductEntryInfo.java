package com.kingdee.eas.custom.szcount;

import java.io.Serializable;

public class SzSemiProductEntryInfo extends AbstractSzSemiProductEntryInfo implements Serializable 
{
    public SzSemiProductEntryInfo()
    {
        super();
    }
    protected SzSemiProductEntryInfo(String pkField)
    {
        super(pkField);
    }
}