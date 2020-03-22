package com.kingdee.eas.custom.eas2temp;

import java.io.Serializable;

public class EasLogsInfo extends AbstractEasLogsInfo implements Serializable 
{
    public EasLogsInfo()
    {
        super();
    }
    protected EasLogsInfo(String pkField)
    {
        super(pkField);
    }
}