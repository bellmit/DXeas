package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;

public class MonthFoodBillInfo extends AbstractMonthFoodBillInfo implements Serializable 
{
    public MonthFoodBillInfo()
    {
        super();
    }
    protected MonthFoodBillInfo(String pkField)
    {
        super(pkField);
    }
}