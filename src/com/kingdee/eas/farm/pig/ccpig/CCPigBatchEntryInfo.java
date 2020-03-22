package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;

public class CCPigBatchEntryInfo extends AbstractCCPigBatchEntryInfo implements Serializable 
{
    public CCPigBatchEntryInfo()
    {
        super();
    }
    protected CCPigBatchEntryInfo(String pkField)
    {
        super(pkField);
    }
}