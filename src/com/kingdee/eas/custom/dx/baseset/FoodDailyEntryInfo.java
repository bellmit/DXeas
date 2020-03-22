package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;

public class FoodDailyEntryInfo extends AbstractFoodDailyEntryInfo implements Serializable 
{
    public FoodDailyEntryInfo()
    {
        super();
    }
    protected FoodDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
}