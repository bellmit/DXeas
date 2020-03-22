package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;

public class CCPigBatchInfo extends AbstractCCPigBatchInfo implements Serializable 
{
    public CCPigBatchInfo()
    {
        super();
    }
    protected CCPigBatchInfo(String pkField)
    {
        super(pkField);
    }
}