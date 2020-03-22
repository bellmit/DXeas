package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class BatchPlanEntryInfo extends AbstractBatchPlanEntryInfo implements Serializable 
{
    public BatchPlanEntryInfo()
    {
        super();
    }
    protected BatchPlanEntryInfo(String pkField)
    {
        super(pkField);
    }
}