package com.kingdee.eas.farm.breed;

import java.io.Serializable;

public class BreedBatchEntryInfo extends AbstractBreedBatchEntryInfo implements Serializable 
{
    public BreedBatchEntryInfo()
    {
        super();
    }
    protected BreedBatchEntryInfo(String pkField)
    {
        super(pkField);
    }
}