package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class FarmerFarmEntryInfo extends AbstractFarmerFarmEntryInfo implements Serializable 
{
    public FarmerFarmEntryInfo()
    {
        super();
    }
    protected FarmerFarmEntryInfo(String pkField)
    {
        super(pkField);
    }
}