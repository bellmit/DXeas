package com.kingdee.eas.farm.food;

import java.io.Serializable;

public class SlaughterPlanInfo extends AbstractSlaughterPlanInfo implements Serializable 
{
    public SlaughterPlanInfo()
    {
        super();
    }
    protected SlaughterPlanInfo(String pkField)
    {
        super(pkField);
    }
}