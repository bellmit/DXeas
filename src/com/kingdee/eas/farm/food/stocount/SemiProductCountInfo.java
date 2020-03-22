package com.kingdee.eas.farm.food.stocount;

import java.io.Serializable;

public class SemiProductCountInfo extends AbstractSemiProductCountInfo implements Serializable 
{
    public SemiProductCountInfo()
    {
        super();
    }
    protected SemiProductCountInfo(String pkField)
    {
        super(pkField);
    }
}