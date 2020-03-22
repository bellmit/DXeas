package com.kingdee.eas.farm.food;

import java.io.Serializable;

public class TransportDailyEntryInfo extends AbstractTransportDailyEntryInfo implements Serializable 
{
    public TransportDailyEntryInfo()
    {
        super();
    }
    protected TransportDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
}