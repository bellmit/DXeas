package com.kingdee.eas.custom.stockprice;

import java.io.Serializable;

public class RealTimeInventoryInfo extends AbstractRealTimeInventoryInfo implements Serializable 
{
    public RealTimeInventoryInfo()
    {
        super();
    }
    protected RealTimeInventoryInfo(String pkField)
    {
        super(pkField);
    }
}