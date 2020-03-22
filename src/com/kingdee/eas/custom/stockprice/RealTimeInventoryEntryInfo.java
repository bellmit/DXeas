package com.kingdee.eas.custom.stockprice;

import java.io.Serializable;

public class RealTimeInventoryEntryInfo extends AbstractRealTimeInventoryEntryInfo implements Serializable 
{
    public RealTimeInventoryEntryInfo()
    {
        super();
    }
    protected RealTimeInventoryEntryInfo(String pkField)
    {
        super(pkField);
    }
}