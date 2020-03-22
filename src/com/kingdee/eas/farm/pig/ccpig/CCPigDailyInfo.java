package com.kingdee.eas.farm.pig.ccpig;

import java.io.Serializable;

public class CCPigDailyInfo extends AbstractCCPigDailyInfo implements Serializable 
{
    public CCPigDailyInfo()
    {
        super();
    }
    protected CCPigDailyInfo(String pkField)
    {
        super(pkField);
    }
}