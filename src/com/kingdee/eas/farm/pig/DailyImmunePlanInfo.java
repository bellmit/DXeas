package com.kingdee.eas.farm.pig;

import java.io.Serializable;

public class DailyImmunePlanInfo extends AbstractDailyImmunePlanInfo implements Serializable 
{
    public DailyImmunePlanInfo()
    {
        super();
    }
    protected DailyImmunePlanInfo(String pkField)
    {
        super(pkField);
    }
}