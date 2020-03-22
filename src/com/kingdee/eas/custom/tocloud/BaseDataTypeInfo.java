package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;

public class BaseDataTypeInfo extends AbstractBaseDataTypeInfo implements Serializable 
{
    public BaseDataTypeInfo()
    {
        super();
    }
    protected BaseDataTypeInfo(String pkField)
    {
        super(pkField);
    }
}