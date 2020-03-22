package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;

public class SaleForecastEntryInfo extends AbstractSaleForecastEntryInfo implements Serializable 
{
    public SaleForecastEntryInfo()
    {
        super();
    }
    protected SaleForecastEntryInfo(String pkField)
    {
        super(pkField);
    }
}