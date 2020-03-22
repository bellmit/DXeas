package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class WorkAgeAwardCalculationInfo extends AbstractWorkAgeAwardCalculationInfo implements Serializable 
{
    public WorkAgeAwardCalculationInfo()
    {
        super();
    }
    protected WorkAgeAwardCalculationInfo(String pkField)
    {
        super(pkField);
    }
}