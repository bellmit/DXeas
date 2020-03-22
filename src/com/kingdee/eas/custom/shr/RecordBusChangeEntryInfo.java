package com.kingdee.eas.custom.shr;

import java.io.Serializable;

public class RecordBusChangeEntryInfo extends AbstractRecordBusChangeEntryInfo implements Serializable 
{
    public RecordBusChangeEntryInfo()
    {
        super();
    }
    protected RecordBusChangeEntryInfo(String pkField)
    {
        super(pkField);
    }
}