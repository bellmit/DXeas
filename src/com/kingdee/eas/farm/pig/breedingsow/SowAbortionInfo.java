package com.kingdee.eas.farm.pig.breedingsow;

import java.io.Serializable;

public class SowAbortionInfo extends AbstractSowAbortionInfo implements Serializable 
{
    public SowAbortionInfo()
    {
        super();
    }
    protected SowAbortionInfo(String pkField)
    {
        super(pkField);
    }
}