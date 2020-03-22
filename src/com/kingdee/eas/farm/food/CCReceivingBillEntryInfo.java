package com.kingdee.eas.farm.food;

import java.io.Serializable;

public class CCReceivingBillEntryInfo extends AbstractCCReceivingBillEntryInfo implements Serializable 
{
    public CCReceivingBillEntryInfo()
    {
        super();
    }
    protected CCReceivingBillEntryInfo(String pkField)
    {
        super(pkField);
    }
}