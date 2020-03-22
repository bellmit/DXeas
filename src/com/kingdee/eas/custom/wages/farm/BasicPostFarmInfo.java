package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;

public class BasicPostFarmInfo extends AbstractBasicPostFarmInfo implements Serializable 
{
    public BasicPostFarmInfo()
    {
        super();
    }
    protected BasicPostFarmInfo(String pkField)
    {
        super(pkField);
    }
}