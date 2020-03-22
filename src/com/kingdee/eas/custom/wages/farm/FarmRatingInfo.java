package com.kingdee.eas.custom.wages.farm;

import java.io.Serializable;

public class FarmRatingInfo extends AbstractFarmRatingInfo implements Serializable 
{
    public FarmRatingInfo()
    {
        super();
    }
    protected FarmRatingInfo(String pkField)
    {
        super(pkField);
    }
}