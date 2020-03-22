package com.kingdee.eas.custom.foodtrac;

import java.io.Serializable;

public class LeavecheckInfo extends AbstractLeavecheckInfo implements Serializable 
{
    public LeavecheckInfo()
    {
        super();
    }
    protected LeavecheckInfo(String pkField)
    {
        super(pkField);
    }
}