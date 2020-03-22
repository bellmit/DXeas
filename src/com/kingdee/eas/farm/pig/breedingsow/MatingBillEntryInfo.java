package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;

public class MatingBillEntryInfo extends AbstractMatingBillEntryInfo implements Serializable 
{
    public MatingBillEntryInfo()
    {
        super();
    }
    protected MatingBillEntryInfo(String pkField)
    {
        super(pkField);
    }
}