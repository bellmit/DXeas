package com.kingdee.eas.custom.szcount;

import java.io.Serializable;

public class FreshDailyEntryInfo extends AbstractFreshDailyEntryInfo implements Serializable 
{
    public FreshDailyEntryInfo()
    {
        super();
    }
    protected FreshDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
}