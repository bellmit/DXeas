package com.kingdee.eas.custom.wages;

import java.io.Serializable;

public class PostAllocationInfo extends AbstractPostAllocationInfo implements Serializable 
{
    public PostAllocationInfo()
    {
        super();
    }
    protected PostAllocationInfo(String pkField)
    {
        super(pkField);
    }
}