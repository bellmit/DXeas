package com.kingdee.eas.custom.shr;

import java.io.Serializable;

public class MyTestInfo extends AbstractMyTestInfo implements Serializable 
{
    public MyTestInfo()
    {
        super();
    }
    protected MyTestInfo(String pkField)
    {
        super(pkField);
    }
}