package com.kingdee.eas.farm.food;

import java.io.Serializable;

public class ChickenDailyBodyEntryInfo extends AbstractChickenDailyBodyEntryInfo implements Serializable 
{
    public ChickenDailyBodyEntryInfo()
    {
        super();
    }
    protected ChickenDailyBodyEntryInfo(String pkField)
    {
        super(pkField);
    }
}