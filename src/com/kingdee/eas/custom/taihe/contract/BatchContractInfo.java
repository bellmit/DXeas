package com.kingdee.eas.custom.taihe.contract;

import java.io.Serializable;

public class BatchContractInfo extends AbstractBatchContractInfo implements Serializable 
{
    public BatchContractInfo()
    {
        super();
    }
    protected BatchContractInfo(String pkField)
    {
        super(pkField);
    }
}