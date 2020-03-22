package com.kingdee.eas.farm.pig;

import java.io.Serializable;

public class PigBatchEntryInfo extends AbstractPigBatchEntryInfo implements Serializable 
{
    public PigBatchEntryInfo()
    {
        super();
    }
    protected PigBatchEntryInfo(String pkField)
    {
        super(pkField);
    }
}