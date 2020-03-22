package com.kingdee.eas.farm.food;

import java.io.Serializable;

public class SlaughterPlanEntryInfo extends AbstractSlaughterPlanEntryInfo implements Serializable 
{
    public SlaughterPlanEntryInfo()
    {
        super();
    }
    protected SlaughterPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
}