package com.kingdee.eas.farm.pig.breedingboar;

import java.io.Serializable;

public class BoarDailyEntryInfo extends AbstractBoarDailyEntryInfo implements Serializable 
{
    public BoarDailyEntryInfo()
    {
        super();
    }
    protected BoarDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
}