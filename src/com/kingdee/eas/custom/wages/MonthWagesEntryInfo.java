package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class MonthWagesEntryInfo extends AbstractMonthWagesEntryInfo implements Serializable 
{
    public MonthWagesEntryInfo()
    {
        super();
    }
    protected MonthWagesEntryInfo(String pkField)
    {
        super(pkField);
    }
}