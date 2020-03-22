package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;

public class FarmHouseEntryInfo extends AbstractFarmHouseEntryInfo implements Serializable 
{
    public FarmHouseEntryInfo()
    {
        super();
    }
    protected FarmHouseEntryInfo(String pkField)
    {
        super(pkField);
    }
}