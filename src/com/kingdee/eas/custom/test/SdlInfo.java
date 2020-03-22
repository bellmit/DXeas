package com.kingdee.eas.custom.test;

import java.io.Serializable;

public class SdlInfo extends AbstractSdlInfo implements Serializable 
{
    public SdlInfo()
    {
        super();
    }
    protected SdlInfo(String pkField)
    {
        super(pkField);
    }
}