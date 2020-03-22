package com.kingdee.eas.farm.pig;

import java.io.Serializable;

public class PigLevelInfo extends AbstractPigLevelInfo implements Serializable 
{
    public PigLevelInfo()
    {
        super();
    }
    protected PigLevelInfo(String pkField)
    {
        super(pkField);
    }
}