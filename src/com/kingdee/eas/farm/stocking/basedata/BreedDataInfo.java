package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;

public class BreedDataInfo extends AbstractBreedDataInfo implements Serializable 
{
    public BreedDataInfo()
    {
        super();
    }
    protected BreedDataInfo(String pkField)
    {
        super(pkField);
    }
}