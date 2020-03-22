package com.kingdee.eas.farm.carnivorous.basedata;

import java.io.Serializable;

public class BatchHouseEntryInfo extends AbstractBatchHouseEntryInfo implements Serializable 
{
    public BatchHouseEntryInfo()
    {
        super();
    }
    protected BatchHouseEntryInfo(String pkField)
    {
        super(pkField);
    }
}