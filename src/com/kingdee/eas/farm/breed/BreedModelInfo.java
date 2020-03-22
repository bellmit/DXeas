package com.kingdee.eas.farm.breed;

import java.io.Serializable;

public class BreedModelInfo extends AbstractBreedModelInfo implements Serializable 
{
    public BreedModelInfo()
    {
        super();
    }
    protected BreedModelInfo(String pkField)
    {
        super(pkField);
    }
}