package com.kingdee.eas.custom.wages.food;

import java.io.Serializable;

public class BasicPostFoodInfo extends AbstractBasicPostFoodInfo implements Serializable 
{
    public BasicPostFoodInfo()
    {
        super();
    }
    protected BasicPostFoodInfo(String pkField)
    {
        super(pkField);
    }
}