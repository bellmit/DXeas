package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;

public class CountPositionSetInfo extends AbstractCountPositionSetInfo implements Serializable 
{
    public CountPositionSetInfo()
    {
        super();
    }
    protected CountPositionSetInfo(String pkField)
    {
        super(pkField);
    }
}