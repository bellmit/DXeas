package com.kingdee.eas.farm.carnivorous.feedbiz;

import java.io.Serializable;

public class ConFeedContractInfo extends AbstractConFeedContractInfo implements Serializable 
{
    public ConFeedContractInfo()
    {
        super();
    }
    protected ConFeedContractInfo(String pkField)
    {
        super(pkField);
    }
}