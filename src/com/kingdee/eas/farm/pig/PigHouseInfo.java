package com.kingdee.eas.farm.pig;

import java.io.Serializable;

public class PigHouseInfo extends AbstractPigHouseInfo implements Serializable 
{
    public PigHouseInfo()
    {
        super();
    }
    protected PigHouseInfo(String pkField)
    {
        super(pkField);
    }
}