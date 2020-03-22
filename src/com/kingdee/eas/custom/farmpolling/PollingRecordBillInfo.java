package com.kingdee.eas.custom.farmpolling;

import java.io.Serializable;

public class PollingRecordBillInfo extends AbstractPollingRecordBillInfo implements Serializable 
{
    public PollingRecordBillInfo()
    {
        super();
    }
    protected PollingRecordBillInfo(String pkField)
    {
        super(pkField);
    }
}