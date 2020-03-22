package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class FarmerTypeInfo extends AbstractFarmerTypeInfo implements Serializable 
{
    public FarmerTypeInfo()
    {
        super();
    }
    protected FarmerTypeInfo(String pkField)
    {
        super(pkField);
    }
}