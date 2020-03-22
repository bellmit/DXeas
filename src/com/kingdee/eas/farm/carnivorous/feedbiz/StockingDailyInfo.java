package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;

public class StockingDailyInfo extends AbstractStockingDailyInfo implements Serializable 
{
    public StockingDailyInfo()
    {
        super();
    }
    protected StockingDailyInfo(String pkField)
    {
        super(pkField);
    }
}