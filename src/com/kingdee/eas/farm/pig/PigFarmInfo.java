package com.kingdee.eas.farm.pig;

import java.io.Serializable;

public class PigFarmInfo extends AbstractPigFarmInfo implements Serializable 
{
    public PigFarmInfo()
    {
        super();
    }
    protected PigFarmInfo(String pkField)
    {
        super(pkField);
    }
}