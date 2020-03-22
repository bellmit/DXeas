package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;

public class FarmRatingEntryInfo extends AbstractFarmRatingEntryInfo implements Serializable 
{
    public FarmRatingEntryInfo()
    {
        super();
    }
    protected FarmRatingEntryInfo(String pkField)
    {
        super(pkField);
    }
}