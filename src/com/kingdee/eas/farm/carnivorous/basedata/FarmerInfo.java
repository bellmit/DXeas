package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class FarmerInfo extends AbstractFarmerInfo implements Serializable 
{
    public FarmerInfo()
    {
        super();
    }
    protected FarmerInfo(String pkField)
    {
        super(pkField);
    }
}