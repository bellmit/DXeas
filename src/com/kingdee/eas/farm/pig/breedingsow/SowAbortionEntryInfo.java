package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;

public class SowAbortionEntryInfo extends AbstractSowAbortionEntryInfo implements Serializable 
{
    public SowAbortionEntryInfo()
    {
        super();
    }
    protected SowAbortionEntryInfo(String pkField)
    {
        super(pkField);
    }
}