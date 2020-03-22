package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;

public class StockingDailyEntryInfo extends AbstractStockingDailyEntryInfo implements Serializable 
{
    public StockingDailyEntryInfo()
    {
        super();
    }
    protected StockingDailyEntryInfo(String pkField)
    {
        super(pkField);
    }
}