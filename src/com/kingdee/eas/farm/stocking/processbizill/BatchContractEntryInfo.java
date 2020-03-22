package com.kingdee.eas.farm.stocking.processbizill;

import java.io.Serializable;

public class BatchContractEntryInfo extends AbstractBatchContractEntryInfo implements Serializable 
{
    public BatchContractEntryInfo()
    {
        super();
    }
    protected BatchContractEntryInfo(String pkField)
    {
        super(pkField);
    }
}