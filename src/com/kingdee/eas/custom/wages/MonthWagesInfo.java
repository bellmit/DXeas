package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class MonthWagesInfo extends AbstractMonthWagesInfo implements Serializable 
{
    public MonthWagesInfo()
    {
        super();
    }
    protected MonthWagesInfo(String pkField)
    {
        super(pkField);
    }
}