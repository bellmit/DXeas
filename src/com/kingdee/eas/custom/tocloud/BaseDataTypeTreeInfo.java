package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;

public class BaseDataTypeTreeInfo extends AbstractBaseDataTypeTreeInfo implements Serializable 
{
    public BaseDataTypeTreeInfo()
    {
        super();
    }
    protected BaseDataTypeTreeInfo(String pkField)
    {
        super(pkField);
    }
}