package com.kingdee.eas.farm.pig;

import java.io.Serializable;

public class PigBatchTypeTreeInfo extends AbstractPigBatchTypeTreeInfo implements Serializable 
{
    public PigBatchTypeTreeInfo()
    {
        super();
    }
    protected PigBatchTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
}