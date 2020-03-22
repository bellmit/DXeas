package com.kingdee.eas.custom.tocloud;

import java.io.Serializable;

public class BaseDataRelTreeInfo extends AbstractBaseDataRelTreeInfo implements Serializable 
{
    public BaseDataRelTreeInfo()
    {
        super();
    }
    protected BaseDataRelTreeInfo(String pkField)
    {
        super(pkField);
    }
}