package com.kingdee.eas.farm.dayratecost;

import java.io.Serializable;

public class CostAllocationEntryInfo extends AbstractCostAllocationEntryInfo implements Serializable 
{
    public CostAllocationEntryInfo()
    {
        super();
    }
    protected CostAllocationEntryInfo(String pkField)
    {
        super(pkField);
    }
}