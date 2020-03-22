package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;

public class CCPigDailyEntryInfo extends AbstractCCPigDailyEntryInfo implements Serializable 
{
    public CCPigDailyEntryInfo()
    {
        super();
    }
    protected CCPigDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
}