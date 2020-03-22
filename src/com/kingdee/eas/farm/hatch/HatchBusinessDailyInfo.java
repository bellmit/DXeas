package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class HatchBusinessDailyInfo extends AbstractHatchBusinessDailyInfo implements Serializable 
{
    public HatchBusinessDailyInfo()
    {
        super();
    }
    protected HatchBusinessDailyInfo(String pkField)
    {
        super(pkField);
    }
}