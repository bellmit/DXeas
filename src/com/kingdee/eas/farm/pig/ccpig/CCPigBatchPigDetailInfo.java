package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;

public class CCPigBatchPigDetailInfo extends AbstractCCPigBatchPigDetailInfo implements Serializable 
{
    public CCPigBatchPigDetailInfo()
    {
        super();
    }
    protected CCPigBatchPigDetailInfo(String pkField)
    {
        super(pkField);
    }
}