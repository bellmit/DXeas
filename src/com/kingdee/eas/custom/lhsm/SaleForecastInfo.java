package com.kingdee.eas.custom.lhsm;

import java.io.Serializable;

public class SaleForecastInfo extends AbstractSaleForecastInfo implements Serializable 
{
    public SaleForecastInfo()
    {
        super();
    }
    protected SaleForecastInfo(String pkField)
    {
        super(pkField);
    }
}