package com.kingdee.eas.farm.stocking.basedata;

import java.io.Serializable;

public class StockingBatchHouseEntryInfo extends AbstractStockingBatchHouseEntryInfo implements Serializable 
{
    public StockingBatchHouseEntryInfo()
    {
        super();
    }
    protected StockingBatchHouseEntryInfo(String pkField)
    {
        super(pkField);
    }
}