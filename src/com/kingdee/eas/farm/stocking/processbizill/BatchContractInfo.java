package com.kingdee.eas.farm.stocking.processbizill;

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