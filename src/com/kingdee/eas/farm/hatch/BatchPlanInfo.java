package com.kingdee.eas.farm.hatch;

import java.io.Serializable;

public class BatchPlanInfo extends AbstractBatchPlanInfo implements Serializable 
{
    public BatchPlanInfo()
    {
        super();
    }
    protected BatchPlanInfo(String pkField)
    {
        super(pkField);
    }
}