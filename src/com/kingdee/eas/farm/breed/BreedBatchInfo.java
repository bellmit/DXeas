package com.kingdee.eas.farm.breed;

import java.io.Serializable;

public class BreedBatchInfo extends AbstractBreedBatchInfo implements Serializable 
{
    public BreedBatchInfo()
    {
        super();
    }
    protected BreedBatchInfo(String pkField)
    {
        super(pkField);
    }
}