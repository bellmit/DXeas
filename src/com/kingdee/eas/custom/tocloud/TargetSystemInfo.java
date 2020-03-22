package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;

public class TargetSystemInfo extends AbstractTargetSystemInfo implements Serializable 
{
    public TargetSystemInfo()
    {
        super();
    }
    protected TargetSystemInfo(String pkField)
    {
        super(pkField);
    }
}