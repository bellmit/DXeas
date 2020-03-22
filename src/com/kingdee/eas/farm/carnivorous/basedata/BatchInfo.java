package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class BatchInfo extends AbstractBatchInfo implements Serializable 
{
    public BatchInfo()
    {
        super();
    }
    protected BatchInfo(String pkField)
    {
        super(pkField);
    }
}