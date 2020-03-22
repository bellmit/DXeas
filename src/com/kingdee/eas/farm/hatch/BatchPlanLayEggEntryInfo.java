package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class BatchPlanLayEggEntryInfo extends AbstractBatchPlanLayEggEntryInfo implements Serializable 
{
    public BatchPlanLayEggEntryInfo()
    {
        super();
    }
    protected BatchPlanLayEggEntryInfo(String pkField)
    {
        super(pkField);
    }
}