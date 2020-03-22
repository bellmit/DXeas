package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;

public class BreedDataEntryInfo extends AbstractBreedDataEntryInfo implements Serializable 
{
    public BreedDataEntryInfo()
    {
        super();
    }
    protected BreedDataEntryInfo(String pkField)
    {
        super(pkField);
    }
}