package com.kingdee.eas.custom.dx.baseset;

import java.io.Serializable;

public class FoodDailyInfo extends AbstractFoodDailyInfo implements Serializable 
{
    public FoodDailyInfo()
    {
        super();
    }
    protected FoodDailyInfo(String pkField)
    {
        super(pkField);
    }
}