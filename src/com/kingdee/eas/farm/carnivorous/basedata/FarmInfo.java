package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class FarmInfo extends AbstractFarmInfo implements Serializable 
{
    public FarmInfo()
    {
        super();
    }
    protected FarmInfo(String pkField)
    {
        super(pkField);
    }
}