package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;

public class BaseDataRelInfo extends AbstractBaseDataRelInfo implements Serializable 
{
    public BaseDataRelInfo()
    {
        super();
    }
    protected BaseDataRelInfo(String pkField)
    {
        super(pkField);
    }
}