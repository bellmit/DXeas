package com.kingdee.eas.custom.shr;

import java.io.Serializable;

public class MyTestEntryInfo extends AbstractMyTestEntryInfo implements Serializable 
{
    public MyTestEntryInfo()
    {
        super();
    }
    protected MyTestEntryInfo(String pkField)
    {
        super(pkField);
    }
}