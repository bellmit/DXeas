package com.kingdee.eas.farm.breed;

import java.io.Serializable;

public class HenhouseEntryInfo extends AbstractHenhouseEntryInfo implements Serializable 
{
    public HenhouseEntryInfo()
    {
        super();
    }
    protected HenhouseEntryInfo(String pkField)
    {
        super(pkField);
    }
}