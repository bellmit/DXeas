package com.kingdee.eas.custom.taihe.contract;

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