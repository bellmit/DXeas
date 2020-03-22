package com.kingdee.eas.custom.shr;

import java.io.Serializable;

public class RecordBusChangeInfo extends AbstractRecordBusChangeInfo implements Serializable 
{
    public RecordBusChangeInfo()
    {
        super();
    }
    protected RecordBusChangeInfo(String pkField)
    {
        super(pkField);
    }
}